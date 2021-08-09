// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class w
{
    private static int Code(int n, final int[] array) {
        while (array[n] == 0) {
            if (++n == array.length) {
                return 0;
            }
        }
        return array.length - n;
    }
    
    public static int[] Code(final int[] array, final int[] array2) {
        final int[] array3 = new int[array2.length];
        final int[] array4 = new int[array2.length * 2];
        Code(array4, array, array);
        I(array4, array2);
        System.arraycopy(array4, array4.length - array3.length, array3, 0, array3.length);
        for (int i = 0; i < array4.length; ++i) {
            array4[i] = 0;
        }
        Code(array4, array3, array);
        I(array4, array2);
        System.arraycopy(array4, array4.length - array3.length, array3, 0, array3.length);
        return array3;
    }
    
    private static int[] Code(final int[] array, final int[] array2, final int[] array3) {
        for (int i = array3.length - 1; i >= 0; --i) {
            final long n = array3[i];
            long n2 = 0L;
            for (int j = array2.length - 1; j >= 0; --j) {
                final long n3 = n2 + (((long)array2[j] & 0xFFFFFFFFL) * (n & 0xFFFFFFFFL) + ((long)array[i + j + 1] & 0xFFFFFFFFL));
                array[i + j + 1] = (int)n3;
                n2 = n3 >>> 32;
            }
            array[i] = (int)n2;
        }
        return array;
    }
    
    private static void I(final int[] array, final int[] array2) {
        final int n = array.length - Code(0, array);
        final int n2 = array2.length - Code(0, array2);
        final int n3 = array.length - n - (array2.length - n2);
        final int[] array3 = new int[array2.length - n2 + n3];
        for (int i = n3 * 32; i >= 0; --i) {
            final int n4 = i >>> 5;
            final int n5 = i & 0x1F;
            final int n6 = array2.length - n2;
            int n7;
            if (n5 == 0) {
                System.arraycopy(array2, n2, array3, array3.length - n6 - n4, n6);
                n7 = n4;
            }
            else {
                final int n8 = 32 - n5;
                final int n9 = array2[n2] >>> n8;
                n7 = n4;
                if (n9 != 0) {
                    n7 = n4 + 1;
                }
                int n10 = array3.length - n6 - n7;
                if (n9 != 0) {
                    final int n11 = n10 + 1;
                    array3[n10] = n9;
                    n10 = n11;
                }
                int n12 = array2[n2];
                int n13;
                for (int j = n2 + 1; j < n6; ++j, n12 = n13, ++n10) {
                    n13 = array2[j];
                    array3[n10] = (n12 << n5 | n13 >>> n8);
                }
                array3[n10] = array2[n6 + n2 - 1] << n5;
            }
            final int n14 = array3.length - n6 - n7;
            while (true) {
                final int n15 = array.length - Code(n, array);
                int n17;
                final int n16 = n17 = array3.length - Code(n14, array3);
                int n18 = n15;
                int n19;
                if (array.length - n15 != array3.length - n16) {
                    n19 = array.length - n15 - (array3.length - n16);
                }
                else {
                    while (n18 < array.length - 1 && array[n18] == array3[n17]) {
                        ++n18;
                        ++n17;
                    }
                    n19 = (int)(((long)array[n18] & 0xFFFFFFFFL) - ((long)array3[n17] & 0xFFFFFFFFL) >> 63);
                }
                if (n19 < 0) {
                    break;
                }
                final int length = array.length;
                int n20 = array3.length - 1;
                int n21 = 0;
                int n22 = length - 1;
                long n25;
                int n26;
                int n27;
                while (true) {
                    final long n23 = array[n22];
                    final int n24 = n20 - 1;
                    n25 = (n23 & 0xFFFFFFFFL) - ((long)array3[n20] & 0xFFFFFFFFL) + n21;
                    n26 = n22 - 1;
                    array[n22] = (int)n25;
                    n27 = (int)(n25 >> 63);
                    if (n24 < n14) {
                        break;
                    }
                    n22 = n26;
                    n20 = n24;
                    n21 = n27;
                }
                while (n26 >= n && n25 < 0L) {
                    n25 = ((long)array[n26] & 0xFFFFFFFFL) + n27;
                    array[n26] = (int)n25;
                    --n26;
                }
            }
        }
    }
}
