// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.Proxy;
import java.net.HttpURLConnection;

public final class ay implements ah
{
    private HttpURLConnection Code;
    
    public ay(final String s, final String requestMethod, final Proxy proxy) {
        if (x.ak < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        (this.Code = (HttpURLConnection)new URL(s).openConnection(proxy)).setRequestMethod(requestMethod);
        b$2.m(this.Code);
        this.Code.setDoInput(true);
        this.Code.setInstanceFollowRedirects(false);
        if (!requestMethod.equals("GET")) {
            this.Code.setDoOutput(true);
        }
        this.Code.setConnectTimeout(30000);
    }
    
    @Override
    public final long B() {
        return this.Code.getContentLength();
    }
    
    @Override
    public final String Code(final String s) {
        return this.Code.getHeaderField(s);
    }
    
    @Override
    public final void Code() {
        this.Code.disconnect();
    }
    
    @Override
    public final void Code(final String s, final String s2) {
        try {
            this.Code.setRequestProperty(s, s2);
        }
        catch (IllegalStateException ex) {
            throw new IOException();
        }
    }
    
    @Override
    public final DataOutputStream I() {
        return new DataOutputStream(this.Code.getOutputStream());
    }
    
    @Override
    public final int J() {
        return this.Code.getResponseCode();
    }
    
    @Override
    public final DataInputStream Z() {
        if (this.Code.getResponseCode() >= 400) {
            return new DataInputStream(this.Code.getErrorStream());
        }
        return new DataInputStream(this.Code.getInputStream());
    }
}
