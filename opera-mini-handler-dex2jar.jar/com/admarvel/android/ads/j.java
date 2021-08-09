// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.view.MotionEvent;
import com.admarvel.android.util.Logging;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.net.Uri;
import android.view.SurfaceHolder$Callback;
import android.media.MediaPlayer$OnPreparedListener;
import android.media.MediaPlayer$OnVideoSizeChangedListener;
import android.media.MediaPlayer$OnBufferingUpdateListener;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnSeekCompleteListener;
import android.media.MediaPlayer$OnCompletionListener;
import android.widget.MediaController$MediaPlayerControl;
import android.view.SurfaceView;

class j extends SurfaceView implements MediaController$MediaPlayerControl
{
    private MediaPlayer$OnCompletionListener A;
    private MediaPlayer$OnSeekCompleteListener B;
    private MediaPlayer$OnErrorListener C;
    private MediaPlayer$OnBufferingUpdateListener D;
    MediaPlayer$OnVideoSizeChangedListener a;
    MediaPlayer$OnPreparedListener b;
    SurfaceHolder$Callback c;
    private int d;
    private Uri e;
    private int f;
    private int g;
    private int h;
    private SurfaceHolder i;
    private MediaPlayer j;
    private int k;
    private int l;
    private int m;
    private int n;
    private MediaPlayer$OnCompletionListener o;
    private MediaPlayer$OnPreparedListener p;
    private int q;
    private MediaPlayer$OnErrorListener r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Context w;
    private j$a x;
    private int y;
    private final WeakReference z;
    
