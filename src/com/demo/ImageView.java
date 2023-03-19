package com.demo;

import com.demo.utils.Commands;
import com.demo.zxing.BitMatrix;

import javax.microedition.lcdui.*;

public class ImageView
        extends Canvas {

    private static final int[] BLACK = new int[]{0xFF000000};
    private static final int[] WHITE = new int[]{0xFFFFFFFF};

    private Image qrCodeImage;
    private int initX;
    private int initY;

    public ImageView(CommandListener commandListener,  BitMatrix bitMatrix) {
        this.addCommand(Commands.RISK_AREA_BACK);
        this.setCommandListener(commandListener);
        removeCommand(Commands.OK);


        // Load the image
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        this.qrCodeImage = Image.createImage(width, height);
        Graphics imageGraphics = qrCodeImage.getGraphics();
        imageGraphics.fillRect(0, 0, width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                imageGraphics.drawRGB(bitMatrix.get(x, y) ? BLACK : WHITE, 0, 1, x, y, 1, 1, false);
            }
        }

        initX = (getWidth() - width) / 2;
        initY = (getHeight() - height) / 2;

    }


    protected void paint(Graphics graphics) {
        graphics.setColor(255, 255, 255); // white
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.drawImage(this.qrCodeImage, initX, initY, Graphics.TOP | Graphics.LEFT);
    }
}
