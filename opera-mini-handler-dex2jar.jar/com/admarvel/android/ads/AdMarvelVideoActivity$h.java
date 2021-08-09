// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class AdMarvelVideoActivity$h extends BroadcastReceiver
{
    final /* synthetic */ AdMarvelVideoActivity a;
    
    AdMarvelVideoActivity$h(final AdMarvelVideoActivity a) {
        this.a = a;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            if (this.a.h != null) {
                final AdMarvelVideoActivity$b adMarvelVideoActivity$b = (AdMarvelVideoActivity$b)this.a.h.get();
                if (adMarvelVideoActivity$b != null && adMarvelVideoActivity$b.a() && !this.a.H) {
                    adMarvelVideoActivity$b.d();
                    this.a.c();
                }
            }
            if (this.a.F && this.a.i == AdMarvelVideoActivity$k.g && this.a.L != null) {
                this.a.i = AdMarvelVideoActivity$k.b;
                this.a.F = false;
            }
            if (this.a.G && this.a.i == AdMarvelVideoActivity$k.g && this.a.L != null) {
                this.a.L.pause();
                this.a.i = AdMarvelVideoActivity$k.c;
                this.a.G = false;
            }
        }
    }
}
