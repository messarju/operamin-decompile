// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.File;
import android.content.SharedPreferences$Editor;
import android.content.Context;

public class aj
{
    @DontOptimize
    static String Code(final Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }
    
    @DontOptimize
    public static void Code(final SharedPreferences$Editor sharedPreferences$Editor) {
        sharedPreferences$Editor.apply();
    }
    
    @DontOptimize
    public static boolean Code(final File file, final boolean b, final boolean b2) {
        return file.setExecutable(b, b2);
    }
    
    @DontOptimize
    public static boolean I(final File file, final boolean b, final boolean b2) {
        return file.setReadable(b, b2);
    }
    
    @DontOptimize
    public static boolean Z(final File file, final boolean b, final boolean b2) {
        return file.setWritable(b, b2);
    }
}
