// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.net.NetworkInfo;
import java.util.HashMap;
import android.os.Handler;
import android.content.Context;
import android.net.ConnectivityManager;

public final class d
{
    private static d Code;
    private String B;
    private String C;
    private int I;
    private ConnectivityManager J;
    private Context Z;
    private int a;
    private h b;
    private B c;
    private boolean d;
    private Handler e;
    private Runnable f;
    
    static {
        d.Code = new d();
    }
    
    private d() {
        this.I = 100;
        this.B = "GoogleAnalytics";
        this.C = "1.4.2";
        new HashMap();
        new HashMap();
        this.f = new Runnable() {
            @Override
            public final void run() {
                com.google.android.apps.analytics.d.this.I();
            }
        };
    }
    
    public static boolean B() {
        return false;
    }
    
    private void C() {
        if (this.a < 0) {
            return;
        }
        this.e.postDelayed(this.f, (long)(this.a * 1000));
    }
    
    public static d Code() {
        return d.Code;
    }
    
    private void a() {
        if (this.e != null) {
            this.e.removeCallbacks(this.f);
        }
    }
    
    public final void Code(final Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        h b;
        if (this.b == null) {
            b = new p(context);
            final int i = this.I;
        }
        else {
            b = this.b;
        }
        B c;
        if (this.c == null) {
            c = new m(this.B, this.C);
        }
        else {
            c = this.c;
        }
        final C c2 = new C(this);
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.Z = context.getApplicationContext();
        this.b = b;
        new Code();
        this.b.Z();
        (this.c = c).Code(c2);
        this.d = false;
        if (this.J == null) {
            this.J = (ConnectivityManager)this.Z.getSystemService("connectivity");
        }
        if (this.e == null) {
            this.e = new Handler(context.getMainLooper());
        }
        else {
            this.a();
        }
        final int a = this.a;
        this.a = -1;
        if (a <= 0) {
            this.C();
        }
        else if (a > 0) {
            this.a();
            this.C();
        }
    }
    
    public final boolean I() {
        if (this.d) {
            this.C();
        }
        else {
            final NetworkInfo activeNetworkInfo = this.J.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                this.C();
                return false;
            }
            if (this.b.I() != 0) {
                this.c.Code(this.b.Code());
                this.d = true;
                this.C();
                return true;
            }
        }
        return false;
    }
    
    public final void J() {
        if (this.c != null) {
            this.c.Code();
        }
        this.a();
    }
    
    final void Z() {
        this.d = false;
    }
}
