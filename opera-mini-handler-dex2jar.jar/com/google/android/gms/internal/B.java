// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class B
{
    private final List Code;
    private final Object I;
    
    private B(final Object o) {
        this.I = C.Code(o);
        this.Code = new ArrayList();
    }
    
    public final B Code(final String s, final Object o) {
        this.Code.add((String)C.Code(s) + "=" + String.valueOf(o));
        return this;
    }
    
    @Override
    public final String toString() {
        final StringBuilder append = new StringBuilder(100).append(this.I.getClass().getSimpleName()).append('{');
        for (int size = this.Code.size(), i = 0; i < size; ++i) {
            append.append((String)this.Code.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
