// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.LinearLayout;
import android.util.TypedValue;
import android.view.View;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class AdMarvelVideoActivity$b extends RelativeLayout
{
    TextView a;
    ProgressBar b;
    private final Context c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private final WeakReference h;
    
    public AdMarvelVideoActivity$b(final Context c, final AdMarvelVideoActivity adMarvelVideoActivity) {
        super(c);
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = 0;
        this.h = new WeakReference((T)adMarvelVideoActivity);
        this.c = c;
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.setBackgroundColor(this.getResources().getColor(17170445));
        new RelativeLayout$LayoutParams(-1, this.a(100.0f));
        this.a = new TextView(c);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
        this.a.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        RelativeLayout$LayoutParams relativeLayout$LayoutParams;
        if (Version.getAndroidSDKVersion() < 9) {
            this.b = new ProgressBar(this.c, (AttributeSet)null, 16842872);
            relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, -2);
        }
        else {
            this.b = new ProgressBar(this.c, (AttributeSet)null, 16843401);
            relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(this.a(50.0f), this.a(50.0f));
        }
        this.b.setId(189523436);
        this.b.setVisibility(0);
        relativeLayout$LayoutParams.addRule(13);
        this.addView((View)this.b, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
        layoutParams2.addRule(3, this.b.getId());
        layoutParams2.addRule(14);
        layoutParams2.addRule(13);
        this.addView((View)this.a);
    }
    
    private int a(final float n) {
        return (int)TypedValue.applyDimension(1, n, this.getResources().getDisplayMetrics());
    }
    
    private void e() {
        final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)this.h.get();
        if (adMarvelVideoActivity != null) {
            final LinearLayout linearLayout = (LinearLayout)adMarvelVideoActivity.findViewById(AdMarvelVideoActivity.c);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            if (adMarvelVideoActivity.findViewById(AdMarvelVideoActivity.b) != null && adMarvelVideoActivity.t && adMarvelVideoActivity.s) {
                adMarvelVideoActivity.b(true);
            }
        }
    }
    
    public boolean a() {
        return this.f;
    }
    
    public void b() {
        this.setShowing(true);
        this.b.setVisibility(0);
        this.setVisibility(0);
    }
    
    public void c() {
        this.d = true;
    }
    
    public void d() {
        this.setShowing(false);
        this.b.setVisibility(8);
        this.setVisibility(8);
    }
    
    public int getProgress() {
        return this.g;
    }
    
    public void setCancelable(final boolean e) {
        this.e = e;
    }
    
    public void setMessage(final String text) {
        this.a.setText((CharSequence)text);
    }
    
    public void setProgress(final int n) {
        this.g = n;
        this.b.setProgress(n);
        if (n >= 100) {
            this.d();
        }
        this.a.setText((CharSequence)("Loading..." + n + "% "));
        this.a.invalidate();
    }
    
    public void setShowing(final boolean f) {
        this.f = f;
    }
}
