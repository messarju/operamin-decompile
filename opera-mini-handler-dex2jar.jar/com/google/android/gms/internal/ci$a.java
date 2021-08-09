// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class ci$a extends BroadcastReceiver
{
    private ci$a() {
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            return;
        }
        intent.getAction();
    }
}
