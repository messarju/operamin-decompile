// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.view.View;
import android.content.Context;
import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceView;

public class bf extends SurfaceView implements SurfaceHolder$Callback, bi
{
    private static Runnable B;
    private static int C;
    private static k I;
    private static Bitmap Z;
    private static int a;
    private static int b;
    private static int c;
    private static boolean d;
    private static cd e;
    private MiniView Code;
    private SurfaceHolder J;
    
    static {
        bf.d = false;
        bf.e = new cd();
    }
    
    public bf(final Context context, final MiniView code) {
        super(context);
        this.Code = code;
        (this.J = this.getHolder()).addCallback((SurfaceHolder$Callback)this);
        this.setFocusableInTouchMode(true);
    }
    
    private void Code(int a, final int a2, int c, final int c2, final boolean b) {
        if (bf.B == null) {
            bf.B = new bg(this, (byte)0);
            new Thread(bf.B).start();
        }
        synchronized (bf.B) {
            if (bf.b > 0) {
                final int c3 = bf.C;
                final int b2 = bf.b;
                bf.C = Math.min(bf.C, a);
                bf.b = Math.max(a + c, c3 + b2) - bf.C;
                a = bf.a;
                c = bf.c;
                bf.a = Math.min(bf.a, a2);
                bf.c = Math.max(a2 + c2, a + c) - bf.a;
            }
            else {
                bf.C = a;
                bf.a = a2;
                bf.b = c;
                bf.c = c2;
            }
            if (b) {
                bf.d = true;
                bf.B.notify();
            }
        }
    }
    
    public void C() {
        this.Code(0, 0, this.getWidth(), this.getHeight());
    }
    
    public View Code() {
        return (View)this;
    }
    
    public void Code(final int n, final int n2, final int n3, final int n4) {
        this.Code(n, n2, n3, n4, true);
    }
    
    public bi I() {
        return this;
    }
    
    public void J() {
        if (bf.B == null) {
            return;
        }
        synchronized (bf.B) {
            bf.b = 0;
            bf.c = 0;
            bf.C = 0;
            bf.a = 0;
            bf.B.notifyAll();
            monitorexit(bf.B);
            bf.e.Code();
        }
    }
    
    public void Z() {
    }
    
    public void a() {
    }
    
    public boolean b() {
        return true;
    }
    
    public void onPause() {
    }
    
    public void onResume() {
    }
    
    public void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.Code(0, 0, n, n2, false);
        this.Code.I(n, n2, n3, n4);
        this.Code(0, 0, n, n2, false);
    }
    
    public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
        this.C();
    }
    
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
    }
    
    public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
    }
}
