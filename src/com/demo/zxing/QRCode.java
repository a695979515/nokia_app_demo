package com.demo.zxing;



public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private Mode mode;
    private ErrorCorrectionLevel ecLevel;
    private Version version;
    private int maskPattern = -1;
    private ByteMatrix matrix;

    public QRCode() {
    }

    public Mode getMode() {
        return this.mode;
    }

    public ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public Version getVersion() {
        return this.version;
    }

    public int getMaskPattern() {
        return this.maskPattern;
    }

    public ByteMatrix getMatrix() {
        return this.matrix;
    }

    public void setMode(Mode value) {
        this.mode = value;
    }

    public void setECLevel(ErrorCorrectionLevel value) {
        this.ecLevel = value;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public void setMaskPattern(int value) {
        this.maskPattern = value;
    }

    public void setMatrix(ByteMatrix value) {
        this.matrix = value;
    }

    public static boolean isValidMaskPattern(int maskPattern) {
        return maskPattern >= 0 && maskPattern < 8;
    }
}
