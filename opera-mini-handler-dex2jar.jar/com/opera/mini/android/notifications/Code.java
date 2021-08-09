// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.x;
import com.opera.mini.android.events.EventDispatcher;
import android.content.SharedPreferences;

public final class Code extends k
{
    public Code(final g g, final SharedPreferences sharedPreferences) {
        super(g, sharedPreferences, "Discover", 2130968576, "odp:showuptodate", (byte)0);
        EventDispatcher.Z(new I(this, (byte)0));
    }
    
    @Override
    protected final long Code() {
        if (this.Z.getBoolean("Discover:odp_enabled", false)) {
            return super.Code();
        }
        return Long.MAX_VALUE;
    }
}
