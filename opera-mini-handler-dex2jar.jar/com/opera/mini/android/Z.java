// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.opera.mini.android.events.ActivityDestroyEvent;
import java.util.Map;
import com.admarvel.android.ads.AdMarvelUtils;
import com.opera.mini.android.events.ActivityCreateEvent;

final class Z
{
    private Z() {
    }
    
    @cr
    public final void onCreate(final ActivityCreateEvent activityCreateEvent) {
        try {
            AdMarvelUtils.initialize(activityCreateEvent.Code, null);
        }
        catch (Exception ex) {}
    }
    
    @cr
    public final void onDestroy(final ActivityDestroyEvent activityDestroyEvent) {
        try {
            AdMarvelUtils.uninitialize(activityDestroyEvent.Code);
        }
        catch (Exception ex) {}
    }
}
