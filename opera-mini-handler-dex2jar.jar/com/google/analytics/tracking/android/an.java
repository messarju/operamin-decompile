// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.text.DecimalFormat;

public class an
{
    private long B;
    private long C;
    private final ap Code;
    private final ao I;
    private volatile boolean J;
    private volatile boolean Z;
    private boolean a;
    
    static {
        new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
    }
    
    an() {
        this.Z = false;
        this.J = false;
        this.B = 120000L;
        this.a = true;
        this.Code = null;
        this.I = null;
    }
    
    an(final String s, final ap code) {
        this.Z = false;
        this.J = false;
        this.B = 120000L;
        this.a = true;
        if (s == null) {
            throw new IllegalArgumentException("trackingId cannot be null");
        }
        this.Code = code;
        (this.I = new ao((byte)0)).I("trackingId", s);
        this.I.I("sampleRate", "100");
        this.I.Code("sessionControl", "start");
        this.I.I("useSecure", Boolean.toString(true));
    }
    
    private void Code(final String s, final Map map) {
        this.J = true;
        Map map2 = map;
        if (map == null) {
            map2 = new HashMap();
        }
        map2.put("hitType", s);
        this.I.Code(map2, true);
        if (!this.I()) {
            ae.a("Too many hits sent too quickly, throttling invoked.");
        }
        else {
            this.Code.Code(this.I.I());
        }
        this.I.Code();
    }
    
    private boolean I() {
        while (true) {
            boolean b = true;
            Label_0102: {
                synchronized (this) {
                    if (this.a) {
                        final long currentTimeMillis = System.currentTimeMillis();
                        if (this.B < 120000L) {
                            final long n = currentTimeMillis - this.C;
                            if (n > 0L) {
                                this.B = Math.min(120000L, n + this.B);
                            }
                        }
                        this.C = currentTimeMillis;
                        if (this.B < 2000L) {
                            break Label_0102;
                        }
                        this.B -= 2000L;
                    }
                    return b;
                }
            }
            ae.a("Excessive tracking detected.  Tracking call ignored.");
            b = false;
            return b;
        }
    }
    
    public Map B(final String s) {
        final HashMap hashMap = new HashMap();
        hashMap.put("exDescription", s);
        hashMap.put("exFatal", Boolean.toString(true));
        y.Code().Code(aa.d);
        return hashMap;
    }
    
    public void Code() {
        y.Code().Code(aa.B);
        this.I.Code("sessionControl", "start");
    }
    
    public void Code(final double n) {
        y.Code().Code(aa.c);
        this.I.I("sampleRate", Double.toString(n));
    }
    
    public void Code(final int n, final Long n2) {
        if (n <= 0) {
            ae.C("index must be > 0, ignoring setCustomMetric call for " + n + ", " + n2);
            return;
        }
        String string = null;
        if (n2 != null) {
            string = Long.toString(n2);
        }
        this.I.Code(aq.Code("customMetric", n), string);
    }
    
    public void Code(final int n, final String s) {
        if (n <= 0) {
            ae.C("index must be > 0, ignoring setCustomDimension call for " + n + ", " + s);
            return;
        }
        this.I.Code(aq.Code("customDimension", n), s);
    }
    
    public void Code(final String s) {
        if (this.J) {
            ae.a("Tracking already started, setAppName call ignored");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            ae.a("setting appName to empty value not allowed, call ignored");
            return;
        }
        y.Code().Code(aa.C);
        this.I.I("appName", s);
    }
    
    public void Code(final String s, final long n, final String s2, final String s3) {
        y.Code().Code(aa.J);
        y.Code().Code(true);
        this.Code("timing", this.I(s, n, s2, s3));
        y.Code().Code(false);
    }
    
    public void Code(final String s, final String s2, final String s3, final Long n) {
        y.Code().Code(aa.I);
        y.Code().Code(true);
        this.Code("event", this.I(s, s2, s3, n));
        y.Code().Code(false);
    }
    
    public void Code(final boolean b) {
        y.Code().Code(aa.b);
        this.I.I("anonymizeIp", Boolean.toString(b));
    }
    
    public Map I(final String s, final long n, final String s2, final String s3) {
        final HashMap hashMap = new HashMap();
        hashMap.put("timingCategory", s);
        hashMap.put("timingValue", Long.toString(n));
        hashMap.put("timingVar", s2);
        hashMap.put("timingLabel", s3);
        y.Code().Code(aa.e);
        return hashMap;
    }
    
    public Map I(final String s, final String s2, final String s3, final Long n) {
        final HashMap hashMap = new HashMap();
        hashMap.put("eventCategory", s);
        hashMap.put("eventAction", s2);
        hashMap.put("eventLabel", s3);
        if (n != null) {
            hashMap.put("eventValue", Long.toString(n));
        }
        y.Code().Code(aa.k);
        return hashMap;
    }
    
    public void I(final String s) {
        if (this.J) {
            ae.a("Tracking already started, setAppVersion call ignored");
            return;
        }
        y.Code().Code(aa.a);
        this.I.I("appVersion", s);
    }
    
    public void J(final String s) {
        y.Code().Code(aa.Z);
        y.Code().Code(true);
        this.Code("exception", this.B(s));
        y.Code().Code(false);
    }
    
    public void Z(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalStateException("trackView requires a appScreen to be set");
        }
        y.Code().Code(aa.Code);
        this.I.I("description", s);
        this.Code("appview", null);
    }
}
