// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.ServerNotificationSettingsEvent;
import com.opera.mini.android.events.MobileStoreShownEvent;
import com.opera.mini.android.events.ActivityResumeEvent;

final class J
{
    private /* synthetic */ Z Code;
    
    private J(final Z code) {
        this.Code = code;
    }
    
    @cr
    public final void onActivityResumed(final ActivityResumeEvent activityResumeEvent) {
        Z.Code(this.Code);
    }
    
    @cr
    public final void onMobileStoreShown(final MobileStoreShownEvent mobileStoreShownEvent) {
        Z.I(this.Code);
        this.Code.I(false);
        this.Code.Z();
    }
    
    @cr
    public final void onServerNotificationSettingsReceived(final ServerNotificationSettingsEvent serverNotificationSettingsEvent) {
        Z.Code(this.Code, serverNotificationSettingsEvent.j);
        this.Code.Code(serverNotificationSettingsEvent.I);
        this.Code.Code(serverNotificationSettingsEvent.d);
    }
}
