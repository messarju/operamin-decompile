// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.TrustManager;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

class SandboxSSLSocketFactory extends SSLSocketFactory
{
    SSLContext sslContext;
    
    public SandboxSSLSocketFactory(final KeyStore keyStore) {
        super(keyStore);
        (this.sslContext = SSLContext.getInstance("TLS")).init(null, new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] array, final String s) {
                }
                
                @Override
                public void checkServerTrusted(final X509Certificate[] array, final String s) {
                }
                
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            } }, null);
    }
    
    public Socket createSocket() {
        return this.sslContext.getSocketFactory().createSocket();
    }
    
    public Socket createSocket(final Socket socket, final String s, final int n, final boolean b) {
        return this.sslContext.getSocketFactory().createSocket(socket, s, n, b);
    }
}
