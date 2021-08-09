// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.graphics.Bitmap$Config;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.Paint;

public final class r extends ba
{
    private static Paint Code;
    
    static {
        r.Code = new Paint();
    }
    
    public r() {
        r.Code.setFilterBitmap(true);
    }
    
    private static az Code(final Bitmap bitmap, final boolean b) {
        final int[] array = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(array, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (b) {
            Code(array, bitmap.getWidth(), bitmap.getHeight());
        }
        return new q(array, bitmap.getWidth(), bitmap.getHeight(), true);
    }
    
    public static az Code(final InputStream inputStream) {
        return Code(BitmapFactory.decodeStream(inputStream), false);
    }
    
    private static void Code(final int[] array, final int n, final int n2) {
        int i = 0;
        int n3 = 0;
        while (i < n2) {
            for (int j = 0; j < n; ++j) {
                final int n4 = array[n3];
                final int n5 = n4 >> 16 & 0xFF;
                final int n6 = n4 >> 8 & 0xFF;
                final int n7 = n4 & 0xFF;
                final int n8 = n5 & 0xFFFFFFF8;
                final int n9 = n6 & 0xFFFFFFFC;
                final int n10 = n7 & 0xFFFFFFF8;
                final int n11 = n8 | n8 >> 5;
                final int n12 = n9 | n9 >> 6;
                final int n13 = n10 | n10 >> 5;
                array[n3] = ((n4 & 0xFF000000) | n11 << 16 | n12 << 8 | n13);
                final int n14 = n5 - n11;
                final int n15 = n6 - n12;
                final int n16 = n7 - n13;
                final int n17 = n14 / 2;
                final int n18 = n15 / 2;
                final int n19 = n16 / 2;
                if (j < n - 1) {
                    Code(array, n3 + 1, n14 - n17, n15 - n18, n16 - n19);
                }
                if (i < n2 - 1) {
                    Code(array, n3 + n, n17, n18, n19);
                }
                ++n3;
            }
            ++i;
        }
    }
    
    private static void Code(final int[] array, final int n, int n2, int n3, final int n4) {
        if (n2 == 0 && n3 == 0 && n4 == 0) {
            return;
        }
        final int n5 = array[n];
        final int n6 = n5 >> 16 & 0xFF;
        final int n7 = n5 >> 8 & 0xFF;
        final int n8 = n5 & 0xFF;
        int n9;
        if (n2 > 0) {
            n9 = Math.min(255, n6 + n2);
        }
        else {
            n9 = n6;
            if (n2 < 0) {
                n9 = Math.max(0, n6 + n2);
            }
        }
        if (n3 > 0) {
            n2 = Math.min(255, n7 + n3);
        }
        else {
            n2 = n7;
            if (n3 < 0) {
                n2 = Math.max(0, n7 + n3);
            }
        }
        if (n4 > 0) {
            n3 = Math.min(255, n8 + n4);
        }
        else {
            n3 = n8;
            if (n4 < 0) {
                n3 = Math.max(0, n8 + n4);
            }
        }
        array[n] = (n3 | (n2 << 8 | (n9 << 16 | (n5 & 0xFF000000))));
    }
    
    @Override
    public final az Code(final int n, final int n2) {
        return new q(n, n2);
    }
    
    @Override
    protected final az Code(final byte[] array, final int n, final int n2, final boolean b) {
        return Code(BitmapFactory.decodeByteArray(array, n, n2), b);
    }
    
    @Override
    public final az Code(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5) {
        return new q(array, n, n2, n3, n4, n5);
    }
    
    @Override
    public final az Code(final int[] array, final int n, final int n2, final boolean b, final boolean b2) {
        if (b2) {
            Code(array, n, n2);
        }
        return new q(array, n, n2, b);
    }
    
    @Override
    protected final ch Code() {
        return new aa();
    }
    
    @Override
    public final Object Code(final byte[] array, final int n, final int n2) {
        if (array.length < n + n2) {
            return null;
        }
        if (cg.v && ba.I(array, n, n2)) {
            final aa aa = new aa();
            if (aa.Code(array, n, n2)) {
                final long z = aa.Z();
                aa.Code();
                aa.I();
                return new t(z);
            }
            return null;
        }
        else {
            final Bitmap decodeByteArray = BitmapFactory.decodeByteArray(array, n, n2);
            if (decodeByteArray == null) {
                return null;
            }
            Bitmap copy;
            if (decodeByteArray.getConfig() == null) {
                Bitmap$Config bitmap$Config;
                if (decodeByteArray.hasAlpha()) {
                    bitmap$Config = Bitmap$Config.ARGB_8888;
                }
                else {
                    bitmap$Config = Bitmap$Config.RGB_565;
                }
                copy = decodeByteArray.copy(bitmap$Config, false);
            }
            else {
                copy = decodeByteArray;
            }
            return new t(copy);
        }
    }
}
