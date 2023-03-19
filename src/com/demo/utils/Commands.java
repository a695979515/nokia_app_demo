/*
 * Copyright © 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation. 
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners. 
 * See LICENSE.TXT for license information.
 */
package com.demo.utils;

import com.demo.uihelpers.Compatibility;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;

/**
 * A public store for commonly used Commands, to allow different parts
 * of the MIDlets talk the same language
 */
public class Commands {

    public static final Command SELECT =
        new Command(toFT("ѡ��"), Command.SCREEN, 1);
    public static final Command LIST_SELECT =
        new Command("ѡ��", Command.OK, 1);
    public static final Command BACK =
        new Command("����", Command.BACK, 1);
    public static final Command EXIT =
        new Command("�˳�", Command.EXIT, 1);
    public static final Command INFORMATION =
        new Command(Compatibility.isFullTouch() ? "information"
        : "Info", toFT("Information"), Command.SCREEN, 3);
    public static final Command INFORMATION_BACK =
        new Command(toFT("Back"), Command.BACK, 1);
    public static final Command RISK_AREA_BACK =
            new Command(toFT("����"), Command.BACK, 1);
    public static final Command OK = new Command("OK", Command.OK, 1);
    public static final Command DONE = new Command(toFT("ȷ��"), Command.OK, 1);
    public static final Command ALERT_HELP =
        new Command(toFTAlert("Help"), Command.HELP, 1);
    public static final Command CANCEL =
        new Command("ȡ��", Command.CANCEL, 1);
    public static final Command ALERT_OK = new Command("OK", Command.OK, 1);
    public static final Command ALERT_CANCEL =
        new Command("�˳�", Command.CANCEL, 1);
    public static final Command ALERT_CONTINUE =
        new Command("����", Command.OK, 1);
    public static final Command ALERT_SAVE_YES =
        new Command(toFTAlert("Yes"), Command.OK, 1);
    public static final Command ALERT_CONFIRM =
        new Command(toFTAlert("ȷ��"), Command.OK, 1);
    public static final Command ALERT_CANCEL_BACK =
        new Command(toFTAlert("ȡ��"), Command.CANCEL, 1);
    public static final Command EDIT =
        new Command(toFT("Edit"), Command.SCREEN, 1);
    public static final Command SEND_MSG = new Command("����", Command.SCREEN, 1);

    public static final Command ADD_ICON;
    public static final Command DELETE_INACTIVE_ICON;
    public static final Command DELETE_ACTIVE_ICON;
    public static final Command OK_INACTIVE_ICON;
    public static final Command OK_ACTIVE_ICON;
    public static final Command EMPTY_ICON;
    public static final Command OK_SCREEN =
        new Command("OK", Command.SCREEN, 2);
    public static final Command DELETE_SCREEN =
        new Command(toFT("Delete"), Command.SCREEN, 2);

    static {
        ADD_ICON = Compatibility.getCommand(
            ImageLoader.load("/add_icon.png"), null, toFT("Add"), Command.OK, 1);
        DELETE_INACTIVE_ICON = Compatibility.getCommand(
            ImageLoader.load("/topbar_delete_inactive.png"), null, "",
            Command.OK, 1);
        DELETE_ACTIVE_ICON = Compatibility.getCommand(
            ImageLoader.load("/topbar_delete_active.png"), null, toFT("Delete"),
            Command.OK, 1);
        OK_INACTIVE_ICON = Compatibility.getCommand(
            ImageLoader.load("/topbar_tick_inactive.png"), null, "",
            Command.OK, 1);
        OK_ACTIVE_ICON = Compatibility.getCommand(
            ImageLoader.load("/topbar_tick_active.png"), null, "OK",
            Command.OK, 1);
        EMPTY_ICON = Compatibility.getCommand(
            Image.createRGBImage(new int[32 * 28], 32, 28, true), null, "OK",
            Command.OK, 1);
    }

    private static String toFT(String text) {
        return Compatibility.toLowerCaseIfFT(text);
    }

    private static String toFTAlert(String text) {
        return Compatibility.isFullTouch() ? text.toUpperCase() : text;
    }
}