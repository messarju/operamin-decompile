// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.util.TypedValue;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.RelativeLayout;
import android.view.ViewGroup;
import android.os.Handler;
import android.os.Looper;
import android.content.Context;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.view.OrientationEventListener;

class m$u extends OrientationEventListener
{
    private final WeakReference a;
    private final WeakReference b;
    private int c;
    
    public m$u(final m m, final Activity activity, final int n) {
        super((Context)activity, n);
        this.c = -1;
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)activity);
    }
    
    public void onOrientationChanged(final int c) {
        if (this.c == -1) {
            this.c = c;
        }
        else if (Math.abs(c - this.c) >= 90 && Math.abs(c - this.c) <= 270) {
            final m m = (m)this.a.get();
            if (m != null) {
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        final Activity activity = (Activity)m$u.this.b.get();
                        Label_0216: {
                            if (activity != null && m.x) {
                                final ViewGroup viewGroup = (ViewGroup)activity.getWindow().findViewById(16908290);
                                final RelativeLayout relativeLayout = (RelativeLayout)viewGroup.findViewWithTag((Object)(m.s + "EXPAND_LAYOUT"));
                                if (relativeLayout != null) {
                                    final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)relativeLayout.getLayoutParams();
                                    final LinearLayout linearLayout = (LinearLayout)viewGroup.findViewWithTag((Object)(m.s + "BTN_CLOSE"));
                                    if (linearLayout != null) {
                                        b(linearLayout, (RelativeLayout$LayoutParams)linearLayout.getLayoutParams(), m.j, frameLayout$LayoutParams.leftMargin, frameLayout$LayoutParams.topMargin, frameLayout$LayoutParams.width, frameLayout$LayoutParams.height, viewGroup.getWidth(), viewGroup.getHeight(), (int)TypedValue.applyDimension(1, 30.0f, m.getContext().getResources().getDisplayMetrics()));
                                        break Label_0216;
                                    }
                                }
                                return;
                            }
                        }
                        m$u.this.c = c;
                    }
                }, 500L);
            }
        }
    }
}
