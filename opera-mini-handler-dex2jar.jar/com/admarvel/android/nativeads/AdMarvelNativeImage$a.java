// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.nativeads;

import com.admarvel.android.util.Logging;
import android.graphics.BitmapFactory;
import java.net.URL;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import android.widget.ImageView;
import android.os.AsyncTask;

class AdMarvelNativeImage$a extends AsyncTask
{
    final /* synthetic */ AdMarvelNativeImage a;
    private final ImageView b;
    private final WeakReference c;
    
    public AdMarvelNativeImage$a(final AdMarvelNativeImage a, final ImageView b) {
        this.a = a;
        this.b = b;
        this.c = new WeakReference((T)b);
    }
    
    protected Bitmap a(String... array) {
        array = (String[])(Object)array[0];
        try {
            return BitmapFactory.decodeStream(new URL((String)(Object)array).openStream());
        }
        catch (Exception ex) {
            Logging.log("Error downloading image: " + (String)(Object)array + " " + ex);
            return null;
        }
    }
    
    protected void a(final Bitmap imageBitmap) {
        if (this.c.get() != null) {
            ((ImageView)this.c.get()).setImageBitmap(imageBitmap);
        }
    }
}
