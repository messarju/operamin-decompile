// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Message;
import android.os.Handler$Callback;
import android.os.Handler;
import android.content.Context;

public final class e implements al
{
    private static final Object Code;
    private static e g;
    private int B;
    private boolean C;
    private Context I;
    private volatile f J;
    private d Z;
    private boolean a;
    private boolean b;
    private e$Code c;
    private Handler d;
    private GANetworkReceiver e;
    private boolean f;
    
    static {
        Code = new Object();
    }
    
    private e() {
        this.B = 1800;
        this.C = true;
        this.a = true;
        this.b = true;
        this.c = new Object() {
            public final void Code(final boolean b) {
                com.google.analytics.tracking.android.e.this.Code(b, com.google.analytics.tracking.android.e.this.a);
            }
        };
        this.f = false;
    }
    
    public static e Code() {
        if (e.g == null) {
            e.g = new e();
        }
        return e.g;
    }
    
    @Override
    public final void Code(final int n) {
        synchronized (this) {
            if (this.d == null) {
                ae.C("Need to call initialize() and be in fallback mode to start dispatch.");
                this.B = n;
            }
            else {
                y.Code().Code(aa.j);
                if (!this.f && this.a && this.B > 0) {
                    this.d.removeMessages(1, com.google.analytics.tracking.android.e.Code);
                }
                if ((this.B = n) > 0 && !this.f && this.a) {
                    this.d.sendMessageDelayed(this.d.obtainMessage(1, com.google.analytics.tracking.android.e.Code), (long)(n * 1000));
                }
            }
        }
    }
    
    final void Code(final Context context, final f j) {
        synchronized (this) {
            if (this.I == null) {
                this.I = context.getApplicationContext();
                if (this.J == null) {
                    this.J = j;
                    if (this.C) {
                        j.Code();
                    }
                }
            }
        }
    }
    
    @Override
    public final void Code(final boolean b) {
        synchronized (this) {
            this.Code(this.f, b);
        }
    }
    
    final void Code(final boolean f, final boolean a) {
        while (true) {
            while (true) {
                Label_0155: {
                    Label_0148: {
                        synchronized (this) {
                            if (this.f != f || this.a != a) {
                                if ((f || !a) && this.B > 0) {
                                    this.d.removeMessages(1, com.google.analytics.tracking.android.e.Code);
                                }
                                if (!f && a && this.B > 0) {
                                    this.d.sendMessageDelayed(this.d.obtainMessage(1, com.google.analytics.tracking.android.e.Code), (long)(this.B * 1000));
                                }
                                final StringBuilder sb = new StringBuilder("PowerSaveMode ");
                                if (!f && a) {
                                    break Label_0148;
                                }
                                break Label_0155;
                            }
                            return;
                            StringBuilder sb = null;
                            final String s;
                            ae.J(sb.append(s).toString());
                            this.f = f;
                            this.a = a;
                            return;
                        }
                    }
                    final String s = "terminated.";
                    continue;
                }
                final String s = "initiated.";
                continue;
            }
        }
    }
    
    final d I() {
        Label_0050: {
            synchronized (this) {
                if (this.Z != null) {
                    break Label_0050;
                }
                if (this.I == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
            }
            this.Z = new ad(this.c, this.I);
        }
        if (this.d == null) {
            this.d = new Handler(this.I.getMainLooper(), (Handler$Callback)new Handler$Callback() {
                public final boolean handleMessage(final Message message) {
                    if (1 == message.what && com.google.analytics.tracking.android.e.Code.equals(message.obj)) {
                        y.Code().Code(true);
                        com.google.analytics.tracking.android.e.this.Z();
                        y.Code().Code(false);
                        if (com.google.analytics.tracking.android.e.this.B > 0 && !com.google.analytics.tracking.android.e.this.f) {
                            com.google.analytics.tracking.android.e.this.d.sendMessageDelayed(com.google.analytics.tracking.android.e.this.d.obtainMessage(1, com.google.analytics.tracking.android.e.Code), (long)(com.google.analytics.tracking.android.e.this.B * 1000));
                        }
                    }
                    return true;
                }
            });
            if (this.B > 0) {
                this.d.sendMessageDelayed(this.d.obtainMessage(1, com.google.analytics.tracking.android.e.Code), (long)(this.B * 1000));
            }
        }
        if (this.e == null && this.b) {
            this.e = new GANetworkReceiver(this);
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.I.registerReceiver((BroadcastReceiver)this.e, intentFilter);
        }
        final d z = this.Z;
        monitorexit(this);
        return z;
    }
    
    @Override
    public final void Z() {
        synchronized (this) {
            if (this.J == null) {
                ae.C("dispatch call queued.  Need to call GAServiceManager.getInstance().initialize().");
                this.C = true;
            }
            else {
                y.Code().Code(aa.i);
                this.J.Code();
            }
        }
    }
}
