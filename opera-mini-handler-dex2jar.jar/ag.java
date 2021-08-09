import android.os.Build;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ag
{
    public static char Code() {
        final String brand = Build.BRAND;
        if (brand != null && brand.toLowerCase().contains("blackberry")) {
            return 'b';
        }
        return "android".charAt(0);
    }
}
