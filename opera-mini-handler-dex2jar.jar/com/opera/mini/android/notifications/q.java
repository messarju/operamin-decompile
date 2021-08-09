// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android.notifications;

import android.app.PendingIntent;
import android.support.v4.app.Z;
import android.content.Intent;
import com.opera.mini.android.Browser;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public final class q
{
    private static q Code;
    private Context I;
    private NotificationManager Z;
    
    private q(final Context i) {
        this.I = i;
        this.Z = (NotificationManager)i.getSystemService("notification");
    }
    
    public static Notification Code(final Context context, final String action, final String s, final String s2) {
        final Intent intent = new Intent(context, (Class)Browser.class);
        intent.setAction(action);
        return new Z(context).Code(s).I(s2).Code().I().Code(PendingIntent.getActivity(context, 0, intent, 1073741824)).Z();
    }
    
    public static q Code(final Context context) {
        if (q.Code == null) {
            q.Code = new q(context);
        }
        return q.Code;
    }
    
    public static boolean Code(final Intent intent) {
        boolean b = true;
        final String action = intent.getAction();
        if (action == null || !action.startsWith("com.opera.mini.android.ACTION_USERNOTIFICATION:")) {
            b = false;
        }
        else {
            try {
                if (Integer.parseInt(action.split(":")[1]) == 0) {
                    Browser.Z.Code("opera:downloads");
                    return true;
                }
            }
            catch (NumberFormatException ex) {
                return true;
            }
        }
        return b;
    }
    
    public final void Code(final int n) {
        this.Z.cancel(n);
    }
    
    public final void Code(final int n, final int n2, final String s, final String s2) {
        this.Z.notify(n2, Code(this.I, "com.opera.mini.android.ACTION_USERNOTIFICATION:" + n, s, s2));
    }
}
