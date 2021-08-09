// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.e;
import android.content.Context;
import java.util.Map;
import java.lang.ref.WeakReference;

class AdMarvelView$a implements Runnable
{
    private final WeakReference a;
    private final Map b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final String g;
    private final WeakReference h;
    private final int i;
    private final String j;
    
    public AdMarvelView$a(final Context context, final Map b, final String c, final String d, final String e, final int f, final String g, final AdMarvelView adMarvelView, final int i, final String j) {
        this.a = new WeakReference((T)context);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = new WeakReference((T)adMarvelView);
        this.i = i;
        this.j = j;
    }
    
    @Override
    public void run() {
        final Context context = (Context)this.a.get();
        final AdMarvelView adMarvelView = (AdMarvelView)this.h.get();
        if (context != null && adMarvelView != null) {
            if (Version.getAndroidSDKVersion() < 11) {
                new k(context).execute(new Object[] { this.b, this.c, this.d, this.e, this.f, this.g, adMarvelView, this.i, this.j, adMarvelView.c(), adMarvelView.r });
                return;
            }
            com.admarvel.android.util.e.a().b().execute(new AdMarvelView$b(context, this.b, this.c, this.d, this.e, this.f, this.g, adMarvelView, this.i, this.j));
        }
    }
}
