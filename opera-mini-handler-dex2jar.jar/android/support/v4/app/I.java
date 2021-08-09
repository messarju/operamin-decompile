// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import java.util.Iterator;
import java.util.ArrayList;
import android.os.Build$VERSION;

public final class I
{
    private static final J Code;
    
    static {
        if (Build$VERSION.SDK_INT >= 20) {
            Code = new B();
            return;
        }
        if (Build$VERSION.SDK_INT >= 19) {
            Code = new f();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            Code = new e();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            Code = new d();
            return;
        }
        if (Build$VERSION.SDK_INT >= 11) {
            Code = new a();
            return;
        }
        if (Build$VERSION.SDK_INT >= 9) {
            Code = new C();
            return;
        }
        Code = new J();
    }
}
