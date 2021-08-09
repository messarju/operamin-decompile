// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.ads.identifier;

import com.google.android.gms.internal.d;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.e;
import android.os.Looper;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import android.content.ServiceConnection;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.I;
import android.content.Context;

public final class AdvertisingIdClient
{
    private static I g(final Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            final Context context2 = context;
            GooglePlayServicesUtil.m(context2);
            final I i = new I();
            final String s = "com.google.android.gms.ads.identifier.service.START";
            final Intent intent = new Intent(s);
            final Intent intent3;
            final Intent intent2 = intent3 = intent;
            final String s2 = "com.google.android.gms";
            intent3.setPackage(s2);
            final Context context3 = context;
            final Intent intent4 = intent2;
            final Object o = i;
            final int n = 1;
            final boolean b = context3.bindService(intent4, (ServiceConnection)o, n);
            if (b) {
                return i;
            }
            throw new IOException("Connection failure");
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        try {
            final Context context2 = context;
            GooglePlayServicesUtil.m(context2);
            final I i = new I();
            final String s = "com.google.android.gms.ads.identifier.service.START";
            final Intent intent = new Intent(s);
            final Intent intent3;
            final Intent intent2 = intent3 = intent;
            final String s2 = "com.google.android.gms";
            intent3.setPackage(s2);
            final Context context3 = context;
            final Intent intent4 = intent2;
            final Object o = i;
            final int n = 1;
            final boolean b = context3.bindService(intent4, (ServiceConnection)o, n);
            if (b) {
                return i;
            }
        }
        catch (GooglePlayServicesNotAvailableException ex2) {
            throw new IOException(ex2);
        }
        throw new IOException("Connection failure");
    }
    
    public static Code getAdvertisingIdInfo(final Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Calling this from your main thread can lead to deadlock");
        }
        final I g = g(context);
        try {
            final d code = e.Code(g.Code());
            return new Code(code.Code(), code.Code(true));
        }
        catch (RemoteException ex) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", (Throwable)ex);
            throw new IOException("Remote exception");
        }
        catch (InterruptedException ex2) {
            throw new IOException("Interrupted exception");
        }
        finally {
            context.unbindService((ServiceConnection)g);
        }
    }
}
