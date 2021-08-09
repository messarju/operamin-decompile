// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.nfc.NdefRecord;
import java.util.Arrays;
import java.nio.charset.Charset;
import android.nfc.NdefMessage;
import android.content.Intent;

public class ak
{
    private static final String[] Code;
    
    static {
        Code = new String[] { "", "http://www.", "https://www.", "http://", "https://", "tel:", "mailto:", "ftp://anonymous:anonymous@", "ftp://ftp.", "ftps://", "sftp://", "smb://", "nfs://", "ftp://", "dav://", "news:", "telnet://", "imap:", "rtsp://", "urn:", "pop:", "sip:", "sips:", "tftp:", "btspp://", "btl2cap://", "btgoep://", "tcpobex://", "irdaobex://", "file://", "urn:epc:id:", "urn:epc:tag:", "urn:epc:pat:", "urn:epc:raw:", "urn:epc:", "urn:nfc:" };
    }
    
    @DontOptimize
    public static String Code(final Intent intent) {
        final NdefMessage ndefMessage = (NdefMessage)intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES")[0];
        if (ndefMessage.getRecords().length > 0) {
            final NdefRecord ndefRecord = ndefMessage.getRecords()[0];
            final short tnf = ndefRecord.getTnf();
            if (tnf == 3) {
                return new String(ndefRecord.getType(), Charset.forName("UTF-8"));
            }
            if (tnf == 1 && new String(ndefRecord.getType()).equals("U")) {
                final byte[] payload = ndefRecord.getPayload();
                if (payload[0] >= 0 && payload[0] < ak.Code.length) {
                    return ak.Code[payload[0]] + new String(Arrays.copyOfRange(payload, 1, payload.length), Charset.forName("UTF-8"));
                }
            }
        }
        return null;
    }
    
    @DontOptimize
    public static boolean Code(final String s) {
        return "android.nfc.action.NDEF_DISCOVERED".equals(s);
    }
}
