// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Intent;
import android.app.IntentService;

public final class CampaignTrackingService extends IntentService
{
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }
    
    protected final void onHandleIntent(final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        try {
            final FileOutputStream openFileOutput = this.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
        }
        catch (IOException ex) {
            ae.I("Error storing install campaign.");
        }
    }
}
