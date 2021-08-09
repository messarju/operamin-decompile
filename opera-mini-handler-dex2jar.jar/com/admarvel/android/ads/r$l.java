// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.content.Intent;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import com.admarvel.android.util.Logging;
import android.util.Log;
import android.graphics.BitmapFactory;
import java.io.File;
import android.os.Environment;
import java.lang.ref.WeakReference;
import android.graphics.Bitmap;
import java.io.InputStream;

class r$l implements Runnable
{
    String a;
    String b;
    InputStream c;
    Bitmap d;
    private final WeakReference e;
    
    public r$l(final d d, final String a, final String b) {
        this.c = null;
        this.d = null;
        this.e = new WeakReference((T)d);
        this.a = a;
        this.b = b;
    }
    
    @TargetApi(14)
    @Override
    public void run() {
        final Object o = this.e.get();
        if (o != null) {
            String string;
            while (true) {
                string = Environment.getExternalStorageDirectory().toString() + "/Pictures/";
                while (true) {
                    Label_0262: {
                        try {
                            if (this.a != null) {
                                if (!this.a.startsWith("/mnt/sdcard")) {
                                    break Label_0262;
                                }
                                if (new File(this.a).exists()) {
                                    this.d = BitmapFactory.decodeFile(this.a);
                                }
                                else {
                                    ((d)o).e(this.b + "(\"NO\")");
                                }
                            }
                            if (this.d == null && this.c != null) {
                                final Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        r$l.this.d = BitmapFactory.decodeStream(r$l.this.c);
                                    }
                                });
                                thread.start();
                                thread.join();
                            }
                            if (this.d == null) {
                                ((d)o).e(this.b + "(\"NO\")");
                                return;
                            }
                            break;
                        }
                        catch (Exception string) {
                            ((d)o).e(this.b + "(\"NO\")");
                            Logging.log(Log.getStackTraceString((Throwable)string));
                            return;
                            iftrue(Label_0350:)(!this.a.startsWith("http:") && !this.a.startsWith("https:"));
                            this.a = r.a(this.a, ((d)o).getContext());
                            final Thread thread2 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        r$l.this.c = new URL(r$l.this.a).openStream();
                                    }
                                    catch (MalformedURLException ex) {
                                        ex.printStackTrace();
                                    }
                                    catch (IOException ex2) {
                                        ex2.printStackTrace();
                                    }
                                    catch (Exception ex3) {
                                        ex3.printStackTrace();
                                    }
                                }
                            });
                            thread2.start();
                            thread2.join();
                            continue;
                        }
                        finally {
                            if (this.d != null) {
                                this.d.recycle();
                                this.d = null;
                            }
                        }
                    }
                    Label_0350: {
                        if (this.a.startsWith("file:///android_asset/")) {
                            this.c = ((d)o).getContext().getAssets().open(this.a.substring(22));
                            continue;
                        }
                    }
                    continue;
                }
            }
            final File file = new File(string);
            if (!file.exists()) {
                file.mkdirs();
            }
            final String string2 = string + System.currentTimeMillis() + ".jpg";
            final FileOutputStream fileOutputStream = new FileOutputStream(string2);
            if (this.d != null) {
                this.d.compress(Bitmap$CompressFormat.JPEG, 90, (OutputStream)fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            final Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(string2)));
            ((d)o).getContext().sendBroadcast(intent);
            ((d)o).e(this.b + "(\"YES\")");
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
        }
    }
}
