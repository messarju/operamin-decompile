// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

class AdMarvelView$h implements AdMarvelAdapterListener
{
    private final WeakReference a;
    
    public AdMarvelView$h(final AdMarvelView adMarvelView) {
        this.a = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void onClickAd(final String s) {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final AdMarvelAd f = adMarvelView.v;
            if (f != null) {
                adMarvelView.h.a(adMarvelView.getContext(), adMarvelView, s, f.getSiteId(), f.getId(), f.getTargetParams(), f.getIpAddress());
            }
        }
    }
    
    @Override
    public void onClose() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.i = false;
        adMarvelView.h.b();
    }
    
    @Override
    public void onExpand() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        adMarvelView.i = true;
        adMarvelView.h.a();
    }
    
    @Override
    public void onFailedToReceiveAd(final int n, final AdMarvelUtils$ErrorReason adMarvelUtils$ErrorReason) {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView != null) {
            final AdMarvelAd f = adMarvelView.v;
            new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$j(adMarvelView));
            final boolean b = false;
            if (f != null && f.getAdType() == AdMarvelAd$AdType.SDKCALL) {
                int n2 = b ? 1 : 0;
                if (f.getRetry() != null) {
                    n2 = (b ? 1 : 0);
                    if (f.getRetry().equals(true)) {
                        n2 = (b ? 1 : 0);
                        if (f.getRetrynum() <= f.getMaxretries()) {
                            final int retrynum = f.getRetrynum();
                            final String excluded = f.getExcluded();
                            String s;
                            if (f.getExcluded() != null && f.getExcluded().length() > 0) {
                                s = excluded + "," + f.getBannerid();
                            }
                            else {
                                s = f.getBannerid();
                            }
                            if (adMarvelView.getContext() != null) {
                                Logging.log("Retry : onRequestAd");
                                new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$a(adMarvelView.getContext(), f.getTargetParams(), f.getPartnerId(), f.getSiteId(), f.getAndroidId(), f.getOrientation(), f.getDeviceConnectivity(), adMarvelView, retrynum + 1, s));
                            }
                            n2 = 1;
                        }
                    }
                }
                if (n2 == 0) {
                    adMarvelView.h.a(adMarvelView.getContext(), adMarvelView, n, adMarvelUtils$ErrorReason, f.getSiteId(), f.getId(), f.getTargetParams(), f.getIpAddress());
                }
            }
        }
    }
    
    @Override
    public void onReceiveAd() {
        final AdMarvelView adMarvelView = (AdMarvelView)this.a.get();
        if (adMarvelView == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post((Runnable)new AdMarvelView$d(adMarvelView, adMarvelView.v));
    }
    
    @Override
    public void onReceiveNativeAd(final Object o) {
    }
}
