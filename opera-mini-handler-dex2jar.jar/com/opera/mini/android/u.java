// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.opera.mini.android.events.ActivityResumeEvent;

final class u
{
    private /* synthetic */ J Code;
    
    u(final J code) {
        this.Code = code;
    }
    
    @cr
    public final void onActivityResumed(final ActivityResumeEvent activityResumeEvent) {
        J.u = null;
        this.Code.ay();
    }
}
