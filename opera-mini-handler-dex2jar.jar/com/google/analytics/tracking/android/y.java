// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.util.TreeSet;
import java.util.SortedSet;

final class y
{
    private static final y J;
    private SortedSet Code;
    private StringBuilder I;
    private boolean Z;
    
    static {
        J = new y();
    }
    
    private y() {
        this.Code = new TreeSet();
        this.I = new StringBuilder();
        this.Z = false;
    }
    
    public static y Code() {
        return y.J;
    }
    
    public final void Code(final aa aa) {
        synchronized (this) {
            if (!this.Z) {
                this.Code.add(aa);
                this.I.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(aa.ordinal()));
            }
        }
    }
    
    public final void Code(final boolean z) {
        synchronized (this) {
            this.Z = z;
        }
    }
    
    public final String I() {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            int n = 6;
            int n2 = 0;
            while (this.Code.size() > 0) {
                final aa aa = this.Code.first();
                this.Code.remove(aa);
                while (aa.ordinal() >= n) {
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n2));
                    n += 6;
                    n2 = 0;
                }
                n2 += 1 << aa.ordinal() % 6;
            }
            if (n2 > 0 || sb.length() == 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n2));
            }
            this.Code.clear();
            return sb.toString();
        }
    }
    
    public final String Z() {
        synchronized (this) {
            if (this.I.length() > 0) {
                this.I.insert(0, ".");
            }
            final String string = this.I.toString();
            this.I = new StringBuilder();
            return string;
        }
    }
}
