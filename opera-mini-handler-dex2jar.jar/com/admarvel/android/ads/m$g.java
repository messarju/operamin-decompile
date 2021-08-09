// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.RelativeLayout;
import android.graphics.drawable.Drawable;
import com.admarvel.android.util.AdMarvelBitmapDrawableUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout$LayoutParams;
import android.util.TypedValue;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.widget.LinearLayout;

class m$g extends LinearLayout
{
    private final WeakReference a;
    
    public m$g(final Context context, final m m) {
        super(context);
        this.a = new WeakReference((T)m);
        this.a(context);
    }
    
    private void a(final Context context) {
        this.setBackgroundColor(0);
        final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(r.a(50.0f, context), r.a(50.0f, context));
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.gravity = 17;
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -2);
        linearLayout$LayoutParams.weight = 25.0f;
        linearLayout$LayoutParams.gravity = 17;
        final float applyDimension = TypedValue.applyDimension(1, 36.0f, this.getResources().getDisplayMetrics());
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams((int)applyDimension, (int)applyDimension);
        relativeLayout$LayoutParams.addRule(13);
        this.a(context, relativeLayout$LayoutParams, layoutParams);
    }
    
    private void a(final Context context, final RelativeLayout$LayoutParams layoutParams, final LinearLayout$LayoutParams layoutParams2) {
        final m m = (m)this.a.get();
        if (m == null) {
            return;
        }
        final ImageView imageView = new ImageView(context);
        imageView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final BitmapDrawable bitMapDrawable = AdMarvelBitmapDrawableUtils.getBitMapDrawable("close", context);
        imageView.setTag((Object)"BTN_CLOSE_IMAGE");
        if (!m.h) {
            imageView.setImageDrawable((Drawable)bitMapDrawable);
        }
        else {
            imageView.setBackgroundColor(0);
        }
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        relativeLayout.addView((View)imageView);
        relativeLayout.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                new Handler(Looper.getMainLooper()).post((Runnable)new m$h(m));
            }
        });
        this.addView((View)relativeLayout);
    }
}
