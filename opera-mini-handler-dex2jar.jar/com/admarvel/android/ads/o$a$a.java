// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.ColorFilter;
import android.graphics.drawable.LayerDrawable;

public class o$a$a extends LayerDrawable
{
    protected int a;
    protected ColorFilter b;
    final /* synthetic */ o$a c;
    
    public o$a$a(final o$a c, final Drawable drawable) {
        this.c = c;
        super(new Drawable[] { drawable });
        this.a = 100;
        this.b = (ColorFilter)new LightingColorFilter(3768514, 1);
    }
    
    public boolean isStateful() {
        return true;
    }
    
    protected boolean onStateChange(final int[] array) {
        boolean b = false;
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int n2 = array[i];
            int n3;
            if (n2 == 16842910) {
                n3 = 1;
            }
            else {
                n3 = n;
                if (n2 == 16842919) {
                    b = true;
                    n3 = n;
                }
            }
            ++i;
            n = n3;
        }
        if (n != 0 && b) {
            this.setColorFilter(this.b);
        }
        else if (n != 0) {
            this.setColorFilter((ColorFilter)null);
            this.setAlpha(255);
        }
        else if (n == 0) {
            this.setColorFilter((ColorFilter)null);
            this.setAlpha(this.a);
        }
        else {
            this.setColorFilter((ColorFilter)null);
        }
        this.invalidateSelf();
        return super.onStateChange(array);
    }
}
