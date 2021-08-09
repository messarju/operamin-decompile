// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.AsyncTask;

class r$h implements Runnable
{
    final /* synthetic */ r a;
    private String b;
    
    public r$h(final r a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        new r$g(this.a, this.b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    }
}
