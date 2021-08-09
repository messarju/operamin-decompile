// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.ActivityResumeEvent;
import android.content.Context;
import com.opera.mini.android.events.ActivityPausedEvent;
import com.opera.mini.android.events.ActivityDestroyEvent;
import com.opera.mini.android.events.ActivityCreateEvent;

public final class C
{
    @cr
    public final void onActivityCreate(final ActivityCreateEvent activityCreateEvent) {
        activityCreateEvent.Code.registerReceiver(B.Z, B.J);
    }
    
    @cr
    public final void onActivityDestroy(final ActivityDestroyEvent activityDestroyEvent) {
        activityDestroyEvent.Code.unregisterReceiver(B.Z);
    }
    
    @cr
    public final void onActivityPaused(final ActivityPausedEvent activityPausedEvent) {
        if (B.I != null) {
            a((Context)activityPausedEvent.Code).listen(B.I, 0);
        }
    }
    
    @cr
    public final void onActivityResumed(final ActivityResumeEvent activityResumeEvent) {
        if (B.I != null) {
            a((Context)activityResumeEvent.Code).listen(B.I, 256);
        }
    }
}
