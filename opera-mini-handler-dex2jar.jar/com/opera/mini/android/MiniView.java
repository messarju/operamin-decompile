// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.MotionEvent;
import android.view.View;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Looper;
import android.os.Handler;
import android.widget.FrameLayout;

public class MiniView extends FrameLayout
{
    private static int C;
    static MiniView Code;
    private static Handler Z;
    private static int a;
    private ba B;
    bi I;
    private bi J;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private bj f;
    private bh g;
    private bh h;
    private int i;
    private boolean j;
    private Runnable k;
    
    static {
        MiniView.Z = new Handler(Looper.getMainLooper());
    }
    
    public MiniView(final Context context, final AttributeSet set) {
        super(context, set);
        this.b = false;
        this.d = 0;
        this.e = 0;
        MiniView.Code = this;
        this.c = (x.ak >= 4 && !bc.C());
        this.f = bj.I(this.getContext());
        this.g = new bh(this, 80);
        this.h = new bh(this, 65);
        if (this.c) {
            this.B = new ba(context, this);
            this.addView(this.B.Code());
            this.B.Code().setVisibility(8);
        }
        this.J = new bf(context, this);
        this.addView(this.J.Code());
        this.J.Code().setVisibility(8);
        if (this.c) {
            this.B.Code().setVisibility(0);
            this.I = this.B;
            return;
        }
        this.J.Code().setVisibility(0);
        this.I = this.J;
    }
    
    private static int Code(int unicodeChar, final KeyEvent keyEvent) {
        switch (unicodeChar) {
            default: {
                if (keyEvent.isPrintingKey()) {
                    unicodeChar = keyEvent.getUnicodeChar();
                }
                return unicodeChar;
            }
            case 82: {
                return -11;
            }
            case 23:
            case 66: {
                return 8;
            }
            case 4: {
                return -5;
            }
            case 19: {
                return 1;
            }
            case 20: {
                return 6;
            }
            case 21: {
                return 2;
            }
            case 22: {
                return 5;
            }
            case 67: {
                return -6;
            }
            case 84: {
                return -13;
            }
            case 1: {
                return -1;
            }
            case 2: {
                return -2;
            }
        }
    }
    
    private static char[] Code(final KeyEvent keyEvent) {
        if (keyEvent.isPrintingKey()) {
            return new char[] { (char)keyEvent.getUnicodeChar() };
        }
        return new char[0];
    }
    
