// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.events;

import java.util.Map;

public class ServerNotificationSettingsEvent
{
    public int B;
    public int C;
    public long Code;
    public long I;
    public long J;
    public long Z;
    public int a;
    public long b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public String k;
    
    public ServerNotificationSettingsEvent(final Map map) {
        final boolean b = true;
        this.Code = I(map, "discover_interval");
        this.I = I(map, "mobile_store_interval");
        this.j = I(map, "mobile_store_check_interval");
        this.B = Code(map, "data_saving_min_bytes_received");
        this.C = Code(map, "data_saving_max_bytes_received");
        this.a = Code(map, "data_saving_max_pages_opened");
        this.b = I(map, "data_saving_wait_time");
        this.i = I(map, "data_saving_delay_after_power_connected");
        this.c = (Code(map, "discover_on") == 1);
        this.e = (Code(map, "data_saving_on") == 1);
        this.d = (Code(map, "mobile_store_on") == 1 && b);
        this.Z = Code(Z(map, "prime_time_start"));
        this.J = Code(Z(map, "prime_time_end"));
        this.f = I(map, "prime_time_notification_allowed_time_since_last_paused");
        this.g = I(map, "prime_time_notification_fresh_run_protected_time");
        this.h = I(map, "prime_time_app_paused_protected_time");
        this.k = map.get("ga_tracking_id");
        if (this.k != null) {
            this.k = this.k.trim();
            if (this.k.length() == 0) {
                this.k = null;
            }
        }
    }
    
    private static int Code(final String s) {
        final String[] split = s.split(":");
        if (split.length != 2) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(split[1]) + Integer.parseInt(split[0]) * 60;
    }
    
    private static int Code(final Map map, final String s) {
        return Integer.parseInt(Z(map, s));
    }
    
    private static long I(final Map map, String trim) {
        trim = Z(map, trim).trim();
        long n2;
        final long n = n2 = 1L;
        String substring = trim;
        if (trim.length() > 0) {
            final int n3 = trim.length() - 1;
            final char char1 = trim.charAt(n3);
            n2 = n;
            substring = trim;
            if (!Character.isDigit(char1)) {
                substring = trim.substring(0, n3);
                switch (char1) {
                    default: {
                        n2 = n;
                        break;
                    }
                    case 's': {
                        n2 = 1000L;
                        break;
                    }
                    case 'm': {
                        n2 = 60000L;
                        break;
                    }
                    case 'h': {
                        n2 = 3600000L;
                        break;
                    }
                    case 'd': {
                        n2 = 86400000L;
                        break;
                    }
                }
            }
        }
        return n2 * Long.parseLong(substring);
    }
    
    private static String Z(final Map map, final String s) {
        if (!map.containsKey(s)) {
            throw new IllegalArgumentException(s + " not found");
        }
        return map.get(s);
    }
}
