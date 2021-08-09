// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.File;
import java.util.StringTokenizer;
import java.io.FilenameFilter;

final class f implements FilenameFilter
{
    private String[] Code;
    
    f(final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, "*");
        this.Code = new String[stringTokenizer.countTokens()];
        int n = 0;
        while (stringTokenizer.hasMoreTokens()) {
            this.Code[n] = stringTokenizer.nextToken();
            ++n;
        }
    }
    
    @Override
    public final boolean accept(final File file, final String s) {
        int n;
        int n2;
        boolean b;
        int index;
        for (n = -1, n2 = 0, b = true; b && n2 < this.Code.length; b = (index > n), ++n2, n = index) {
            index = s.indexOf(this.Code[n2]);
        }
        return b;
    }
}
