// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.apps.analytics;

import java.net.Socket;
import org.apache.http.HttpRequest;
import org.apache.http.params.HttpParams;
import java.net.InetAddress;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.ProtocolVersion;
import org.apache.http.HttpVersion;
import java.io.IOException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.HttpHost;

final class r
{
    private HttpHost B;
    private SocketFactory C;
    s Code;
    private DefaultHttpClientConnection I;
    private boolean J;
    private int Z;
    
    public r(final HttpHost httpHost) {
        this(httpHost, (SocketFactory)new PlainSocketFactory());
    }
    
    private r(final HttpHost b, final SocketFactory c) {
        this.I = new DefaultHttpClientConnection();
        this.J = true;
        this.B = b;
        this.C = c;
    }
    
    private void Z() {
        if (this.I == null || !this.I.isOpen()) {
            return;
        }
        try {
            this.I.close();
        }
        catch (IOException ex) {}
    }
    
    public final void Code() {
        this.I.flush();
        final HttpConnectionMetrics metrics = this.I.getMetrics();
        while (metrics.getResponseCount() < metrics.getRequestCount()) {
            final HttpResponse receiveResponseHeader = this.I.receiveResponseHeader();
            if (!receiveResponseHeader.getStatusLine().getProtocolVersion().greaterEquals((ProtocolVersion)HttpVersion.HTTP_1_1)) {
                this.Code.Code();
                this.J = false;
            }
            final Header[] headers = receiveResponseHeader.getHeaders("Connection");
            if (headers != null) {
                for (int length = headers.length, i = 0; i < length; ++i) {
                    if ("close".equalsIgnoreCase(headers[i].getValue())) {
                        this.Code.Code();
                        this.J = false;
                    }
                }
            }
            this.Z = receiveResponseHeader.getStatusLine().getStatusCode();
            if (this.Z != 200) {
                this.Code.Code.J = this.Z;
                this.Z();
                break;
            }
            this.I.receiveResponseEntity(receiveResponseHeader);
            receiveResponseHeader.getEntity().consumeContent();
            this.Code.I();
            d.Code();
            d.B();
            if (!this.J) {
                this.Z();
            }
        }
    }
    
    public final void Code(final HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (this.I == null || !this.I.isOpen()) {
            final BasicHttpParams basicHttpParams = new BasicHttpParams();
            final Socket connectSocket = this.C.connectSocket(this.C.createSocket(), this.B.getHostName(), this.B.getPort(), (InetAddress)null, 0, (HttpParams)basicHttpParams);
            connectSocket.setReceiveBufferSize(8192);
            this.I.bind(connectSocket, (HttpParams)basicHttpParams);
        }
        this.I.sendRequestHeader((HttpRequest)httpEntityEnclosingRequest);
        this.I.sendRequestEntity(httpEntityEnclosingRequest);
    }
    
    public final void I() {
        this.Z();
    }
}
