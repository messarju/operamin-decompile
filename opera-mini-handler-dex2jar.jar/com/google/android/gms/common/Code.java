// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.common;

import android.content.Intent;

public class Code extends Exception
{
    private final Intent mIntent;
    
    public Code(final String s, final Intent mIntent) {
        super(s);
        this.mIntent = mIntent;
    }
    
    public Intent getIntent() {
        return new Intent(this.mIntent);
    }
}
