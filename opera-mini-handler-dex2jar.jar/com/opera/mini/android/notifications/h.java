// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.ServerNotificationSettingsEvent;
import com.opera.mini.android.events.NotificationSettingChangedEvent;
import android.content.SharedPreferences$Editor;
import com.opera.mini.android.bq;
import com.opera.mini.android.events.BreamInitializedEvent;
import com.opera.mini.android.events.ActivityResumeEvent;
import android.content.Context;
import com.opera.mini.android.ai;
import com.opera.mini.android.x;
import com.opera.mini.android.events.ActivityPausedEvent;

final class h
{
    private /* synthetic */ g Code;
    
    private h(final g code) {
        this.Code = code;
    }
    
    @cr
    public final void onActivityPaused(final ActivityPausedEvent activityPausedEvent) {
        if (x.ak < 7 || ai.Code((Context)activityPausedEvent.Code)) {
            this.Code.C = false;
        }
        x.Code(this.Code.I.edit().putLong("last_in_foreground_utc", System.currentTimeMillis()));
        this.Code.Code();
    }
    
    @cr
    public final void onActivityResumed(final ActivityResumeEvent activityResumeEvent) {
        this.Code.C = true;
    }
    
    @cr
    public final void onBreamInitialized(final BreamInitializedEvent breamInitializedEvent) {
        final SharedPreferences$Editor edit = this.Code.I.edit();
        edit.putBoolean("notifications_enabled_by_user", bq.I());
        if (!this.Code.I.contains("first_start_time_utc")) {
            edit.putLong("first_start_time_utc", System.currentTimeMillis());
        }
        x.Code(edit);
    }
    
    @cr
    public final void onNotificationAlarm(final e e) {
        this.Code.Code();
    }
    
    @cr
    public final void onNotificationSettingChanged(final NotificationSettingChangedEvent notificationSettingChangedEvent) {
        x.Code(this.Code.I.edit().putBoolean("notifications_enabled_by_user", notificationSettingChangedEvent.Code));
    }
    
    @cr
    public final void onServerNotificationSettingEvent(final ServerNotificationSettingsEvent serverNotificationSettingsEvent) {
        x.Code(this.Code.I.edit().putString("ga_tracking_id", serverNotificationSettingsEvent.k));
    }
}
