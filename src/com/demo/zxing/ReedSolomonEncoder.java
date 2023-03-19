package com.demo.zxing;


/**
 * <p>Implements Reed-Solomon enbcoding, as the name implies.</p>
 *
 * @author Sean Owen
 * @author William Rucklidge
 */
public final class ReedSolomonEncoder {

    private final GenericGF field;
    private GenericGFPoly[] cachedGenerators;

    public ReedSolomonEncoder(GenericGF field) {
        this.field = field;
        this.cachedGenerators = new GenericGFPoly[1];
        cachedGenerators[0] = new GenericGFPoly(field, new int[]{1});
    }

    private GenericGFPoly buildGenerator(int degree) {
        if (degree >= cachedGenerators.length) {
            GenericGFPoly lastGenerator = cachedGenerators[cachedGenerators.length - 1];
            int length = cachedGenerators.length;
            cachedGenerators = copyOf(cachedGenerators, length+degree);
            for (int d = length; d <= degree; d++) {
                GenericGFPoly nextGenerator = lastGenerator.multiply(
                        new GenericGFPoly(field, new int[]{1, field.exp(d - 1 + field.getGeneratorBase())}));
                cachedGenerators[d] = nextGenerator;
                lastGenerator = nextGenerator;
            }
        }
        return cachedGenerators[degree];
    }

    public static GenericGFPoly[] copyOf(GenericGFPoly[] original, int newLength) {
        GenericGFPoly[] copy = new GenericGFPoly[newLength];
        System.arraycopy(original, 0, copy, 0,
                Math.min(original.length, newLength));
        return copy;
    }

    public void encode(int[] toEncode, int ecBytes) {
        if (ecBytes == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int dataBytes = toEncode.length - ecBytes;
        if (dataBytes <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly generator = buildGenerator(ecBytes);
        int[] infoCoefficients = new int[dataBytes];
        System.arraycopy(toEncode, 0, infoCoefficients, 0, dataBytes);
        GenericGFPoly info = new GenericGFPoly(field, infoCoefficients);
        info = info.multiplyByMonomial(ecBytes, 1);
        GenericGFPoly remainder = info.divide(generator)[1];
        int[] coefficients = remainder.getCoefficients();
        int numZeroCoefficients = ecBytes - coefficients.length;
        for (int i = 0; i < numZeroCoefficients; i++) {
            toEncode[dataBytes + i] = 0;
        }
        System.arraycopy(coefficients, 0, toEncode, dataBytes + numZeroCoefficients, coefficients.length);
    }

}
