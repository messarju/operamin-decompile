// 
// Decompiled by Procyon v0.6-prerelease
// 

public class q
{
    public static int Code(final int n) {
        if (n <= 127) {
            return 1;
        }
        if (n <= 2047) {
            return 2;
        }
        if (n <= 65535) {
            return 3;
        }
        return 4;
    }
    
    public static int Code(final int n, final byte[] array, int n2) {
        if (n <= 127) {
            array[n2] = (byte)n;
            return 1;
        }
        if (n <= 2047) {
            array[n2] = (byte)(n >> 6 | 0xC0);
            array[n2 + 1] = (byte)((n & 0x3F) | 0x80);
            return 2;
        }
        if (n <= 65535) {
            final int n3 = n2 + 1;
            array[n2] = (byte)(n >> 12 | 0xE0);
            array[n3] = (byte)((n >> 6 & 0x3F) | 0x80);
            array[n3 + 1] = (byte)((n & 0x3F) | 0x80);
            return 3;
        }
        final int n4 = n2 + 1;
        array[n2] = (byte)(n >> 18 | 0xF0);
        n2 = n4 + 1;
        array[n4] = (byte)((n >> 12 & 0x3F) | 0x80);
        array[n2] = (byte)((n >> 6 & 0x3F) | 0x80);
        array[n2 + 1] = (byte)((n & 0x3F) | 0x80);
        return 4;
    }
    
    public static int Code(final String s) {
        int i = 0;
        int n = 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 >= '\ud800' && char1 <= '\udbff') {
                n += 4;
                ++i;
            }
            else {
                n += Code(char1);
            }
            ++i;
        }
        return n;
    }
    
    public static int Code(final String s, final byte[] array, final int n) {
        int i = 0;
        int n2 = 0;
        while (i < s.length()) {
            int char1 = s.charAt(i);
            if (char1 >= 55296 && char1 <= 56319) {
                ++i;
                char1 = s.charAt(i) - '\udc00' + (65536 + (char1 - 55296 << 10));
            }
            n2 += Code(char1, array, n + n2 + 2);
            ++i;
        }
        I(n2, array, n);
        return n2;
    }
    
    public static String Code(final byte[] array, int n) {
        final int z = Z(array, n);
        n += 2;
        return Code(array, n, z + n);
    }
    
    public static String Code(final byte[] array, final int n, final int n2) {
        return new String(Z(array, n, n2));
    }
    
    public static int I(final byte[] array, final int n) {
        return (array[n] << 8) + (array[n + 1] & 0xFF);
    }
    
    public static void I(final int n, final byte[] array, final int n2) {
        array[n2] = (byte)(n >> 8);
        array[n2 + 1] = (byte)n;
    }
    
    private static boolean I(final int n) {
        return n > 0 && n <= 1114111 && (n < 55296 || n > 57343) && (n < 64976 || n > 65007) && (n & 0xFFFE) != 0xFFFE;
    }
    
    public static boolean I(final byte[] array, int i, int n) {
        n += i;
        while (i < n) {
            switch ((array[i] & 0xFF) >> 4) {
                default: {
                    if (array[i] == 0) {
                        return false;
                    }
                    ++i;
                    continue;
                }
                case 8:
                case 9:
                case 10:
                case 11: {
                    return false;
                }
                case 12:
                case 13: {
                    if (i + 2 <= n && (array[i + 1] & 0xC0) == 0x80 && (array[i] & 0x1F) >= 2) {
                        i = i + 1 + 1;
                        continue;
                    }
                    return false;
                }
                case 14: {
                    if (i + 3 > n || (array[i + 1] & 0xC0) != 0x80 || (array[i + 2] & 0xC0) != 0x80) {
                        return false;
                    }
                    final int n2 = i + 1;
                    final byte b = array[i];
                    final int n3 = n2 + 1;
                    final byte b2 = array[n2];
                    i = n3 + 1;
                    final int n4 = (b2 & 0x3F) << 6 | (b & 0xF) << 12 | (array[n3] & 0x3F);
                    if (n4 < 2048) {
                        return false;
                    }
                    if (!I(n4)) {
                        return false;
                    }
                    continue;
                }
                case 15: {
                    if (i + 4 > n || (array[i + 1] & 0xC0) != 0x80 || (array[i + 2] & 0xC0) != 0x80 || (array[i + 3] & 0xC0) != 0x80 || (array[i] & 0x8) != 0x0) {
                        return false;
                    }
                    final int n5 = i + 1;
                    final byte b3 = array[i];
                    i = n5 + 1;
                    final byte b4 = array[n5];
                    final int n6 = i + 1;
                    final byte b5 = array[i];
                    i = n6 + 1;
                    final int n7 = (b4 & 0x3F) << 12 | (b3 & 0x7) << 18 | (b5 & 0x3F) << 6 | (array[n6] & 0x3F);
                    if (n7 < 65536) {
                        return false;
                    }
                    if (!I(n7)) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }
    
    public static int J(final byte[] array, final int n) {
        return (array[n] << 24) + ((array[n + 1] & 0xFF) << 16) + ((array[n + 2] & 0xFF) << 8) + (array[n + 3] & 0xFF);
    }
    
    public static int Z(final byte[] array, final int n) {
        return ((array[n] & 0xFF) << 8) + (array[n + 1] & 0xFF);
    }
    
    public static void Z(final int n, final byte[] array, final int n2) {
        array[n2] = (byte)(n >> 24);
        array[n2 + 1] = (byte)(n >> 16);
        array[n2 + 2] = (byte)(n >> 8);
        array[n2 + 3] = (byte)n;
    }
    
    private static char[] Z(final byte[] array, int n, final int n2) {
        final int n3 = 0;
        int n4 = 0;
        int n5;
        for (int i = n; i < n2; i = n5) {
            final int j = r.I(array[i]);
            n5 = i + j;
            int n6 = n4;
            if (j == 4) {
                n6 = n4 + 1;
            }
            n4 = n6 + 1;
        }
        final char[] array2 = new char[n4];
        int k = n;
        n = n3;
        while (k < n2) {
            final int b = r.B(array, k);
            if (b <= 65535) {
                final int n7 = n + 1;
                array2[n] = (char)b;
                n = n7;
            }
            else {
                final int n8 = n + 1;
                array2[n] = (char)(0xD800 | b - 65536 >> 10);
                n = n8 + 1;
                array2[n8] = (char)(0xDC00 | (b & 0x3FF));
            }
            k += r.I(array[k]);
        }
        return array2;
    }
}
