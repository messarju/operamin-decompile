// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

public final class ah
{
    private final String Code;
    private final String I;
    private final ag Z;
    
    public ah(final String code, final String i, final ag z) {
        this.Code = code;
        this.I = i;
        this.Z = z;
    }
    
    public final String Code() {
        return this.I;
    }
    
    public final String Code(String string) {
        final String s = null;
        if (string.contains("*")) {
            final String code = this.Code;
            final String[] split = string.split("\\*");
            string = s;
            if (split.length <= 1) {
                return string;
            }
            try {
                string = code + Integer.parseInt(split[1]);
                return string;
            }
            catch (NumberFormatException ex) {
                ae.C("Unable to parse slot for url parameter " + code);
                return null;
            }
        }
        return this.Code;
    }
    
    public final ag I() {
        return this.Z;
    }
}
