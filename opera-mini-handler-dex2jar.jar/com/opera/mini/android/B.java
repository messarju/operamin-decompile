// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.Iterator;
import com.admarvel.android.ads.AdMarvelHttpPost;
import com.admarvel.android.ads.AdMarvelNetworkHandler;

public final class B implements AdMarvelNetworkHandler
{
    @Override
    public final String executeNetworkCall(final AdMarvelHttpPost adMarvelHttpPost) {
        if (adMarvelHttpPost == null || adMarvelHttpPost.getEndpointUrl() == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        if (adMarvelHttpPost.getHttpHeaders() != null) {
            for (final String s : adMarvelHttpPost.getHttpHeaders().keySet()) {
                if (sb.length() != 0) {
                    sb.append('\n');
                }
                sb.append(s);
                sb.append(':');
                sb.append((String)adMarvelHttpPost.getHttpHeaders().get(s));
            }
        }
        final C c = new C(adMarvelHttpPost.getEndpointUrl(), sb.toString(), adMarvelHttpPost.getPostString());
        c.start();
        int n = 200;
        while (n == 0 || (c.J != -1 && c.B == null)) {
            --n;
            cg.Code(50);
        }
        if (c.J == -1 || c.B == null) {
            new StringBuilder("AdMarvelNetworkHandlerImpl.executeNetworkCall fail | ").append(c.C).append(" | contentLength=").append(c.J).append(" | data=").append(c.B);
            return null;
        }
        return new String(c.B);
    }
}
