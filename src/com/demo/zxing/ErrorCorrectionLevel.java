package com.demo.zxing;

public class ErrorCorrectionLevel {
//    L(1),
//    M(0),
//    Q(3),
//    H(2);

//    private static final ErrorCorrectionLevel[] FOR_BITS = new ErrorCorrectionLevel[]{M, L, H, Q};
    private final int bits;

    public ErrorCorrectionLevel(int bits) {
        this.bits = bits;
    }

    public int getBits() {
        return this.bits;
    }

//    public static ErrorCorrectionLevel forBits(int bits) {
//        if (bits >= 0 && bits < FOR_BITS.length) {
//            return FOR_BITS[bits];
//        } else {
//            throw new IllegalArgumentException();
//        }
//    }
}
