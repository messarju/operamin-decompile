// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

public class d
{
    public String a(final String s) {
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (true) {
            final int index = s.indexOf("&#", i);
            if (index == -1) {
                break;
            }
            final int index2 = s.indexOf(59, index);
            if (index2 == -1) {
                break;
            }
            int j = index + 2;
            int n = -1;
            while (j < index2) {
                final char char1 = s.charAt(j);
                if ('0' > char1 || char1 > '9') {
                    break;
                }
                int n2;
                if (n == -1) {
                    n2 = 0;
                }
                else {
                    n2 = n * 10;
                }
                n = n2 + char1 - 48;
                ++j;
            }
            if (j != index2) {
                n = -1;
            }
            if (n != -1) {
                sb.append((char)n);
                i = index2 + 1;
            }
            else {
                while (i < j) {
                    sb.append(s.charAt(i));
                    ++i;
                }
                i = j;
            }
        }
        if (sb.length() == 0) {
            return s;
        }
        sb.append(s.substring(i, s.length()));
        return sb.toString();
    }
}
