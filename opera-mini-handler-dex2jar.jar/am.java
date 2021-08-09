// 
// Decompiled by Procyon v0.6-prerelease
// 

final class am
{
    int B;
    int C;
    int[] Code;
    az[] I;
    int J;
    az[] Z;
    private int a;
    private int b;
    
    am() {
        this.Code = new int[1536];
        this.I = new az[256];
        this.Z = new az[256];
    }
    
    private boolean Code(final az[] array, final int n, final az az) {
        final az az2 = array[n];
        if (az2 != null) {
            this.b -= az2.J();
            array[n] = null;
        }
        final int j = az.J();
        if (!this.I(j)) {
            return false;
        }
        array[n] = az;
        this.b += j;
        return true;
    }
    
    final void Code(final int a) {
        this.a = a;
    }
    
    final void Code(final int n, final int c) {
        if (n <= 0) {
            this.B = 0;
            this.C = 0;
            return;
        }
        this.B = Math.max(1, n - c);
        this.C = c;
    }
    
    final void Code(final int n, final boolean b, final boolean b2) {
        if (b) {
            final az az = this.Z[n];
            if (az != null) {
                this.b -= az.J();
                this.Z[n] = null;
            }
        }
        if (b2) {
            final az az2 = this.I[n];
            if (az2 != null) {
                this.b -= az2.J();
                this.I[n] = null;
            }
        }
    }
    
    final boolean Code(int n, int n2, final am am, final int n3) {
        boolean b = false;
        final int z = this.Z(n);
        if (this.I(z, n)) {
            final az az = this.I[z];
            if (az != null) {
                n = az.J();
                am.I[n3] = az;
                am.b += n;
                if (am.B > 0) {
                    am.B += n;
                    am.C -= n;
                }
            }
            if (n2 == this.a) {
                final az az2 = this.Z[z];
                if (az2 != null) {
                    n = az2.J();
                    am.Z[n3] = az2;
                    am.b += n;
                    if (am.B > 0) {
                        am.B += n;
                        am.C -= n;
                    }
                }
            }
            if (am.C < 0) {
                am.C = 0;
            }
            final int[] code = am.Code;
            n = n3 * 6 + 2;
            n2 = code[n];
            code[n] = ((this.Code[z * 6 + 2] & Integer.MIN_VALUE) | n2);
            b = true;
        }
        return b;
    }
    
    final boolean Code(final int n, final boolean b, final az az, final az az2) {
        az[] array;
        az[] array2;
        if (b) {
            array = this.I;
            array2 = this.Z;
        }
        else {
            array = this.Z;
            array2 = this.I;
        }
        if (!this.Code(array, n, az)) {
            return false;
        }
        if (az2 != null) {
            this.Code(array2, n, az2);
        }
        return true;
    }
    
    final boolean I(final int n) {
        return this.B == 0 || this.b + n < this.B;
    }
    
    final boolean I(final int n, final int n2) {
        return n < this.J && this.Code[n * 6 + 0] == n2;
    }
    
    final int Z(final int n) {
        return cg.Code(this.Code, this.J, 6, n);
    }
}
