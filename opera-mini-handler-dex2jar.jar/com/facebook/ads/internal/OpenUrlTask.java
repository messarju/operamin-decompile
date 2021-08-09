// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.util.Iterator;
import org.apache.http.client.HttpClient;
import android.util.Log;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpGet;
import java.net.URLEncoder;
import java.util.Map;
import android.os.AsyncTask;

public class OpenUrlTask extends AsyncTask
{
    private static final String INVALID_ADDRESS = "#";
    private static final int NUM_RETRIES = 2;
    private static final String TAG;
    private Map extraData;
    
    static {
        TAG = OpenUrlTask.class.getSimpleName();
    }
    
    public OpenUrlTask() {
        this.extraData = null;
    }
    
    public OpenUrlTask(final Map extraData) {
        this.extraData = extraData;
    }
    
    private String addAnalogInfo(final String s) {
        try {
            return this.addData(s, "analog", AdUtilities.jsonEncode(AdAnalogData.getAnalogInfo()));
        }
        catch (Exception ex) {
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            return s;
        }
    }
    
    private String addData(final String s, final String s2, final String s3) {
        if (StringUtils.isNullOrEmpty(s) || StringUtils.isNullOrEmpty(s2) || StringUtils.isNullOrEmpty(s3)) {
            return s;
        }
        String s4;
        if (s.contains("?")) {
            s4 = "&";
        }
        else {
            s4 = "?";
        }
        return s + s4 + s2 + "=" + URLEncoder.encode(s3);
    }
    
    private boolean makeRequest(final String s) {
        boolean b = false;
        final HttpClient httpClient = AdUtilities.getHttpClient();
        final HttpGet httpGet = new HttpGet(s);
        try {
            if (httpClient.execute((HttpUriRequest)httpGet).getStatusLine().getStatusCode() == 200) {
                b = true;
            }
            return b;
        }
        catch (Exception ex) {
            Log.e(OpenUrlTask.TAG, "Error opening url: " + s, (Throwable)ex);
            AdClientEventManager.addClientEvent(AdClientEvent.newErrorEvent(ex));
            return false;
        }
    }
    
    protected Void doInBackground(final String... array) {
        final String s = array[0];
        if (!StringUtils.isNullOrEmpty(s) && !s.equals("#")) {
            String s2 = this.addAnalogInfo(s);
            String s3;
            if (this.extraData != null) {
                final Iterator iterator = this.extraData.keySet().iterator();
                while (true) {
                    s3 = s2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final String s4 = (String)iterator.next();
                    s2 = this.addData(s2, s4, (String)this.extraData.get(s4));
                }
            }
            else {
                s3 = s2;
            }
            for (int n = 1; n <= 2 && !this.makeRequest(s3); ++n) {}
        }
        return null;
    }
}
