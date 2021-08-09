// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import android.app.Activity;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Map;
import android.content.Context;

public final class l
{
    private static l Code;
    private String B;
    private int C;
    private boolean I;
    private String J;
    private String Z;
    private boolean a;
    private Double b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private long h;
    private Context i;
    private final Map j;
    private an k;
    private aj l;
    private g m;
    private al n;
    private h o;
    private Timer p;
    private TimerTask q;
    private boolean r;
    
    private l() {
        this.I = false;
        this.C = 1800;
        this.e = false;
        this.f = 0;
        this.j = new HashMap();
        this.k = null;
        this.r = false;
        this.o = new h() {
            @Override
            public final long Code() {
                return System.currentTimeMillis();
            }
        };
    }
    
    public static l Code() {
        if (l.Code == null) {
            l.Code = new l();
        }
        return l.Code;
    }
    
    public static an I() {
        if (Code().i == null) {
            throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
        }
        return Code().k;
    }
    
    private void Z() {
        synchronized (this) {
            if (this.p != null) {
                this.p.cancel();
                this.p = null;
            }
        }
    }
    
    public final void Code(final Activity activity) {
        this.Code((Context)activity);
        if (this.I) {
            this.Z();
            if (!this.r && this.f == 0) {
                int n;
                if (this.g == 0L || (this.g > 0L && this.o.Code() > this.h + this.g)) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n != 0) {
                    this.k.Code();
                    final boolean e = this.e;
                }
            }
            this.r = true;
            ++this.f;
            if (this.e) {
                final an k = this.k;
                final String canonicalName = activity.getClass().getCanonicalName();
                String code;
                if (this.j.containsKey(canonicalName)) {
                    code = this.j.get(canonicalName);
                }
                else {
                    if ((code = this.l.Code(canonicalName)) == null) {
                        code = canonicalName;
                    }
                    this.j.put(canonicalName, code);
                }
                k.Z(code);
            }
        }
    }
    
    public final void Code(final Context context) {
        final boolean b = true;
        if (context == null) {
            ae.I("Context cannot be null");
        }
        else {
            final e code = com.google.analytics.tracking.android.e.Code();
            final aj l = new aj(context.getApplicationContext());
            final g code2 = com.google.analytics.tracking.android.g.Code(context.getApplicationContext());
            if (context == null) {
                ae.I("Context cannot be null");
            }
            if (this.i == null) {
                this.i = context.getApplicationContext();
                this.m = code2;
                this.n = code;
                this.l = l;
                this.Z = this.l.Code("ga_trackingId");
                if (TextUtils.isEmpty((CharSequence)this.Z)) {
                    this.Z = this.l.Code("ga_api_key");
                    if (TextUtils.isEmpty((CharSequence)this.Z)) {
                        ae.I("EasyTracker requested, but missing required ga_trackingId");
                        this.k = new m();
                        return;
                    }
                }
                this.I = true;
                this.J = this.l.Code("ga_appName");
                this.B = this.l.Code("ga_appVersion");
                this.a = this.l.Z("ga_debug");
                this.b = this.l.I("ga_sampleFrequency");
                if (this.b == null) {
                    this.b = new Double(this.l.Code("ga_sampleRate", 100));
                }
                this.C = this.l.Code("ga_dispatchPeriod", 1800);
                this.g = this.l.Code("ga_sessionTimeout", 30) * 1000;
                boolean e = b;
                if (!this.l.Z("ga_autoActivityTracking")) {
                    e = (this.l.Z("ga_auto_activity_tracking") && b);
                }
                this.e = e;
                this.c = this.l.Z("ga_anonymizeIp");
                this.d = this.l.Z("ga_reportUncaughtExceptions");
                this.k = this.m.Code(this.Z);
                if (!TextUtils.isEmpty((CharSequence)this.J)) {
                    ae.Z("setting appName to " + this.J);
                    this.k.Code(this.J);
                }
                if (this.B != null) {
                    this.k.I(this.B);
                }
                this.k.Code(this.c);
                this.k.Code(this.b);
                final g m = this.m;
                com.google.analytics.tracking.android.g.Code(this.a);
                this.n.Code(this.C);
                if (this.d) {
                    Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new p(this.k, this.n, Thread.getDefaultUncaughtExceptionHandler(), this.i));
                }
            }
        }
    }
    
    public final void I(final Activity activity) {
        this.Code((Context)activity);
        if (this.I) {
            --this.f;
            this.f = Math.max(0, this.f);
            this.h = this.o.Code();
            if (this.f == 0) {
                this.Z();
                this.q = new n(this, (byte)0);
                (this.p = new Timer("waitForActivityStart")).schedule(this.q, 1000L);
            }
        }
    }
}
