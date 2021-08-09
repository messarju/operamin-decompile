// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnPreparedListener;

class a$d implements MediaPlayer$OnPreparedListener
{
    final /* synthetic */ a a;
    
    a$d(final a a) {
        this.a = a;
    }
    
    public void onPrepared(final MediaPlayer mediaPlayer) {
        this.a.n = 2;
        this.a.x = (this.a.y = (this.a.z = true));
        if (this.a.t != null) {
            this.a.t.onPrepared(this.a.p);
        }
        if (this.a.e != null) {
            this.a.e.d();
        }
        final int c = this.a.w;
        if (c != 0) {
            this.a.seekTo(c);
        }
        if (this.a.c != 0 && this.a.d != 0) {
            this.a.i();
            if (this.a.o == 3) {
                this.a.start();
            }
            else if (!this.a.isPlaying() && c == 0 && this.a.getCurrentPosition() > 0) {
                return;
            }
        }
        else if (this.a.o == 3) {
            this.a.start();
        }
    }
}
