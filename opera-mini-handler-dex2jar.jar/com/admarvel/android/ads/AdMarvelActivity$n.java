// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.net.Uri;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

class AdMarvelActivity$n implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    private String c;
    
    public AdMarvelActivity$n(final String c, final AdMarvelActivity adMarvelActivity, final d d) {
        this.c = c;
        this.a = new WeakReference((T)adMarvelActivity);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        Label_0387: {
            AdMarvelActivity adMarvelActivity;
            d d;
            RelativeLayout relativeLayout;
            j i;
            int n;
            try {
                adMarvelActivity = (AdMarvelActivity)this.a.get();
                d = (d)this.b.get();
                if (adMarvelActivity == null || d == null || this.c == null) {
                    return;
                }
                if (this.c.length() <= 0) {
                    return;
                }
                adMarvelActivity.i = true;
                relativeLayout = (RelativeLayout)adMarvelActivity.findViewById(AdMarvelActivity.b);
                final j j = (j)relativeLayout.findViewWithTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
                if (j == null) {
                    i = new j((Context)adMarvelActivity);
                    i.setTag((Object)(adMarvelActivity.h + "BR_VIDEO"));
                    if (!adMarvelActivity.j) {
                        break Label_0387;
                    }
                    final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    i.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    for (final int childCount = relativeLayout.getChildCount(), n = 0; n < childCount && relativeLayout.getChildAt(n) != d; ++n) {}
                }
                else {
                    if (this.c != null) {
                        j.a(Uri.parse(this.c));
                    }
                    return;
                }
            }
            catch (Exception ex) {
                Logging.log(Log.getStackTraceString((Throwable)ex));
                return;
            }
            relativeLayout.addView((View)i, n);
            relativeLayout.removeView((View)d);
            d.setBackgroundColor(0);
            d.setBackgroundDrawable((Drawable)null);
            while (true) {
                if (Version.getAndroidSDKVersion() < 11) {
                    break Label_0313;
                }
                try {
                    View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(d, 1, null);
                    relativeLayout.addView((View)d);
                    while (true) {
                        i.a(Uri.parse(this.c));
                        i.setVisibility(0);
                        i.a((MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
                            public void onPrepared(final MediaPlayer mediaPlayer) {
                                if (adMarvelActivity.j) {
                                    if (adMarvelActivity.k != null && adMarvelActivity.k.length() > 0) {
                                        d.loadUrl("javascript:" + adMarvelActivity.k + "()");
                                    }
                                    if (adMarvelActivity.m != null && adMarvelActivity.m.length() > 0) {
                                        d.loadUrl("javascript:" + adMarvelActivity.m + "()");
                                    }
                                    return;
                                }
                                d.loadUrl("javascript:AdApp.videoView().setDuration(" + mediaPlayer.getDuration() / 1000 + ")");
                                d.loadUrl("javascript:AdApp.videoView().setCanPlay(true)");
                                d.loadUrl("javascript:AdApp.adView().play()");
                            }
                        });
                        i.a((MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
                            public void onCompletion(final MediaPlayer mediaPlayer) {
                                if (adMarvelActivity.j) {
                                    if (adMarvelActivity.o != null && adMarvelActivity.o.length() > 0) {
                                        d.loadUrl("javascript:" + adMarvelActivity.o + "()");
                                    }
                                }
                                else {
                                    d.loadUrl("javascript:AdApp.videoView().end();");
                                }
                                adMarvelActivity.g.post((Runnable)new AdMarvelActivity$d(adMarvelActivity));
                            }
                        });
                        i.a((MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
                            public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                                adMarvelActivity.g.post((Runnable)new AdMarvelActivity$d(adMarvelActivity));
                                if (adMarvelActivity.j && adMarvelActivity.q != null && adMarvelActivity.q.length() > 0) {
                                    d.loadUrl("javascript:" + adMarvelActivity.q + "()");
                                }
                                return false;
                            }
                        });
                        return;
                        i.setLayoutParams((ViewGroup$LayoutParams)new RelativeLayout$LayoutParams(1, 1));
                        relativeLayout.addView((View)i);
                        continue;
                    }
                }
                catch (Exception ex2) {
                    continue;
                }
                break;
            }
        }
    }
}
