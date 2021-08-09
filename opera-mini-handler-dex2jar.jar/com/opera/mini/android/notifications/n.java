// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.ServerNotificationSettingsEvent;
import com.opera.mini.android.events.OnPowerConnected;
import com.opera.mini.android.events.OpenUrlEvent;
import android.content.SharedPreferences$Editor;
import com.opera.mini.android.x;
import com.opera.mini.android.bq;
import com.opera.mini.android.events.ActivityPausedEvent;

final class n
{
    private /* synthetic */ m Code;
    
    private n(final m code) {
        this.Code = code;
    }
    
    @cr
    public final void onActivityPaused(final ActivityPausedEvent activityPausedEvent) {
        final SharedPreferences$Editor edit = this.Code.Z.edit();
        edit.putLong("SavedData:bytes_received", bq.Code());
        edit.putInt("SavedData:saved_percent", bq.J());
        x.Code(edit);
        m.Z(this.Code);
    }
    
    @cr
    public final void onOpenUrl(final OpenUrlEvent openUrlEvent) {
        m.Code(this.Code);
    }
    
    @cr
    public final void onPowerConnected(final OnPowerConnected onPowerConnected) {
        this.Code.Code = true;
        if (this.Code.Z()) {
            this.Code.J.Code();
        }
        this.Code.Code = false;
    }
    
    @cr
    public final void onServerNotificationSettingsReceived(final ServerNotificationSettingsEvent serverNotificationSettingsEvent) {
        final SharedPreferences$Editor edit = this.Code.Z.edit();
        edit.putLong("SavedData:min_bytes_received", (long)serverNotificationSettingsEvent.B);
        edit.putLong("SavedData:max_bytes_received", (long)serverNotificationSettingsEvent.C);
        edit.putInt("SavedData:max_pages_opened", serverNotificationSettingsEvent.a);
        edit.putLong("SavedData:delay_after_power_connected", serverNotificationSettingsEvent.i);
        edit.putLong("SavedData:wait", serverNotificationSettingsEvent.b);
        x.Code(edit);
        this.Code.Code(serverNotificationSettingsEvent.e);
    }
}
