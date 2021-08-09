// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;

class m$t implements Runnable
{
    final /* synthetic */ m a;
    private final String b;
    
    public m$t(final m a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        if (!this.a.an) {
            Logging.log("onPagFinished is not  called after delay" + Constants.WAIT_FOR_ON_PAGE_FINISHED);
            this.a.d(this.b);
            this.a.e();
            this.a.d();
        }
    }
}
