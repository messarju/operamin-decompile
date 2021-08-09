// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.graphics.drawable.Drawable;
import com.admarvel.android.util.AdMarvelBitmapDrawableUtils;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.util.TypedValue;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.widget.LinearLayout;

class d$i extends LinearLayout
{
    private final d$a a;
    private final WeakReference b;
    private final WeakReference c;
    
    public d$i(final Context context, final d d, final d$a a, final Activity activity) {
        super(context);
        this.a = a;
        this.b = new WeakReference((T)d);
        this.c = new WeakReference((T)activity);
        this.a(context);
    }
    
    private void a(final Context context) {
        this.setBackgroundColor(0);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.gravity = 5;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -2);
        linearLayout$LayoutParams.weight = 25.0f;
        linearLayout$LayoutParams.gravity = 5;
        final float applyDimension = TypedValue.applyDimension(1, 36.0f, this.getResources().getDisplayMetrics());
        final LinearLayout$LayoutParams linearLayout$LayoutParams2 = new LinearLayout$LayoutParams((int)applyDimension, (int)applyDimension);
        linearLayout$LayoutParams2.gravity = 17;
        this.a(context, linearLayout$LayoutParams2, linearLayout$LayoutParams);
    }
    
    private void a(final Context context, final LinearLayout$LayoutParams layoutParams, final LinearLayout$LayoutParams layoutParams2) {
        final d d = (d)this.b.get();
        if (d != null && !d.M) {
            final ImageView imageView = new ImageView(context);
            final RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            final LinearLayout linearLayout = new LinearLayout(context);
            final RelativeLayout$LayoutParams layoutParams3 = new RelativeLayout$LayoutParams(r.a(50.0f, context), r.a(50.0f, context));
            layoutParams3.addRule(11);
            linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
            if (this.a != null) {
                linearLayout.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        d$i.this.a.a();
                    }
                });
            }
            else {
                linearLayout.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        final Activity activity = (Activity)d$i.this.c.get();
                        if (activity != null && activity instanceof AdMarvelActivity) {
                            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)activity;
                            if (adMarvelActivity.e()) {
                                if (com.admarvel.android.ads.d.c(d.s) != null) {
                                    com.admarvel.android.ads.d.c(d.s).a();
                                }
                                activity.finish();
                            }
                            else {
                                final boolean b = AdMarvelInterstitialAds.getListener().b();
                                adMarvelActivity.b();
                                if (adMarvelActivity.r != null && adMarvelActivity.r.length() > 0) {
                                    d.loadUrl("javascript:" + adMarvelActivity.r + "()");
                                }
                                if (!b) {
                                    activity.finish();
                                }
                                if (adMarvelActivity.a() > 2) {
                                    adMarvelActivity.finish();
                                }
                            }
                        }
                    }
                });
            }
            layoutParams.weight = 1.0f;
            imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            imageView.setDuplicateParentStateEnabled(true);
            imageView.setClickable(false);
            imageView.setImageDrawable((Drawable)AdMarvelBitmapDrawableUtils.getBitMapDrawable("close", context));
            imageView.setTag((Object)(d.s + "BTN_CLOSE_IMAGE"));
            linearLayout.addView((View)imageView);
            relativeLayout.addView((View)linearLayout);
            this.addView((View)relativeLayout);
        }
    }
}
