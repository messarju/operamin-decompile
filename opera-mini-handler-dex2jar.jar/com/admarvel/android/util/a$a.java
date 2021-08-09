// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import android.util.Log;
import android.os.AsyncTask;

class a$a implements Runnable
{
    final /* synthetic */ a a;
    private final String b;
    private final int c;
    
    public a$a(final a a, final String b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void run() {
        try {
            new a$b(this.a, this.b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Integer[] { this.c });
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
