// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.TargetApi;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.os.Handler;
import android.os.Looper;
import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import java.lang.ref.WeakReference;

class m$q implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private String c;
    
    public m$q(final String c, final m m, final d d) {
        this.c = c;
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @TargetApi(14)
    @Override
    public void run() {
        while (true) {
            while (true) {
                Label_0309: {
                    try {
                        final m m = (m)this.a.get();
                        final d d = (d)this.b.get();
                        if (m == null || d == null || this.c == null) {
                            break;
                        }
                        if (this.c.length() <= 0) {
                            return;
                        }
                        a a = (a)m.findViewWithTag((Object)(m.s + "EMBEDDED_VIDEO"));
                        if (a == null) {
                            a = new a(m.getContext(), false, this.c);
                            a.setTag((Object)(m.s + "EMBEDDED_VIDEO"));
                            a.a(m.A, m.B, m.C, m.D);
                            final float density = m.getContext().getResources().getDisplayMetrics().density;
                            if (m.E > 0) {
                                final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)m.getLayoutParams();
                                layoutParams.height = (int)(density * m.E);
                                m.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                            }
                            m.removeAllViews();
                            m.addView((View)a);
                            m.addView((View)d);
                            d.setBackgroundColor(0);
                            d.setBackgroundDrawable((Drawable)null);
                            d.setLayerType(1, (Paint)null);
                            a.a(this.c, 0);
                            a.a(new a$a() {});
                            a.a((MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
                                public void onPrepared(final MediaPlayer mediaPlayer) {
                                    if (m.P) {
                                        mediaPlayer.setVolume(0.0f, 0.0f);
                                        m.P = false;
                                    }
                                    if (m.F != null && m.F.length() > 0) {
                                        d.e(m.F + "()");
                                    }
                                    if (m.H != null && m.H.length() > 0) {
                                        d.e(m.H + "()");
                                    }
                                    if (m.O == null) {
                                        m.O = new m$ac(m, d);
                                        new Handler(Looper.getMainLooper()).postDelayed((Runnable)m.O, 500L);
                                    }
                                }
                            });
                            a.a((MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
                                public void onCompletion(final MediaPlayer mediaPlayer) {
                                    if (m.J != null && m.J.length() > 0) {
                                        d.e(m.J + "()");
                                    }
                                }
                            });
                            a.a((MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
                                public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                                    if (m.N != null && m.N.length() > 0) {
                                        d.e(m.N + "()");
                                    }
                                    return false;
                                }
                            });
                            return;
                        }
                        break Label_0309;
                    }
                    catch (Exception ex) {
                        Logging.log(Log.getStackTraceString((Throwable)ex));
                        return;
                    }
                }
                continue;
            }
        }
    }
}
