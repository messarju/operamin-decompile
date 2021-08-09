// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import android.content.SharedPreferences$Editor;
import com.opera.mini.android.x;
import com.opera.mini.android.events.ServerNotificationSettingsEvent;

final class l
{
    private /* synthetic */ k Code;
    
    private l(final k code) {
        this.Code = code;
    }
    
    @cr
    public final void onNewServerNotificationSettings(final ServerNotificationSettingsEvent serverNotificationSettingsEvent) {
        final SharedPreferences$Editor edit = this.Code.Z.edit();
        edit.putLong("prime_time_start", serverNotificationSettingsEvent.Z);
        edit.putLong("prime_time_end", serverNotificationSettingsEvent.J);
        edit.putLong("prime_time_app_paused_protected_time", serverNotificationSettingsEvent.h);
        edit.putLong("prime_time_fresh_run_protected_time", serverNotificationSettingsEvent.g);
        edit.putLong("prime_time_allowed_for", serverNotificationSettingsEvent.f);
        x.Code(edit);
    }
}
