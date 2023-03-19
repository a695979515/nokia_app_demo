package com.demo.zxing;


public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    public QRCodeWriter() {
    }



    public BitMatrix encode(String contents, int width, int height) throws RuntimeException {
        if (contents == null) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (width >= 0 && height >= 0) {
            ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel(1);
            int quietZone = 4;
            QRCode code = Encoder.encode(contents, errorCorrectionLevel);
            return renderResult(code, width, height, quietZone);
        } else {
            throw new IllegalArgumentException("Requested dimensions are too small: " + width + 'x' + height);
        }
    }

    private static BitMatrix renderResult(QRCode code, int width, int height, int quietZone) {
        ByteMatrix input = code.getMatrix();
        if (input == null) {
            throw new IllegalStateException();
        } else {
            int inputWidth = input.getWidth();
            int inputHeight = input.getHeight();
            int qrWidth = inputWidth + (quietZone << 1);
            int qrHeight = inputHeight + (quietZone << 1);
            int outputWidth = Math.max(width, qrWidth);
            int outputHeight = Math.max(height, qrHeight);
            int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
            int leftPadding = (outputWidth - inputWidth * multiple) / 2;
            int topPadding = (outputHeight - inputHeight * multiple) / 2;
            BitMatrix output = new BitMatrix(outputWidth, outputHeight);
            int inputY = 0;

            for(int outputY = topPadding; inputY < inputHeight; outputY += multiple) {
                int inputX = 0;

                for(int outputX = leftPadding; inputX < inputWidth; outputX += multiple) {
                    if (input.get(inputX, inputY) == 1) {
                        output.setRegion(outputX, outputY, multiple, multiple);
                    }

                    ++inputX;
                }

                ++inputY;
            }

            return output;
        }
    }
}
