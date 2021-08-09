// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.View;
import android.util.TypedValue;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.view.ViewGroup;
import android.app.Activity;
import java.lang.ref.WeakReference;

class m$j implements Runnable
{
    private int a;
    private int b;
    private int c;
    private int d;
    private final WeakReference e;
    private final WeakReference f;
    
    public m$j(final m m, final Activity activity, final int a, final int b) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = new WeakReference((T)m);
        this.f = new WeakReference((T)activity);
        this.a = a;
        this.b = b;
    }
    
    public m$j(final m m, final Activity activity, final int c, final int d, final int a, final int b) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = new WeakReference((T)m);
        this.f = new WeakReference((T)activity);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void run() {
        final m m = (m)this.e.get();
        if (m != null) {
            final Activity activity = (Activity)this.f.get();
            if (activity != null) {
                final ViewGroup viewGroup = (ViewGroup)activity.getWindow().findViewById(16908290);
                final d d = (d)viewGroup.findViewWithTag((Object)(m.s + "INTERNAL"));
                if (d != null && !d.b() && m.x) {
                    final RelativeLayout relativeLayout = (RelativeLayout)viewGroup.findViewWithTag((Object)(m.s + "EXPAND_LAYOUT"));
                    if (relativeLayout != null) {
                        final FrameLayout frameLayout = (FrameLayout)viewGroup.findViewWithTag((Object)(m.s + "EXPAND_BG"));
                        if (frameLayout != null) {
                            frameLayout.setFocusableInTouchMode(true);
                            frameLayout.requestFocus();
                            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)relativeLayout.getLayoutParams();
                            if (frameLayout$LayoutParams != null) {
                                frameLayout$LayoutParams.width = this.a;
                                frameLayout$LayoutParams.height = this.b;
                                frameLayout$LayoutParams.leftMargin = this.c;
                                frameLayout$LayoutParams.topMargin = this.d;
                                if (this.c != 0) {
                                    frameLayout$LayoutParams.gravity = 0;
                                }
                            }
                            d.a(this.c, this.d, this.a, this.b);
                            if (m.f) {
                                final LinearLayout linearLayout = (LinearLayout)viewGroup.findViewWithTag((Object)(m.s + "BTN_CLOSE"));
                                if (linearLayout == null) {
                                    return;
                                }
                                b(linearLayout, new RelativeLayout$LayoutParams(-2, -2), m.j, this.c, this.d, this.a, this.b, viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight(), (int)TypedValue.applyDimension(1, 30.0f, m.getContext().getResources().getDisplayMetrics()));
                                linearLayout.removeAllViews();
                                linearLayout.addView((View)new m$g(m.getContext(), m));
                            }
                            m.ag = true;
                            viewGroup.invalidate();
                            viewGroup.requestLayout();
                            m.a.set(true);
                            m.invalidate();
                            m.requestLayout();
                            if (com.admarvel.android.ads.m.a(m.s) != null) {
                                com.admarvel.android.ads.m.a(m.s).a();
                            }
                            m.invalidate();
                            m.requestLayout();
                        }
                    }
                }
            }
        }
    }
}
