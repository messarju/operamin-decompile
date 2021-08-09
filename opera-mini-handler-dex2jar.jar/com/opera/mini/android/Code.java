// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import com.admarvel.android.nativeads.AdMarvelNativeAd$RequestParameters;
import com.admarvel.android.nativeads.AdMarvelNativeAd$RequestParameters$Builder;
import com.admarvel.android.nativeads.AdMarvelNativeAd$AdMarvelNativeAdListener;
import com.admarvel.android.nativeads.AdMarvelNativeAd;
import com.admarvel.android.nativeads.AdMarvelNativeImage;
import com.opera.mini.android.events.EventDispatcher;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import com.admarvel.android.ads.AdMarvelNetworkHandler;
import java.util.Map;
import android.content.Context;

public final class Code
{
    private J.J$Code B;
    private int C;
    private Context Code;
    private Map I;
    private Map J;
    private Map Z;
    private AdMarvelNetworkHandler a;
    private Map b;
    
    public Code(final Context code, final J.J$Code b) {
        this.I = new ConcurrentHashMap();
        this.Z = new ConcurrentHashMap();
        this.J = new ConcurrentHashMap();
        this.C = new Random().nextInt(Integer.MAX_VALUE);
        this.a = new B();
        this.b = new HashMap();
        this.Code = code;
        this.B = b;
        EventDispatcher.Z(new Z((byte)0));
        this.b.put("APP_VERSION", x.q());
    }
    
    private void Z(final String s, final String s2) {
        try {
            final AdMarvelNativeAd adMarvelNativeAd = new AdMarvelNativeAd();
            adMarvelNativeAd.setListener(new I(this, s));
            final AdMarvelNativeAd$RequestParameters build = new AdMarvelNativeAd$RequestParameters$Builder().context(this.Code).partnerId(s2).siteId(s).targetParams(this.b).build();
            adMarvelNativeAd.setAdMarvelNetworkHandler(this.a);
            adMarvelNativeAd.requestNativeAd(build);
            this.I.put(s, false);
        }
        catch (Exception ex) {}
    }
    
    public final void Code(final int n) {
        if (n >= 0) {
            final AdMarvelNativeAd adMarvelNativeAd = this.Z.get(n);
            if (adMarvelNativeAd != null) {
                adMarvelNativeAd.handleClick();
            }
        }
    }
    
    public final void Code(final String s, final String s2) {
        this.Z(s, s2);
    }
    
    public final boolean Code(final int n, final String s) {
        if (n < 0) {
            return true;
        }
        final Integer n2 = this.J.get(s);
        if (n2 != null) {
            if (!n2.equals(n)) {
                this.Z.remove(n2);
                this.J.put(s, n);
            }
            return true;
        }
        return false;
    }
    
    public final void I(final int n) {
        if (n >= 0) {
            final AdMarvelNativeAd adMarvelNativeAd = this.Z.get(n);
            if (adMarvelNativeAd != null) {
                adMarvelNativeAd.handleImpression();
            }
        }
    }
    
    public final void I(final String s, final String s2) {
        if (Boolean.FALSE.equals(this.I.get(s))) {
            return;
        }
        this.Z(s, s2);
    }
}
