// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Map;
import android.webkit.URLUtil;
import android.content.Intent;
import android.net.Uri;
import android.annotation.SuppressLint;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.shapes.RectShape;
import com.admarvel.android.util.AdMarvelBitmapDrawableUtils;
import android.view.View$OnClickListener;
import android.view.View;
import android.widget.RelativeLayout;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.widget.LinearLayout$LayoutParams;
import android.util.TypedValue;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.widget.LinearLayout;

class o extends LinearLayout
{
    static int a;
    final String b;
    private final WeakReference c;
    
    static {
        o.a = 100001;
    }
    
    @SuppressLint({ "NewApi" })
    o(final Activity activity, final Context context, final String b) {
        super(context);
        this.c = new WeakReference((T)activity);
        this.b = b;
        this.setId(o.a);
        this.setGravity(17);
        this.setOrientation(1);
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-1, (int)TypedValue.applyDimension(1, 5.0f, this.getResources().getDisplayMetrics()));
        final ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(Color.parseColor("#33B5E5"));
        final ClipDrawable progressDrawable = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
        final ProgressBar progressBar = new ProgressBar(context, (AttributeSet)null, 16842872);
        progressBar.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        progressBar.setTag((Object)(this.b + "PROGRESS_BAR"));
        progressBar.setBackgroundColor(0);
        progressBar.setProgressDrawable((Drawable)progressDrawable);
        progressBar.setVisibility(8);
        final float applyDimension = TypedValue.applyDimension(1, 34.0f, this.getResources().getDisplayMetrics());
        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, this.a(36.0f));
        linearLayout$LayoutParams.weight = 25.0f;
        linearLayout$LayoutParams.gravity = 17;
        final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams((int)applyDimension, (int)applyDimension);
        relativeLayout$LayoutParams.addRule(13);
        final o$a o$a = new o$a(this, context);
        o$a.setTag((Object)(this.b + "CLOSE_BUTTON"));
        o$a.setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setTag((Object)(this.b + "CLOSE_BUTTON_LAYOUT"));
        relativeLayout.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        relativeLayout.addView((View)o$a);
        o$a.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                final Activity activity = (Activity)o.this.c.get();
                if (activity != null && activity instanceof AdMarvelActivity) {
                    final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)activity;
                    if (adMarvelActivity.c()) {
                        AdMarvelInterstitialAds.getListener().b();
                    }
                    else {
                        adMarvelActivity.finish();
                    }
                    if (d.d(o.this.b) != null) {
                        d.d(o.this.b).a(o.this.b);
                    }
                }
            }
        });
        o$a.setBackgroundDrawable((Drawable)AdMarvelBitmapDrawableUtils.getBitMapDrawable("done", context));
        final o$a o$a2 = new o$a(this, context);
        o$a2.setTag((Object)(this.b + "BACK_BUTTON"));
        o$a2.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                o.this.b();
            }
        });
        o$a2.setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        o$a2.setEnabled(false);
        o$a2.setBackgroundDrawable((Drawable)AdMarvelBitmapDrawableUtils.getBitMapDrawable("backward", this.getContext()));
        final RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setTag((Object)(this.b + "BACK_BUTTON_LAYOUT"));
        relativeLayout2.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        relativeLayout2.addView((View)o$a2);
        final o$a o$a3 = new o$a(this, context);
        o$a3.setTag((Object)(this.b + "FORWARD_BUTTON"));
        o$a3.setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        o$a3.setEnabled(false);
        final RelativeLayout relativeLayout3 = new RelativeLayout(context);
        o$a3.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                o.this.c();
            }
        });
        o$a3.setBackgroundDrawable((Drawable)AdMarvelBitmapDrawableUtils.getBitMapDrawable("resume", this.getContext()));
        relativeLayout3.setTag((Object)(this.b + "FORWARD_BUTTON_LAYOUT"));
        relativeLayout3.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        relativeLayout3.addView((View)o$a3);
        final o$a o$a4 = new o$a(this, context);
        o$a4.setTag((Object)(this.b + "BROWSER_BUTTON"));
        o$a4.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                o.this.d();
            }
        });
        o$a4.setLayoutParams((ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        o$a4.setBackgroundDrawable((Drawable)AdMarvelBitmapDrawableUtils.getBitMapDrawable("open_url", this.getContext()));
        final RelativeLayout relativeLayout4 = new RelativeLayout(context);
        relativeLayout4.setTag((Object)(this.b + "BROWSER_BUTTON_LAYOUT"));
        relativeLayout4.setLayoutParams((ViewGroup$LayoutParams)linearLayout$LayoutParams);
        relativeLayout4.addView((View)o$a4);
        final float applyDimension2 = TypedValue.applyDimension(1, 40.0f, this.getResources().getDisplayMetrics());
        final ShapeDrawable backgroundDrawable = new ShapeDrawable((Shape)new RectShape());
        backgroundDrawable.getPaint().setColor(Color.parseColor("#FF1D1C1D"));
        final LinearLayout$LayoutParams layoutParams3 = new LinearLayout$LayoutParams(-1, (int)applyDimension2);
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setTag((Object)(this.b + "BUTTON_BAR_LAYOUT"));
        linearLayout.setLayoutParams((ViewGroup$LayoutParams)layoutParams3);
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(100.0f);
        linearLayout.setBackgroundDrawable((Drawable)backgroundDrawable);
        linearLayout.addView((View)relativeLayout);
        linearLayout.addView((View)relativeLayout2);
        linearLayout.addView((View)relativeLayout3);
        linearLayout.addView((View)relativeLayout4);
        this.addView((View)progressBar);
        this.addView((View)linearLayout);
    }
    
    private int a(final float n) {
        return (int)TypedValue.applyDimension(1, n, this.getResources().getDisplayMetrics());
    }
    
    private void b() {
        final d d = (d)((RelativeLayout)this.getParent()).findViewWithTag((Object)(this.b + "WEBVIEW"));
        if (d.canGoBack()) {
            d.goBack();
            this.a();
        }
    }
    
    private void c() {
        final d d = (d)((RelativeLayout)this.getParent()).findViewWithTag((Object)(this.b + "WEBVIEW"));
        if (d.canGoForward()) {
            d.goForward();
            this.a();
        }
    }
    
    private void d() {
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((d)((RelativeLayout)this.getParent()).findViewWithTag((Object)(this.b + "WEBVIEW"))).getUrl()));
        intent.addFlags(268435456);
        final Activity activity = (Activity)this.c.get();
        if (activity != null && activity instanceof AdMarvelActivity) {
            final AdMarvelActivity adMarvelActivity = (AdMarvelActivity)activity;
            if (r.a(this.getContext(), intent)) {
                adMarvelActivity.startActivity(intent);
            }
            if (adMarvelActivity.c()) {
                AdMarvelInterstitialAds.getListener().b();
                adMarvelActivity.b();
            }
            adMarvelActivity.a();
            adMarvelActivity.finish();
        }
    }
    
    void a() {
        final d d = (d)((RelativeLayout)this.getParent()).findViewWithTag((Object)(this.b + "WEBVIEW"));
        final o$a o$a = (o$a)this.findViewWithTag((Object)(this.b + "BACK_BUTTON_LAYOUT")).findViewWithTag((Object)(this.b + "BACK_BUTTON"));
        final o$a o$a2 = (o$a)this.findViewWithTag((Object)(this.b + "FORWARD_BUTTON_LAYOUT")).findViewWithTag((Object)(this.b + "FORWARD_BUTTON"));
        if (d.canGoBack()) {
            o$a.setEnabled(true);
        }
        else {
            o$a.setEnabled(false);
        }
        if (d.canGoForward()) {
            o$a2.setEnabled(true);
        }
        else {
            o$a2.setEnabled(false);
        }
        final Map adMarvelOptionalFlags = AdMarvelUtils.getAdMarvelOptionalFlags();
        final o$a o$a3 = (o$a)this.findViewWithTag((Object)(this.b + "BROWSER_BUTTON_LAYOUT")).findViewWithTag((Object)(this.b + "BROWSER_BUTTON"));
        final String url = d.getUrl();
        if (url != null && URLUtil.isNetworkUrl(url)) {
            o$a3.setEnabled(true);
        }
        else {
            o$a3.setEnabled(false);
        }
        if (adMarvelOptionalFlags != null && adMarvelOptionalFlags.containsKey("AP_TOOL_DISABLE_EXTERNAL_BROWSER_ICON") && ((String)adMarvelOptionalFlags.get("AP_TOOL_DISABLE_EXTERNAL_BROWSER_ICON")).equals("true")) {
            o$a3.setEnabled(false);
            o$a3.setVisibility(8);
        }
    }
    
    public void setVisibility(final int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0) {
            this.a();
        }
    }
}
