// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import org.apache.http.HttpHost;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URI;

final class bm extends bo
{
    private URI C;
    private String a;
    private String b;
    
    bm(final String s) {
        this(s, "GET");
    }
    
    bm(String a, final String b) {
        super(a);
        this.C = new URI(this.Code[2]);
        if (this.Code[4].length() > 0) {
            a = this.Code[4];
        }
        else {
            a = null;
        }
        this.a = a;
        this.b = b;
    }
    
    private int Code(final Socket socket, final boolean b) {
        final long i = bk.I();
        final PrintStream printStream = new PrintStream(socket.getOutputStream());
        String s;
        if (b) {
            s = this.C.toString();
        }
        else {
            s = this.C.getPath();
        }
        printStream.print(this.b + " " + (s + "?" + System.nanoTime() % 65537L) + " HTTP/1.0\r\nHost: " + this.C.getHost() + "\r\nCache-Control: no-cache\r\nConnection: close\r\n\r\n");
        if (printStream.checkError()) {
            throw new IOException();
        }
        final boolean b2 = !this.b.equals("HEAD");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        while (true) {
            Label_0256: {
                String s2;
                while (true) {
                    final String line2 = bufferedReader.readLine();
                    s2 = line;
                    if (line2 == null) {
                        break;
                    }
                    if (line != null) {
                        this.Z = "Unexpectedly got more than one line of response";
                        s2 = line;
                        break;
                    }
                    if (line2.length() != 0) {
                        continue;
                    }
                    if (!b2) {
                        break Label_0256;
                    }
                    line = bufferedReader.readLine();
                }
                final long j = bk.I();
                if (s2 == null) {
                    this.Z = "No response from server";
                }
                else if (b2 && this.Z == null && this.a != null && !this.a.equals(s2)) {
                    this.Z = "Response \"" + s2.substring(0, Math.min(s2.length(), this.a.length() * 2)) + "\" didn't match \"" + this.a + "\"";
                }
                return (int)(j - i);
            }
            String s2 = "";
            continue;
        }
    }
    
    @Override
    protected final int Code() {
        final HttpHost code = br.Code(bk.Z, this.C);
        String s = this.C.getHost();
        int n = this.C.getPort();
        if (code != null) {
            s = code.getHostName();
            n = code.getPort();
        }
        final Socket socket = new Socket();
        Label_0113: {
            if (n <= 0) {
                break Label_0113;
            }
            try {
                while (true) {
                    socket.connect(new InetSocketAddress(s, n), 3000);
                    socket.setSoTimeout(3000);
                    return this.Code(socket, code != null);
                    n = 80;
                    continue;
                }
            }
            finally {
                if (!socket.isClosed()) {
                    socket.close();
                }
            }
        }
    }
}
