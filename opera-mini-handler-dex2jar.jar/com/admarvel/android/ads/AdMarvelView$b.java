// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.AsyncTask;
import android.content.Context;
import java.util.Map;
import java.lang.ref.WeakReference;

class AdMarvelView$b implements Runnable
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
    
    public AdMarvelView$b(final Context context, final Map b, final String c, final String d, final String e, final int f, final String g, final AdMarvelView adMarvelView, final int i, final String j) {
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
        if (this.a.get() != null && this.h.get() != null) {
            new k((Context)this.a.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { this.b, this.c, this.d, this.e, this.f, this.g, this.h.get(), this.i, this.j, ((AdMarvelView)this.h.get()).c(), ((AdMarvelView)this.h.get()).r });
        }
    }
}
