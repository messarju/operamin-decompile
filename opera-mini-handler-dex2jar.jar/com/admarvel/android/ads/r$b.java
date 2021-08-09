// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.AsyncTask;

class r$b implements Runnable
{
    private r$b() {
    }
    
    @Override
    public void run() {
        new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { null });
    }
}
