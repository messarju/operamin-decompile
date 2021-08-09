// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.graphics.Typeface;
import android.graphics.Paint;
import android.graphics.Paint$FontMetricsInt;
import android.text.TextPaint;

public class g implements au
{
    private static Long Code;
    private static char[] b;
    private static ThreadLocal c;
    private TextPaint B;
    private int C;
    private int I;
    private Paint$FontMetricsInt J;
    private char[] Z;
    private int a;
    
    static {
        g.b = new char[2];
        g.c = new ThreadLocal() {};
    }
    
    private g(final TextPaint b, final int i) {
        this.Z = new char[1];
        this.B = b;
        this.I = i;
        this.J = b.getFontMetricsInt();
        --this.J.top;
        this.a = this.J.bottom - this.J.top;
        this.C = (int)Math.ceil(b.measureText(" "));
    }
    
    private int Code(int chars) {
        chars = Character.toChars(chars, g.b, 0);
        return (int)Math.ceil(this.B.measureText(g.b, 0, chars));
    }
    
    public static int Code(final Paint paint, final int n, final char[] array, int n2, int n3) {
        final int n4 = n2 + n3;
        n3 = n2;
        n2 = 0;
        int n5 = 0;
    Label_0060:
        while (true) {
            n5 = n2;
            if (n3 >= n4) {
                break;
            }
            int n6 = n3;
            n3 = n2;
            while (array[n6] == ' ') {
                n3 += n;
                ++n6;
                if (n6 == n4) {
                    n5 = n3;
                    break Label_0060;
                }
            }
            int n7 = n6;
            do {
                n2 = n7;
                if (array[n7] == ' ') {
                    break;
                }
                n2 = n7 + 1;
            } while ((n7 = n2) != n4);
            if (n2 >= n6) {
                final int n8 = n2 - n6;
                int n9;
                if (n8 <= 0) {
                    n9 = 0;
                }
                else {
                    float n10;
                    if (n8 < 255) {
                        final char[] array2 = g.c.get();
                        int i;
                        for (i = 0; i < n8; ++i) {
                            array2[i] = array[i + n6];
                        }
                        array2[i] = '\0';
                        n10 = paint.measureText(array2, 0, n8);
                    }
                    else {
                        n10 = paint.measureText(array, n6, n8);
                    }
                    n9 = (int)Math.ceil(n10);
                }
                final int n11 = n3 + n9;
                n3 = n2;
                n2 = n11;
            }
            else {
                final int n12 = n3;
                n3 = n2;
                n2 = n12;
            }
        }
        return n5;
    }
    
    static g Code(final int n, final int n2, final int n3, final boolean b) {
        boolean b2 = false;
        final TextPaint textPaint = new TextPaint(129);
        boolean b3;
        if ((n2 & 0x1) != 0x0) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        boolean b4;
        if ((n2 & 0x2) != 0x0) {
            b4 = true;
        }
        else {
            b4 = false;
        }
        if (b3) {
            b2 = true;
        }
        int n4 = b2 ? 1 : 0;
        if (b4) {
            n4 = ((b2 ? 1 : 0) | 0x2);
        }
        if ((n2 & 0x4) != 0x0) {
            textPaint.setUnderlineText(true);
        }
        Typeface typeface = null;
        switch (n) {
            default: {
                typeface = Typeface.defaultFromStyle(n4);
                break;
            }
            case 32: {
                typeface = Typeface.create(Typeface.MONOSPACE, n4);
                break;
            }
            case 128: {
                typeface = Typeface.create(Typeface.SERIF, n4);
                break;
            }
        }
        textPaint.setTypeface(typeface);
        textPaint.setTextSize((float)n3);
        if (b) {
            if (b3 && !typeface.isBold()) {
                textPaint.setFakeBoldText(true);
            }
            if (b4 && !typeface.isItalic()) {
                textPaint.setTextSkewX(-0.25f);
            }
        }
        return new g(textPaint, n);
    }
    
    public static Long e() {
        return g.Code;
    }
    
    @Override
    public final String B() {
        if (this.b()) {
            return "monospace";
        }
        if (this.c()) {
            return "serif";
        }
        return "sans";
    }
    
    @Override
    public final boolean C() {
        return this.B.getTypeface().isBold() || this.B.isFakeBoldText();
    }
    
    @Override
    public final int Code() {
        return this.a;
    }
    
    @Override
    public final int Code(final char c) {
        final int code = ap.Code(this, c);
        if (code != -1) {
            return code;
        }
        this.Z[0] = c;
        return (int)Math.ceil(this.B.measureText(this.Z, 0, 1));
    }
    
    @Override
    public final int Code(final String s) {
        return this.Code(s.toCharArray(), 0, s.length());
    }
    
    @Override
    public int Code(final char[] array, final int n, final int n2) {
        return Code((Paint)this.B, this.C, array, n, n2);
    }
    
    public int Code(final char[] array, final int n, final int n2, final float n3) {
        final Paint paint = new Paint((Paint)this.B);
        paint.setTextSize(this.B.getTextSize() * n3);
        return Code(paint, (int)Math.ceil(paint.measureText(" ")), array, n, n2);
    }
    
    @Override
    public final int I() {
        return this.a;
    }
    
    @Override
    public final int J() {
        return -this.J.top;
    }
    
    @Override
    public final int Z() {
        return 0;
    }
    
    @Override
    public final boolean a() {
        return this.B.getTypeface().isItalic() || this.B.getTextSkewX() != 0.0f;
    }
    
    @Override
    public final boolean b() {
        return this.I == 32;
    }
    
    @Override
    public final boolean c() {
        return this.I == 128;
    }
    
    @Override
    public final void d() {
        if (g.Code == null) {
            g.Code = System.nanoTime();
        }
        ap.Code(this);
    }
    
    final int f() {
        return (int)this.B.getTextSize();
    }
    
    public final TextPaint g() {
        return this.B;
    }
}
