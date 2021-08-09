// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.os.IBinder;
import java.io.IOException;
import android.content.ServiceConnection;
import android.content.Intent;
import android.os.Looper;
import com.admarvel.android.ads.Version;
import android.content.Context;
import java.lang.ref.WeakReference;

public class j
{
    public static j a;
    private String b;
    private int c;
    private final WeakReference d;
    
    private j(Context context) {
        int n;
        int n2;
        int n3;
        String a;
        boolean a2;
        Label_0086_Outer:Label_0135_Outer:
        while (true) {
            n = 1;
            n2 = 0;
            this.b = "VALUE_NOT_DEFINED";
            this.d = new WeakReference((T)context);
            while (true) {
                Label_0197: {
                    Label_0169: {
                        while (true) {
                            while (true) {
                                try {
                                    Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                                    n3 = 1;
                                    if (n3 == 0) {
                                        break Label_0197;
                                    }
                                    context = (Context)new j$e(this, context);
                                    a = ((j$e)context).b();
                                    a2 = ((j$e)context).a();
                                    if (a == null || a.length() <= 0) {
                                        break Label_0169;
                                    }
                                    this.a(a);
                                    if (a2) {
                                        this.a(n);
                                        if (this.b != null && this.b.equals("VALUE_NOT_DEFINED")) {
                                            Logging.log("Not able to fetch GoogleAdv Id form google service library trying form gms IAdvertisingIdService" + this.b);
                                            n3 = n2;
                                            if (n3 == 0 && Version.getAndroidSDKVersion() > 8) {
                                                Logging.log("Fetching from IAdvertisingIdService ");
                                                this.b();
                                            }
                                            return;
                                        }
                                        break Label_0197;
                                    }
                                }
                                catch (ClassNotFoundException ex) {
                                    n3 = 0;
                                    continue Label_0086_Outer;
                                }
                                break;
                            }
                            n = 0;
                            continue Label_0135_Outer;
                        }
                    }
                    Logging.log("Not able to fetch GoogleAdv Id form google service library trying form gms IAdvertisingIdService" + this.b);
                    n3 = n2;
                    continue;
                }
                continue;
            }
        }
    }
    
    public static void a() {
        j.a = null;
    }
    
    public static j c(final Context context) {
        if (j.a == null || (j.a != null && j.a.b.equals("VALUE_NOT_DEFINED"))) {
            j.a = null;
            j.a = new j(context);
        }
        return j.a;
    }
    
    private static void e(final Context ex) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        j$b j$b;
        try {
            ((Context)ex).getPackageManager().getPackageInfo("com.android.vending", 0);
            j$b = new j$b(null);
            final Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (((Context)ex).bindService(intent, (ServiceConnection)j$b, 1)) {
                final j$b j$b2 = j$b;
                final IBinder binder = j$b2.a();
                final j$c j$c = new j$c(binder);
                final j$c j$c3;
                final j$c j$c2 = j$c3 = j$c;
                final String s = j$c3.a();
                final j$c j$c4 = j$c2;
                final boolean b = true;
                final Exception ex2 = ex;
                final boolean b2 = j$c4.a(b, (Context)ex2);
                final j$a j$a = new j$a(s, b2);
                final j j = com.admarvel.android.util.j.a;
                final j$a j$a2 = j$a;
                final String s2 = j$a2.a();
                j.b = s2;
                return;
            }
            throw new IOException("Google Play connection failed");
        }
        catch (Exception ex) {
            throw ex;
        }
        try {
            final j$b j$b2 = j$b;
            final IBinder binder = j$b2.a();
            final j$c j$c = new j$c(binder);
            final j$c j$c3;
            final j$c j$c2 = j$c3 = j$c;
            final String s = j$c3.a();
            final j$c j$c4 = j$c2;
            final boolean b = true;
            final Exception ex2 = ex;
            final boolean b2 = j$c4.a(b, (Context)ex2);
            final j$a j$a = new j$a(s, b2);
            final j j = com.admarvel.android.util.j.a;
            final j$a j$a2 = j$a;
            final String s2 = j$a2.a();
            j.b = s2;
            return;
        }
        catch (Exception ex3) {
            throw ex3;
        }
        finally {
            ((Context)ex).unbindService((ServiceConnection)j$b);
        }
        throw new IOException("Google Play connection failed");
    }
    
    public int a(final Context context) {
        return this.c;
    }
    
    public void a(final int c) {
        this.c = c;
    }
    
    public void a(final String b) {
        this.b = b;
    }
    
    public String b(final Context context) {
        if (this.b != null) {
            return this.b;
        }
        return "VALUE_NOT_DEFINED";
    }
    
    public void b() {
        Context context;
        if (this.d != null) {
            context = (Context)this.d.get();
        }
        else {
            context = null;
        }
        if (context != null) {
            new Thread(new j$d(this, context)).start();
        }
    }
}
