import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class co
{
    final Object Code;
    private final Method I;
    private boolean J;
    private final int Z;
    
    co(final Object code, final Method i) {
        this.J = true;
        if (code == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        }
        if (i == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
        this.Code = code;
        (this.I = i).setAccessible(true);
        this.Z = (i.hashCode() + 31) * 31 + code.hashCode();
    }
    
    public final boolean Code() {
        return this.J;
    }
    
    public final Object I() {
        if (!this.J) {
            throw new IllegalStateException(this.toString() + " has been invalidated and can no longer produce events.");
        }
        try {
            return this.I.invoke(this.Code, new Object[0]);
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
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final co co = (co)o;
            if (!this.I.equals(co.I) || this.Code != co.Code) {
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
        return "[EventProducer " + this.I + "]";
    }
}
