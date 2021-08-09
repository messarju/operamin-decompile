// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.google.analytics.tracking.android.CampaignTrackingReceiver;
import com.google.analytics.tracking.android.g;
import android.content.Intent;
import com.google.android.apps.analytics.d;
import android.content.SharedPreferences$Editor;
import android.text.TextUtils;
import android.content.Context;
import android.content.BroadcastReceiver;

public class OpMiniInstallReferrerReceiver extends BroadcastReceiver
{
    public static String Code(final Context context) {
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = context.getSharedPreferences("analytics", 0).getString("referrer", "")))) {
            final String s2 = s = I(context);
            if (!TextUtils.isEmpty((CharSequence)s2)) {
                Code(context, s2);
                s = s2;
            }
        }
        return s;
    }
    
    private static void Code(final Context context, final String s) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("analytics", 0).edit();
        edit.putString("referrer", s);
        edit.commit();
    }
    
    private static String I(final Context context) {
        final d code = d.Code();
        if (code == null) {
            return null;
        }
        try {
            code.Code(context);
            final Object code2 = bs.Code(code, "getHitStore", new Object[0]);
            if (code2 == null) {
                return null;
            }
            final Object code3 = bs.Code(code2, "getReferrer", new Object[0]);
            if (code3 == null) {
                return null;
            }
            return (String)bs.Code(code3, "getReferrerString", new Object[0]);
        }
        catch (Exception ex) {
            return null;
        }
        finally {
            code.J();
        }
    }
    
    public void onReceive(final Context context, final Intent intent) {
        Code(context, intent.getStringExtra("referrer"));
        if (x.s()) {
            g.Code(context);
            g.Code(false);
            new CampaignTrackingReceiver().onReceive(context, intent);
        }
    }
}
