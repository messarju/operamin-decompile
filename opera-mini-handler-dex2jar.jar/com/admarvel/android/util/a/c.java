// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util.a;

import java.lang.reflect.Method;

public class c
{
    public static Method a(Class superclass, final String s, final Class... array) {
        while (superclass != null) {
            try {
                return superclass.getDeclaredMethod(s, (Class[])array);
            }
            catch (NoSuchMethodException ex) {
                superclass = superclass.getSuperclass();
                continue;
            }
            break;
        }
        throw new NoSuchMethodException();
    }
}
