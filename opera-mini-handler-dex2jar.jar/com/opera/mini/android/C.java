// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.DataInputStream;

final class C extends t
{
    volatile byte[] B;
    String C;
    volatile int J;
    private int a;
    
    C(final String s, final String s2, final String s3) {
        super(s, s2, s3);
    }
    
    @Override
    protected final void Code(final int n, final String c) {
        this.C = c;
        this.J = -1;
    }
    
    @Override
    protected final void Code(final DataInputStream dataInputStream) {
        if (this.J <= 0) {
            throw new IOException("AdMarvelRequest.payload: Invalid content length");
        }
        final byte[] array = new byte[1024];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.J);
        while (this.a < this.J) {
            final int read = dataInputStream.read(array);
            if (read < 0) {
                throw new IOException("AdMarvelRequest.payload: Read -1 bytes.");
            }
            byteArrayOutputStream.write(array, 0, read);
            this.a += read;
        }
        this.B = byteArrayOutputStream.toByteArray();
    }
    
    @Override
    protected final boolean Code(final String s, final String s2) {
        if (s.equals("content-length")) {
            this.J = Integer.parseInt(s2);
        }
        return true;
    }
}
