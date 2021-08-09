// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public final class Z
{
    static {
        Uri.parse("http://plus.google.com/").buildUpon().appendPath("circles").appendPath("find").build();
    }
    
    public static Intent Code() {
        return new Intent("android.settings.DATE_SETTINGS");
    }
    
    public static Intent Code(final String s) {
        final Uri fromParts = Uri.fromParts("package", s, (String)null);
        final Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
    
    public static Intent I(final String s) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter("id", s).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
    
    public static Intent Z(final String s) {
        final Uri parse = Uri.parse("bazaar://search?q=pname:" + s);
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(524288);
        return intent;
    }
}
