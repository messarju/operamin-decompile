// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.os.SystemClock;
import android.content.Context;
import com.opera.mini.android.events.BreamInitializedEvent;
import android.os.Handler;
import android.os.Looper;
import com.opera.mini.android.events.OdpVisitedEvent;
import com.opera.mini.android.events.NotificationSettingChangedEvent;
import com.opera.mini.android.events.MobileStoreShownEvent;
import com.opera.mini.android.events.OpenUrlEvent;
import com.opera.mini.android.events.EventDispatcher;
import com.opera.mini.android.events.OdpSettingEvent;
import java.util.List;
import java.util.Arrays;

public class a extends u
{
    public a(final bn bn) {
        super(bn);
        a.b = 2;
        this.g();
    }
    
    private static native void Code(final bh p0, final int p1, final int p2, final int p3);
    
    private native void Code(final p p0, final aw p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    private static boolean Code(final aw aw, final Object o, final int n, final int n2, final int n3, final int n4) {
        return !((bh)o).b().Code(aw, n, n2, n3, n4);
    }
    
    private static native void I(final bh p0);
    
    public static al z() {
        return ((a)a.I).B.b();
    }
    
    final void A() {
        if (this.B != null) {
            ((a)a.I).Code(this.B);
        }
    }
    
    @Override
    protected final String Code(final String[] array) {
        if (com.opera.mini.android.x.ak < 4) {
            return super.Code(array);
        }
        final int code = com.opera.mini.android.ah.Code();
        if (code < 120) {
            return array[0];
        }
        final List<String> list = Arrays.asList(array);
        if (code <= 120 && list.contains("qvga")) {
            return "qvga";
        }
        if (code <= 160 && list.contains("hvga")) {
            return "hvga";
        }
        if (code <= 240 && list.contains("vga")) {
            return "vga";
        }
        if (code <= 320 && list.contains("svga")) {
            return "svga";
        }
        return array[array.length - 1];
    }
    
    @Override
    protected final void Code(final bh bh) {
        I(bh);
        bh.Code((String)null);
    }
    
    @Override
    public void Code(final boolean b) {
        if (b) {
            this.s();
        }
        for (int size = this.J.size(), i = 0; i < size; ++i) {
            final bh bh = this.J.elementAt(i);
            if (bh != this.B) {
                bh.b().I(b);
            }
            else {
                bh.b().I(false);
            }
        }
        final p z = a.Z;
        int n;
        if (b) {
            n = 99;
        }
        else {
            n = 0;
        }
        z.E(n);
        System.gc();
        System.runFinalization();
        System.gc();
        this.u();
    }
    
    @Override
    public void I(int n) {
        final boolean b = true;
        final Throwable t = null;
    Label_0604_Outer:
        while (true) {
        Label_0679_Outer:
            while (true) {
            Label_0708_Outer:
                while (true) {
                Label_0640_Outer:
                    while (true) {
                        while (true) {
                            switch (n) {
                                default: {
                                    break Label_0604_Outer;
                                }
                                case -340: {
                                    break Label_0604_Outer;
                                }
                                case -339: {
                                    break Label_0604_Outer;
                                }
                                case -342: {
                                    break Label_0604_Outer;
                                }
                                case -343: {
                                    break Label_0604_Outer;
                                }
                                case -344: {
                                    break Label_0604_Outer;
                                }
                                case -341: {
                                    break Label_0604_Outer;
                                }
                                case -346: {
                                    break Label_0604_Outer;
                                }
                                case -345: {
                                    break Label_0604_Outer;
                                }
                                case -347: {
                                    break Label_0604_Outer;
                                }
                                case -348: {
                                    break Label_0604_Outer;
                                }
                                case -349: {
                                    break Label_0604_Outer;
                                }
                                case -350: {
                                    break Label_0604_Outer;
                                }
                                case -104: {
                                    break Label_0604_Outer;
                                }
                                case -351: {
                                    Label_0589: {
                                        break Label_0589;
                                        Throwable t2 = null;
                                        Throwable t3;
                                        boolean b2 = false;
                                        boolean b3;
                                        String f;
                                        String f2;
                                        boolean b4;
                                        int h;
                                        boolean b5;
                                        boolean b6;
                                        int h2;
                                        int h3;
                                        int h4;
                                        int h5;
                                        int f3;
                                        int f4;
                                        bh bh;
                                        Label_0176_Outer:Label_0248_Outer:Label_0302_Outer:
                                        while (true) {
                                        Label_0542:
                                            while (true) {
                                            Label_0397:
                                                while (true) {
                                                    while (true) {
                                                        Label_0302:Label_0272_Outer:
                                                        while (true) {
                                                        Label_0272:
                                                            while (true) {
                                                            Label_0252_Outer:
                                                                while (true) {
                                                                Label_0990:
                                                                    while (true) {
                                                                        Label_0959: {
                                                                            Label_0929: {
                                                                                Label_0834: {
                                                                                Label_0785:
                                                                                    while (true) {
                                                                                        try {
                                                                                            super.I(n);
                                                                                            Label_0173: {
                                                                                                t2 = null;
                                                                                            }
                                                                                            t3 = t;
                                                                                            switch (n) {
                                                                                                default: {
                                                                                                    t3 = t2;
                                                                                                }
                                                                                                case -195:
                                                                                                case -64: {
                                                                                                    if (t3 != null) {
                                                                                                        throw t3;
                                                                                                    }
                                                                                                    break Label_0589;
                                                                                                }
                                                                                                case -290: {
                                                                                                    break Label_0785;
                                                                                                }
                                                                                                case -284: {
                                                                                                    break Label_0834;
                                                                                                }
                                                                                                case -285: {
                                                                                                    break Label_0929;
                                                                                                }
                                                                                                case -286: {
                                                                                                    break Label_0959;
                                                                                                }
                                                                                                case -333: {
                                                                                                    break Label_0990;
                                                                                                }
                                                                                            }
                                                                                            EventDispatcher.I(new OdpSettingEvent(b2));
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            EventDispatcher.I(new OpenUrlEvent());
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            EventDispatcher.I(new MobileStoreShownEvent());
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            com.opera.mini.android.as.Code(b3);
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            Block_7: {
                                                                                                Block_8: {
                                                                                                    Block_9: {
                                                                                                    Block_10_Outer:
                                                                                                        while (true) {
                                                                                                            Browser.I.I.Code(f, f2);
                                                                                                            t2 = null;
                                                                                                            continue Label_0248_Outer;
                                                                                                            while (true) {
                                                                                                                b3 = true;
                                                                                                                continue Label_0542;
                                                                                                                EventDispatcher.I(new NotificationSettingChangedEvent(b4));
                                                                                                                t2 = null;
                                                                                                                continue Label_0248_Outer;
                                                                                                                iftrue(Label_1051:)(a.Z.h() == 0);
                                                                                                                continue Label_0272_Outer;
                                                                                                            }
                                                                                                            while (true) {
                                                                                                                Browser.I.I.I(h);
                                                                                                                t2 = null;
                                                                                                                continue Label_0248_Outer;
                                                                                                                com.opera.mini.android.as.Code(a.Z.f(a.Z.f()), a.Z.f(a.Z.f()));
                                                                                                                t2 = null;
                                                                                                                continue Label_0248_Outer;
                                                                                                                iftrue(Label_0168:)(!u.o());
                                                                                                                Block_13: {
                                                                                                                    break Block_13;
                                                                                                                    while (true) {
                                                                                                                        b4 = true;
                                                                                                                        continue Label_0272;
                                                                                                                        ((bl)a.Z.y(a.Z.f())).Code(a.Z.f(a.Z.f()));
                                                                                                                        t2 = null;
                                                                                                                        continue Label_0248_Outer;
                                                                                                                        iftrue(Label_1033:)(a.Z.h() == 0);
                                                                                                                        break Block_7;
                                                                                                                        iftrue(Label_1027:)(a.Z.h() == 0);
                                                                                                                        continue Label_0604_Outer;
                                                                                                                    }
                                                                                                                    a.Z.b(a.Z.Code(com.opera.mini.android.al.Code.Code(a.Z.f(a.Z.f()))));
                                                                                                                    t2 = null;
                                                                                                                    continue Label_0248_Outer;
                                                                                                                }
                                                                                                                bz.Code();
                                                                                                                continue Label_0176_Outer;
                                                                                                                bq.Code(a.Z.h(a.Z.f()));
                                                                                                                t2 = null;
                                                                                                                continue Label_0248_Outer;
                                                                                                                iftrue(Label_1039:)(a.Z.h() == 0);
                                                                                                                break Block_8;
                                                                                                                bq.I(b5);
                                                                                                                t2 = null;
                                                                                                                continue Label_0248_Outer;
                                                                                                                h = a.Z.h();
                                                                                                                iftrue(Label_0173:)(!com.opera.mini.android.x.am);
                                                                                                                continue Label_0604_Outer;
                                                                                                            }
                                                                                                            iftrue(Label_1045:)(a.Z.h() == 0);
                                                                                                            break Block_9;
                                                                                                            f2 = a.Z.f(a.Z.f());
                                                                                                            f = a.Z.f(a.Z.f());
                                                                                                            a.Z.h();
                                                                                                            iftrue(Label_0173:)(!com.opera.mini.android.x.am);
                                                                                                            continue Block_10_Outer;
                                                                                                        }
                                                                                                    }
                                                                                                    b5 = true;
                                                                                                    continue Label_0397;
                                                                                                }
                                                                                                b6 = true;
                                                                                                bq.Code(b6);
                                                                                                t2 = null;
                                                                                                continue Label_0248_Outer;
                                                                                            }
                                                                                            b2 = true;
                                                                                            continue Label_0302;
                                                                                            bq.I(a.Z.h(a.Z.f()));
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            com.opera.mini.android.as.Code(a.Z.h());
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            EventDispatcher.I(new OdpVisitedEvent());
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            a.Z.y(a.Z.f());
                                                                                            a.Z.h();
                                                                                            a.Z.f(a.Z.f());
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                            com.opera.mini.android.as.Code(a.Z.f(a.Z.f()), a.Z.h(a.Z.f()));
                                                                                            t2 = null;
                                                                                            continue Label_0248_Outer;
                                                                                        }
                                                                                        catch (Throwable t2) {
                                                                                            continue Label_0248_Outer;
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    n = a.Z.h();
                                                                                    Code((bh)a.Z.y(a.Z.f()), a.Z.h(), a.Z.h(), n);
                                                                                    t3 = t;
                                                                                    continue Label_0302_Outer;
                                                                                }
                                                                                n = a.Z.h();
                                                                                h2 = a.Z.h();
                                                                                h3 = a.Z.h();
                                                                                h4 = a.Z.h();
                                                                                h5 = a.Z.h();
                                                                                f3 = a.Z.f();
                                                                                f4 = a.Z.f();
                                                                                if (f4 != 0) {
                                                                                    bh = (bh)a.Z.y(f4);
                                                                                }
                                                                                else {
                                                                                    bh = null;
                                                                                }
                                                                                com.opera.mini.android.k.Code(bh, h5, h4, h3, h2, n, a.Z, f3);
                                                                                t3 = t;
                                                                                continue Label_0302_Outer;
                                                                            }
                                                                            com.opera.mini.android.k.I(a.Z.h() != 0);
                                                                            t3 = t;
                                                                            continue Label_0302_Outer;
                                                                        }
                                                                        com.opera.mini.android.k.Z(a.Z.h() != 0 && b);
                                                                        t3 = t;
                                                                        continue Label_0302_Outer;
                                                                    }
                                                                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                                                                        @Override
                                                                        public final void run() {
                                                                            if (com.opera.mini.android.x.s()) {
                                                                                com.opera.mini.android.as.Code();
                                                                            }
                                                                            EventDispatcher.Code(new BreamInitializedEvent());
                                                                            EventDispatcher.Z(new ao((Context)Browser.Z));
                                                                        }
                                                                    });
                                                                    Browser.Z.I();
                                                                    continue Label_0252_Outer;
                                                                }
                                                                Label_1027: {
                                                                    b4 = false;
                                                                }
                                                                continue Label_0272;
                                                            }
                                                            Label_1033: {
                                                                b2 = false;
                                                            }
                                                            continue Label_0302;
                                                        }
                                                        Label_1039: {
                                                            b6 = false;
                                                        }
                                                        continue Label_0640_Outer;
                                                    }
                                                    Label_1045: {
                                                        b5 = false;
                                                    }
                                                    continue Label_0397;
                                                }
                                                Label_1051: {
                                                    b3 = false;
                                                }
                                                continue Label_0542;
                                            }
                                        }
                                    }
                                }
                                case -107: {
                                    continue Label_0679_Outer;
                                }
                                case -108: {
                                    continue;
                                }
                                case -89: {
                                    continue Label_0708_Outer;
                                }
                                case -90: {
                                    continue Label_0640_Outer;
                                }
                                case -336: {
                                    continue Label_0604_Outer;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                break;
            }
            break;
        }
    }
    
    @Override
    public void Z() {
        final int n = 1;
        final p z = a.Z;
        int n2;
        if (com.opera.mini.android.x.s()) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        z.J(39, n2);
        final p z2 = a.Z;
        int n3;
        if (com.opera.mini.android.x.al) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        z2.J(38, n3);
        final p z3 = a.Z;
        int n4;
        if (com.opera.mini.android.x.am) {
            n4 = n;
        }
        else {
            n4 = 0;
        }
        z3.J(18, n4);
        super.Z();
    }
    
    @Override
    protected final void b(final int n) {
        this.Code(a.Z, this.g, n, this.g.Code(), this.g.I(), this.g.Z(), this.g.J());
    }
    
    @Override
    public final void f() {
        super.f();
        bz.I();
        if (com.opera.mini.android.x.ak >= 7) {
            bk.Code((Context)Browser.Z);
        }
    }
    
    @Override
    protected final boolean k() {
        return ((J)a.Code).d();
    }
    
    @Override
    public final String l() {
        if (cg.l) {
            return a.f[0];
        }
        return super.Code(u.f);
    }
    
    @Override
    public void run() {
        Looper.prepare();
        super.run();
    }
    
    @Override
    public final int t() {
        return (int)SystemClock.uptimeMillis();
    }
    
    @Override
    protected final void x() {
        bw.J();
    }
}
