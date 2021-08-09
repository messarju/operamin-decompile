// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.app.Notification;
import java.util.ArrayList;

public final class Z
{
    ArrayList B;
    Notification C;
    Context Code;
    CharSequence I;
    PendingIntent J;
    CharSequence Z;
    
    public Z(final Context code) {
        this.B = new ArrayList();
        this.C = new Notification();
        this.Code = code;
        this.C.when = System.currentTimeMillis();
        this.C.audioStreamType = -1;
    }
    
    public final Z Code() {
        this.C.icon = 2130837511;
        return this;
    }
    
    public final Z Code(final PendingIntent j) {
        this.J = j;
        return this;
    }
    
    public final Z Code(final CharSequence i) {
        this.I = i;
        return this;
    }
    
    public final Z I() {
        final Notification c = this.C;
        c.flags |= 0x10;
        return this;
    }
    
    public final Z I(final CharSequence z) {
        this.Z = z;
        return this;
    }
    
    public final Notification Z() {
        return android.support.v4.app.I.Code.Code(this);
    }
}
