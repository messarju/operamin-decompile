// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.a;
import android.content.Context;

public class AdMarvelVideoActivity$e implements Runnable
{
    private final AdMarvelAd a;
    private final Context b;
    
    public AdMarvelVideoActivity$e(final AdMarvelAd a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        if (this.a != null) {
            this.a.setResponseJson();
        }
        final a b = com.admarvel.android.util.a.b(this.b);
        if (b != null && this.a != null) {
            final int a = b.a(this.b);
            this.a.setAdHistoryCounter(a);
            b.a(this.a.getAdHistoryDumpString(), a);
        }
    }
}
