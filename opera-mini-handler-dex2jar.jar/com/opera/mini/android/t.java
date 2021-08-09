// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.nio.Buffer;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

class t
{
    private static ByteBuffer b;
    private boolean B;
    private int C;
    private long Code;
    private Bitmap I;
    private int J;
    private int Z;
    private int a;
    
    public t(final long code) {
        this.Code = code;
    }
    
    public t(final Bitmap i) {
        this.Z = i.getHeight();
        this.J = i.getWidth();
        this.B = i.hasAlpha();
        this.C = i.getRowBytes();
        if (i.getConfig() == Bitmap$Config.ALPHA_8) {
            this.a = 0;
        }
        else if (i.getConfig() == Bitmap$Config.ARGB_4444) {
            this.a = 1;
        }
        else if (i.getConfig() == Bitmap$Config.ARGB_8888) {
            this.a = 2;
        }
        else if (i.getConfig() == Bitmap$Config.RGB_565) {
            this.a = 3;
        }
        else {
            this.a = -1;
        }
        this.I = i;
    }
    
    public void Code(final ByteBuffer byteBuffer) {
        this.I.copyPixelsToBuffer((Buffer)byteBuffer);
    }
    
    public byte[] Code() {
        final int n = this.C * this.Z;
        if (t.b == null || t.b.capacity() < n) {
            t.b = ByteBuffer.allocate(n);
        }
        t.b.rewind();
        this.I.copyPixelsToBuffer((Buffer)t.b);
        return t.b.array();
    }
    
    @Override
    protected native void finalize();
}
