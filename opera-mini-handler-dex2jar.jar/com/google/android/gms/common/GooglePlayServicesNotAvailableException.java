// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException extends Exception
{
    public final int errorCode;
    
    public GooglePlayServicesNotAvailableException(final int errorCode) {
        this.errorCode = errorCode;
    }
}
