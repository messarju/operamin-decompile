// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

final class a
{
    final int B;
    final int C;
    final String Code;
    final String I;
    final String J;
    final String Z;
    final int a;
    J b;
    private long c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private u m;
    private k n;
    
    a(final long c, final String code, final int d, final int f, final int g, final int h, final int i, final String j, final String z, final String k, final int b, final int c2, final int a) {
        this.c = c;
        this.Code = code;
        this.d = d;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.I = j;
        this.Z = z;
        this.J = k;
        this.B = b;
        this.a = a;
        this.C = c2;
        this.j = -1;
        this.l = false;
    }
    
    a(final a a, final String s) {
        this(a.c, s, a.d, a.f, a.g, a.h, a.i, a.I, a.Z, a.J, a.B, a.C, a.a);
        this.e = a.e;
        this.j = a.j;
        this.k = a.k;
        this.l = a.l;
        this.b = a.b;
        this.m = a.m;
        this.n = a.n;
    }
    
    final int B() {
        return this.h;
    }
    
    final void B(final int i) {
        this.i = i;
    }
    
    final int C() {
        return this.i;
    }
    
    final void C(final int j) {
        this.j = j;
    }
    
    final int Code() {
        return this.d;
    }
    
    final void Code(final int d) {
        this.d = d;
    }
    
    public final void Code(final k n) {
        if (!this.I.equals("__##GOOGLEITEM##__")) {
            throw new IllegalStateException("Attempted to add an item to an event of type " + this.I);
        }
        this.n = n;
    }
    
    public final void Code(final u m) {
        if (!this.I.equals("__##GOOGLETRANSACTION##__")) {
            throw new IllegalStateException("Attempted to add a transction to an event of type " + this.I);
        }
        this.m = m;
    }
    
    final int I() {
        return this.e;
    }
    
    final void I(final int f) {
        this.f = f;
    }
    
    final int J() {
        return this.g;
    }
    
    final void J(final int h) {
        this.h = h;
    }
    
    final int Z() {
        return this.f;
    }
    
    final void Z(final int g) {
        this.g = g;
    }
    
    final int a() {
        return this.j;
    }
    
    final void b() {
        this.k = false;
    }
    
    final boolean c() {
        return this.k;
    }
    
    final boolean d() {
        return this.l;
    }
    
    public final u e() {
        return this.m;
    }
    
    public final k f() {
        return this.n;
    }
    
    public final boolean g() {
        return this.f != -1;
    }
    
    @Override
    public final String toString() {
        return "id:" + this.c + " random:" + this.d + " timestampCurrent:" + this.h + " timestampPrevious:" + this.g + " timestampFirst:" + this.f + " visits:" + this.i + " value:" + this.B + " category:" + this.I + " action:" + this.Z + " label:" + this.J + " width:" + this.C + " height:" + this.a;
    }
}
