// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpEntity;
import android.util.Log;
import android.graphics.BitmapFactory;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpGet;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.os.AsyncTask;

public class DownloadImageTask extends AsyncTask
{
    private static final String TAG;
    private final ImageView imageView;
    
    static {
        TAG = DownloadImageTask.class.getSimpleName();
    }
    
    public DownloadImageTask(final ImageView imageView) {
        this.imageView = imageView;
    }
    
    protected Bitmap doInBackground(String... array) {
        final String s = array[0];
        array = (String[])(Object)AdUtilities.getHttpClient();
        final HttpGet httpGet = new HttpGet(s);
        HttpEntity entity = null;
        try {
            entity = ((HttpClient)(Object)array).execute((HttpUriRequest)httpGet).getEntity();
            array = (String[])EntityUtils.toByteArray(entity);
            array = (String[])(Object)BitmapFactory.decodeByteArray((byte[])array, 0, array.length);
            final HttpEntity httpEntity = entity;
            httpEntity.consumeContent();
            final String[] array2 = array;
            return (Bitmap)(Object)array2;
        }
        catch (Exception ex) {
            array = null;
        }
        while (true) {
            try {
                final HttpEntity httpEntity = entity;
                httpEntity.consumeContent();
                final String[] array2 = array;
                return (Bitmap)(Object)array2;
                final Exception ex;
                Log.e(DownloadImageTask.TAG, "Error downloading image: " + s, (Throwable)ex);
                return (Bitmap)(Object)array;
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    protected void onPostExecute(final Bitmap imageBitmap) {
        this.imageView.setImageBitmap(imageBitmap);
    }
}
