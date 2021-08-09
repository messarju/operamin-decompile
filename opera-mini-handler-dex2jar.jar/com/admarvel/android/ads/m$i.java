// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.a;
import android.content.Context;

class m$i implements Runnable
{
    private final AdMarvelAd a;
    private final Context b;
    
    public m$i(final AdMarvelAd a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        final a b = com.admarvel.android.util.a.b(this.b);
        if (b != null) {
            final int adHistoryCounter = this.a.getAdHistoryCounter();
            final StringBuilder sb = new StringBuilder();
            sb.append("/sse_");
            sb.append(adHistoryCounter);
            sb.append(".jpg");
            b.a(sb.toString());
        }
    }
}
