import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class cn
{
    private final Object Code;
    private final Method I;
    private boolean J;
    private final int Z;
    
    cn(final Object code, final Method i) {
        this.J = true;
        if (code == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        }
        if (i == null) {
            throw new NullPointerException("EventHandler method cannot be null.");
        }
        this.Code = code;
        (this.I = i).setAccessible(true);
        this.Z = (i.hashCode() + 31) * 31 + code.hashCode();
    }
    
    public final void Code(final Object o) {
        if (!this.J) {
            throw new IllegalStateException(this.toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.I.invoke(this.Code, o);
        }
        catch (IllegalAccessException ex) {
            throw new AssertionError((Object)ex);
        }
        catch (InvocationTargetException ex2) {
            if (ex2.getCause() instanceof Error) {
                throw (Error)ex2.getCause();
            }
            throw ex2;
        }
    }
    
    public final boolean Code() {
        return this.J;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final cn cn = (cn)o;
            if (!this.I.equals(cn.I) || this.Code != cn.Code) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return this.Z;
    }
    
    @Override
    public final String toString() {
        return "[EventHandler " + this.I + "]";
    }
}
