import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Set;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ck
{
    private final cp B;
    private final ThreadLocal C;
    private final ConcurrentMap Code;
    private final ConcurrentMap I;
    private final cs J;
    private final String Z;
    private final ThreadLocal a;
    private final Map b;
    
    public ck() {
        this("default");
    }
    
    public ck(final cs cs, final String s) {
        this(cs, s, cp.Code);
    }
    
    private ck(final cs j, final String z, final cp b) {
        this.Code = new ConcurrentHashMap();
        this.I = new ConcurrentHashMap();
        this.C = new ThreadLocal() {};
        this.a = new ThreadLocal() {};
        this.b = new HashMap();
        this.J = j;
        this.Z = z;
        this.B = b;
    }
    
    private ck(final String s) {
        this(cs.Code, s);
    }
    
    private void Code() {
        if (this.a.get()) {
            return;
        }
        this.a.set(true);
        try {
            while (true) {
                final cl cl = this.C.get().poll();
                if (cl == null) {
                    break;
                }
                if (!cl.I.Code()) {
                    continue;
                }
                Code(cl.Code, cl.I);
            }
        }
        finally {
            this.a.set(false);
        }
        this.a.set(false);
    }
    
    private static void Code(final cn cn, co i) {
        final Object o = null;
        while (true) {
            try {
                i = ((co)i).I();
                if (i == null) {
                    return;
                }
            }
            catch (InvocationTargetException ex) {
                Code("Producer " + i + " threw an exception.", ex);
                i = o;
                continue;
            }
            break;
        }
        Code(i, cn);
    }
    
    private static void Code(final Object o, final cn cn) {
        try {
            cn.Code(o);
        }
        catch (InvocationTargetException ex) {
            Code("Could not dispatch event: " + o.getClass() + " to handler " + cn, ex);
        }
    }
    
    private static void Code(final String s, final InvocationTargetException ex) {
        final Throwable cause = ex.getCause();
        if (cause != null) {
            throw new RuntimeException(s, cause);
        }
        throw new RuntimeException(s);
    }
    
    public final void Code(Object o) {
        this.J.Code(this);
        final Map code = this.B.Code(o);
        for (final Class clazz : code.keySet()) {
            final co co = code.get(clazz);
            final co co2 = this.I.putIfAbsent(clazz, co);
            if (co2 != null) {
                throw new IllegalArgumentException("Producer method for type " + clazz + " found on type " + co.Code.getClass() + ", but already registered by type " + co2.Code.getClass() + ".");
            }
            final Set set = (Set)this.Code.get(clazz);
            if (set == null || set.isEmpty()) {
                continue;
            }
            final Iterator iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                Code((cn)iterator2.next(), co);
            }
        }
        final Map i = this.B.I(o);
        for (final Class clazz2 : i.keySet()) {
            if ((o = this.Code.get(clazz2)) == null) {
                final Set<?> set2 = new CopyOnWriteArraySet<Object>();
                if ((o = this.Code.putIfAbsent(clazz2, set2)) == null) {
                    o = set2;
                }
            }
            ((Set<Object>)o).addAll((Collection<?>)i.get(clazz2));
        }
        for (final Map.Entry<Class, V> entry : i.entrySet()) {
            final co co3 = (co)this.I.get(entry.getKey());
            if (co3 != null && co3.Code()) {
                for (final cn cn : (Set)entry.getValue()) {
                    if (!co3.Code()) {
                        break;
                    }
                    if (!cn.Code()) {
                        continue;
                    }
                    Code(cn, co3);
                }
            }
        }
    }
    
    public final void I(final Object o) {
        this.J.Code(this);
        final Class<?> class1 = o.getClass();
        Set set;
        if ((set = this.b.get(class1)) == null) {
            final LinkedList list = new LinkedList();
            set = new HashSet();
            list.add(class1);
            while (!list.isEmpty()) {
                final Class clazz = (Class)list.remove(0);
                set.add(clazz);
                final Class superclass = clazz.getSuperclass();
                if (superclass != null) {
                    list.add(superclass);
                }
            }
            this.b.put(class1, set);
        }
        final Iterator iterator = set.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Set set2 = (Set)this.Code.get(iterator.next());
            if (set2 != null && !set2.isEmpty()) {
                final Iterator iterator2 = set2.iterator();
                while (iterator2.hasNext()) {
                    this.C.get().offer(new cl(o, (cn)iterator2.next()));
                }
                b = true;
            }
        }
        if (!b && !(o instanceof cm)) {
            this.I(new cm());
        }
        this.Code();
    }
    
    @Override
    public final String toString() {
        return "[Bus \"" + this.Z + "\"]";
    }
}
