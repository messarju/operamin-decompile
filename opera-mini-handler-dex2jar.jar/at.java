import java.io.IOException;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class at
{
    private String Code;
    private String I;
    
    public at(final String code, final String s) {
        this.Code = code;
        this.I = I(s);
    }
    
    private static String I(final String s) {
        String string = s;
        if (!s.startsWith("file://")) {
            String string2 = s;
            if (!s.startsWith("/")) {
                string2 = "/" + s;
            }
            string = "file://" + string2;
        }
        return string;
    }
    
    public final String Code() {
        return this.Code;
    }
    
    public final boolean Code(final String s) {
        if (this.I == null || s == null) {
            return this.I == null && s == null;
        }
        return this.I.equals(I(s));
    }
    
    public final String I() {
        return this.I;
    }
    
    public final boolean J() {
        ar code = null;
        try {
            return (code = u.c.Code(this.I, false, 2)).B();
        }
        catch (IOException code) {
            return false;
        }
        finally {
            cg.Code(code);
        }
    }
    
    public final boolean Z() {
        ar code = null;
        try {
            return (code = u.c.Code(this.I, false, 1)).J();
        }
        catch (IOException code) {
            return false;
        }
        finally {
            cg.Code(code);
        }
    }
}
