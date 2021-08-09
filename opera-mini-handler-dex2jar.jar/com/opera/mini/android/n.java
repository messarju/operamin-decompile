// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.nio.Buffer;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class n implements l
{
    private k Code;
    private ByteBuffer I;
    
    public n(final k code, final ByteBuffer i) {
        this.Code = code;
        this.I = i;
    }
    
    @Override
    public final void Code(final Bitmap bitmap) {
        bitmap.copyPixelsFromBuffer((Buffer)this.I);
    }
    
    @Override
    public native boolean Code();
    
    @Override
    public native void I();
}
