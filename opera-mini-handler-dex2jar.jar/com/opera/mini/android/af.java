// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.nfc.NdefRecord;
import android.nfc.NdefMessage;
import android.nfc.NfcEvent;
import android.nfc.NfcAdapter$CreateNdefMessageCallback;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.app.Activity;

public class af
{
    @DontOptimize
    public static void Code(final Activity activity) {
        final NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter((Context)activity);
        if (defaultAdapter != null) {
            defaultAdapter.setNdefPushMessageCallback((NfcAdapter$CreateNdefMessageCallback)new NfcAdapter$CreateNdefMessageCallback() {
                public final NdefMessage createNdefMessage(final NfcEvent nfcEvent) {
                    final String n = x.n();
                    if (n == null || n == "") {
                        return null;
                    }
                    return new NdefMessage(new NdefRecord[] { NdefRecord.createUri(n) });
                }
            }, activity, new Activity[0]);
        }
    }
}
