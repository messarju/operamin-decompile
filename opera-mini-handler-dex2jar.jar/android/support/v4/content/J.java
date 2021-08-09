// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class J
{
    final IntentFilter Code;
    final BroadcastReceiver I;
    boolean Z;
    
    J(final IntentFilter code, final BroadcastReceiver i) {
        this.Code = code;
        this.I = i;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.I);
        sb.append(" filter=");
        sb.append(this.Code);
        sb.append("}");
        return sb.toString();
    }
}
