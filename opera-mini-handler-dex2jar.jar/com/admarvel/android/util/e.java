// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ExecutorService;

public class e
{
    private static e c;
    private ExecutorService a;
    private ScheduledExecutorService b;
    
    static {
        e.c = null;
    }
    
    private e() {
        this.a = null;
        this.b = null;
    }
    
    public static e a() {
        if (e.c == null) {
            e.c = new e();
        }
        return e.c;
    }
    
    public ExecutorService b() {
        if (this.a == null) {
            this.a = Executors.newCachedThreadPool();
        }
        return this.a;
    }
}
