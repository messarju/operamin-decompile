// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.x;
import com.opera.mini.android.events.EventDispatcher;
import android.content.SharedPreferences;

public final class m extends o
{
    private boolean Code;
    
    public m(final g g, final SharedPreferences sharedPreferences) {
        final String j = com.opera.mini.android.notifications.B.J(g.I());
        String s;
        if ("in".equalsIgnoreCase(j)) {
            s = "india";
        }
        else if ("za".equalsIgnoreCase(j)) {
            s = "sa";
        }
        else {
            s = "global";
        }
        super(g, sharedPreferences, "SavedData", 2130968579, String.format("http://www.opera.com/o/opera-mini-reengage?region=%s&savings=%s", s, sharedPreferences.getInt("SavedData:saved_percent", 0)), (byte)1);
        EventDispatcher.Z(new n(this, (byte)0));
    }
    
    private void I(final boolean b) {
        x.Code(this.Z.edit().putBoolean("SavedData:notified", b));
    }
    
    private boolean Z() {
        if (!this.Z.getBoolean("SavedData:notified", true)) {
            int n;
            if (System.currentTimeMillis() >= this.J.B() + this.Z.getLong("SavedData:wait", 2147483647L)) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (n != 0) {
                final long long1 = this.Z.getLong("SavedData:bytes_received", 0L);
                int n2;
                if (long1 > this.Z.getLong("SavedData:min_bytes_received", 2147483647L) && long1 < this.Z.getLong("SavedData:max_bytes_received", 0L)) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                if (n2 != 0) {
                    final int int1 = this.Z.getInt("SavedData:open_url_counter", 0);
                    boolean b;
                    if (int1 > 0 && int1 <= this.Z.getInt("SavedData:max_pages_opened", Integer.MAX_VALUE)) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    if (b && this.Z.getInt("SavedData:saved_percent", 0) > 15) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    protected final long Code() {
        if (this.Z()) {
            if (this.Code) {
                return System.currentTimeMillis() + this.Z.getLong("SavedData:delay_after_power_connected", 2147483647L);
            }
            this.I();
            this.I(true);
        }
        return Long.MAX_VALUE;
    }
}
