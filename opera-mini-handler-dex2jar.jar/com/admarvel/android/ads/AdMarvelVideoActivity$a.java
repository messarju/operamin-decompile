// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.widget.ImageView;
import java.lang.ref.WeakReference;

class AdMarvelVideoActivity$a implements Runnable
{
    final /* synthetic */ AdMarvelVideoActivity a;
    private WeakReference b;
    
    public AdMarvelVideoActivity$a(final AdMarvelVideoActivity a, final ImageView imageView) {
        this.a = a;
        this.b = null;
        this.b = new WeakReference((T)imageView);
    }
    
    @Override
    public void run() {
        final ImageView imageView = (ImageView)this.b.get();
        if (imageView != null && imageView.getDrawable() != null) {
            imageView.getDrawable().setAlpha(25);
            if (this.a.Z != null && this.a.Z.c()) {
                this.a.Z.b();
            }
        }
    }
}
