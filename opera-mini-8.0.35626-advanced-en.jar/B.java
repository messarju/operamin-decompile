import javax.microedition.lcdui.Image;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class B
{
    public int I;
    public boolean I;
    public boolean Code;
    public int Code;
    private static boolean Z;
    public Image Code;
    private static boolean J;
    private Code I;
    public Code Code;
    
    public final void Code(final int n) {
        final int j = this.J();
        final int b = this.B();
        int n2 = Integer.MAX_VALUE;
        boolean i = false;
        for (B b2 = new B(this); Code.Code(b2.J(), b2.B(), j, b) && !i; i = b2.I()) {
            final int abs;
            if ((abs = Math.abs(b2.Z() - n)) < n2) {
                this.Code(b2);
                n2 = abs;
            }
        }
    }
    
    public final void Code(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.Code.getRGB(array, 0, n, n2, n3, n4, n5);
    }
    
    public final B Code(int n, int n2, int n3, int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final boolean b) {
        if (n3 != n5 || n4 != n6) {
            final int[] array = new int[n3 * n4];
            this.Code(array, n3, n, n2, n3, n4);
            final int[] code = Code.Code(array, n3, n4, n5, n6, n7, n8, n9, n10, n11, b);
            return Code.Z.Code(code, code.length / n6, n6, true, true);
        }
        if (n3 == this.Code.getWidth() && n4 == this.Code.getHeight()) {
            return this;
        }
        final int n12 = n;
        final int n13 = n2;
        final int n14 = n3;
        n = n4;
        n2 = n14;
        n3 = n13;
        n4 = n12;
        if (!B.Z) {
            final int[] array2;
            final Image rgbImage = Image.createRGBImage(array2 = new int[] { -2139062144 }, 1, 1, true);
            array2[0] = 0;
            Image.createImage(rgbImage, 0, 0, 1, 1, 0).getRGB(array2, 0, 1, 0, 0, 1, 1);
            final int n15 = (array2[0] >>> 24) - 128;
            B.J = (((n15 | -n15) >>> 31 ^ 0x1) != 0x0);
            B.Z = true;
        }
        if (B.J) {
            final Image code2 = this.Code;
            final int[] array3 = new int[n2 * n];
            code2.getRGB(array3, 0, n2, n4, n3, n2, n);
            return new B(Image.createRGBImage(array3, n2, n, true), this.Code);
        }
        return new B(Image.createImage(this.Code, n4, n3, n2, n, 0), this.Code);
    }
    
    private B(final Code i, final Code code, final int code2) {
        this.I = true;
        this.I = i;
        this.Code = code;
        this.Code = code2;
    }
    
    public B(final B b) {
        this.I = true;
        this.Code(b);
    }
    
    public final int Code() {
        return this.Code.getWidth() * this.Code.getHeight() * Code.Z;
    }
    
    public final int B() {
        if (this.Code()) {
            return 0;
        }
        return Code.a(this.Code.C());
    }
    
    public final boolean Code() {
        return this.Code == null;
    }
    
    public final void Code(final int n, final int n2, final int n3) {
        if (this.Code != null && this.Code.Code(n2, n3)) {
            this.Code(this.Code, n2, n3);
            return;
        }
        this.Code(this.I.Code(n, n2, n3), n2, n3);
    }
    
    public B() {
    }
    
    public B(final Image code, final boolean code2) {
        this();
        this.Code = code;
        this.Code = code2;
    }
    
    public final Code Code() {
        return new Code(this.Code.getGraphics());
    }
    
    public B(final Code i) {
        this.I = true;
        this.I = i;
        this.I = Integer.MIN_VALUE;
    }
    
    public final void Code(final B b) {
        this.I = b.I;
        this.Code = b.Code;
        this.Code = b.Code;
        this.I = b.I;
    }
    
    public final void Code(final Code code, final int n, final int n2) {
        if (code == null) {
            return;
        }
        this.I = Integer.MIN_VALUE;
        this.Code = code;
        this.Code = 0;
        int n3 = Integer.MAX_VALUE;
        final B b = new B(this);
        do {
            final int a = Code.a(b.Code.C());
            final Code j;
            final B b2 = ((j = b.Code.J()) != null) ? new B(this.I, j, 0) : new B(this.I, b.Code, b.Code.I().length());
            for (boolean i = false; b.Code(b2) <= 0 && !i; i = b.I()) {
                final int n4 = b.Z() - n;
                final int n5 = b.J() + a / 2 - n2;
                final int n6;
                if ((n6 = n4 * n4 + n5 * n5) < n3) {
                    this.Code(b);
                    n3 = n6;
                }
            }
            b.Code = j;
            b.Code = 0;
        } while (b.Code != null && b.Code.I(this.Code));
    }
    
    public final boolean I() {
        final int length = this.Code.I().length();
        if (this.Code < length - 1) {
            ++this.Code;
            return false;
        }
        final Code j;
        if ((j = this.Code.J()) != null) {
            if (this.Code == length - 1 && this.Code.Code(j)) {
                ++this.Code;
                return false;
            }
            this.Code = j;
            this.Code = 0;
            return false;
        }
        else {
            if (this.Code < length) {
                ++this.Code;
                return false;
            }
            return true;
        }
    }
    
    public final int Z() {
        if (this.Code()) {
            return 0;
        }
        final int c = this.Code.C();
        final char[] code = this.Code.Code();
        if (this.Code.J()) {
            int n;
            for (n = this.Code - 1; n >= 0 && code[n] != '\n'; --n) {}
            return this.Code.J() + Code.Code(c, code, n + 1, this.Code - 1 - n);
        }
        int code2;
        for (code2 = this.Code; code2 < code.length && code[code2] != '\n'; ++code2) {}
        return this.Code.J() + Code.Code(c, code, this.Code, code2 - this.Code);
    }
    
    public final int I() {
        if (this.I == Integer.MIN_VALUE) {
            this.I = this.Z();
        }
        return this.I;
    }
    
    public final int J() {
        if (this.Code()) {
            return 0;
        }
        int b = this.Code.B();
        final int c = this.Code.C();
        final String i = this.Code.I();
        final int a = Code.a(c);
        for (int j = 0; j < this.Code; ++j) {
            if (i.charAt(j) == '\n') {
                b += a;
            }
        }
        return b;
    }
    
    public static B Code(final B b, final B b2) {
        if (b.Code()) {
            return b;
        }
        if (b2.Code()) {
            return b2;
        }
        if (b.Code.Z() < b2.Code.Z()) {
            return b;
        }
        if (b.Code.Z() > b2.Code.Z()) {
            return b2;
        }
        if (b.Code <= b2.Code) {
            return b;
        }
        return b2;
    }
    
    public final int Code(final B b) {
        if (this.Code.Code(b.Code) == 0) {
            return this.Code - b.Code;
        }
        return this.Code.Code(b.Code);
    }
}
