// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.Vector;
import java.io.FilenameFilter;
import java.util.Enumeration;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.channels.Channels;
import java.io.RandomAccessFile;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;

public final class e implements ar
{
    private File Code;
    private OutputStream I;
    private /* synthetic */ d J;
    private InputStream Z;
    
    public e(final d j, final File code) {
        this.J = j;
        this.Code = code;
    }
    
    @Override
    public final boolean B() {
        return this.Code.canWrite();
    }
    
    @Override
    public final void C() {
        try {
            if (this.I != null) {
                this.I.flush();
                this.I.close();
                this.I = null;
            }
            if (this.Z != null) {
                this.Z.close();
                this.Z = null;
            }
            if (this.Code.exists() && !this.Code.isDirectory() && ap.c(this.Code.getName()) == 0 && d.Code.isConnected()) {
                d.Code.scanFile(this.Code.getAbsolutePath(), (String)null);
            }
        }
        catch (Throwable t) {}
    }
    
    @Override
    public final InputStream Code() {
        if (this.Z == null) {
            this.Z = new FileInputStream(this.Code);
        }
        return this.Z;
    }
    
    @Override
    public final OutputStream Code(final long n) {
        if (this.I == null) {
            FileChannel fileChannel = new RandomAccessFile(this.Code, "rw").getChannel();
            if (n != 0L) {
                fileChannel = fileChannel.position(n);
            }
            this.I = Channels.newOutputStream(fileChannel);
        }
        return this.I;
    }
    
    @Override
    public final Enumeration Code(final String s) {
        File[] array;
        if (s != null && s.length() > 0) {
            final d j = this.J;
            array = this.Code.listFiles(new f(s));
        }
        else {
            array = this.Code.listFiles();
        }
        final Vector<String> vector = new Vector<String>();
        for (int i = 0; i < array.length; ++i) {
            final StringBuilder append = new StringBuilder().append(array[i].getName());
            String s2;
            if (array[i].isDirectory()) {
                s2 = "/";
            }
            else {
                s2 = "";
            }
            vector.addElement(append.append(s2).toString());
        }
        return vector.elements();
    }
    
    @Override
    public final String I() {
        return this.Code.getAbsolutePath();
    }
    
    @Override
    public final boolean J() {
        return this.Code.exists();
    }
    
    @Override
    public final long Z() {
        return this.Code.length();
    }
}
