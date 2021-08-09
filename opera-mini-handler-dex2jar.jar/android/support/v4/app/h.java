// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.app.RemoteInput;
import android.app.Notification$Action$Builder;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import android.app.PendingIntent;
import android.app.Notification;
import android.content.Context;
import android.app.Notification$Builder;

public final class h implements Code
{
    private Notification$Builder Code;
    
    public h(final Context context, final Notification notification, final CharSequence contentTitle, final CharSequence contentText, final PendingIntent contentIntent) {
        final boolean b = true;
        this.Code = new Notification$Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, (RemoteViews)null).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 0x2) != 0x0).setOnlyAlertOnce((notification.flags & 0x8) != 0x0).setAutoCancel((notification.flags & 0x10) != 0x0).setDefaults(notification.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText((CharSequence)null).setContentInfo((CharSequence)null).setContentIntent(contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent((PendingIntent)null, (notification.flags & 0x80) != 0x0 && b).setLargeIcon((Bitmap)null).setNumber(0).setUsesChronometer(false).setPriority(0).setProgress(0, 0, false).setLocalOnly(false).setExtras((Bundle)null).setGroup((String)null).setGroupSummary(false).setSortKey((String)null);
    }
    
    public final Notification Code() {
        return this.Code.build();
    }
    
    @Override
    public final void Code(final l l) {
        int i = 0;
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(0, (CharSequence)null, (PendingIntent)null);
        if (l.I() != null) {
            for (RemoteInput[] code = r.Code(l.I()); i < code.length; ++i) {
                notification$Action$Builder.addRemoteInput(code[i]);
            }
        }
        if (l.Code() != null) {
            notification$Action$Builder.addExtras(l.Code());
        }
        this.Code.addAction(notification$Action$Builder.build());
    }
}
