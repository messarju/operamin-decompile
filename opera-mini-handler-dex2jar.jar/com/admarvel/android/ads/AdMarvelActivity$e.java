// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.util.TypedValue;
import android.view.View;
import android.util.AttributeSet;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class AdMarvelActivity$e extends RelativeLayout
{
    TextView a;
    ProgressBar b;
    final /* synthetic */ AdMarvelActivity c;
    private final Context d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    
    public AdMarvelActivity$e(final AdMarvelActivity c, final Context d) {
        this.c = c;
        super(d);
        this.e = false;
        this.f = true;
        this.g = true;
        this.h = 0;
        this.d = d;
        final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.setBackgroundColor(this.getResources().getColor(17170445));
        new RelativeLayout$LayoutParams(-1, this.a(100.0f));
        this.a = new TextView(d);
        final RelativeLayout$LayoutParams layoutParams2 = new RelativeLayout$LayoutParams(-2, -2);
        this.a.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
        RelativeLayout$LayoutParams relativeLayout$LayoutParams;
        if (Version.getAndroidSDKVersion() < 9) {
            this.b = new ProgressBar(this.d, (AttributeSet)null, 16842872);
            relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(-2, -2);
        }
        else {
            this.b = new ProgressBar(this.d, (AttributeSet)null, 16843401);
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
        this.a.setText((CharSequence)("Loading..." + this.h + "% "));
        if (c.A) {
            this.f = false;
            c.c = true;
            c.g.postDelayed(c.e, 5000L);
        }
    }
    
    private int a(final float n) {
        return (int)TypedValue.applyDimension(1, n, this.getResources().getDisplayMetrics());
    }
    
    private void c() {
        final AdMarvelActivity c = this.c;
        c.c = false;
        final RelativeLayout relativeLayout = (RelativeLayout)c.findViewById(AdMarvelActivity.b);
        if (relativeLayout != null) {
            final o o = (o)relativeLayout.findViewWithTag((Object)(c.h + "CONTROLS"));
            final d d = (d)relativeLayout.findViewWithTag((Object)(c.h + "WEBVIEW"));
            if (!this.e) {
                if (o == null || d == null) {
                    return;
                }
                d.clearHistory();
                d.setVisibility(0);
                o.setVisibility(0);
            }
            else {
                if (d != null) {
                    d.stopLoading();
                    d.e();
                    d.setVisibility(8);
                }
                if (o != null) {
                    o.setVisibility(8);
                }
            }
            relativeLayout.requestLayout();
        }
    }
    
    public void a() {
        this.e = true;
    }
    
    public void b() {
        this.setShowing(false);
        this.b.setVisibility(8);
        this.setVisibility(8);
    }
    
    public int getProgress() {
        return this.h;
    }
    
    public void setCancelable(final boolean f) {
        this.f = f;
    }
    
    public void setProgress(final int n) {
        this.h = n;
        this.b.setProgress(n);
        if (n >= 100) {
            this.b();
        }
        this.a.setText((CharSequence)("Loading..." + n + "% "));
        this.a.invalidate();
    }
    
    public void setShowing(final boolean g) {
        this.g = g;
    }
}
