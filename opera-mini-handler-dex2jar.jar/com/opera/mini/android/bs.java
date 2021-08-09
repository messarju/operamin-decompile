// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public final class bs
{
    public static Object Code(Object invoke, final String s, final Object... array) {
        if (invoke != null) {
            while (true) {
                Label_0117: {
                    if (array == null) {
                        break Label_0117;
                    }
                    final Class[] array2 = new Class[array.length];
                    for (int i = 0; i < array.length; ++i) {
                        Class<?> class1;
                        if (array[i] == null) {
                            class1 = null;
                        }
                        else {
                            class1 = array[i].getClass();
                        }
                        array2[i] = class1;
                    }
                    final Class[] array3 = array2;
                    final Method code = Code(invoke, s, array3);
                    if (code == null) {
                        return null;
                    }
                    code.setAccessible(true);
                    try {
                        if (invoke instanceof Class) {
                            return code.invoke(null, array);
                        }
                        invoke = code.invoke(invoke, array);
                        return invoke;
                    }
                    catch (ClassCastException ex) {
                        throw ex;
                    }
                    catch (ExceptionInInitializerError exceptionInInitializerError) {
                        return null;
                    }
                    catch (InvocationTargetException ex2) {
                        return null;
                    }
                    catch (IllegalArgumentException ex3) {
                        return null;
                    }
                    catch (IllegalAccessException ex4) {
                        return null;
                    }
                }
                final Class[] array3 = null;
                continue;
            }
        }
        return null;
    }
    
    private static Method Code(Object class1, final String s, final Class[] array) {
        Label_0027: {
            if (!(class1 instanceof Class)) {
                break Label_0027;
            }
            class1 = class1;
            while (true) {
                if (class1 == Object.class) {
                    goto Label_0044;
                }
                try {
                    return ((Class)class1).getDeclaredMethod(s, (Class<?>[])array);
                    class1 = class1.getClass();
                    continue;
                }
                catch (NoSuchMethodException ex) {}
                catch (SecurityException ex2) {
                    goto Label_0036;
                }
                break;
            }
        }
    }
}
