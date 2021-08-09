// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.os.Build$VERSION;
import android.os.Bundle;

public final class q extends t
{
    private final Bundle B;
    private final String Code;
    private final CharSequence I;
    private final boolean J;
    private final CharSequence[] Z;
    
    static {
        if (Build$VERSION.SDK_INT < 20) {
            final int sdk_INT = Build$VERSION.SDK_INT;
        }
    }
    
    public final Bundle B() {
        return this.B;
    }
    
    public final String Code() {
        return this.Code;
    }
    
    public final CharSequence I() {
        return this.I;
    }
    
    public final boolean J() {
        return this.J;
    }
    
    public final CharSequence[] Z() {
        return this.Z;
    }
}
