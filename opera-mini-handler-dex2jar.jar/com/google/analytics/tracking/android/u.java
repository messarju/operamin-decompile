// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

final class u extends TimerTask
{
    private /* synthetic */ r Code;
    
    private u(final r code) {
        this.Code = code;
    }
    
    @Override
    public final void run() {
        if (this.Code.I == s.Code) {
            this.Code.c();
        }
    }
}
