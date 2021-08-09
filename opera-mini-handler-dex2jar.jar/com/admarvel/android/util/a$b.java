// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.util.Iterator;
import com.admarvel.android.ads.AdFetcher;
import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import android.os.AsyncTask;

public class a$b extends AsyncTask
{
    final /* synthetic */ a a;
    private final String b;
    private final String c;
    
    public a$b(final a a, final String c) {
        this.a = a;
        this.c = c;
        this.b = this.c + ".zip";
    }
    
    protected String a(final Integer... array) {
    Label_0248_Outer:
        while (true) {
            while (true) {
                int n2 = 0;
                int b = 0;
            Label_0761:
                while (true) {
                    Label_0756: {
                        while (true) {
                            Label_0753: {
                                try {
                                    int n = array[0];
                                    final File[] listFiles = this.a.e.listFiles();
                                    if (listFiles == null || listFiles.length == 0) {
                                        break;
                                    }
                                    if (n <= this.a.c) {
                                        break Label_0756;
                                    }
                                    n = this.a.c;
                                    final ArrayList<String> list = new ArrayList<String>();
                                    final ArrayList<File> list2 = new ArrayList<File>();
                                    for (int length = listFiles.length, i = 0; i < length; ++i) {
                                        list2.add(listFiles[i]);
                                    }
                                    final Context context = (Context)com.admarvel.android.util.a.f.get();
                                    final String string = this.a.e.getAbsolutePath() + "/log_";
                                    final String string2 = this.a.e.getAbsolutePath() + "/ss_";
                                    final String string3 = this.a.e.getAbsolutePath() + "/sse_";
                                    final String string4 = this.a.e.getAbsolutePath() + "/ssr_";
                                    if (context != null) {
                                        final int a = this.a.c(context);
                                        n2 = 0;
                                        if (n2 != n) {
                                            if ((b = a) <= 0) {
                                                b = this.a.c;
                                            }
                                            final File file = new File(string + b + ".txt");
                                            if (file.exists()) {
                                                list.add(file.getAbsolutePath());
                                            }
                                            final File file2 = new File(string2 + b + ".jpg");
                                            if (file2.exists()) {
                                                list.add(file2.getAbsolutePath());
                                            }
                                            final File file3 = new File(string3 + b + ".jpg");
                                            if (file3.exists()) {
                                                list.add(file3.getAbsolutePath());
                                            }
                                            final File file4 = new File(string4 + b + ".jpg");
                                            if (file4.exists()) {
                                                list.add(file4.getAbsolutePath());
                                            }
                                            break Label_0761;
                                        }
                                    }
                                    final String[] array2 = new String[list.size()];
                                    final Iterator<String> iterator = list.iterator();
                                    int n3 = 0;
                                    while (iterator.hasNext()) {
                                        array2[n3] = iterator.next();
                                        ++n3;
                                    }
                                    final String string5 = this.a.e.getAbsolutePath() + "/" + this.b;
                                    new g(array2, string5).a();
                                    String s = "http://sdk-rh.admarvel.com/adhistory/upload?" + "platform=android" + "&deviceid=" + OptionalUtils.getId(context);
                                    if (context != null) {
                                        s = s + "&appid=" + context.getPackageName();
                                        this.a.a(s + "&zipguid=" + this.c + "&timestamp=" + System.currentTimeMillis() + AdFetcher.lastAdRequestPostString, string5);
                                        return string5;
                                    }
                                    break Label_0753;
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                    return null;
                                }
                            }
                            continue;
                        }
                    }
                    continue Label_0248_Outer;
                }
                final int a = b - 1;
                ++n2;
                continue;
            }
        }
        return null;
    }
    
    protected void a(final String s) {
        super.onPostExecute((Object)s);
    }
    
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
