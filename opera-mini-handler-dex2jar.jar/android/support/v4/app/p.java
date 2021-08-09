// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.util.SparseArray;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import android.app.PendingIntent;
import android.app.Notification;
import android.content.Context;
import java.util.List;
import android.os.Bundle;
import android.app.Notification$Builder;

public final class p implements Code
{
    private Notification$Builder Code;
    private Bundle I;
    private List Z;
    
    public p(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final PendingIntent contentIntent) {
        final boolean b = true;
        this.Z = new ArrayList();
        this.Code = new Notification$Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, (RemoteViews)null).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 0x2) != 0x0).setOnlyAlertOnce((notification.flags & 0x8) != 0x0).setAutoCancel((notification.flags & 0x10) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText((CharSequence)null).setContentInfo((CharSequence)null).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent((PendingIntent)null, (notification.flags & 0x80) != 0x0 && b).setLargeIcon((Bitmap)null).setNumber(0).setUsesChronometer(false).setPriority(0).setProgress(0, 0, false);
        this.I = new Bundle();
    }
    
    public final Notification Code() {
        final SparseArray code = m.Code(this.Z);
        if (code != null) {
            this.I.putSparseParcelableArray("android.support.actionExtras", code);
        }
        this.Code.setExtras(this.I);
        return this.Code.build();
    }
    
    @Override
    public final void Code(final l l) {
        this.Z.add(m.Code(this.Code, l));
    }
}
