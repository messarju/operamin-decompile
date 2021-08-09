import java.util.HashSet;
import java.util.Set;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class cj
{
    private static final Map Code;
    private static final Map I;
    
    static {
        Code = new HashMap();
        I = new HashMap();
    }
    
    static Map Code(final Object o) {
        final Class<?> class1 = o.getClass();
        final HashMap hashMap = new HashMap();
        if (!cj.Code.containsKey(class1)) {
            Code(class1);
        }
        final Map map = cj.Code.get(class1);
        if (!map.isEmpty()) {
            for (final Map.Entry<Object, V> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new co(o, (Method)entry.getValue()));
            }
        }
        return hashMap;
    }
    
    private static void Code(final Class clazz) {
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int length = declaredMethods.length, i = 0; i < length; ++i) {
            final Method method = declaredMethods[i];
            if (method.isAnnotationPresent(cr.class)) {
                final Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation but requires " + parameterTypes.length + " arguments.  Methods must require a single argument.");
                }
                final Class<?> clazz2 = parameterTypes[0];
                if (clazz2.isInterface()) {
                    throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + clazz2 + " which is an interface.  Subscription must be on a concrete class type.");
                }
                if ((method.getModifiers() & 0x1) == 0x0) {
                    throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation on " + clazz2 + " but is not 'public'.");
                }
                Set set;
                if ((set = (Set)hashMap.get(clazz2)) == null) {
                    set = new HashSet();
                    hashMap.put(clazz2, set);
                }
                set.add(method);
            }
            else if (method.isAnnotationPresent(cq.class)) {
                final Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 0) {
                    throw new IllegalArgumentException("Method " + method + "has @Produce annotation but requires " + parameterTypes2.length + " arguments.  Methods must require zero arguments.");
                }
                if (method.getReturnType() == Void.class) {
                    throw new IllegalArgumentException("Method " + method + " has a return type of void.  Must declare a non-void type.");
                }
                final Class<?> returnType = method.getReturnType();
                if (returnType.isInterface()) {
                    throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " which is an interface.  Producers must return a concrete class type.");
                }
                if (returnType.equals(Void.TYPE)) {
                    throw new IllegalArgumentException("Method " + method + " has @Produce annotation but has no return type.");
                }
                if ((method.getModifiers() & 0x1) == 0x0) {
                    throw new IllegalArgumentException("Method " + method + " has @Produce annotation on " + returnType + " but is not 'public'.");
                }
                if (hashMap2.containsKey(returnType)) {
                    throw new IllegalArgumentException("Producer for type " + returnType + " has already been registered.");
                }
                hashMap2.put(returnType, method);
            }
        }
        cj.Code.put(clazz, hashMap2);
        cj.I.put(clazz, hashMap);
    }
    
    static Map I(final Object o) {
        final Class<?> class1 = o.getClass();
        final HashMap hashMap = new HashMap();
        if (!cj.I.containsKey(class1)) {
            Code(class1);
        }
        final Map map = cj.I.get(class1);
        if (!map.isEmpty()) {
            for (final Map.Entry<K, Set> entry : map.entrySet()) {
                final HashSet set = new HashSet();
                final Iterator iterator2 = entry.getValue().iterator();
                while (iterator2.hasNext()) {
                    set.add(new cn(o, (Method)iterator2.next()));
                }
                hashMap.put(entry.getKey(), set);
            }
        }
        return hashMap;
    }
}
