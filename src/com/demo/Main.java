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
import com.demo.utils.CategoryBarUtils;
import com.demo.utils.Commands;
import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpsConnection;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import java.io.DataInputStream;
import java.io.IOException;


public class Main
        extends MIDlet
        implements CommandListener, CategoryBarUtils.ElementListener {
    private CategoryBar categoryBar;
    private CategoryBarView categoryBarView;
    private CategoryGridView categoryGridView;
    private BackStack backStack;

    /**
     * Start the app, create and show the initial List view,
     * setup listeners and enable orientation support
     */
    public void startApp() {
        try {
            //do nothing, just init the network connection
            sendHttpGet("https://baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        backStack = new BackStack(this);
        createCategoryView(2);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {

        if (c == Commands.BACK || c == Commands.EXIT) {
            backStack.back();
        } else if (c == Commands.LIST_SELECT) {
            int index = categoryGridView.getSelectedIndex();
            if (index == 0) {
                backStack.forward(new StringItemView(this, backStack, "ChatGPT"));
            } else if (index == 1) {

                backStack.forward(new TextView(this, backStack, " ‰»Îƒ⁄»›"));

            }

        }
    }

    /**
     * Handles CategoryBar events, tells the currently visible CategoryBarView
     * to switch view to whatever item is tapped
     *
     * @param categoryBar
     * @param selectedIndex
     */
    public void notifyElementSelected(CategoryBar categoryBar, int selectedIndex) {
        switch (selectedIndex) {
            case ElementListener.BACK:
                categoryBar.setVisibility(false);
                backStack.back();
                break;
            default:
                categoryBarView.setActive(selectedIndex);
                break;
        }
    }


    /**
     * Generates and displays the CategoryBarView with the requested
     * amount of items
     *
     * @param amountOfCategories
     */
    private void createCategoryView(int amountOfCategories) {

        categoryGridView = new CategoryGridView(amountOfCategories);
        categoryGridView.setCommandListener(this);
        CategoryGridView.Theme theme = CategoryGridView.createTheme(Display.getDisplay(this));
        theme.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN,
                Font.SIZE_SMALL));
        categoryGridView.setTheme(theme);
        backStack.forward(categoryGridView);


    }

    public String sendHttpGet(String url) throws IOException {

        HttpsConnection hcon = null;
        DataInputStream dis = null;
        StringBuffer message = new StringBuffer();
        try {


            hcon = (HttpsConnection) Connector.open(url);


            dis = new DataInputStream(hcon.openInputStream());


            int ch;
            while ((ch = dis.read()) != -1) {

                message = message.append((char) ch);
            }



        } finally {
            if (hcon != null) hcon.close();
            if (dis != null) dis.close();
        }
        return message.toString();
    }
}
