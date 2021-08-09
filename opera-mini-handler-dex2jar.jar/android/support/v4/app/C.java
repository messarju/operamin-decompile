// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.app.Notification;

final class C extends J
{
    @Override
    public final Notification Code(final Z z) {
        final Notification c = z.C;
        c.setLatestEventInfo(z.Code, z.I, z.Z, z.J);
        c.setLatestEventInfo(z.Code, z.I, z.Z, z.J);
        c.fullScreenIntent = null;
        return c;
    }
}
