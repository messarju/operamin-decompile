// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ac
{
    private static String Code;
    private static String I;
    
    public static String Code() {
        if (ac.Code == null) {
            ac.Code = u.Z("locale");
        }
        return ac.Code;
    }
    
    public static void Code(final String code) {
        ac.Code = code;
    }
    
    public static String I() {
        if (ac.I != null) {
            return ac.I;
        }
        if (ac.Code != null && ac.Code.length() >= 2) {
            return ac.Code.substring(0, 2);
        }
        return "";
    }
    
    public static void I(final String i) {
        ac.I = i;
    }
    
    public static String Z() {
        if (ac.Code != null && ac.Code.indexOf("-") >= 0) {
            return ac.Code.substring(ac.Code.indexOf("-") + 1);
        }
        return "";
    }
}
