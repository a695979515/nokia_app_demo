/*
 * Copyright ? 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation.
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners.
 * See LICENSE.TXT for license information.
 */
package com.demo;

import com.demo.utils.*;
import com.demo.zxing.BitMatrix;
import com.demo.zxing.MultiFormatWriter;

import javax.microedition.lcdui.*;

public class TextView
        extends TextBox
        implements CommandListener {

    private static final int MAX_SIZE = 512;
    private final Command CLEAR_COMMAND = new Command(
            "Çå³ýÀ¸Ä¿", Command.SCREEN, 1);
    private BackStack backStack;
    private CommandListener parentCommandListener;


    /**
     * Constructs the view
     *
     * @param title title of the view
     */
    public TextView(CommandListener parentCommandListener, BackStack backStack, String title) {
        super(title, null, MAX_SIZE, TextField.UNEDITABLE);
        this.backStack = backStack;
        this.parentCommandListener = parentCommandListener;
        // If the TextBox is editable, make it accept all input and 
        // add a clear command to the options menu
        this.setConstraints(TextField.ANY);
        this.addCommand(CLEAR_COMMAND);

        this.addCommand(Commands.DONE);
        this.addCommand(Commands.BACK);
        this.setCommandListener(this);
    }

    /**
     * Handle commands here and delegate some to the parent command listener
     *
     * @param c
     * @param d
     */
    public void commandAction(Command c, Displayable d) {

        if (c == CLEAR_COMMAND) {
            // Clear the TextBox contents
            this.setString(null);
        } else if (c == Commands.DONE) {
            if(getString() !=null && getString().length()>0) {
                int width = 240;
                int height = 240;
                BitMatrix bitMatrix = new MultiFormatWriter().encode(getString(), width, height);
                backStack.forward(new ImageView(this, bitMatrix));
            }
        } else if (c == Commands.BACK) {
            backStack.back();
        }else if (c == Commands.RISK_AREA_BACK) {
            backStack.back();
        }else {
            parentCommandListener.commandAction(c, d);
        }
    }

}
