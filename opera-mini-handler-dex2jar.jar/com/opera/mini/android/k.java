// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.os.Build;
import java.nio.Buffer;
import android.graphics.PorterDuff$Mode;
import android.graphics.Region$Op;
import android.graphics.Bitmap$Config;
import java.nio.ByteBuffer;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.Rect;
import android.graphics.Paint;

public class k implements aw
{
    private static Paint B;
    private static Rect C;
    private static char[] Code;
    private static g I;
    private static Paint$FontMetricsInt J;
    private static float Z;
    private static Canvas a;
    private static Bitmap b;
    private static ByteBuffer c;
    private static byte[] d;
    private static int e;
    private static int f;
    private long g;
    private l h;
    
    static {
        k.Code = new char[1];
        k.B = new Paint();
        k.C = new Rect();
        k.a = new Canvas();
        i();
    }
    
    private static char Code(char char1) {
        final int index = "()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".indexOf(char1);
        if (index >= 0) {
            int n;
            if ((index & 0x1) == 0x0) {
                n = index + 1;
            }
            else {
                n = index - 1;
            }
            char1 = "()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".charAt(n);
        }
        return char1;
    }
    
    private static Rect Code(final char[] array, int i, int max, final int n, int max2, final float z, final g j, final boolean b) {
        final int[] array2 = { i, max };
        max = array2[0];
        final int n2 = array2[1];
        int n3 = 0;
        int n4 = 0;
        while (true) {
            int n5;
            char[] array3;
            int n6;
            Paint$FontMetricsInt paint$FontMetricsInt;
            int min;
            int n7;
            int n8;
            for (i = max; i < max + n2; ++i, n4 = n5, n3 = n8) {
                if ((n5 = n4) == 0) {
                    n5 = n4;
                    if (cg.Code(array[i])) {
                        n5 = 1;
                        if (cg.J(array[i])) {
                            array3 = array;
                            n6 = array2[0];
                            i = array2[1];
                            if (k.I != j) {
                                k.B.set((Paint)j.g());
                                k.f = (int)Math.ceil(k.B.measureText(" "));
                                k.I = j;
                                k.Z = 0.0f;
                            }
                            if (z != k.Z) {
                                k.B.setTextSize(j.f() * z);
                                k.f = (int)Math.ceil(k.B.measureText(" "));
                                paint$FontMetricsInt = (k.J = k.B.getFontMetricsInt());
                                --paint$FontMetricsInt.top;
                                k.Z = z;
                            }
                            if (i > 2048) {
                                i = 2048;
                            }
                            min = Math.min(max2, g.Code(k.B, k.f, array3, n6, i));
                            n7 = k.J.bottom - k.J.top;
                            if (k.b == null || k.b.getWidth() < min || k.b.getHeight() < n7) {
                                if (k.b != null) {
                                    max2 = Math.max(k.b.getWidth(), min);
                                    max = Math.max(k.b.getHeight(), n7);
                                    k.b.recycle();
                                }
                                else {
                                    max = n7;
                                    max2 = min;
                                }
                                k.b = null;
                                k.c = null;
                                k.d = null;
                                k.e = max2;
                                k.c = ByteBuffer.wrap(k.d = new byte[max2 * max]);
                                k.b = Bitmap.createBitmap(max2, max, Bitmap$Config.ALPHA_8);
                                k.a.setBitmap(k.b);
                            }
                            k.a.clipRect(0.0f, 0.0f, (float)min, (float)n7, Region$Op.REPLACE);
                            k.a.drawColor(0, PorterDuff$Mode.SRC);
                            k.a.drawText(array3, n6, i, (float)(-n), (float)(-k.J.top), k.B);
                            if (b) {
                                k.c.position(0);
                                k.b.copyPixelsToBuffer((Buffer)k.c);
                            }
                            k.C.top = k.J.top;
                            k.C.bottom = k.J.bottom;
                            k.C.left = 0;
                            k.C.right = min;
                            return k.C;
                        }
                    }
                }
                n8 = n3;
                if (array[i] == '\u200f') {
                    n8 = n3 + 1;
                }
            }
            array3 = array;
            if (n3 != 0) {
                array3 = new char[n2 - n3];
                if (n4 == 0 && n2 == 2) {
                    if (array[0] != '\u200f') {
                        i = 0;
                    }
                    else {
                        i = 1;
                    }
                    array3[0] = Code(array[i]);
                }
                else {
                    int n9;
                    char code;
                    for (n9 = 0, i = max; i < max + n2 - 1; ++i, ++n9) {
                        if (array[i] == '\u200f') {
                            ++i;
                            code = Code(array[i]);
                        }
                        else {
                            code = array[i];
                        }
                        array3[n9] = code;
                    }
                    if (i < n2) {
                        array3[n9] = array[i];
                    }
                }
                array2[0] = 0;
                array2[1] = array3.length;
            }
            continue;
        }
    }
    
