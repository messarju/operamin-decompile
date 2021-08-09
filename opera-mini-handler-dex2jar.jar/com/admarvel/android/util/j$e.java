// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import com.google.android.gms.ads.identifier.Code;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import android.content.Context;

public class j$e
{
    final /* synthetic */ j a;
    private final Context b;
    
    public j$e(final j a, final Context b) {
        this.a = a;
        this.b = b;
    }
    
    private String b() {
        String code = null;
        try {
            final Code advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.b.getApplicationContext());
            if (advertisingIdInfo != null) {
                code = advertisingIdInfo.Code();
            }
            return code;
        }
        catch (IllegalStateException ex) {
            Logging.log("IllegalStateException " + ex.getMessage() + " in fetching ADvID");
            return null;
        }
        catch (GooglePlayServicesRepairableException ex2) {
            Logging.log("GooglePlayServicesRepairableException " + ex2.getMessage() + " in fetching ADvID");
            return null;
        }
        catch (IOException ex3) {
            Logging.log("IOException " + ex3.getMessage() + " in fetching ADvID");
            return null;
        }
        catch (GooglePlayServicesNotAvailableException ex4) {
            Logging.log("GooglePlayServicesNotAvailableException " + ex4.getMessage() + " in fetching ADvID");
            return null;
        }
    }
    
    public boolean a() {
        boolean i = false;
        try {
            final Code advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.b.getApplicationContext());
            if (advertisingIdInfo != null) {
                i = advertisingIdInfo.I();
            }
            return i;
        }
        catch (IllegalStateException ex) {
            Logging.log("IllegalStateException " + ex.getMessage() + " in fetching ADvID");
            return false;
        }
        catch (GooglePlayServicesRepairableException ex2) {
            Logging.log("GooglePlayServicesRepairableException " + ex2.getMessage() + " in fetching ADvID");
            return false;
        }
        catch (IOException ex3) {
            Logging.log("IOException " + ex3.getMessage() + " in fetching ADvID");
            return false;
        }
        catch (GooglePlayServicesNotAvailableException ex4) {
            Logging.log("GooglePlayServicesNotAvailableException " + ex4.getMessage() + " in fetching ADvID");
            return false;
        }
    }
}
