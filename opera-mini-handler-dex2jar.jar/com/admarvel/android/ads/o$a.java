// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.graphics.drawable.Drawable;
import android.content.Context;
import android.widget.Button;

public class o$a extends Button
{
    final /* synthetic */ o a;
    
    public o$a(final o a, final Context context) {
        this.a = a;
        super(context);
    }
    
    public void setBackgroundDrawable(final Drawable drawable) {
        if (drawable != null) {
            super.setBackgroundDrawable((Drawable)new o$a$a(this, drawable));
        }
    }
}
