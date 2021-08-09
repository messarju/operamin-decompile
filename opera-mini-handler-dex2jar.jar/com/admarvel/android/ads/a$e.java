// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.media.MediaPlayer;
import android.media.MediaPlayer$OnVideoSizeChangedListener;

class a$e implements MediaPlayer$OnVideoSizeChangedListener
{
    final /* synthetic */ a a;
    
    a$e(final a a) {
        this.a = a;
    }
    
    public void onVideoSizeChanged(final MediaPlayer mediaPlayer, final int n, final int n2) {
        if (this.a.c != 0 && this.a.d != 0) {
            this.a.i();
        }
    }
}
