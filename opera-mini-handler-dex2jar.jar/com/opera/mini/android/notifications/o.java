// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import com.opera.mini.android.Browser;
import android.content.Context;
import android.app.NotificationManager;
import android.content.SharedPreferences$Editor;
import com.opera.mini.android.x;
import com.opera.mini.android.events.EventDispatcher;
import android.content.SharedPreferences;

public abstract class o
{
    private String B;
    private byte C;
    private int Code;
    protected String I;
    protected g J;
    protected SharedPreferences Z;
    
    public o(final g j, final SharedPreferences z, final String i, final int code, final String b, final byte c) {
        this.Code = code;
        this.J = j;
        this.Z = z;
        this.I = i;
        this.B = b;
        this.C = c;
        EventDispatcher.Z(new p(this, (byte)0));
    }
    
    public final byte B() {
        return this.C;
    }
    
    public final String C() {
        return this.I;
    }
    
    protected abstract long Code();
    
    protected final void Code(final boolean b) {
        x.Code(this.Z.edit().putBoolean(this.I + ":enabled", b));
    }
    
    protected void I() {
        new StringBuilder("SystemNotification.send(): ").append(this.I);
        final Context i = this.J.I();
        ((NotificationManager)i.getSystemService("notification")).notify(this.I.hashCode(), q.Code(i, "com.opera.mini.android.ACTION_NOTIFICATION:" + this.I, i.getResources().getString(2130968583), i.getResources().getString(this.Code)));
        x.Code(this.Z.edit().putInt(this.I + ":PENDING_IMPRESSIONS", this.c() + 1));
        if (x.s()) {
            this.J.C().Code(this.I, this.J.c());
        }
    }
    
    public final void a() {
        x.Code(this.Z.edit().putInt(this.I + ":PENDING_CLICKS", this.d() + 1));
        if (x.s()) {
            this.J.C().I(this.I, this.J.c());
        }
        Browser.Z.Code(this.B);
    }
    
    protected final boolean b() {
        return this.Z.getBoolean(this.I + ":enabled", false);
    }
    
    public final int c() {
        return this.Z.getInt(this.I + ":PENDING_IMPRESSIONS", 0);
    }
    
    public final int d() {
        return this.Z.getInt(this.I + ":PENDING_CLICKS", 0);
    }
    
    public final boolean e() {
        return this.c() + this.d() > 0;
    }
}
