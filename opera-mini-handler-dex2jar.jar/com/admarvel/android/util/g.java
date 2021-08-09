// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.util.zip.ZipEntry;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.zip.ZipOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class g
{
    private String[] a;
    private String b;
    
    public g(final String[] a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public void a() {
        ZipOutputStream zipOutputStream;
        while (true) {
            int n = 0;
            while (true) {
                BufferedInputStream bufferedInputStream;
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.b)));
                    final byte[] array = new byte[2048];
                    if (n >= this.a.length) {
                        break;
                    }
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(this.a[n]), 2048);
                    zipOutputStream.putNextEntry(new ZipEntry(this.a[n].substring(this.a[n].lastIndexOf("/") + 1)));
                    while (true) {
                        final int read = bufferedInputStream.read(array, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(array, 0, read);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
                bufferedInputStream.close();
                ++n;
                continue;
            }
        }
        zipOutputStream.close();
    }
}
