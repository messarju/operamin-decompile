// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

class c$a implements ThreadFactory
{
    private final AtomicInteger a;
    
    private c$a() {
        this.a = new AtomicInteger(1);
    }
    
    @Override
    public Thread newThread(final Runnable runnable) {
        return new Thread(runnable, "AsyncTask #" + this.a.getAndIncrement());
    }
}
