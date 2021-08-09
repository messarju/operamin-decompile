// 
// Decompiled by Procyon v0.6-prerelease
// 

final class ai
{
    private final String B;
    private final String C;
    private final al Code;
    private final int I;
    private final String J;
    private final int Z;
    private final int a;
    
    ai(final al code, final int i, final int z, final String j, final String b, final String c, final int a) {
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
        this.B = b;
        this.C = c;
        this.a = a;
    }
    
    static /* synthetic */ String Code(final ai ai) {
        final String b = ai.B;
        final int index = b.indexOf(63);
        String substring = b;
        if (index > 0) {
            substring = b.substring(0, index);
        }
        final int lastIndex = substring.lastIndexOf(47);
        String substring2 = substring;
        if (lastIndex > 0) {
            substring2 = substring.substring(lastIndex + 1);
        }
        String string = substring2;
        if (substring2.indexOf(46) == -1) {
            string = substring2;
            if (ai.C != null) {
                string = substring2;
                if (ai.C.startsWith("image/")) {
                    string = substring2 + "." + ai.C.substring(ai.C.indexOf(47) + 1);
                }
            }
        }
        return string;
    }
    
    private static String Code(final String s) {
        final char[] array = new char[s.length()];
        for (int i = 0; i < array.length; ++i) {
            array[i] = '*';
        }
        return new String(array);
    }
    
    private int f() {
        if (this.a <= 0) {
            return 0;
        }
        return this.Code.m(this.a);
    }
    
    final boolean B() {
        return this.B != null;
    }
    
    final String C() {
        if (this.B()) {
            return this.B;
        }
        return "";
    }
    
    final int Code() {
        return this.I;
    }
    
    final void Code(final int n) {
        switch (n) {
            case 2: {
                if (this.B()) {
                    cg.Code(new Runnable() {
                        @Override
                        public final void run() {
                            ai.this.Code.Code(ai.Code(ai.this), ai.this.C, ai.this.B);
                        }
                    });
                    return;
                }
                break;
            }
            case 4: {
                if (this.a()) {
                    String s = this.Code.p(this.a);
                    if (this.c()) {
                        s = Code(s);
                    }
                    u.Code.w().Code(s);
                    return;
                }
                break;
            }
            case 5: {
                if (this.a()) {
                    String s2 = this.Code.p(this.a);
                    if (this.c()) {
                        s2 = Code(s2);
                    }
                    u.Code.w().Code(s2);
                    this.Code.Code(this.a, "");
                    return;
                }
                break;
            }
            case 6: {
                if (this.a()) {
                    this.Code.Code(this.a, u.Code.w().Code());
                    return;
                }
                break;
            }
        }
    }
    
    final int I() {
        return this.Z;
    }
    
    final String J() {
        if (this.Z()) {
            return this.J;
        }
        return "";
    }
    
    final boolean Z() {
        return this.J != null;
    }
    
    final boolean a() {
        final int f = this.f();
        return f == 97 || f == 120 || f == 112 || f == 83 || f == 85;
    }
    
    final boolean b() {
        return this.a() && !this.Code.p(this.a).equals("");
    }
    
    final boolean c() {
        return this.f() == 112;
    }
    
    final boolean d() {
        return this.f() == 102;
    }
    
    final boolean e() {
        return this.f() == 97;
    }
}
