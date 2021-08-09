// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends Code
{
    private final int iL;
    
    GooglePlayServicesRepairableException(final int il, final String s, final Intent intent) {
        super(s, intent);
        this.iL = il;
    }
    
    public int getConnectionStatusCode() {
        return this.iL;
    }
}
