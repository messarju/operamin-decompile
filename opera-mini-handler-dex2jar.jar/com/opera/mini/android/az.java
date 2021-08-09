// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import android.net.Uri;
import java.net.Socket;

public final class az implements ah
{
    private Socket Code;
    
    public az(final String s) {
        final Uri parse = Uri.parse(s);
        (this.Code = new Socket(parse.getHost(), parse.getPort())).setSoLinger(true, 0);
        this.Code.setSoTimeout(0);
        this.Code.setReceiveBufferSize(65536);
        this.Code.setKeepAlive(true);
    }
    
    @Override
    public final void Code() {
        this.Code.close();
    }
    
    @Override
    public final DataOutputStream I() {
        return new DataOutputStream(this.Code.getOutputStream());
    }
    
    @Override
    public final DataInputStream Z() {
        return new DataInputStream(this.Code.getInputStream());
    }
}
