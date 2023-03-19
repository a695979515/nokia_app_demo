package com.demo.zxing;


public final class MultiFormatWriter implements Writer {
    public MultiFormatWriter() {
    }

    public BitMatrix encode(String contents, int width, int height) throws RuntimeException {
        Object writer = new QRCodeWriter();
        return ((Writer) writer).encode(contents, width, height);
    }
}
