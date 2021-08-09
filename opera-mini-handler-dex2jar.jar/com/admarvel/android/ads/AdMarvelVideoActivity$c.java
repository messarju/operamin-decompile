// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import com.admarvel.android.util.Logging;
import android.util.Log;
import android.graphics.BitmapFactory;
import java.net.URL;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.os.AsyncTask;

class AdMarvelVideoActivity$c extends AsyncTask
{
    ImageView a;
    final /* synthetic */ AdMarvelVideoActivity b;
    
    public AdMarvelVideoActivity$c(final AdMarvelVideoActivity b, final ImageView a) {
        this.b = b;
        this.a = a;
    }
    
    protected Bitmap a(final String... array) {
        final String s = array[0];
        try {
            return BitmapFactory.decodeStream(new URL(s).openStream());
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return null;
        }
    }
    
    protected void a(final Bitmap imageBitmap) {
        this.a.setImageBitmap(imageBitmap);
    }
}
