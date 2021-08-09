// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.Enumeration;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

public final class h implements av
{
    private static h B;
    private static Hashtable C;
    static int Code;
    private static int I;
    private static final int[] J;
    private static final int[] Z;
    
    static {
        h.I = 95;
        Z = new int[] { 8, 10, 12, 13, 15, 17, 19, 21, 23, 25, 28, 32 };
        J = new int[] { 10, 11, 12, 14, 16, 18, 20, 23, 26, 30, 34, 39, 44, 50, 57, 65 };
        h.C = new Hashtable();
    }
    
    private h() {
        final float min = Math.min(x.k(), x.l());
        final int widthPixels = x.ag.widthPixels;
        final int heightPixels = x.ag.heightPixels;
        h.I = Math.round((h.I = Math.max(30, Math.min(95, (int)(1083.3310546875 / Math.sqrt(Math.sqrt(widthPixels * widthPixels + heightPixels * heightPixels)) + 3683.7212f / min - 1.9227999448776245)))) / 10.0f) * 10;
        for (int i = 0; i < h.J.length; ++i) {
            h.J[i] = (int)(h.J[i] * 100 / (h.I * 1.25f));
        }
        h.I *= (int)1.25f;
    }
    
    private int Code(final au[] array, final int n, final int n2, final int n3, final boolean b) {
        return this.I(array, this.I(array, n, n2, n3, b), n2, n3 | 0x2, b);
    }
    
    private int Code(final au[] array, final int n, final int n2, final boolean b) {
        return this.Code(array, this.Code(array, n, n2, 0, b), n2, 1, b);
    }
    
    private au Code(final int n, final int n2, final int n3, final boolean b) {
        monitorenter(this);
        Label_0114: {
            if (!b) {
                break Label_0114;
            }
            int n4 = 1;
        Label_0064_Outer:
            while (true) {
                while (true) {
                    Label_0127: {
                        try {
                            final Integer n5 = new Integer(n4 | (n2 * 2 | (n * 1024 | n3 * 8)));
                            final WeakReference weakReference = h.C.get(n5);
                            if (weakReference != null) {
                                final g g = (g)weakReference.get();
                                g code = g;
                                if (g == null) {
                                    code = com.opera.mini.android.g.Code(n, n2, n3, b);
                                }
                                if (code != null) {
                                    h.C.put(n5, new WeakReference(code));
                                    J();
                                }
                                return code;
                            }
                            break Label_0127;
                            n4 = 0;
                            continue Label_0064_Outer;
                        }
                        finally {
                            monitorexit(this);
                        }
                    }
                    final g g = null;
                    continue;
                }
            }
        }
    }
    
    public static h Code() {
        if (h.B == null) {
            h.B = new h();
        }
        return h.B;
    }
    
    public static int I() {
        return h.J[Z(0)];
    }
    
    private int I(final au[] array, int n, final int n2, final int n3, final boolean b) {
        int[] array2;
        if (b) {
            array2 = h.Z;
        }
        else {
            array2 = h.J;
        }
        for (int length = array2.length, i = 0; i < length; ++i) {
            final g g = (g)this.Code(n2, n3, array2[i], !b);
            int n5;
            if (g != null) {
                boolean b2;
                if (g.C()) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                int n4;
                if (g.a()) {
                    n4 = 2;
                }
                else {
                    n4 = 0;
                }
                n5 = ((b2 ? 1 : 0) | n4);
            }
            else {
                n5 = n3;
            }
            if (g != null && n5 == n3) {
                array[n] = g;
                ++n;
            }
        }
        return n;
    }
    
    public static boolean I(final int n) {
        return n < h.Code;
    }
    
    private static void J() {
        final Enumeration keys = h.C.keys();
        while (keys.hasMoreElements()) {
            final Integer n = (Integer)keys.nextElement();
            final WeakReference weakReference = h.C.get(n);
            if (weakReference != null && weakReference.get() == null) {
                h.C.remove(n);
            }
        }
    }
    
    public static int Z(final int n) {
        switch (n) {
            default: {
                return h.Code + 2;
            }
            case 0: {
                return h.Code + 0;
            }
            case 2: {
                return h.Code + 4;
            }
        }
    }
    
    @Override
    public final int Code(int n) {
        final int n2 = 48;
        int i;
        final int n3 = i = h.I;
        Label_0043: {
            switch (n) {
                default: {
                    i = n3;
                    break Label_0043;
                }
                case 2: {
                    i = (int)(n3 / 1.25f);
                    break Label_0043;
                }
                case 0: {
                    i = (int)(n3 * 1.25f);
                }
                case 1: {
                    if (i > 48 && i < 52) {
                        if (i <= 50) {
                            n = n2;
                        }
                        else {
                            n = 52;
                        }
                    }
                    else {
                        n = i;
                    }
                    return Math.min(95, n);
                }
            }
        }
    }
    
    @Override
    public final au Code(final int n, int n2) {
        switch (n2) {
            default: {
                n2 = h.J[0];
                break;
            }
            case 0: {
                n2 = h.J[2];
                break;
            }
            case 16: {
                n2 = h.J[4];
                break;
            }
        }
        final au code = this.Code(n, 0, n2);
        if (code == null) {
            return this.Code(64, 0, n2);
        }
        return code;
    }
    
    @Override
    public final au Code(final int n, final int n2, final int n3) {
        synchronized (this) {
            return this.Code(n, n2, n3, true);
        }
    }
    
    public final au[] Z() {
        final au[] array = new au[h.Z.length * 12 + h.J.length * 12];
        final int code = this.Code(array, this.Code(array, this.Code(array, h.Code = this.Code(array, this.Code(array, this.Code(array, 0, 64, true), 128, true), 32, true), 64, false), 128, false), 32, false);
        if (code < array.length) {
            final au[] array2 = new au[code];
            System.arraycopy(array, 0, array2, 0, code);
            return array2;
        }
        return array;
    }
}
