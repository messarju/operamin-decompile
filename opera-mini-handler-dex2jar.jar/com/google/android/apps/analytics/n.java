// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import android.os.Handler;
import android.os.HandlerThread;

final class n extends HandlerThread
{
    private int B;
    private long C;
    private volatile Handler Code;
    private final r I;
    private int J;
    private final String Z;
    private o a;
    private final C b;
    private final s c;
    private final m d;
    
    private n(final C b, final r i, final String z, final m d) {
        super("DispatcherThread");
        this.B = 30;
        this.a = null;
        this.b = b;
        this.Z = z;
        this.I = i;
        this.c = new s(this, (byte)0);
        this.I.Code = this.c;
        this.d = d;
    }
    
    private n(final C c, final String s, final m m) {
        this(c, new r(m.I), s, m);
    }
    
    public final void Code(final f[] array) {
        if (this.Code == null) {
            return;
        }
        this.Code.post((Runnable)new o(this, array));
    }
    
    protected final void onLooperPrepared() {
        this.Code = new Handler();
    }
}
