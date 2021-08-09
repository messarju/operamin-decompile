// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.util.Log;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.content.DialogInterface$OnClickListener;

public final class I implements DialogInterface$OnClickListener
{
    private final Activity Code;
    private final Intent I;
    private final int Z;
    
    public I(final Activity code, final Intent i, final int z) {
        this.Code = code;
        this.I = i;
        this.Z = z;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        try {
            if (this.I != null) {
                this.Code.startActivityForResult(this.I, this.Z);
            }
            dialogInterface.dismiss();
        }
        catch (ActivityNotFoundException ex) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