    private static int I(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 50: {
                return 7;
            }
            case 52: {
                return 9;
            }
            case 54: {
                return 10;
            }
            case 56: {
                return 8;
            }
        }
    }
    
    private static void I(final boolean b) {
        if (b) {
            u.I.h();
            u.I.Z(36);
        }
        MiniView.Code.a();
    }
    
    private static boolean Z(final int n) {
        switch (n) {
            default: {
                return false;
            }
            case 3:
            case 5:
            case 6:
            case 24:
            case 25:
            case 26:
            case 27:
            case 57:
            case 58:
            case 59:
            case 60:
            case 64:
            case 65:
            case 79:
            case 80:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90: {
                return true;
            }
        }
    }
    
    static int c() {
        return MiniView.C;
    }
    
    static int d() {
        return MiniView.a;
    }
    
    private static void h() {
        MiniView.Code.I.a();
    }
    
    public final void B() {
        this.I.Z();
    }
    
    public final void C() {
        this.I.J();
    }
    
    public final void Code() {
        if (this.c) {
            this.B.Code().setVisibility(8);
            this.J.Code().setVisibility(0);
            this.B.B();
            this.I = this.J.I();
        }
    }
    
    final void Code(final int i) {
        if (this.i != i) {
            this.i = i;
            if (Browser.Code.C) {
                u.I.h();
                u.I.Z(46);
            }
        }
    }
    
    public final void Code(final int n, final int n2, final int n3, final int n4) {
        this.I.Code(n, n2, n3, n4);
    }
    
    final void Code(final boolean j) {
        this.j = j;
        this.a();
    }
    
    final void I() {
        if (!this.b) {
            this.b = true;
            Browser.Code.f();
        }
        Browser.Code.A();
    }
    
    final void I(final int c, final int a, final int n, final int n2) {
        this.k = null;
        x.m();
        MiniView.C = c;
        MiniView.a = a;
        final View decorView = Browser.Z.getWindow().getDecorView();
        final Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        final int top = rect.top;
        final int n3 = x.ag.heightPixels - rect.bottom;
        Label_0153: {
            if (x.ag.widthPixels <= x.ag.heightPixels) {
                break Label_0153;
            }
            int n4 = 1;
        Label_0100_Outer:
            while (true) {
                Label_0168: {
                    if (n3 < 100) {
                        break Label_0168;
                    }
                    Label_0159: {
                        if (n4 == 0) {
                            break Label_0159;
                        }
                        int n5 = this.e;
                        while (true) {
                            final int n6 = n3 - n5;
                            if (MiniView.a + n6 <= x.ag.heightPixels) {
                                MiniView.a += n6;
                            }
                            Label_0199: {
                                if (!Browser.Code.C) {
                                    break Label_0199;
                                }
                                try {
                                    Browser.Code.q();
                                    this.Code(n6);
                                    return;
                                    n5 = this.d;
                                    continue;
                                    iftrue(Label_0186:)(n4 == 0);
                                    Block_7: {
                                        break Block_7;
                                        Label_0186: {
                                            this.d = n3;
                                        }
                                        n5 = n3;
                                        continue;
                                        this.k = new Runnable() {
                                            @Override
                                            public final void run() {
                                                MiniView.this.I.onSizeChanged(c, a, n, n2);
                                            }
                                        };
                                        return;
                                        n4 = 0;
                                        continue Label_0100_Outer;
                                    }
                                    this.e = n3;
                                    n5 = n3;
                                    continue;
                                }
                                catch (Throwable t) {}
                            }
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
    
    public final void J() {
        this.I.onResume();
    }
    
    public final void Z() {
        this.I.onPause();
    }
    
    public final void a() {
        this.I.C();
    }
    
    public final boolean b() {
        return this.I.b();
    }
    
    final int e() {
        return this.i;
    }
    
    final boolean f() {
        return this.j;
    }
    
    public final void g() {
        MiniView.Z.post(this.k);
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (84 == n) {
            bw.Code(true);
        }
        else {
            while (true) {
                while (true) {
                    Label_0243: {
                        try {
                            if (!Browser.Code.C || Z(n)) {
                                break;
                            }
                            if (keyEvent.getRepeatCount() <= 0) {
                                if (n == 4 && com.opera.mini.android.J.Code != null) {
                                    com.opera.mini.android.J.Code.I = true;
                                }
                                final int code = Code(n, keyEvent);
                                u.I.h();
                                u.Z.c(code);
                                u.Z.c(0);
                                u.Z.c(0);
                                u.Z.c(n);
                                u.Z.c(I(code));
                                u.Z.b(u.Z.Code(String.valueOf(Code(keyEvent))));
                                u.Z.c((int)keyEvent.getEventTime());
                                u.Z.b(u.Z.Code(String.valueOf(Code(keyEvent)).toUpperCase()));
                                u.I.Z(60);
                                return true;
                            }
                            switch (n) {
                                case 19:
                                case 20:
                                case 21:
                                case 22: {
                                    return true;
                                }
                                case 23:
                                case 66: {
                                    return true;
                                }
                                case 82: {
                                    return true;
                                }
                                default: {
                                    break Label_0243;
                                }
                            }
                        }
                        catch (Throwable t) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    public boolean onKeyLongPress(final int n, final KeyEvent keyEvent) {
        return 84 == n && bw.I();
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        Label_0128: {
            if (84 != n) {
                break Label_0128;
            }
            Block_2: {
                if (bw.Z()) {
                    bw.Code(false);
                    final int code = Code(n, keyEvent);
                    u.I.h();
                    u.Z.c(code);
                    u.Z.c(0);
                    u.Z.c(0);
                    u.Z.c(n);
                    u.Z.c(I(code));
                    u.Z.b(u.Z.Code(String.valueOf(Code(keyEvent))));
                    u.Z.c((int)keyEvent.getEventTime());
                    u.Z.b(u.Z.Code(String.valueOf(Code(keyEvent)).toUpperCase()));
                    u.I.Z(60);
                    break Block_2;
                }
                return false;
            }
            try {
                cg.Code();
                cg.Z(n);
                cg.I(8);
                if (Browser.Code.C && !Z(n)) {
                    u.I.h();
                    u.Z.c(Code(n, keyEvent));
                    u.Z.c(n);
                    u.Z.c((int)keyEvent.getEventTime());
                    u.I.Z(61);
                    return true;
                }
                return false;
            }
            catch (Throwable t) {
                return false;
            }
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
    Label_0096_Outer:
        while (true) {
            while (true) {
                Label_0179: {
                    Label_0170: {
                        Label_0164: {
                            Label_0158: {
                                Label_0152: {
                                    try {
                                        final int n = (int)motionEvent.getX();
                                        final int n2 = (int)motionEvent.getY();
                                        cg.Code();
                                        cg.Z(n);
                                        cg.Z(n2);
                                        cg.I(2);
                                        if (!Browser.Code.C) {
                                            return true;
                                        }
                                        if (this.f != null && this.f.Code(motionEvent)) {
                                            return true;
                                        }
                                        switch (motionEvent.getAction()) {
                                            case 1: {
                                                break Label_0152;
                                            }
                                            case 2: {
                                                break Label_0158;
                                            }
                                            case 3: {
                                                break Label_0164;
                                            }
                                            case 4: {
                                                break Label_0170;
                                            }
                                            default: {
                                                return false;
                                            }
                                            case 0: {
                                                break Label_0179;
                                            }
                                        }
                                        while (true) {
                                            u.I.h();
                                            u.Z.c(n);
                                            u.Z.c(n2);
                                            u.Z.c((int)motionEvent.getEventTime());
                                            u.Z.c(0);
                                            final int n3;
                                            u.I.Z(n3);
                                            return true;
                                            iftrue(Label_0175:)(n3 == -1);
                                            continue Label_0096_Outer;
                                        }
                                    }
                                    catch (Throwable t) {
                                        return false;
                                    }
                                }
                                final int n3 = 63;
                                continue;
                            }
                            final int n3 = 65;
                            continue;
                        }
                        final int n3 = 64;
                        continue;
                    }
                    final int n3 = -1;
                    continue;
                }
                final int n3 = 62;
                continue;
            }
            Label_0175: {
                return true;
            }
        }
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        try {
            final int code = this.g.Code(motionEvent.getX() * motionEvent.getXPrecision());
            final int code2 = this.h.Code(motionEvent.getY() * motionEvent.getYPrecision());
            cg.Code();
            cg.Z(code);
            cg.Z(code2);
            cg.I(2);
            if (!Browser.Code.C) {
                return true;
            }
            if (motionEvent.getAction() != 0) {
                if (motionEvent.getAction() != 1) {
                    u.I.h();
                    u.Z.c(code);
                    u.Z.c(code2);
                    u.Z.b(u.Z.Code(motionEvent.getEventTime()));
                    u.Z.c(4);
                    u.I.Z(69);
                    return true;
                }
            }
        }
        catch (Throwable t) {
            return false;
        }
        return false;
    }
}
