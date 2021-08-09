// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.graphics.Bitmap;
import java.io.IOException;
import android.graphics.BitmapFactory;
import android.content.res.AssetManager;

public class p
{
    public static native void Code();
    
    private static native void Code(final int p0, final int p1, final int[] p2);
    
    public static void Code(final AssetManager assetManager) {
        try {
            final Bitmap decodeStream = BitmapFactory.decodeStream(assetManager.open("elements.png"));
            if (decodeStream == null) {
                return;
            }
            final int width = decodeStream.getWidth();
            final int height = decodeStream.getHeight();
            final int[] array = new int[width * height];
            decodeStream.getPixels(array, 0, width, 0, 0, width, height);
            Code(width, height, array);
            decodeStream.recycle();
        }
        catch (IllegalArgumentException ex) {}
        catch (IOException ex2) {}
        catch (ArrayIndexOutOfBoundsException ex3) {}
    }
}
