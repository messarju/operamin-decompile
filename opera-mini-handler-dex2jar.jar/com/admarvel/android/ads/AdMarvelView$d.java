// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import android.content.Context;
import com.admarvel.android.util.Logging;
import android.util.Log;
import com.admarvel.android.util.a.b;
import android.os.Handler;
import java.lang.ref.WeakReference;

class AdMarvelView$d implements Runnable
{
    private final AdMarvelAd a;
    private final WeakReference b;
    
    public AdMarvelView$d(final AdMarvelView adMarvelView, final AdMarvelAd a) {
        this.a = a;
        this.b = new WeakReference((T)adMarvelView);
    }
    
    @Override
    public void run() {
        AdMarvelView adMarvelView = null;
        Context context = null;
        View viewWithTag = null;
        View viewWithTag2;
        r r = null;
        Label_0190_Outer:Label_0222_Outer:
        while (true) {
        Label_0366:
            while (true) {
                Label_0354: {
                    while (true) {
                    Label_0314:
                        while (true) {
                            try {
                                adMarvelView = (AdMarvelView)this.b.get();
                                if (adMarvelView == null) {
                                    return;
                                }
                                context = adMarvelView.getContext();
                                if (context == null) {
                                    break;
                                }
                                viewWithTag = adMarvelView.findViewWithTag((Object)"PENDING");
                                if (viewWithTag == null) {
                                    break;
                                }
                                if (AdMarvelUtils.isLogDumpEnabled() && this.a != null) {
                                    this.a.setResponseJson();
                                }
                                viewWithTag2 = adMarvelView.findViewWithTag((Object)"CURRENT");
                                if (viewWithTag2 != null && !adMarvelView.j && viewWithTag2.isShown()) {
                                    break Label_0354;
                                }
                                if (this.a != null && this.a.isMustBeVisible() && this.a.getSdkAdNetwork() == AdMarvelUtils$SDKAdNetwork.PULSE3D) {
                                    viewWithTag.setTag((Object)"CURRENT");
                                    adMarvelView.a(viewWithTag2);
                                    if (!adMarvelView.i) {
                                        adMarvelView.b(viewWithTag2);
                                    }
                                    if (this.a != null) {
                                        if (!adMarvelView.b()) {
                                            break Label_0314;
                                        }
                                        adMarvelView.h.b(context, adMarvelView, this.a.getSiteId(), this.a.getId(), this.a.getTargetParams(), this.a.getIpAddress());
                                    }
                                    if (AdMarvelUtils.isLogDumpEnabled()) {
                                        new Handler().postDelayed((Runnable)new AdMarvelView$e(this.a, context), 1000L);
                                    }
                                    r = new r(context);
                                    if (AdMarvelView.a && !adMarvelView.t) {
                                        new b().a(this.a, context, new Handler());
                                        return;
                                    }
                                    break Label_0366;
                                }
                            }
                            catch (Exception ex) {
                                Logging.log(Log.getStackTraceString((Throwable)ex));
                                return;
                            }
                            adMarvelView.a(viewWithTag2);
                            adMarvelView.e();
                            viewWithTag.setTag((Object)"CURRENT");
                            viewWithTag.setVisibility(0);
                            adMarvelView.setHorizontalGravity(1);
                            adMarvelView.removeAllViews();
                            adMarvelView.addView(viewWithTag);
                            continue Label_0190_Outer;
                        }
                        adMarvelView.h.a(context, adMarvelView, this.a.getSiteId(), this.a.getId(), this.a.getTargetParams(), this.a.getIpAddress());
                        continue Label_0222_Outer;
                    }
                }
                adMarvelView.a(viewWithTag, this.a);
                continue;
            }
            if (!AdMarvelView.a) {
                r.a(this.a);
                break;
            }
            break;
        }
    }
}
