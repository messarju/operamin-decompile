// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

class bb implements Runnable
{
    ba Code;
    final /* synthetic */ ba I;
    
    public bb(final ba i, final ba code) {
        this.I = i;
        this.Code = code;
    }
    
    @Override
    public void run() {
        this.Code.c();
    }
}
