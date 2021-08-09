// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.content.Context;
import android.os.Handler;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.widget.FrameLayout$LayoutParams;
import android.view.KeyEvent;
import android.view.View$OnKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.app.Activity;
import java.lang.ref.WeakReference;

class m$k implements Runnable
{
    private int a;
    private int b;
    private int c;
    private int d;
    private final WeakReference e;
    private final WeakReference f;
    private final AdMarvelAd g;
    
    public m$k(final m m, final Activity activity, final int c, final int d, final int a, final int b, final AdMarvelAd g) {
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
        this.g = g;
    }
    
    public m$k(final m m, final Activity activity, final int a, final int b, final AdMarvelAd g) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = new WeakReference((T)m);
        this.f = new WeakReference((T)activity);
        this.a = a;
        this.b = b;
        this.g = g;
    }
    
    @Override
    public void run() {
        m m;
        Activity activity;
        ViewGroup viewGroup;
        d d;
        FrameLayout frameLayout;
        FrameLayout$LayoutParams frameLayout$LayoutParams;
        RelativeLayout relativeLayout;
        FrameLayout$LayoutParams frameLayout$LayoutParams2;
        int n;
        try {
            m = (m)this.e.get();
            if (m == null) {
                return;
            }
            activity = (Activity)this.f.get();
            if (activity == null) {
                return;
            }
            viewGroup = (ViewGroup)activity.getWindow().findViewById(16908290);
            d = (d)m.findViewWithTag((Object)(m.s + "INTERNAL"));
            if (d == null || d.b()) {
                return;
            }
            d.f = true;
            frameLayout = new FrameLayout(m.getContext());
            frameLayout.setTag((Object)(m.s + "EXPAND_BG"));
            frameLayout.setOnTouchListener((View$OnTouchListener)new View$OnTouchListener() {
                public boolean onTouch(final View view, final MotionEvent motionEvent) {
                    return true;
                }
            });
            frameLayout.setFocusableInTouchMode(true);
            frameLayout.requestFocus();
            frameLayout.setOnKeyListener((View$OnKeyListener)new View$OnKeyListener() {
                public boolean onKey(final View view, final int n, final KeyEvent keyEvent) {
                    if (keyEvent.getAction() == 0 && n == 4) {
                        m.e();
                        return true;
                    }
                    return false;
                }
            });
            frameLayout$LayoutParams = new FrameLayout$LayoutParams(-1, -1);
            relativeLayout = new RelativeLayout(m.getContext());
            relativeLayout.setTag((Object)(m.s + "EXPAND_LAYOUT"));
            frameLayout$LayoutParams2 = new FrameLayout$LayoutParams(this.a, this.b);
            if (this.c == 0) {
                frameLayout$LayoutParams2.gravity = 1;
            }
            else if (Version.getAndroidSDKVersion() < 11) {
                frameLayout$LayoutParams2.gravity = 48;
            }
            relativeLayout.setGravity(1);
            frameLayout$LayoutParams2.leftMargin = this.c;
            frameLayout$LayoutParams2.topMargin = this.d;
            for (final int childCount = m.getChildCount(), n = 0; n < childCount && m.getChildAt(n) != d; ++n) {}
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        final FrameLayout frameLayout2 = new FrameLayout(m.getContext());
        frameLayout2.setTag((Object)(m.s + "EXPAND_PLACE_HOLDER"));
        m.addView((View)frameLayout2, n, (ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(d.getWidth(), d.getHeight()));
        m.removeView((View)d);
        if (d != null) {
            d.a(this.c, this.d, this.a, this.b);
        }
        relativeLayout.addView((View)d);
        m.x = true;
        frameLayout.addView((View)relativeLayout, (ViewGroup$LayoutParams)frameLayout$LayoutParams2);
        viewGroup.addView((View)frameLayout, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
        relativeLayout.bringToFront();
        if (m.g && !m.ag) {
            final LinearLayout linearLayout = new LinearLayout(m.getContext());
            linearLayout.setBackgroundColor(0);
            linearLayout.setTag((Object)(m.s + "BTN_CLOSE"));
            b(linearLayout, new RelativeLayout$LayoutParams(r.a(50.0f, m.getContext()), r.a(50.0f, m.getContext())), m.j, this.c, this.d, this.a, this.b, viewGroup.getMeasuredWidth(), viewGroup.getMeasuredHeight(), (int)TypedValue.applyDimension(1, 30.0f, m.getContext().getResources().getDisplayMetrics()));
            linearLayout.addView((View)new m$g(m.getContext(), m));
            relativeLayout.addView((View)linearLayout);
            m.f = true;
            m.k = new m$u(m, activity, 3);
            if (m.k.canDetectOrientation()) {
                m.k.enable();
            }
        }
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
        d.f = false;
        if (AdMarvelUtils.isLogDumpEnabled()) {
            new Handler().postDelayed((Runnable)new m$i(this.g, (Context)activity), 1000L);
        }
    }
}
