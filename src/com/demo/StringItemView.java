/*
 * Copyright ? 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation.
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners.
 * See LICENSE.TXT for license information.
 */
package com.demo;


import com.demo.utils.BackStack;
import com.demo.utils.Commands;


import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import java.io.*;


/**
 * Demonstrates the various ways a StringItem can appear
 */
public class StringItemView
        extends Form implements CommandListener {

    private BackStack backStack;
    private CommandListener parentCommandListener;

    private TextField textField;

    private StringItemView stringItemView = this;


    private int count = 0;


    public StringItemView(CommandListener commandListener, BackStack backStack, String title) {
        super(title);
        removeCommand(Commands.OK);

        this.addCommand(Commands.BACK);
        this.addCommand(Commands.SEND_MSG);


        this.backStack = backStack;
        this.setCommandListener(this);
        parentCommandListener = commandListener;


        textField = new TextField(null, "", 256, TextField.ANY);
        this.append(textField);


    }


    public void commandAction(Command c, Displayable d) {

        if (c == Commands.SEND_MSG) {
            String text = textField.getString();
            textField.setString("");
            if (text != null && !("").equals(text.trim())) {

                StringItem stringItem = new StringItem("Äã", text);
                stringItem.setFont(Font.getFont(Font.FACE_SYSTEM,
                        Font.STYLE_PLAIN, Font.SIZE_SMALL));
                this.set(count, stringItem);

                Gauge gauge = new Gauge(
                        null,
                        false,
                        Gauge.INDEFINITE,
                        Gauge.CONTINUOUS_RUNNING);
                this.append(gauge);
                textField = new TextField(null, "", 256, TextField.ANY);
                this.append(textField);
                count = count + 2;
                try {
                    sendHttpPost1(text);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            parentCommandListener.commandAction(c, d);
        }
    }

    public void sendHttpPost1(final String text) throws IOException {

        new Thread() {
            public void run() {
                try {
                    String answer = sendHttpPost(text);
                    StringItem answerItem = new StringItem("ChatGPT", answer);
                    answerItem.setFont(Font.getFont(Font.FACE_SYSTEM,
                            Font.STYLE_PLAIN, Font.SIZE_SMALL));
                    stringItemView.set(count - 1, answerItem);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

    public String sendHttpPost(String text) throws IOException {
        //api url
        String url = "";

        HttpConnection hcon = null;
        InputStream in = null;

        OutputStream dos = null;
        StringBuffer message = new StringBuffer();
        try {


            hcon = (HttpConnection) Connector.open(url);
            hcon.setRequestMethod(HttpConnection.POST);

            //request header
            hcon.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            hcon.setRequestProperty("Content-Type", "application/json;charset=UTF-8");


            //request body
//            String param = "{\n" +
//                    "  \"prompt\": \""+text+"\"\n" +
//                    "}";
            String param = "\"model\":\"gpt-3.5-turbo\",\n" +
                    "                    \"messages:[\n" +
                    "            {\"role\": \"user\", \"content\": \""+text+"\"}\n" +
                    "            ]";


            dos = hcon.openOutputStream();


            dos.write(param.getBytes("UTF-8"));

            dos.flush();
            dos.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ic;
            in = hcon.openInputStream();

            byte[] buffer = new byte[1024];
            if (in != null) {
                while ((ic = in.read(buffer)) != -1) {
                    baos.write(buffer, 0, ic);
                }
                byte[] myData = baos.toByteArray();
                message = message.append(new String(myData, "UTF-8"));
                in.close();
                baos.close();
            }



        } finally {
            if (hcon != null) hcon.close();
            if (in != null) in.close();
        }
        return message.toString();
    }

}