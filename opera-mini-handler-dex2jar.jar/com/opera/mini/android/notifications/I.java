// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.ServerNotificationSettingsEvent;
import com.opera.mini.android.events.OdpVisitedEvent;
import com.opera.mini.android.events.OdpSettingEvent;
import com.opera.mini.android.bq;
import com.opera.mini.android.events.BreamInitializedEvent;

final class I
{
    private /* synthetic */ Code Code;
    
    private I(final Code code) {
        this.Code = code;
    }
    
    @cr
    public final void onBreamInitialized(final BreamInitializedEvent breamInitializedEvent) {
        com.opera.mini.android.notifications.Code.Code(this.Code, bq.Z());
    }
    
    @cr
    public final void onOdpSettingChanged(final OdpSettingEvent odpSettingEvent) {
        com.opera.mini.android.notifications.Code.Code(this.Code, odpSettingEvent.Code);
    }
    
    @cr
    public final void onOdpVisited(final OdpVisitedEvent odpVisitedEvent) {
        this.Code.Z();
    }
    
    @cr
    public final void onServerNotificationSettingsReceived(final ServerNotificationSettingsEvent serverNotificationSettingsEvent) {
        this.Code.Code(serverNotificationSettingsEvent.Code);
        this.Code.Code(serverNotificationSettingsEvent.c);
    }
}
