// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

class AdMarvelInterstitialAds$a implements Runnable
{
    private final Map a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;
    private final WeakReference g;
    private final int h;
    private final String i;
    private final WeakReference j;
    
    public AdMarvelInterstitialAds$a(final Map a, final String b, final String c, final String d, final int e, final String f, final AdMarvelInterstitialAds adMarvelInterstitialAds, final int h, final String i, final Context context) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = new WeakReference((T)adMarvelInterstitialAds);
        this.h = h;
        this.i = i;
        this.j = new WeakReference((T)context);
    }
    
    @Override
    public void run() {
        final AdMarvelInterstitialAds adMarvelInterstitialAds = (AdMarvelInterstitialAds)this.g.get();
        final Context context = (Context)this.j.get();
        if (adMarvelInterstitialAds != null && context != null) {
            new f(context).execute(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f, adMarvelInterstitialAds, this.h, this.i });
        }
    }
}
