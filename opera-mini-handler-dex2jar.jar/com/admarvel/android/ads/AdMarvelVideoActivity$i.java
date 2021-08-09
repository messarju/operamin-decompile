// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.os.Handler;

class AdMarvelVideoActivity$i
{
    private Handler a;
    private Runnable b;
    private int c;
    private boolean d;
    private boolean e;
    private Runnable f;
    
    public AdMarvelVideoActivity$i(final Handler a, final Runnable b, final int c) {
        this.d = false;
        this.e = false;
        this.f = new Runnable() {
            @Override
            public void run() {
                if (!AdMarvelVideoActivity$i.this.d) {
                    return;
                }
                AdMarvelVideoActivity$i.this.a.post(AdMarvelVideoActivity$i.this.b);
                if (AdMarvelVideoActivity$i.this.e) {
                    AdMarvelVideoActivity$i.this.d = false;
                    return;
                }
                AdMarvelVideoActivity$i.this.a.postDelayed(AdMarvelVideoActivity$i.this.f, (long)AdMarvelVideoActivity$i.this.c);
            }
        };
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public AdMarvelVideoActivity$i(final Handler handler, final Runnable runnable, final int n, final boolean e) {
        this(handler, runnable, n);
        this.e = e;
    }
    
    public void a() {
        if (!this.d && this.c > 0) {
            this.d = true;
            this.a.postDelayed(this.f, (long)this.c);
        }
    }
    
    public void b() {
        if (!this.d) {
            return;
        }
        this.d = false;
        this.a.removeCallbacks(this.b);
        this.a.removeCallbacks(this.f);
    }
    
    public boolean c() {
        return this.d;
    }
}
