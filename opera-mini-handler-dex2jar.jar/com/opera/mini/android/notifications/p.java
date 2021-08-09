// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.events.NotificationStatsAck;

final class p
{
    private /* synthetic */ o Code;
    
    private p(final o code) {
        this.Code = code;
    }
    
    @cr
    public final void onNotificationImpressionAck(final NotificationStatsAck notificationStatsAck) {
        o.Code(this.Code);
    }
}
