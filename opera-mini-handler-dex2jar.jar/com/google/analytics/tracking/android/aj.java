// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import android.content.Context;

final class aj
{
    private final Context Code;
    
    public aj(final Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.Code = context.getApplicationContext();
    }
    
    private int Code(final String s, final String s2) {
        if (this.Code == null) {
            return 0;
        }
        return this.Code.getResources().getIdentifier(s, s2, this.Code.getPackageName());
    }
    
    public final int Code(final String s, final int n) {
        final int code = this.Code(s, "integer");
        if (code == 0) {
            return n;
        }
        try {
            return Integer.parseInt(this.Code.getString(code));
        }
        catch (NumberFormatException ex) {
            ae.C("NumberFormatException parsing " + this.Code.getString(code));
            return n;
        }
    }
    
    public final String Code(final String s) {
        final int code = this.Code(s, "string");
        if (code == 0) {
            return null;
        }
        return this.Code.getString(code);
    }
    
    public final Double I(String code) {
        code = this.Code(code);
        if (TextUtils.isEmpty((CharSequence)code)) {
            return null;
        }
        try {
            return Double.parseDouble(code);
        }
        catch (NumberFormatException ex) {
            ae.C("NumberFormatException parsing " + code);
            return null;
        }
    }
    
    public final boolean Z(final String s) {
        final int code = this.Code(s, "bool");
        return code != 0 && "true".equalsIgnoreCase(this.Code.getString(code));
    }
}
