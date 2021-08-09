// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

final class bd
{
    private String Code;
    private String I;
    private String J;
    private String Z;
    
    bd(final String s) {
        this(s, null, null, null);
    }
    
    bd(final String code, final String i, final String z, final String j) {
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof bd) {
            final bd bd = (bd)o;
            if (((bd.Code == null && this.Code == null) || bd.Code.equals(this.Code)) && ((bd.I == null && this.I == null) || bd.I.equals(this.I)) && ((bd.Z == null && this.Z == null) || bd.Z.equals(this.Z)) && ((bd.J == null && this.J == null) || bd.J.equals(this.J))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        final StringBuilder sb = new StringBuilder();
        String code;
        if (this.Code != null) {
            code = this.Code;
        }
        else {
            code = "";
        }
        final StringBuilder append = sb.append(code).append("jz78qgNXYe");
        String i;
        if (this.I != null) {
            i = this.I;
        }
        else {
            i = "";
        }
        final StringBuilder append2 = append.append(i).append("jz78qgNXYe");
        String z;
        if (this.Z != null) {
            z = this.Z;
        }
        else {
            z = "";
        }
        final StringBuilder append3 = append2.append(z).append("jz78qgNXYe");
        String j;
        if (this.J != null) {
            j = this.J;
        }
        else {
            j = "";
        }
        return append3.append(j).toString().hashCode();
    }
}
