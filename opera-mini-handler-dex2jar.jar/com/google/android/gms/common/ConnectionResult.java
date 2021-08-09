// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.common;

import com.google.android.gms.internal.J;
import android.content.Intent;
import android.app.Activity;
import android.app.PendingIntent;

public final class ConnectionResult
{
    public static final int DATE_INVALID = 12;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final ConnectionResult iP;
    private final int iC;
    private final PendingIntent mPendingIntent;
    
    static {
        iP = new ConnectionResult(0, null);
    }
    
    public ConnectionResult(final int ic, final PendingIntent mPendingIntent) {
        this.iC = ic;
        this.mPendingIntent = mPendingIntent;
    }
    
    private String aH() {
        switch (this.iC) {
            default: {
                return "unknown status code " + this.iC;
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
        }
    }
    
    public final int getErrorCode() {
        return this.iC;
    }
    
    public final PendingIntent getResolution() {
        return this.mPendingIntent;
    }
    
    public final boolean hasResolution() {
        return this.iC != 0 && this.mPendingIntent != null;
    }
    
    public final boolean isSuccess() {
        return this.iC == 0;
    }
    
    public final void startResolutionForResult(final Activity activity, final int n) {
        if (!this.hasResolution()) {
            return;
        }
        activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), n, (Intent)null, 0, 0, 0);
    }
    
    @Override
    public final String toString() {
        return J.Code(this).Code("statusCode", this.aH()).Code("resolution", this.mPendingIntent).toString();
    }
}
