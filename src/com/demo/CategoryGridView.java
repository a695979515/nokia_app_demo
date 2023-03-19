/*
 * Copyright 漏 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation.
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners.
 * See LICENSE.TXT for license information.
 */
package com.demo;

import com.demo.utils.Commands;
import com.demo.utils.ImageLoader;
import com.demo.uihelpers.Grid;

public class CategoryGridView
        extends Grid {

    public static final String[] NAMES = {
            "ChatGPT",
            "二维码生成"



    };
    private static final String[] IMAGES = {
            ImageLoader.CATEGORY_SEARCH,
            ImageLoader.CATEGORY_ALL,

    };

    public CategoryGridView(int amountOfCategories) {
        super("选择分类");

        this.addCommand(Commands.BACK);

        this.setSelectCommand(Commands.LIST_SELECT);

        for (int i = 0; i < amountOfCategories; i++) {
            append(NAMES[i % NAMES.length],
                    ImageLoader.load(IMAGES[i % IMAGES.length]));
        }

    }

    protected void showNotify() {
        super.showNotify();
        int width = getWidth();
        int columns = width / 100;
        int columnWidth = (width - getTheme().getScrollBarMarginRight()
                - getTheme().getScrollBarWidth()) / columns;
        setElementSize(columnWidth, 70);
    }
}
