// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class AdMarvelVideoActivity$d implements Runnable
{
    final /* synthetic */ AdMarvelVideoActivity a;
    private final WeakReference b;
    private final WeakReference c;
    
    public AdMarvelVideoActivity$d(final AdMarvelVideoActivity a, final ImageView imageView, final String s) {
        this.a = a;
        this.b = new WeakReference((T)s);
        this.c = new WeakReference((T)imageView);
    }
    
    @Override
    public void run() {
        if (this.c.get() != null && this.b.get() != null) {
            new AdMarvelVideoActivity$c(this.a, (ImageView)this.c.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[] { (String)this.b.get() });
        }
    }
}
