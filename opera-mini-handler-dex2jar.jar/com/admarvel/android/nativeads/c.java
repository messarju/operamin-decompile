// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import com.admarvel.android.ads.Version;
import android.os.AsyncTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class c
{
    private static final int a;
    private static final int b;
    private static final int c;
    private static final TimeUnit d;
    private static final BlockingQueue e;
    private static final ThreadFactory f;
    private static final ThreadPoolExecutor g;
    
    static {
        a = 10;
        b = 128;
        c = 1;
        d = TimeUnit.SECONDS;
        e = new LinkedBlockingQueue(20);
        f = new c$a(null);
        g = new ThreadPoolExecutor(com.admarvel.android.nativeads.c.a, com.admarvel.android.nativeads.c.b, com.admarvel.android.nativeads.c.c, com.admarvel.android.nativeads.c.d, com.admarvel.android.nativeads.c.e, com.admarvel.android.nativeads.c.f);
    }
    
    @SuppressLint({ "NewApi" })
    public static AsyncTask a(final AsyncTask asyncTask, final Object... array) {
        if (Version.getAndroidSDKVersion() >= 11) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    asyncTask.executeOnExecutor((Executor)com.admarvel.android.nativeads.c.g, array);
                }
            }).start();
            return asyncTask;
        }
        asyncTask.execute(array);
        return asyncTask;
    }
}
