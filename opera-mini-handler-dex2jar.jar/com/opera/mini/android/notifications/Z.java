// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import java.sql.Date;
import android.net.Uri;
import com.opera.mini.android.x;
import com.opera.mini.android.events.EventDispatcher;
import java.util.Locale;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;

public final class Z extends k
{
    SimpleDateFormat Code;
    
    public Z(final g g, final SharedPreferences sharedPreferences) {
        super(g, sharedPreferences, "MobileStore", 2130968577, "http://mobilestore.opera.com", (byte)2);
        this.Code = new SimpleDateFormat("yyyyMMdd", Locale.US);
        EventDispatcher.Z(new J(this, (byte)0));
    }
    
    private void I(final boolean b) {
        x.Code(this.Z.edit().putBoolean("MobileStore:have_new_apps", b));
    }
    
    private boolean f() {
        return this.Z.getBoolean("MobileStore:have_new_apps", true);
    }
    
    private boolean g() {
        return this.Z.getBoolean("MobileStore:oms_visited", false);
    }
    
    @Override
    protected final long Code() {
        if (this.f() && this.g()) {
            return super.Code();
        }
        return Long.MAX_VALUE;
    }
    
    @Override
    protected final void I() {
        super.I();
        this.I(false);
    }
}
