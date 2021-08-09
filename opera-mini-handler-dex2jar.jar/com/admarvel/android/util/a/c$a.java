// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util.a;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class c$a
{
    private final Object a;
    private final String b;
    private Class c;
    private List d;
    private List e;
    private boolean f;
    private boolean g;
    
    public c$a(final Object a, final String b) {
        this.a = a;
        this.b = b;
        this.d = new ArrayList();
        this.e = new ArrayList();
        Class<?> class1;
        if (a != null) {
            class1 = a.getClass();
        }
        else {
            class1 = null;
        }
        this.c = class1;
    }
    
    public c$a a(final Class c) {
        this.g = true;
        this.c = c;
        return this;
    }
    
    public c$a a(final Class clazz, final Object o) {
        this.d.add(clazz);
        this.e.add(o);
        return this;
    }
    
    public Object a() {
        final Method a = com.admarvel.android.util.a.c.a(this.c, this.b, (Class[])this.d.toArray(new Class[this.d.size()]));
        if (this.f) {
            a.setAccessible(true);
        }
        final Object[] array = this.e.toArray();
        if (this.g) {
            return a.invoke(null, array);
        }
        return a.invoke(this.a, array);
    }
}
