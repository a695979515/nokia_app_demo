/*
 * Copyright © 2012 Nokia Corporation. All rights reserved.
 * Nokia and Nokia Connecting People are registered trademarks of Nokia Corporation. 
 * Oracle and Java are trademarks or registered trademarks of Oracle and/or its
 * affiliates. Other product and company names mentioned herein may be trademarks
 * or trade names of their respective owners. 
 * See LICENSE.TXT for license information.
 */
package com.demo.utils;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Form;

/**
 * The information view displayed in various parts of the application
 * presenting context-sensitive help text
 */
public class InformationView
    extends Form {

    private static final String[] INFORMATION_TEXTS = {
        // LISTS
        "This mini application shows different versions of a list."
        + "\n\n- The implicit list should be used for drill downs; "
        + "the list closes after an item is selected"
        + "\n\n- The exclusive list should be used for selecting one item "
        + "(and one item must always be selected); Back discards the selection"
        + ", and “done” from Options menu confirms the selection"
        + "\n\n- The multiple list should be used for selecting no items, one "
        + "item, or multiple items; Back discards the selection, and “done” "
        + "from Options menu confirms the selection"
        + "\n\n- Truncated shows an implicit list where the list items are "
        + "truncated so that they can each fit into one row. Try rotating the "
        + "phone to see how the content of the row is extended"
        + "\n\n- Wrapped shows an implicit list where the list items continue "
        + "onto the next line. It is likely that this layout will cause "
        + "difficulties when used with items of different length and when "
        + "there are no clear markers to indicate where a new item starts"
        + "\n\n- Thumbnails shows an implicit list with additional thumbnails "
        + "for each item. Thumbnails are aligned to the left of the list"
        + "\n\nFor more information on lists, please see the Series 40 full "
        + "touch style guide.",
        
        // TEXT
        "This mini application shows different variations of a Text Box. "
        + "It can be"
        + "\n\n- editable; this is indicated by white font on a black "
        + "background. The user can alter the text by tapping the text. "
        + "This will slide up the virtual keyboard. After finishing the "
        + "changes, the user can slide the keyboard down and continue with "
        + "reading the page or with navigation (back button or action button "
        + "#1)"
        + "\n\n- non-editable; this is indicated with theme-coloured font on "
        + "a black background. The user cannot change the text."
        + "\n\nFor more information on text boxes, please see the Series 40 "
        + "full touch style guide.",
        
        // DIALOGS
        "This mini app demonstrates various types of dialog and should cover "
        + "most possibilities for the use of dialogs."
        + "\n\n- timed dialog; disappears after a timeout – in our example 3 "
        + "seconds – and the user returns to the parent view"
        + "\n\n- text + 1 button"
        + "\n\n- text + 1 button+ image"
        + "\n\n- text + 1 button + image + determinate progress indicator"
        + "\n\n- text + 1 button + image + indeterminate progress indicator"
        + "\n\n- text + 2 buttons"
        + "\n\n- text + 3 buttons + image + indeterminate progress indicator"
        + "\n\nDeterminate progress indicators should be used if the process "
        + "duration is predictable or if it takes longer than 10 seconds. "
        + "Indeterminate progress indicators should only be used if the "
        + "process length is not predictable, but definitely less than 10 "
        + "seconds."
        + "\n\nIf there is only one button, it confirms the note, e.g. an "
        + "information dialog."
        + "\n\nIf there are two buttons, the LSK is for positive (OK) and the "
        + "RSK is for negative (CANCEL) actions"
        + "\n\nIf there are three buttons, the LSK is for help or options, the "
        + "MSK is for positive (OK) and the RSK is for negative (CANCEL) "
        + "actions"
        + "\n\nFor more information on dialogs, please see the Series 40 full "
        + "touch style guide.",
        
        // CANVAS
        "There are different types of canvas supported:"
        + "\n\n- With chrome; all navigation elements are already included"
        + "\n\n- With chrome and the category bar; all navigation elements are "
        + "already included"
        + "\n\n- With the status bar only, no header bar and no back button; "
        + "navigation elements have to be added; in this case, these buttons "
        + "are added as simple buttons on the canvas"
        + "\n\n- In Full screen, without any chrome, navigation elements have "
        + "to be added; in this case, these are added as simple buttons on the "
        + "canvas"
        + "\n\nIn addition there is a special object for editing text"
        + "\n\n- Canvas text editor"
        + "\n\nFor more information on canvases, please see the Series 40 full "
        + "touch style guide.",
        
        // FORMS
        "Forms are the most versatile screen environment. They are "
        + "usually used for data input tasks. Therefore they offer a "
        + "wide variety of types of items and ready-made choice groups. "
        + "Any data entered in a form is either confirmed via an action "
        + "button #1 (checkmark) or cancelled via the back button. The "
        + "back button should always evoke a confirmation query to "
        + "check if the user wants to discard the changes they made."
        + "\n\nProgress bar and slider:"
        + "\n\nThese elements originate from the gauge element. They can be"
        + "\n\n- determinate progress indicators, used as filling "
        + "horizontal bars; these should be used if the process "
        + "duration is predictable or if it takes longer than 10 seconds"
        + "\n\n- indeterminate progress indicators, used as spinners; "
        + "these should only be used if the process length is not "
        + "predictable but definitely less than 10 seconds."
        + "\n\n- sliders , used to set a value within a number range. "
        + "The numbers are integers. The user can precisely edit the "
        + "number by pressing the value bubble. This opens the virtual keyboard."
        + "\n\nExclusive pop-up group:"
        + "\n\nThis collapses after the item has been selected. If there "
        + "are more than 3 items in the pop-up group, the group’s content "
        + "becomes scrollable. This mini app can be shown in 2 versions:"
        + "\n\n- Simple choice item"
        + "\n\n- Header and item with icon"
        + "\n\nTumbler:"
        + "\n\nA tumbler is used to select the time and/or date."
        + "\n\n- time only"
        + "\n\n- date only"
        + "\n\n- combination of time and date"
        + "\n\n- please note that no other tumbler content is possible"
        + "\n\nText input:"
        + "\n\nIt is recommended that you do not “preload” the text field. "
        + "The text field header should contain all the relevant information "
        + "for the text input field. Please take care to use the right "
        + "keyboard layout when opening the text input field and when "
        + "continuing with the text input."
        + "\n\nExclusive choice group (select):"
        + "\n\nThis is a set of radio button items with an optional header "
        + "and optional thumbnails. A choice group does not collapse or "
        + "expand. Exactly one item must always be selected. If there is "
        + "the chance that no elements could be selected, add a \"no "
        + "selection\" option to the group."
        + "\n\nMultiple choice group (select):"
        + "\n\nThis is a set of check box items with an optional header and "
        + "optional thumbnails. A choice group does not collapse or expand. "
        + "It is possible to select no items, one item or multiple items."
        + "\n\nText string:"
        + "\n\nThis offers the possibility to either"
        + "\n\n- display text, or"
        + "\n\n- create buttons and hyperlinks."
        + "\nIt is possible to give a label to each text string."
        + "\n\nImage:"
        + "\n\nThe image item allows images to be added into a form, e.g. to "
        + "make the content look more appealing, or to associate images with "
        + "data input tasks."
        + "\n\nSpacer:"
        + "\n\nThis element allows components to be stretched."
            
        + "\n\nCustom:"
        + "\n\n"
        + "It is possible to create your own elements in a form screen and "
        + "therefore add custom elements in a feasible way to an existing "
        + "palette of form items and groups. Please note that it is possible "
        + "to retrieve the theme colour for highlighting buttons."
            
        + "\n\nThe Custom item demonstrates 4 different examples:"
        + "\n\n1. Slider which allows, e.g. a start value different than 0 "
        + "(1 in case of the example) or which allows different numerical "
        + "systems than the decimal numeral system –  for example HH:MM:SS to "
        + "build a seek bar for a media player."
        + "\n\n2. Switch which allows users to toggle between on/off states "
        + "(or other clearly opposite states)."
        + "\n\n3. Segmented buttons that act like a radio button group: one and "
        + "only one button must always be selected (i.e. highlighted)."
        + "\n\n4. Two buttons that are grouped together to indicate their "
        + "relationship with each other."
        
        + "\n\nFor more information on forms, please see the Series 40 full "
        + "touch style guide.",
        
        // CATEGORY BAR
        "A category represents a certain view. The maximum "
        + "number of categories in the category bar is dynamically "
        + "optimised for landscape (max. 6) and portrait (max. 4) "
        + "orientations. If there are more categories available, "
        + "the category bar adds an extension icon. From there, "
        + "the user can add more category items. "
        + "\n\nHowever, the maximum number of categories for both "
        + "orientations is restricted to 15. Nevertheless, this "
        + "should be sufficient even for feature rich applications."
        + "\n\nDo not add commands into a category bar."
        + "\n\nThe category bar is not inherited to  the next lower "
        + "hierarchy level."
        + "\n\nFor more information on category bars, please see the "
        + "Series 40 full touch style guide.",
        
        // TICKER
        "This application shows how the ticker appears in different display "
        + "types, e.g."
        + "\n\n- lists"
        + "\n\n- canvases"
        + "\n\n- textboxes"
        + "\n\nThe ticker appears as part of the chrome, and does not scroll "
        + "away with the content."
        + "\n\nFor more information on tickers, please see the Series 40 "
        + "full touch style guide.",
        
        // CONFIRMATION
        "Confirmation patterns are necessary, especially if the user might "
        + "lose data by accident. In the Series 40 UI interaction style, "
        + "this can happen with use of the back button. The set action for "
        + "the back button is “cancel and discard” all changes. This may "
        + "cause difficulties, especially for people who are new to the "
        + "platform. To ensure that they do not discard previously made "
        + "changes, it is necessary to have a query following the back "
        + "command. The query must have at least 2 choices: YES/NO. In "
        + "addition, it is possible to add a help option to the query. "
        + "Please also check the other dialog layouts that are possible. "
        + "\n\nOn the other hand, there is no need for an additional "
        + "confirmation query if the user accepts changes that were made "
        + "in a form, via the tick mark in action button #1."
        + "\n\nFor more information on confirmation patterns, please see "
        + "the Series 40 full touch style guide.",
        
        // NO CONTENT
        "It is important to indicate to people if there is no content. "
        + "This will prevent people from perceiving your application as "
        + "broken or unresponsive. It may also help the out-of-box "
        + "experience of your application if people either have sample "
        + "content or a very obvious explanation of how to add their first "
        + "content."
        + "\n\nThis mini app shows 3 different variations:"
        + "\n\n- an indication of ‘no content’ but no further action"
        + "\n\n- an add button in the content area, which disappears "
        + "after the first content is added"
        + "\n\n- an add button as action button #1, and a textual hint "
        + "informing the user that they should use this button to create "
        + "their first content"
        + "\n\nFor more information on empty content, please see the "
        + "Series 40 full touch style guide.",
        
        // MULTIPLE ITEMS
        "The multiple items patterns show how to handle the selection of multiple "
        + "items in case there is:" 
        + "\n\n- a positive selection, like adding multiple images to an e-mail,"
        + "\n\n- a negative selection, like deleting multiple items permanently from the "
        + "phone."

        + "\n\nIn a positive selection, the indicator for selecting an item is a white "
        + "checkmark on top of a green squircle. Action button 1 is filled with a "
        + "checkmark. The checkmark is greyed out in case no selection has been made. "
        + "Pressing the active checkmark in action button 1 does not evoke any "
        + "additional confirmation query, since the selection does not cause any "
        + "final loss. The user can undo the step easily, just by removing the "
        + "files from the list of attached files."

        + "\n\nThe negative selection, in contrast, could display a designated icon in "
        + "action button 1 showing the action being performed – for example a trash "
        + "bin icon in case of deleting the items. The item marker could be a white "
        + "cross on a red squircle. This clearly indicates that this item will be "
        + "deleted when the action button 1 is tapped. Both metaphors imply a negative "
        + "connotation. When deleting an item permanently, the application should show "
        + "a confirmation query after action button 1 is pressed. This prevents the "
        + "user from losing important items just because of a badly performed gesture. "
        + "Action button 1 is dimmed as long as there is no selection made, i.e. "
        + "no item is marked."
        + "\nHowever, both patterns require a confirmation query in case the user "
        + "presses back. The query is always positively formulated, i.e. do you want "
        + "to perform this action? NO – YES – BACK.",

        
        // ZOOMING
        "Zooming can be done in various ways. This mini app demonstrates "
        + "three common ways:"
        + "\n\n- pinch zoom, for zooming in and zooming out"
        + "\n\n- slider zoom, where a separate slider component is used"
        + "\n\n- tap zoom – double tapping toggles between maximum (2) "
        + "zoom factor and normal (1) zoom factor"
        + "\n\nThe image can be panned in any of the cases."
        + "\n\nFor more information on zoom, please see the Series 40 "
        + "full touch style guide.",
        
        // ADD NEW
        "This pattern demonstrates how to add new items to a form. The button "
        + "at the bottom of the form adds a new item. It is not possible to dim "
        + "an item and make it become active later. The entire form is saved by "
        + "pressing the checkmark in action button 1, or via back button and "
        + "the related confirmation query. The query is always positively "
        + "formulated, i.e. do you want to perform this action? NO – YES – BACK.",
        
        // INTERDEPENDENT
        "This pattern shows how to overcome the fact that it is not "
        + "possible to dim items. The example demonstrates three "
        + "interdependent popup choicegroups. The selection of the "
        + "choicegroup defines the content of the next choicegroup. "
        + "Popup choicegroup is well suited for this task, since it "
        + "does not change too much of the visible content in case there "
        + "is a change in a previous item. Besides, the closed choicegroup "
        + "allows the user to glance the entire selection."
        + "The Done button is only shown in case the user has made a "
        + "selection from the last popup choicegroup. The StringItem "
        + "button is more visible than the icon in action button one (in "
        + "case the StringItem is always shown above the fold) and might "
        + "ease the selection task. "

        + "\n\nA real-life task could be the selection of town:"
        + "\n- Continent"
        + "\n- Country"
        + "\n- (Optional state)"
        + "\n- Town"

        + "\n\nThis would avoid any virtual keyboard use and might be an "
        + "alternative to a text-input based search.",
        
        // KEYPADS
        "This application demonstrates the different keypad layouts available "
        + "in Series 40. There are:"
        + "\n\n- normal – standard layout"
        + "\n- initial caps sentence"
        + "\n- initial caps word"
        + "\n- password – hides letters with an asterisk *"
        + "\n- sensitive"
        + "\n- email – all lower case and @"
        + "\n- url – all lower case"
        + "\n- phone number – numbers and #, + "
        + "\n- decimal – numbers and ."
        + "\n- numeric – numbers only"
        + "\n\nIt is highly recommended to choose the correct keypad layout "
        + "for each text input field, not only in full touch phones but also "
        + "in touch and type and non-touch phones.",
        
        // MENUS
        "In touch phones, there are 2 different kinds of menus available: "
        + "\n\n- Options menu, containing commands which act on the entire "
        + "view or which navigate the user to a new view without any item "
        + "being selected."
        + "\n\n- Item specific menu, containing only commands which act on a "
        + "particular item. "
        + "\n\nOptions menu is accessed via the options menu icon, whereas the "
        + "item specific menu is opened via a long press on the particular "
        + "item. "
        + "\n\nIn non-touch phones, these 2 menus are merged into the options "
        + "menu. This is possible due to the focus. The Options menu may "
        + "contain view related commands and item specific commands which act "
        + "only on the item which has the focus."
        + "\n\nIn case the options menu is empty, the icon is dimmed in full "
        + "touch and left empty in touch and type or non-touch phones."
    };

    public InformationView(int item, CommandListener commandListener) {
        super(Strings.getTitle(item));
        append(INFORMATION_TEXTS[item]);
        this.addCommand(Commands.INFORMATION_BACK);
        this.setCommandListener(commandListener);
    }
}
