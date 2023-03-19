/*
 * Copyright © 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation.
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners.
 * See LICENSE.TXT for license information.
 */
package com.demo;

import com.demo.utils.Commands;
import com.demo.utils.ImageLoader;
import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.IconCommand;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.StringItem;
import java.util.Vector;

public class CategoryBarView
        extends Form {

    private final String[] VIEW_NAMES = {
            "search",
            "comments"
    };
    private int amountOfCategories;

    public CategoryBarView(int amountOfCategories) {
        super("search");

        this.amountOfCategories = amountOfCategories;
        this.addCommand(Commands.INFORMATION);
    }

    /**
     * A method to fake different views
     *
     * @param index of the view to change to
     */
    public void setActive(int index) {
        if (index >= 0 && index < VIEW_NAMES.length) {
            this.setTitle(VIEW_NAMES[index]);
            String name = String.valueOf(amountOfCategories) + " categories";
            StringItem stringItem = new StringItem("", name);
            this.deleteAll();
            this.append(stringItem);
        }
    }

    /**
     * A factory method to create a CategoryBar to display in the parent view.
     * Amount of categories is specified during the construction of this object.
     *
     * @return CategoryBar with the requested amount of categories
     */
    public CategoryBar createCategoryBar() {
        Vector commands = new Vector();


        Image search = ImageLoader.load(ImageLoader.CATEGORY_SEARCH);
        Image comments = ImageLoader.load(ImageLoader.CATEGORY_COMMENTS);


        // Passing null as the second image makes the phone draw the selected
        // image with the current highlight color
        commands.addElement(new IconCommand("search", search, null,
                Command.SCREEN, 1));
        commands.addElement(new IconCommand("comments", comments, null,
                Command.SCREEN, 1));


        IconCommand[] iconCommands = new IconCommand[amountOfCategories];

        for (int i = 0; i < amountOfCategories; i++) {
            iconCommands[i] = (IconCommand) commands.elementAt(i);
        }

        return new CategoryBar(iconCommands, true);
    }
}
