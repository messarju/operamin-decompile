// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.io.File;
import android.os.Environment;
import android.os.AsyncTask;

public class c extends AsyncTask
{
    private static long a;
    
    static {
        c.a = 864000000L;
    }
    
    protected Object doInBackground(final Object... array) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                final File file = new File(Environment.getExternalStorageDirectory(), "/" + r.d("adm_tracker_dir"));
                if (file.exists()) {
                    final File[] listFiles = file.listFiles();
                    for (int length = listFiles.length, i = 0; i < length; ++i) {
                        final File file2 = listFiles[i];
                        if (System.currentTimeMillis() - file2.lastModified() > c.a) {
                            file2.delete();
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
