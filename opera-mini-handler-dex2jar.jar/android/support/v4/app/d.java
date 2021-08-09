// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.app.Notification$Builder;
import android.app.Notification;

final class d extends J
{
    @Override
    public final Notification Code(final Z z) {
        final boolean b = true;
        final Context code = z.Code;
        final Notification c = z.C;
        return new Notification$Builder(code).setWhen(c.when).setSmallIcon(c.icon, c.iconLevel).setContent(c.contentView).setTicker(c.tickerText, (RemoteViews)null).setSound(c.sound, c.audioStreamType).setVibrate(c.vibrate).setLights(c.ledARGB, c.ledOnMS, c.ledOffMS).setOngoing((c.flags & 0x2) != 0x0).setOnlyAlertOnce((c.flags & 0x8) != 0x0).setAutoCancel((c.flags & 0x10) != 0x0).setDefaults(c.defaults).setContentTitle(z.I).setContentText(z.Z).setContentInfo((CharSequence)null).setContentIntent(z.J).setDeleteIntent(c.deleteIntent).setFullScreenIntent((PendingIntent)null, (c.flags & 0x80) != 0x0 && b).setLargeIcon((Bitmap)null).setNumber(0).setProgress(0, 0, false).getNotification();
    }
}
