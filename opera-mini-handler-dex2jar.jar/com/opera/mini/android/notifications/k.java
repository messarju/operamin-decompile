// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.x;
import java.util.GregorianCalendar;
import com.opera.mini.android.events.EventDispatcher;
import android.content.SharedPreferences;

public abstract class k extends o
{
    public k(final g g, final SharedPreferences sharedPreferences, final String i, final int n, final String s, final byte b) {
        super(g, sharedPreferences, i, n, s, b);
        this.I = i;
        EventDispatcher.Z(new l(this, (byte)0));
    }
    
    private long f() {
        return this.Z.getLong("prime_time_start", 2147483647L);
    }
    
    @Override
    protected long Code() {
        final long max = Math.max(this.J.B() + this.Z.getLong("prime_time_app_paused_protected_time", 2147483647L), Math.max(this.J.J() + this.Z.getLong("prime_time_fresh_run_protected_time", 2147483647L), this.J() + this.Z.getLong(this.I + ":interval", 2147483647L)));
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(max);
        final int n = gregorianCalendar.get(12) + gregorianCalendar.get(11) * 60;
        long n2;
        if (n < this.f()) {
            n2 = max + (this.f() - n) * 60000L;
        }
        else {
            n2 = max;
            if (n > this.Z.getLong("prime_time_end", -1L)) {
                n2 = max + 86400000L - (n - this.f()) * 60000L;
            }
        }
        int n3;
        if (n2 - this.J.B() > this.Z.getLong("prime_time_allowed_for", Long.MAX_VALUE)) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        if (n3 != 0) {
            n2 = Long.MAX_VALUE;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        new StringBuilder("PrimeTimeNotification").append(this.I).append(" delay=").append(n2 - currentTimeMillis);
        if (n2 <= currentTimeMillis) {
            this.I();
            this.Z();
            return Long.MAX_VALUE;
        }
        return n2;
    }
    
    protected final void Code(final long n) {
        x.Code(this.Z.edit().putLong(this.I + ":interval", n));
    }
    
    protected final long J() {
        return this.Z.getLong(this.I + ":timestamp_utc", 0L);
    }
    
    protected final void Z() {
        x.Code(this.Z.edit().putLong(this.I + ":timestamp_utc", System.currentTimeMillis()));
    }
}