    public static g Code(final int n) {
        return (g)cg.ae[n];
    }
    
    public static k Code(final q q) {
        final k k = new k();
        k.I(q);
        return k;
    }
    
    public static native void Code(final bh p0, final int p1, final int p2, final int p3, final int p4, final int p5, final p p6, final int p7);
    
    private native void Code(final char[] p0, final int p1, final int p2, final int p3, final int p4, final g p5, final int p6, final int p7, final int p8);
    
    public static k I(final int n, final int n2) {
        final k k = new k();
        k.h = new m();
        k.Z(n, n2);
        return k;
    }
    
    public static k I(final Bitmap bitmap) {
        final k k = new k();
        if (d()) {
            k.h = new o(k, bitmap);
        }
        else {
            k.h = new n(k, ByteBuffer.allocateDirect(bitmap.getRowBytes() * bitmap.getHeight()));
        }
        k.Code(bitmap.getWidth(), bitmap.getHeight());
        return k;
    }
    
    public static native void I(final boolean p0);
    
    private native void I(final char[] p0, final int p1, final int p2, final int p3, final int p4, final au p5, final int p6);
    
    public static native void Z(final boolean p0);
    
    public static native boolean d();
    
    private static boolean h() {
        return !Build.MODEL.equalsIgnoreCase("Mi-504");
    }
    
    private static native void i();
    
    native void B();
    
    native void C();
    
    @Override
    public native int Code();
    
    @Override
    public void Code(final char c, final int n, final int n2, final au au, final int n3) {
        k.Code[0] = c;
        this.Code(k.Code, 0, 1, n, n2, au, n3);
    }
    
    native void Code(final int p0, final int p1);
    
    @Override
    public native void Code(final int p0, final int p1, final int p2, final int p3);
    
    @Override
    public void Code(final int n, final int n2, final int n3, final int n4, final int n5) {
        System.err.println("TODO: drawLine");
    }
    
    @Override
    public void Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        System.err.println("TODO: fillRectGradient");
    }
    
    @Override
    public void Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        System.err.println("TODO: fillArc");
    }
    
    @Override
    public void Code(final int n, final char[] array, final int n2, final int n3, final int n4, final int n5, final int n6, final boolean b, final int n7, final int n8, final int n9) {
        this.Code(array, n2, n3, n4, n5, (g)cg.ae[n], n6, n8, n9);
    }
    
    public final void Code(final Bitmap bitmap) {
        this.h.Code(bitmap);
    }
    
    @Override
    public native void Code(final az p0, final int p1, final int p2);
    
    @Override
    public native void Code(final az p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    @Override
    public native void Code(final az p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final int p7, final int p8);
    
    @Override
    public void Code(final az az, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        this.I(az, n, n2, n3, n4, n5, n6);
    }
    
    @Override
    public void Code(final az az, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11) {
        this.Code(az, n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    @Override
    public native void Code(final az p0, final int p1, final int p2, final int p3, final int p4, final boolean p5);
    
    @Override
    public native void Code(final String p0, final int p1, final int p2, final au p3, final int p4);
    
    public native void Code(final boolean p0);
    
    @Override
    public void Code(final char[] array, final int n, final int n2, final int n3, final int n4, final au au, final int n5) {
        this.I(array, n, n2, n3, n4, au, n5);
    }
    
    @Override
    public void Code(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final boolean b) {
        System.err.println("TODO: drawRGB");
    }
    
    @Override
    public native int I();
    
    @Override
    public native void I(final int p0, final int p1, final int p2, final int p3);
    
    @Override
    public void I(final int n, final int n2, final int n3, final int n4, final int n5) {
        System.err.println("TODO: drawRect");
    }
    
    @Override
    public native void I(final az p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6);
    
    native void I(final q p0);
    
    @Override
    public native int J();
    
    native void J(final int p0, final int p1);
    
    @Override
    public native void J(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    @Override
    public native int Z();
    
    native void Z(final int p0, final int p1);
    
    @Override
    public native void Z(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    final boolean a() {
        if (!this.h.Code()) {
            return false;
        }
        this.B();
        return true;
    }
    
    final void b() {
        this.C();
        this.h.I();
    }
    
    native void c();
    
    native void e();
    
    public native void f();
    
    @Override
    protected native void finalize();
    
    public native void g();
}