    public j(final Context w) {
        super(w);
        this.d = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.y = 0;
        this.a = (MediaPlayer$OnVideoSizeChangedListener)new MediaPlayer$OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int n, final int n2) {
                com.admarvel.android.ads.j.this.k = mediaPlayer.getVideoWidth();
                com.admarvel.android.ads.j.this.l = mediaPlayer.getVideoHeight();
                if (com.admarvel.android.ads.j.this.k != 0 && com.admarvel.android.ads.j.this.l != 0) {
                    com.admarvel.android.ads.j.this.getHolder().setFixedSize(com.admarvel.android.ads.j.this.k, com.admarvel.android.ads.j.this.l);
                }
            }
        };
        this.b = (MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
            public void onPrepared(final MediaPlayer mediaPlayer) {
                com.admarvel.android.ads.j.this.g = 2;
                com.admarvel.android.ads.j.this.t = (com.admarvel.android.ads.j.this.u = (com.admarvel.android.ads.j.this.v = true));
                if (com.admarvel.android.ads.j.this.p != null) {
                    com.admarvel.android.ads.j.this.p.onPrepared(com.admarvel.android.ads.j.this.j);
                }
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
                com.admarvel.android.ads.j.this.k = mediaPlayer.getVideoWidth();
                com.admarvel.android.ads.j.this.l = mediaPlayer.getVideoHeight();
                final int f = com.admarvel.android.ads.j.this.s;
                if (f != 0) {
                    com.admarvel.android.ads.j.this.seekTo(f);
                }
                if (com.admarvel.android.ads.j.this.k != 0 && com.admarvel.android.ads.j.this.l != 0) {
                    com.admarvel.android.ads.j.this.getHolder().setFixedSize(com.admarvel.android.ads.j.this.k, com.admarvel.android.ads.j.this.l);
                    if (com.admarvel.android.ads.j.this.m == com.admarvel.android.ads.j.this.k && com.admarvel.android.ads.j.this.n == com.admarvel.android.ads.j.this.l) {
                        if (com.admarvel.android.ads.j.this.h == 3) {
                            com.admarvel.android.ads.j.this.start();
                        }
                        else if (!com.admarvel.android.ads.j.this.isPlaying() && f == 0 && com.admarvel.android.ads.j.this.getCurrentPosition() > 0) {
                            return;
                        }
                    }
                }
                else if (com.admarvel.android.ads.j.this.h == 3) {
                    com.admarvel.android.ads.j.this.start();
                }
            }
        };
        this.A = (MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public void onCompletion(final MediaPlayer mediaPlayer) {
                com.admarvel.android.ads.j.this.g = 5;
                com.admarvel.android.ads.j.this.h = 5;
                if (com.admarvel.android.ads.j.this.o != null) {
                    com.admarvel.android.ads.j.this.o.onCompletion(com.admarvel.android.ads.j.this.j);
                }
            }
        };
        this.B = (MediaPlayer$OnSeekCompleteListener)new MediaPlayer$OnSeekCompleteListener() {
            public void onSeekComplete(final MediaPlayer mediaPlayer) {
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
            }
        };
        this.C = (MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
            public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                com.admarvel.android.ads.j.this.g = -1;
                com.admarvel.android.ads.j.this.h = -1;
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
                if (com.admarvel.android.ads.j.this.r == null || com.admarvel.android.ads.j.this.r.onError(com.admarvel.android.ads.j.this.j, n, n2)) {}
                return true;
            }
        };
        this.D = (MediaPlayer$OnBufferingUpdateListener)new MediaPlayer$OnBufferingUpdateListener() {
            public void onBufferingUpdate(final MediaPlayer mediaPlayer, final int n) {
                com.admarvel.android.ads.j.this.q = n;
            }
        };
        this.c = (SurfaceHolder$Callback)new SurfaceHolder$Callback() {
            public void surfaceChanged(final SurfaceHolder surfaceHolder, int n, int n2, final int n3) {
                final int n4 = 1;
                com.admarvel.android.ads.j.this.m = n2;
                com.admarvel.android.ads.j.this.n = n3;
                if (com.admarvel.android.ads.j.this.h == 3) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (com.admarvel.android.ads.j.this.k == n2 && com.admarvel.android.ads.j.this.l == n3) {
                    n2 = n4;
                }
                else {
                    n2 = 0;
                }
                if (com.admarvel.android.ads.j.this.j != null && n != 0 && n2 != 0) {
                    if (com.admarvel.android.ads.j.this.s != 0) {
                        com.admarvel.android.ads.j.this.seekTo(com.admarvel.android.ads.j.this.s);
                    }
                    com.admarvel.android.ads.j.this.start();
                }
            }
            
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
                com.admarvel.android.ads.j.this.i = surfaceHolder;
                if (com.admarvel.android.ads.j.this.z != null) {
                    final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)com.admarvel.android.ads.j.this.z.get();
                    if (adMarvelVideoActivity != null && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.d && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.e && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.f) {
                        com.admarvel.android.ads.j.this.h();
                    }
                    return;
                }
                com.admarvel.android.ads.j.this.h();
            }
            
            public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                com.admarvel.android.ads.j.this.i = null;
                com.admarvel.android.ads.j.this.a(true);
            }
        };
        this.w = w;
        this.z = null;
        this.g();
    }
    
    public j(final AdMarvelVideoActivity adMarvelVideoActivity, final Context w) {
        super(w);
        this.d = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.y = 0;
        this.a = (MediaPlayer$OnVideoSizeChangedListener)new MediaPlayer$OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int n, final int n2) {
                com.admarvel.android.ads.j.this.k = mediaPlayer.getVideoWidth();
                com.admarvel.android.ads.j.this.l = mediaPlayer.getVideoHeight();
                if (com.admarvel.android.ads.j.this.k != 0 && com.admarvel.android.ads.j.this.l != 0) {
                    com.admarvel.android.ads.j.this.getHolder().setFixedSize(com.admarvel.android.ads.j.this.k, com.admarvel.android.ads.j.this.l);
                }
            }
        };
        this.b = (MediaPlayer$OnPreparedListener)new MediaPlayer$OnPreparedListener() {
            public void onPrepared(final MediaPlayer mediaPlayer) {
                com.admarvel.android.ads.j.this.g = 2;
                com.admarvel.android.ads.j.this.t = (com.admarvel.android.ads.j.this.u = (com.admarvel.android.ads.j.this.v = true));
                if (com.admarvel.android.ads.j.this.p != null) {
                    com.admarvel.android.ads.j.this.p.onPrepared(com.admarvel.android.ads.j.this.j);
                }
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
                com.admarvel.android.ads.j.this.k = mediaPlayer.getVideoWidth();
                com.admarvel.android.ads.j.this.l = mediaPlayer.getVideoHeight();
                final int f = com.admarvel.android.ads.j.this.s;
                if (f != 0) {
                    com.admarvel.android.ads.j.this.seekTo(f);
                }
                if (com.admarvel.android.ads.j.this.k != 0 && com.admarvel.android.ads.j.this.l != 0) {
                    com.admarvel.android.ads.j.this.getHolder().setFixedSize(com.admarvel.android.ads.j.this.k, com.admarvel.android.ads.j.this.l);
                    if (com.admarvel.android.ads.j.this.m == com.admarvel.android.ads.j.this.k && com.admarvel.android.ads.j.this.n == com.admarvel.android.ads.j.this.l) {
                        if (com.admarvel.android.ads.j.this.h == 3) {
                            com.admarvel.android.ads.j.this.start();
                        }
                        else if (!com.admarvel.android.ads.j.this.isPlaying() && f == 0 && com.admarvel.android.ads.j.this.getCurrentPosition() > 0) {
                            return;
                        }
                    }
                }
                else if (com.admarvel.android.ads.j.this.h == 3) {
                    com.admarvel.android.ads.j.this.start();
                }
            }
        };
        this.A = (MediaPlayer$OnCompletionListener)new MediaPlayer$OnCompletionListener() {
            public void onCompletion(final MediaPlayer mediaPlayer) {
                com.admarvel.android.ads.j.this.g = 5;
                com.admarvel.android.ads.j.this.h = 5;
                if (com.admarvel.android.ads.j.this.o != null) {
                    com.admarvel.android.ads.j.this.o.onCompletion(com.admarvel.android.ads.j.this.j);
                }
            }
        };
        this.B = (MediaPlayer$OnSeekCompleteListener)new MediaPlayer$OnSeekCompleteListener() {
            public void onSeekComplete(final MediaPlayer mediaPlayer) {
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
            }
        };
        this.C = (MediaPlayer$OnErrorListener)new MediaPlayer$OnErrorListener() {
            public boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
                com.admarvel.android.ads.j.this.g = -1;
                com.admarvel.android.ads.j.this.h = -1;
                if (com.admarvel.android.ads.j.this.x != null) {
                    com.admarvel.android.ads.j.this.x.k();
                }
                if (com.admarvel.android.ads.j.this.r == null || com.admarvel.android.ads.j.this.r.onError(com.admarvel.android.ads.j.this.j, n, n2)) {}
                return true;
            }
        };
        this.D = (MediaPlayer$OnBufferingUpdateListener)new MediaPlayer$OnBufferingUpdateListener() {
            public void onBufferingUpdate(final MediaPlayer mediaPlayer, final int n) {
                com.admarvel.android.ads.j.this.q = n;
            }
        };
        this.c = (SurfaceHolder$Callback)new SurfaceHolder$Callback() {
            public void surfaceChanged(final SurfaceHolder surfaceHolder, int n, int n2, final int n3) {
                final int n4 = 1;
                com.admarvel.android.ads.j.this.m = n2;
                com.admarvel.android.ads.j.this.n = n3;
                if (com.admarvel.android.ads.j.this.h == 3) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (com.admarvel.android.ads.j.this.k == n2 && com.admarvel.android.ads.j.this.l == n3) {
                    n2 = n4;
                }
                else {
                    n2 = 0;
                }
                if (com.admarvel.android.ads.j.this.j != null && n != 0 && n2 != 0) {
                    if (com.admarvel.android.ads.j.this.s != 0) {
                        com.admarvel.android.ads.j.this.seekTo(com.admarvel.android.ads.j.this.s);
                    }
                    com.admarvel.android.ads.j.this.start();
                }
            }
            
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
                com.admarvel.android.ads.j.this.i = surfaceHolder;
                if (com.admarvel.android.ads.j.this.z != null) {
                    final AdMarvelVideoActivity adMarvelVideoActivity = (AdMarvelVideoActivity)com.admarvel.android.ads.j.this.z.get();
                    if (adMarvelVideoActivity != null && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.d && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.e && adMarvelVideoActivity.i != AdMarvelVideoActivity$k.f) {
                        com.admarvel.android.ads.j.this.h();
                    }
                    return;
                }
                com.admarvel.android.ads.j.this.h();
            }
            
            public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                com.admarvel.android.ads.j.this.i = null;
                com.admarvel.android.ads.j.this.a(true);
            }
        };
        this.w = w;
        this.z = new WeakReference((T)adMarvelVideoActivity);
        this.g();
    }
    
    private int a(final long n) {
        return (int)n / 1000;
    }
    
    private void g() {
        this.k = 0;
        this.l = 0;
        this.getHolder().addCallback(this.c);
        this.getHolder().setType(3);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.requestFocus();
        this.g = 0;
        this.h = 0;
    }
    
    private void h() {
        if (this.e != null && this.i != null) {
            if (!com.admarvel.android.ads.r.k(this.w)) {
                if (this.x != null) {
                    this.x.l();
                }
            }
            else {
                this.a(false);
                try {
                    (this.j = new MediaPlayer()).setOnPreparedListener(this.b);
                    this.j.setOnVideoSizeChangedListener(this.a);
                    this.f = -1;
                    this.j.setOnCompletionListener(this.A);
                    this.j.setOnErrorListener(this.C);
                    this.j.setOnBufferingUpdateListener(this.D);
                    this.j.setOnSeekCompleteListener(this.B);
                    this.q = 0;
                    this.j.setDataSource(this.w, this.e);
                    this.j.setDisplay(this.i);
                    this.j.setAudioStreamType(3);
                    this.j.setScreenOnWhilePlaying(true);
                    this.j.prepareAsync();
                    this.g = 1;
                }
                catch (IOException ex) {
                    this.g = -1;
                    this.h = -1;
                    this.C.onError(this.j, 1, 0);
                }
                catch (IllegalArgumentException ex2) {
                    this.g = -1;
                    this.h = -1;
                    this.C.onError(this.j, 1, 0);
                }
            }
        }
    }
    
    private boolean i() {
        return this.j != null && this.g != -1 && this.g != 0 && this.g != 1;
    }
    
    public void a() {
        try {
            if (this.j != null) {
                this.j.stop();
                this.j.reset();
                this.j.release();
                this.j = null;
                this.g = 0;
                this.h = 0;
                if (this.x != null) {
                    this.x.i();
                }
            }
        }
        catch (Exception ex) {
            if (this.x != null) {
                this.x.m();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void a(final int s) {
        if (!com.admarvel.android.ads.r.k(this.w)) {
            if (this.x != null) {
                this.x.l();
            }
            return;
        }
        if (this.j == null) {
            this.s = s;
            this.h();
            return;
        }
        this.j.seekTo(s);
    }
    
    public void a(final MediaPlayer$OnCompletionListener o) {
        this.o = o;
    }
    
    public void a(final MediaPlayer$OnErrorListener r) {
        this.r = r;
    }
    
    public void a(final MediaPlayer$OnPreparedListener p) {
        this.p = p;
    }
    
    public void a(final Uri e) {
        try {
            if (this.j != null) {
                Logging.log("AdMarvelVideoView-ResetMedia Player");
                this.j.reset();
            }
            this.e = e;
            this.s = 0;
            this.h();
            this.requestLayout();
            this.invalidate();
        }
        catch (Exception ex) {
            if (this.x != null) {
                this.x.m();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void a(final j$a x) {
        this.x = x;
    }
    
    public void a(final boolean b) {
        try {
            if (this.j != null) {
                this.j.reset();
                this.j.release();
                this.j = null;
                this.g = 0;
                if (b) {
                    this.h = 0;
                }
            }
        }
        catch (Exception ex) {
            if (this.x != null) {
                this.x.m();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void b() {
        if (this.i()) {
            this.j.setVolume(0.0f, 0.0f);
        }
    }
    
    public void c() {
        if (this.i()) {
            this.j.setVolume(1.0f, 1.0f);
        }
    }
    
    public boolean canPause() {
        return this.t;
    }
    
    public boolean canSeekBackward() {
        return this.u;
    }
    
    public boolean canSeekForward() {
        return this.v;
    }
    
    public void d() {
        this.y = this.getCurrentPosition();
    }
    
    public void e() {
        if (this.y > 0) {
            if (this.a((long)this.y) == this.a((long)this.getCurrentPosition())) {
                this.start();
                if (this.x != null) {
                    this.x.k();
                }
            }
            else {
                this.a(this.y);
            }
            if (this.x != null) {
                this.x.j();
            }
            return;
        }
        this.start();
    }
    
    public int f() {
        return this.d;
    }
    
    public int getBufferPercentage() {
        if (this.j != null) {
            return this.q;
        }
        return 0;
    }
    
    public int getCurrentPosition() {
        if (this.i()) {
            return this.d = this.j.getCurrentPosition();
        }
        return 0;
    }
    
    public int getDuration() {
        if (!this.i()) {
            return this.f = -1;
        }
        if (this.f > 0) {
            return this.f;
        }
        return this.f = this.j.getDuration();
    }
    
    public boolean isPlaying() {
        return this.i() && this.j.isPlaying();
    }
    
    protected void onMeasure(int defaultSize, int n) {
        final int defaultSize2 = getDefaultSize(this.k, defaultSize);
        final int n2 = defaultSize = getDefaultSize(this.l, n);
        n = defaultSize2;
        if (this.k > 0) {
            defaultSize = n2;
            n = defaultSize2;
            if (this.l > 0) {
                if (this.k * n2 > this.l * defaultSize2) {
                    defaultSize = this.l * defaultSize2 / this.k;
                    n = defaultSize2;
                }
                else {
                    defaultSize = n2;
                    n = defaultSize2;
                    if (this.k * n2 < this.l * defaultSize2) {
                        n = this.k * n2 / this.l;
                        defaultSize = n2;
                    }
                }
            }
        }
        this.setMeasuredDimension(n, defaultSize);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.x != null) {
            this.x.n();
        }
        return false;
    }
    
    public boolean onTrackballEvent(final MotionEvent motionEvent) {
        return false;
    }
    
    public void pause() {
        try {
            this.g = 4;
            this.y = this.getCurrentPosition();
            if (this.i() && this.j.isPlaying()) {
                this.j.pause();
                if (this.x != null) {
                    this.x.h();
                }
            }
            this.h = 4;
        }
        catch (IllegalStateException ex) {
            if (this.x != null) {
                this.x.m();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
    
    public void seekTo(final int s) {
        if (!com.admarvel.android.ads.r.k(this.w)) {
            if (this.x != null) {
                this.x.l();
            }
            return;
        }
        if (this.i()) {
            this.j.seekTo(s);
            this.s = 0;
            return;
        }
        this.s = s;
    }
    
    public void start() {
        try {
            if (this.i()) {
                this.j.start();
                this.g = 3;
            }
            this.h = 3;
            this.y = 0;
        }
        catch (IllegalStateException ex) {
            if (this.x != null) {
                this.x.m();
            }
            Logging.log(Log.getStackTraceString((Throwable)ex));
        }
    }
}
