// 
// Decompiled by Procyon v0.6-prerelease
// 

final class v
{
    static String Code(final byte[] array, final int n) {
        final int n2 = 0;
        final int n3 = (n * 4 + 2) / 3;
        final int n4 = (4 - n3 % 4) % 4;
        final byte[] array2 = new byte[n3 + n4];
        int n5 = 0;
        int i;
        while (true) {
            i = n2;
            if (n5 >= n3) {
                break;
            }
            int j;
            int n6;
            int n7;
            byte b;
            for (j = 0, n6 = 0; j < 6; ++j, n6 = (n6 << 1 | (b >> 7 - n7 % 8 & 0x1))) {
                n7 = n5 * 6 + j;
                if (n7 / 8 < n) {
                    b = array[n7 / 8 + 0];
                }
                else {
                    b = 0;
                }
            }
            int n8;
            if (n6 < 26) {
                n8 = (char)(n6 + 65);
            }
            else if (n6 < 52) {
                n8 = (char)(n6 - 26 + 97);
            }
            else if (n6 < 62) {
                n8 = (char)(n6 - 52 + 48);
            }
            else if (n6 == 62) {
                n8 = 43;
            }
            else {
                n8 = 47;
            }
            array2[n5] = (byte)n8;
            ++n5;
        }
        while (i < n4) {
            array2[n3 + i] = 61;
            ++i;
        }
        return new String(array2);
    }
    
    static byte[] Code(final String s) {
        final byte[] array = new byte[s.length() * 3 / 4];
        int i = 0;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            int n4;
            if (char1 >= 'A' && char1 <= 'Z') {
                n4 = char1 - 'A';
            }
            else if (char1 >= 'a' && char1 <= 'z') {
                n4 = char1 - 'a' + 26;
            }
            else if (char1 >= '0' && char1 <= '9') {
                n4 = char1 - '0' + 52;
            }
            else if (char1 == '+') {
                n4 = 62;
            }
            else if (char1 == '/') {
                n4 = 63;
            }
            else {
                if (char1 != '=') {
                    return null;
                }
                break;
            }
            int n5 = n4 | n3 << 6;
            n2 += 6;
            if (n2 >= 8) {
                array[n] = (byte)(n5 >> n2 - 8);
                n5 ^= array[n] << n2 - 8;
                ++n;
                n2 -= 8;
            }
            ++i;
            n3 = n5;
        }
        if (n == array.length) {
            return array;
        }
        final byte[] array2 = new byte[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
}
