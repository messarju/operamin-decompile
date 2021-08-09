// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.io.FileInputStream;
import java.net.URLConnection;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class k
{
    private final String a;
    private HttpURLConnection b;
    private String c;
    private OutputStream d;
    private PrintWriter e;
    
    public k(final String s, final String c) {
        this.c = c;
        this.a = "===" + System.currentTimeMillis() + "===";
        (this.b = (HttpURLConnection)new URL(s).openConnection()).setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setConnectTimeout(2000);
        this.b.setReadTimeout(2000);
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.a);
        this.d = this.b.getOutputStream();
        this.e = new PrintWriter(new OutputStreamWriter(this.d, c), true);
    }
    
    public List a() {
        final ArrayList list = new ArrayList();
        this.e.append("\r\n").flush();
        this.e.append("--" + this.a + "--").append("\r\n");
        this.e.close();
        final int responseCode = this.b.getResponseCode();
        if (responseCode == 200) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                list.add(line);
            }
            bufferedReader.close();
            this.b.disconnect();
            return list;
        }
        throw new IOException("Server returned non-OK status: " + responseCode);
    }
    
    public void a(final String s, final File file) {
        final String name = file.getName();
        this.e.append("--" + this.a).append("\r\n");
        this.e.append("Content-Disposition: form-data; name=\"" + s + "\"; filename=\"" + name + "\"").append("\r\n");
        this.e.append("Content-Type: " + URLConnection.guessContentTypeFromName(name)).append("\r\n");
        this.e.append("Content-Transfer-Encoding: binary").append("\r\n");
        this.e.append("\r\n");
        this.e.flush();
        final FileInputStream fileInputStream = new FileInputStream(file);
        final byte[] array = new byte[4096];
        while (true) {
            final int read = fileInputStream.read(array);
            if (read == -1) {
                break;
            }
            this.d.write(array, 0, read);
        }
        this.d.flush();
        fileInputStream.close();
        this.e.append("\r\n");
        this.e.flush();
    }
}
