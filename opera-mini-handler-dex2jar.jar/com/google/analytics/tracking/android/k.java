// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import org.apache.http.client.HttpClient;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.DefaultHttpClient;
import java.util.List;
import java.io.InputStream;
import org.apache.http.Header;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.HttpEntityEnclosingRequest;
import java.net.MalformedURLException;
import android.text.TextUtils;
import java.net.URL;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import android.content.Context;

final class k
{
    private final String Code;
    private final ad.ad$Code I;
    private final Context Z;
    
    k(final ad.ad$Code object, final Context context) {
        this(object, context, (byte)0);
    }
    
    private k(final ad.ad$Code i, final Context context, final byte b) {
        this.Z = context.getApplicationContext();
        this.Code = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", "2.0", Build$VERSION.RELEASE, aq.Code(Locale.getDefault()), Build.MODEL, Build.ID);
        this.I = i;
    }
    
    private static URL Code(final ab ab) {
        if (TextUtils.isEmpty((CharSequence)ab.J())) {
            return null;
        }
        try {
            return new URL(ab.J());
        }
        catch (MalformedURLException ex) {
            try {
                return new URL("http://www.google-analytics.com/collect");
            }
            catch (MalformedURLException ex2) {
                return null;
            }
        }
    }
    
    private HttpEntityEnclosingRequest Code(final String s, final String s2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            ae.C("Empty hit, discarding.");
            return null;
        }
        final String string = s2 + "?" + s;
        Object o;
        if (string.length() < 2036) {
            o = new BasicHttpEntityEnclosingRequest("GET", string);
        }
        else {
            final BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", s2);
            try {
                ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).setEntity((HttpEntity)new StringEntity(s));
                o = basicHttpEntityEnclosingRequest;
            }
            catch (UnsupportedEncodingException ex) {
                ae.C("Encoding error, discarding hit");
                return null;
            }
        }
        ((HttpEntityEnclosingRequest)o).addHeader("User-Agent", this.Code);
        return (HttpEntityEnclosingRequest)o;
    }
    
    private static void Code(final boolean b, final HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (!b) {
            return;
        }
        final StringBuffer sb = new StringBuffer();
        final Header[] allHeaders = httpEntityEnclosingRequest.getAllHeaders();
        for (int length = allHeaders.length, i = 0; i < length; ++i) {
            sb.append(allHeaders[i].toString()).append("\n");
        }
        sb.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        while (true) {
            if (httpEntityEnclosingRequest.getEntity() == null) {
                break Label_0151;
            }
            try {
                final InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    final int available = content.available();
                    if (available > 0) {
                        final byte[] array = new byte[available];
                        content.read(array);
                        sb.append("POST:\n");
                        sb.append(new String(array)).append("\n");
                    }
                }
                ae.Z(sb.toString());
            }
            catch (IOException ex) {
                ae.C("Error Writing hit to log...");
                continue;
            }
            break;
        }
    }
    
    public final int Code(final List list) {
        final int min = Math.min(list.size(), 40);
        int i = 0;
        int n = 0;
        while (i < min) {
            final Object j = this.I;
            final DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            final ab ab = list.get(i);
            final URL code = Code(ab);
            if (code == null) {
                if (ae.Code()) {
                    ae.C("No destination: discarding hit: " + ab.Code());
                }
                else {
                    ae.C("No destination: discarding hit.");
                }
                ++n;
            }
            else {
                final HttpHost httpHost = new HttpHost(code.getHost(), code.getPort(), code.getProtocol());
                final String path = code.getPath();
                String string;
                if (TextUtils.isEmpty((CharSequence)ab.Code())) {
                    string = "";
                }
                else {
                    final long currentTimeMillis = System.currentTimeMillis();
                    final StringBuilder sb = new StringBuilder();
                    sb.append(ab.Code());
                    if (ab.Z() > 0L) {
                        final long n2 = currentTimeMillis - ab.Z();
                        if (n2 >= 0L) {
                            sb.append("&qt=").append(n2);
                        }
                    }
                    sb.append("&z=").append(ab.I());
                    string = sb.toString();
                }
                final HttpEntityEnclosingRequest code2 = this.Code(string, path);
                if (code2 == null) {
                    ++n;
                }
                else {
                    code2.addHeader("Host", httpHost.toHostString());
                    Code(ae.Code(), code2);
                    Label_0313: {
                        if (string.length() <= 8192) {
                            try {
                                final HttpResponse execute = ((HttpClient)defaultHttpClient).execute(httpHost, (HttpRequest)code2);
                                if (execute.getStatusLine().getStatusCode() != 200) {
                                    ae.C("Bad response: " + execute.getStatusLine().getStatusCode());
                                    return n;
                                }
                                break Label_0313;
                            }
                            catch (ClientProtocolException ex) {
                                ae.C("ClientProtocolException sending hit; discarding hit...");
                                break Label_0313;
                            }
                            catch (IOException ex2) {
                                ae.C("Exception sending hit: " + ex2.getClass().getSimpleName());
                                ae.C(ex2.getMessage());
                                return n;
                            }
                            break;
                        }
                        ae.C("Hit too long (> 8192 bytes)--not sent");
                    }
                    ++n;
                }
            }
            ++i;
        }
        return n;
    }
    
    public final boolean Code() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.Z.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            ae.B("...no network connectivity");
            return false;
        }
        return true;
    }
}
