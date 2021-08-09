// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.TimerTask;

final class t extends TimerTask
{
    private /* synthetic */ r Code;
    
    private t(final r code) {
        this.Code = code;
    }
    
    @Override
    public final void run() {
        if (this.Code.I == s.I && this.Code.a.isEmpty() && this.Code.Code + this.Code.i < this.Code.h.Code()) {
            ae.J("Disconnecting due to inactivity");
            this.Code.e();
            return;
        }
        this.Code.e.schedule(new t(this.Code), this.Code.i);
    }
}
