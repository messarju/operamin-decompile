// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

final class w extends TimerTask
{
    private /* synthetic */ r Code;
    
    private w(final r code) {
        this.Code = code;
    }
    
    @Override
    public final void run() {
        this.Code.d();
    }
}
