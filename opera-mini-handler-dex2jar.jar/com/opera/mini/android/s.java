// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class s extends Inflater implements bd
{
    private byte[] Code;
    private int I;
    
    public s() {
        super(true);
    }
    
    @Override
    public final void Code() {
        this.Code(new byte[32768]);
    }
    
    @Override
    public final void Code(final bx bx) {
    }
    
    @Override
    public final void Code(final byte[] code) {
        this.Code = code;
        this.I = 0;
    }
    
    @Override
    public final int I() {
        return this.I;
    }
    
    @Override
    public final void end() {
        super.end();
    }
    
    @Override
    public final int read(final byte[] array, final int n, final int n2) {
        this.I = 0;
        Label_0025: {
            if (array == null) {
                break Label_0025;
            }
            while (true) {
                while (true) {
                    try {
                        this.I = super.inflate(array, n, n2);
                        return this.I;
                        this.I = super.inflate(this.Code, n, n2);
                        return this.I;
                    }
                    catch (DataFormatException ex) {
                        return this.I;
                    }
                    continue;
                }
            }
        }
    }
    
    @Override
    public final void setInput(final byte[] array, final int n, final int n2) {
        super.setInput(array, n, n2);
    }
}
