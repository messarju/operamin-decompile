// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import android.net.ConnectivityManager;
import android.content.Context;
import android.os.AsyncTask;

class r$g extends AsyncTask
{
    final /* synthetic */ r a;
    private String b;
    
    public r$g(final r a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    protected Boolean a(final Void... array) {
        try {
            final Context context = (Context)this.a.c.get();
            if (context == null) {
                return false;
            }
            if (((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected()) {
                final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(this.b).openConnection();
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    return true;
                }
                return false;
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
