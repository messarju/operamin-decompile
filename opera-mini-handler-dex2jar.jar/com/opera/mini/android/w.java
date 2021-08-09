// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

final class w implements Runnable
{
    private EditView Code;
    private String I;
    
    w(final EditView code, final String i) {
        this.Code = code;
        this.I = i;
    }
    
    @Override
    public final void run() {
        this.Code.Code(false);
        this.Code.setText((CharSequence)this.I);
        this.Code.setSelection(this.I.length());
        this.Code.Code(true);
    }
}
