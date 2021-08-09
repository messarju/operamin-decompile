// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

final class n extends TimerTask
{
    private /* synthetic */ l Code;
    
    private n(final l code) {
        this.Code = code;
    }
    
    @Override
    public final void run() {
        this.Code.r = false;
    }
}
