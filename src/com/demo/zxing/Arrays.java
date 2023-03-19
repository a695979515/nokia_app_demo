package com.demo.zxing;

public class Arrays {
    public static boolean equals(int[] a, int[] a2) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        return mismatch(a, a2, length) < 0;
    }

    public static int hashCode(int a[]) {
        if (a == null)
            return 0;

        int result = 1;
        for (int i = 0; i< a.length; i++){
        	int element = a[i];
            result = 31 * result + element;
        }

        return result;
    }

    public static int mismatch(int[] a,
                               int[] b,
                               int length) {
        int i = 0;
        for (; i < length; i++) {
            if (a[i] != b[i])
                return i;
        }
        return -1;
    }
}
