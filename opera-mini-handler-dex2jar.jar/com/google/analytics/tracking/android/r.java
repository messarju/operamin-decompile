// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Timer;
import java.util.Queue;
import android.content.Context;

final class r implements C, a, am
{
    private final f B;
    private final Context C;
    private volatile long Code;
    private volatile s I;
    private d J;
    private volatile Z Z;
    private final Queue a;
    private volatile int b;
    private volatile Timer c;
    private volatile Timer d;
    private volatile Timer e;
    private boolean f;
    private boolean g;
    private h h;
    private long i;
    
    private r(final Context c, final f b) {
        this.a = new ConcurrentLinkedQueue();
        this.i = 300000L;
        this.C = c;
        this.B = b;
        this.h = new h() {
            @Override
            public final long Code() {
                return System.currentTimeMillis();
            }
        };
        this.b = 0;
        this.I = s.C;
    }
    
    r(final Context context, final f f, final byte b) {
        this(context, f);
    }
    
    private void C() {
        this.c = Code(this.c);
        this.d = Code(this.d);
        this.e = Code(this.e);
    }
    
    private static Timer Code(final Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }
    
    private void a() {
        while (true) {
            Label_0255: {
                Label_0156: {
                    Label_0170: {
                        synchronized (this) {
                            if (!Thread.currentThread().equals(this.B.Z())) {
                                this.B.I().add(new Runnable() {
                                    @Override
                                    public final void run() {
                                        r.this.a();
                                    }
                                });
                                return;
                            }
                            if (this.g) {
                                this.J();
                            }
                            switch (r$3.Code[this.I.ordinal()]) {
                                case 1: {
                                    while (!this.a.isEmpty()) {
                                        final v v = this.a.poll();
                                        ae.J("Sending hit to store");
                                        this.J.Code(v.Code(), v.I(), v.Z(), v.J());
                                    }
                                    break;
                                }
                                case 2: {
                                    break Label_0170;
                                }
                                case 3: {
                                    break Label_0255;
                                }
                                default: {
                                    return;
                                }
                            }
                        }
                        break Label_0156;
                    }
                    while (!this.a.isEmpty()) {
                        final v v2 = this.a.peek();
                        ae.J("Sending hit to service");
                        this.Z.Code(v2.Code(), v2.I(), v2.Z(), v2.J());
                        this.a.poll();
                    }
                    this.Code = this.h.Code();
                    return;
                }
                if (this.f) {
                    this.b();
                    return;
                }
                return;
            }
            ae.J("Need to reconnect");
            if (!this.a.isEmpty()) {
                this.d();
            }
        }
    }
    
    private void b() {
        this.J.I();
        this.f = false;
    }
    
    private void c() {
        synchronized (this) {
            if (this.I != s.Z) {
                this.C();
                ae.J("falling back to local store");
                final e code = com.google.analytics.tracking.android.e.Code();
                code.Code(this.C, this.B);
                this.J = code.I();
                this.I = s.Z;
                this.a();
            }
        }
    }
    
    private void d() {
        while (true) {
            synchronized (this) {
                if (this.Z != null && this.I != s.Z) {
                    try {
                        ++this.b;
                        Code(this.d);
                        this.I = s.Code;
                        (this.d = new Timer("Failed Connect")).schedule(new u(this, (byte)0), 3000L);
                        ae.J("connecting to Analytics service");
                        this.Z.I();
                        return;
                    }
                    catch (SecurityException ex) {
                        ae.C("security exception on connectToService");
                        this.c();
                    }
                }
            }
            ae.C("client not initialized.");
            this.c();
        }
    }
    
    private void e() {
        synchronized (this) {
            if (this.Z != null && this.I == s.I) {
                this.I = s.B;
                this.Z.Z();
            }
        }
    }
    
    private void f() {
        this.c = Code(this.c);
        (this.c = new Timer("Service Reconnect")).schedule(new w(this, (byte)0), 5000L);
    }
    
    @Override
    public final void B() {
        if (this.Z != null) {
            return;
        }
        this.Z = new J(this.C, this, this);
        this.d();
    }
    
    @Override
    public final void Code() {
        synchronized (this) {
            this.d = Code(this.d);
            this.b = 0;
            ae.J("Connected to service");
            this.I = s.I;
            this.a();
            this.e = Code(this.e);
            (this.e = new Timer("disconnect check")).schedule(new t(this, (byte)0), this.i);
        }
    }
    
    @Override
    public final void Code(final int n) {
        synchronized (this) {
            this.I = s.J;
            if (this.b < 2) {
                ae.C("Service unavailable (code=" + n + "), will retry.");
                this.f();
            }
            else {
                ae.C("Service unavailable (code=" + n + "), using local store.");
                this.c();
            }
        }
    }
    
    @Override
    public final void Code(final Map map, final long n, final String s, final List list) {
        ae.J("putHit called");
        this.a.add(new v(map, n, s, list));
        this.a();
    }
    
    @Override
    public final void I() {
        while (true) {
            Label_0067: {
                synchronized (this) {
                    if (this.I == s.B) {
                        ae.J("Disconnected from service");
                        this.C();
                        this.I = s.C;
                    }
                    else {
                        ae.J("Unexpected disconnect.");
                        this.I = s.J;
                        if (this.b >= 2) {
                            break Label_0067;
                        }
                        this.f();
                    }
                    return;
                }
            }
            this.c();
        }
    }
    
    @Override
    public final void J() {
        ae.J("clearHits called");
        this.a.clear();
        switch (r$3.Code[this.I.ordinal()]) {
            default: {
                this.g = true;
            }
            case 1: {
                this.J.Code();
                this.g = false;
            }
            case 2: {
                this.Z.Code();
                this.g = false;
            }
        }
    }
    
    @Override
    public final void Z() {
        switch (r$3.Code[this.I.ordinal()]) {
            default: {
                this.f = true;
            }
            case 2: {}
            case 1: {
                this.b();
            }
        }
    }
}
