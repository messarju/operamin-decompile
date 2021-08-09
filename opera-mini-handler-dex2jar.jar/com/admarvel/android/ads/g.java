// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.InputStream;
import com.admarvel.android.util.Logging;
import android.util.Log;
import java.net.URL;
import java.net.HttpURLConnection;

public class g implements AdMarvelNetworkHandler
{
    @Override
    public String executeNetworkCall(final AdMarvelHttpPost adMarvelHttpPost) {
        final int n = 0;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection)new URL(adMarvelHttpPost.getEndpointUrl()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            for (final String s : adMarvelHttpPost.getHttpHeaders().keySet()) {
                httpURLConnection.setRequestProperty(s, (String)adMarvelHttpPost.getHttpHeaders().get(s));
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            return null;
        }
        httpURLConnection.setRequestProperty("Content-Length", Integer.toString(adMarvelHttpPost.getPostString().length()));
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.getOutputStream().write(adMarvelHttpPost.getPostString().getBytes());
        final int responseCode = httpURLConnection.getResponseCode();
        final int contentLength = httpURLConnection.getContentLength();
        Logging.log("Connection Status Code: " + responseCode);
        Logging.log("Content Length: " + contentLength);
        Label_0413: {
            if (responseCode != 200) {
                break Label_0413;
            }
            final InputStream inputStream = (InputStream)httpURLConnection.getContent();
            final ArrayList list = new ArrayList();
            int i = 8192;
            int n2 = 0;
            while (i != -1) {
                final byte[] a = new byte[8192];
                final int read = inputStream.read(a, 0, 8192);
                if ((i = read) > 0) {
                    final g$a g$a = new g$a(null);
                    g$a.a = a;
                    g$a.b = read;
                    n2 += read;
                    list.add(g$a);
                    i = read;
                }
            }
            inputStream.close();
            if (n2 <= 0) {
                break Label_0413;
            }
            final byte[] array = new byte[n2];
            int j = 0;
            int n3 = n;
            while (j < list.size()) {
                final g$a g$a2 = (g$a)list.get(j);
                System.arraycopy(g$a2.a, 0, array, n3, g$a2.b);
                n3 += g$a2.b;
                ++j;
            }
            final String s2 = new String(array);
            return s2.toString();
        }
        final String s2 = "";
        return s2.toString();
    }
}
