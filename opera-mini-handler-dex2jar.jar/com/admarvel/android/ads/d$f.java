// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

class d$f implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private boolean c;
    
    public d$f(final d d, final Context context, final Boolean b) {
        this.c = true;
        this.a = new WeakReference((T)context);
        this.b = new WeakReference((T)d);
        this.c = b;
    }
    
    @Override
    public void run() {
        final d d = (d)this.b.get();
        if (d != null && !d.M) {
            final Activity activity = (Activity)this.a.get();
            if (activity != null) {
                final ViewGroup viewGroup = (ViewGroup)activity.getWindow().findViewById(16908290);
                if (this.c) {
                    if (!d.E) {
                        final LinearLayout linearLayout = (LinearLayout)viewGroup.findViewWithTag((Object)(d.s + "BTN_CLOSE"));
                        if (linearLayout != null && d.D) {
                            linearLayout.setVisibility(8);
                        }
                    }
                    else {
                        final ImageView imageView = (ImageView)viewGroup.findViewWithTag((Object)(d.s + "BTN_CLOSE_IMAGE"));
                        if (imageView != null) {
                            imageView.setVisibility(4);
                        }
                    }
                }
                else {
                    final LinearLayout linearLayout2 = (LinearLayout)viewGroup.findViewWithTag((Object)(d.s + "BTN_CLOSE"));
                    if (linearLayout2 != null) {
                        if (linearLayout2.getVisibility() != 0) {
                            linearLayout2.setVisibility(0);
                        }
                        final ImageView imageView2 = (ImageView)viewGroup.findViewWithTag((Object)(d.s + "BTN_CLOSE_IMAGE"));
                        if (imageView2 != null && imageView2.getVisibility() != 0) {
                            imageView2.setVisibility(0);
                        }
                    }
                }
            }
        }
    }
}
