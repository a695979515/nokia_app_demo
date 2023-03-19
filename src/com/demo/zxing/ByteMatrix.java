package com.demo.zxing;


public final class ByteMatrix {
    private final byte[][] bytes;
    private final int width;
    private final int height;

    public ByteMatrix(int width, int height) {
        this.bytes = new byte[height][width];
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte get(int x, int y) {
        return this.bytes[y][x];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public void set(int x, int y, byte value) {
        this.bytes[y][x] = value;
    }

    public void set(int x, int y, int value) {
        this.bytes[y][x] = (byte)value;
    }

    public void set(int x, int y, boolean value) {
        this.bytes[y][x] = (byte)(value ? 1 : 0);
    }

    public void clear(byte value) {
        for(int y = 0; y < this.height; ++y) {
            for(int x = 0; x < this.width; ++x) {
                this.bytes[y][x] = value;
            }
        }

    }
}
