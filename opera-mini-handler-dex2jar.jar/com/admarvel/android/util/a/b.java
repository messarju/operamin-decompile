// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util.a;

import com.admarvel.android.ads.AdMarvelAd;
import android.os.Handler;
import java.util.Map;
import android.content.Context;
import com.admarvel.android.ads.AdFetcher$Adtype;
import android.app.Activity;

public class b
{
    public static String a(String s, final String s2) {
        try {
            final Object a = com.admarvel.android.util.a.a.a(null, "readData").a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils")).a(String.class, s).a(String.class, s2).a();
            if (a != null && a instanceof String) {
                s = (String)a;
                return s;
            }
        }
        catch (Exception ex) {}
        return null;
    }
    
    public static void a() {
        synchronized (b.class) {
            try {
                a.a(null, "disableNetworkActivity").a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils")).a();
            }
            catch (Exception ex) {}
        }
    }
    
    public static void a(final Activity activity, final String s) {
        try {
            a.a(null, "initializeOfflineSDK").a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils")).a(Activity.class, activity).a(String.class, s).a();
        }
        catch (Exception ex) {}
    }
    
    public static void b(final Activity activity, final String s) {
        synchronized (b.class) {
            try {
                a.a(null, "enableNetworkActivity").a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils")).a(Activity.class, activity).a(String.class, s).a();
            }
            catch (Exception ex) {}
        }
    }
    
    public String a(final AdFetcher$Adtype adFetcher$Adtype, final Context context, final String s, final int n, final String s2, final Map map, final String s3, final String s4, final int n2, final String s5, final boolean b, final Handler handler, final boolean b2) {
        try {
            final c$a a = com.admarvel.android.util.a.a.a(Class.forName("com.admarvel.android.offlinesdk.AdMarvelOfflineAdFetcher").newInstance(), "fetchAdFromLocal");
            a.a(AdFetcher$Adtype.class, adFetcher$Adtype);
            a.a(Context.class, context);
            a.a(String.class, s);
            a.a(Integer.TYPE, n);
            a.a(String.class, s2);
            a.a(Map.class, map);
            a.a(String.class, s3);
            a.a(String.class, s4);
            a.a(Integer.TYPE, n2);
            a.a(String.class, s5);
            a.a(Boolean.TYPE, b);
            a.a(Handler.class, handler);
            a.a(Boolean.TYPE, b2);
            final Object a2 = a.a();
            if (a2 != null && a2 instanceof String) {
                return (String)a2;
            }
        }
        catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public void a(final AdMarvelAd adMarvelAd, final Context context, final Handler handler) {
        try {
            final c$a a = com.admarvel.android.util.a.a.a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils").newInstance(), "firePixel");
            a.a(AdMarvelAd.class, adMarvelAd);
            a.a(Context.class, context);
            a.a(Handler.class, handler);
            a.a();
        }
        catch (Exception ex) {}
    }
    
    public void a(final String s, final Context context, final Handler handler) {
        try {
            final c$a a = com.admarvel.android.util.a.a.a(Class.forName("com.admarvel.android.offlinesdk.AdmarvelOfflineUtils").newInstance(), "firePixel");
            a.a(String.class, s);
            a.a(Context.class, context);
            a.a(Handler.class, handler);
            a.a();
        }
        catch (Exception ex) {}
    }
}
