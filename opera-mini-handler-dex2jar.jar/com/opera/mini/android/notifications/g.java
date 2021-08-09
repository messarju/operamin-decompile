// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import android.os.SystemClock;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import java.util.HashMap;
import com.opera.mini.android.x;
import com.opera.mini.android.events.EventDispatcher;
import android.content.Context;
import java.util.Map;
import android.content.SharedPreferences;

public final class g
{
    private static g Code;
    private f B;
    private boolean C;
    private SharedPreferences I;
    private Map J;
    private Context Z;
    
    private g(final Context z) {
        EventDispatcher.Z(new h(this, (byte)0));
        this.Z = z;
        if (x.s()) {
            this.B = new f(z);
        }
        this.I = z.getSharedPreferences("notifications", 0);
        final Code code = new Code(this, this.I);
        final m m = new m(this, this.I);
        final Z z2 = new Z(this, this.I);
        (this.J = new HashMap()).put(code.C(), code);
        this.J.put(m.C(), m);
        this.J.put(z2.C(), z2);
    }
    
    public static g Code(final Context context) {
        if (g.Code == null) {
            g.Code = new g(context);
        }
        return g.Code;
    }
    
    public final long B() {
        return this.I.getLong("last_in_foreground_utc", -1L);
    }
    
    public final f C() {
        return this.B;
    }
    
    public final o Code(final String s) {
        return this.J.get(s);
    }
    
    public final void Code() {
        if (!this.C && this.Z()) {
            final Iterator iterator = this.J.values().iterator();
            long min = Long.MAX_VALUE;
            while (iterator.hasNext()) {
                final o o = (o)iterator.next();
                if (o.b()) {
                    min = Math.min(min, o.Code());
                }
            }
            final PendingIntent broadcast = PendingIntent.getBroadcast(this.Z, 0, new Intent(this.Z, (Class)NotificationAlarmReceiver.class), 134217728);
            final AlarmManager alarmManager = (AlarmManager)this.Z.getSystemService("alarm");
            alarmManager.cancel(broadcast);
            if (min != Long.MAX_VALUE) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                final long n = min - System.currentTimeMillis();
                new StringBuilder("OperaNotificationManager.notifyOrReschedule() delay=").append(n);
                alarmManager.set(3, n + elapsedRealtime, broadcast);
            }
        }
    }
    
    public final Context I() {
        return this.Z;
    }
    
    public final long J() {
        return this.I.getLong("first_start_time_utc", -1L);
    }
    
    public final boolean Z() {
        return this.I.getBoolean("notifications_enabled_by_user", false);
    }
    
    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (final o o : this.J.values()) {
                if (o.e()) {
                    dataOutputStream.writeByte(o.B());
                    dataOutputStream.writeShort(o.c());
                    dataOutputStream.writeShort(o.d());
                }
            }
        }
        catch (IOException ex) {
            new StringBuilder("OperaNotificationManager.getMiniStatsHeader() exception").append(ex.getMessage());
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }
    
    public final boolean b() {
        final Iterator iterator = this.J.values().iterator();
        while (iterator.hasNext()) {
            if (((o)iterator.next()).e()) {
                return true;
            }
        }
        return false;
    }
    
    public final String c() {
        return this.I.getString("ga_tracking_id", (String)null);
    }
}
