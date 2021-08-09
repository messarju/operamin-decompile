// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class s$b implements Runnable
{
    final /* synthetic */ s a;
    private final WeakReference b;
    private String c;
    
    public s$b(final s a, final ImageView imageView, final String c) {
        this.a = a;
        this.b = new WeakReference((T)imageView);
        this.c = c;
    }
    
    @Override
    public void run() {
        if (this.b.get() != null) {
            new s$a(this.a, (ImageView)this.b.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[] { this.c });
        }
    }
}
