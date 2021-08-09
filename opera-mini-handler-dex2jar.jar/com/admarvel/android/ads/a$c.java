// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.io.InputStream;
import java.net.URLConnection;
import com.admarvel.android.util.Logging;
import android.util.Log;
import java.net.URL;
import java.io.File;
import java.io.FileOutputStream;
import android.os.AsyncTask;

class a$c extends AsyncTask
{
    private final String a;
    private final String b;
    private FileOutputStream c;
    private int d;
    
    public a$c(final String a, final String b, final int d) {
        this.d = 0;
        this.a = a;
        this.b = b;
        this.d = d;
    }
    
    protected Boolean a(Void... array) {
        if (this.isCancelled()) {
            return false;
        }
        array = (Void[])(Object)new File(this.b + ".PROCESSING");
        if (((File)(Object)array).exists()) {
            return true;
        }
        ((File)(Object)array).deleteOnExit();
        InputStream inputStream;
        try {
            if (this.isCancelled()) {
                if (((File)(Object)array).exists()) {
                    ((File)(Object)array).delete();
                }
                return false;
            }
            final URLConnection openConnection = new URL(this.a).openConnection();
            openConnection.setConnectTimeout(3000);
            openConnection.setReadTimeout(10000);
            openConnection.connect();
            if (this.isCancelled()) {
                if (((File)(Object)array).exists()) {
                    ((File)(Object)array).delete();
                }
                return false;
            }
            inputStream = openConnection.getInputStream();
            if (inputStream == null) {
                throw new RuntimeException("stream is null");
            }
        }
        catch (Exception ex) {
            Logging.log(Log.getStackTraceString((Throwable)ex));
            if (((File)(Object)array).exists()) {
                ((File)(Object)array).delete();
            }
            return false;
        }
        if (this.isCancelled()) {
            if (((File)(Object)array).exists()) {
                ((File)(Object)array).delete();
            }
            return false;
        }
        if (((File)(Object)array).exists()) {
            return true;
        }
        this.c = new FileOutputStream((File)(Object)array);
        final byte[] array2 = new byte[4096];
        while (!this.isCancelled()) {
            final int read = inputStream.read(array2);
            if (read == -1) {
                break;
            }
            this.c.write(array2, 0, read);
        }
        if (this.isCancelled()) {
            if (((File)(Object)array).exists()) {
                ((File)(Object)array).delete();
            }
            return false;
        }
        final File file = new File(this.b);
        if (file.exists()) {
            file.delete();
        }
        ((File)(Object)array).renameTo(file);
        if (((File)(Object)array).exists()) {
            ((File)(Object)array).delete();
        }
        inputStream.close();
        this.c.flush();
        this.c = null;
        return true;
    }
    
    protected void a(final Boolean b) {
        if (!b && this.d <= 0) {
            if (Version.getAndroidSDKVersion() >= 11) {
                Logging.log("#### onPostExecute");
                new a$c(this.a, this.b, 1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
            }
            else {
                new a$c(this.a, this.b, 1).execute((Object[])new Void[0]);
            }
        }
        super.onPostExecute((Object)b);
    }
    
    protected void onCancelled() {
        final File file = new File(this.b);
        if (file.exists()) {
            file.delete();
        }
        super.onCancelled();
    }
}
