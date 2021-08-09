// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import java.util.Locale;
import android.text.TextUtils;
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.conn.util.InetAddressUtils;
import java.net.InetAddress;
import java.util.Collections;
import java.net.NetworkInterface;
import android.net.NetworkInfo;
import com.opera.mini.android.events.EventDispatcher;
import org.apache.http.HttpResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import android.content.Context;
import com.opera.mini.android.x;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.net.ConnectivityManager;

public final class B
{
    private static ConnectivityManager B;
    private static TelephonyManager C;
    private static a Code;
    private static PhoneStateListener I;
    private static IntentFilter J;
    private static BroadcastReceiver Z;
    
    static {
        if (x.ak >= 7) {
            com.opera.mini.android.notifications.B.I = new d((byte)0);
        }
        com.opera.mini.android.notifications.B.Z = (BroadcastReceiver)new NetUtils.NetUtils$1();
        (com.opera.mini.android.notifications.B.J = new IntentFilter()).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }
    
    public static Document Code(final String s) {
        new StringBuilder("NetUtils.httpGet uri=").append(s);
        final HttpResponse execute = new DefaultHttpClient().execute((HttpUriRequest)new HttpGet(s));
        if (execute.getStatusLine().getStatusCode() != 200) {
            new StringBuilder("NetUtils.httpGet status ").append(execute.getStatusLine());
            return null;
        }
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(execute.getEntity().getContent());
    }
    
    public static void Code() {
        EventDispatcher.Z(new C());
    }
    
    public static boolean Code(final Context context) {
        final NetworkInfo z = Z(context);
        boolean b;
        if (z != null && z.isAvailable() && z.isConnected()) {
            b = true;
        }
        else {
            b = false;
        }
        return b && z.getType() == 1;
    }
    
    public static String I() {
        final Iterator<NetworkInterface> iterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (iterator.hasNext()) {
            for (final InetAddress inetAddress : Collections.list(iterator.next().getInetAddresses())) {
                if (!inetAddress.isLoopbackAddress()) {
                    final String hostAddress = inetAddress.getHostAddress();
                    if (InetAddressUtils.isIPv4Address(hostAddress)) {
                        return hostAddress;
                    }
                    return hostAddress.split("%")[0];
                }
            }
        }
        throw new IOException("Error getting IP number.");
    }
    
    public static boolean I(final Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        final NetworkInfo[] allNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getAllNetworkInfo();
        for (int length = allNetworkInfo.length, i = 0; i < length; ++i) {
            final NetworkInfo networkInfo = allNetworkInfo[i];
            if (networkInfo != null && networkInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }
    
    public static String J(final Context context) {
        final TelephonyManager a = a(context);
        Label_0027: {
            if (a.getPhoneType() == 2) {
                break Label_0027;
            }
            final String s = a.getNetworkCountryIso();
            if (TextUtils.isEmpty((CharSequence)s)) {
                break Label_0027;
            }
            return s;
        }
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = a.getSimCountryIso()))) {
            return Locale.getDefault().getCountry();
        }
        return s;
    }
    
    public static NetworkInfo Z(final Context context) {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }
    
    public static a Z() {
        return com.opera.mini.android.notifications.B.Code;
    }
    
    private static TelephonyManager a(final Context context) {
        if (com.opera.mini.android.notifications.B.C == null) {
            com.opera.mini.android.notifications.B.C = (TelephonyManager)context.getSystemService("phone");
        }
        return com.opera.mini.android.notifications.B.C;
    }
}
