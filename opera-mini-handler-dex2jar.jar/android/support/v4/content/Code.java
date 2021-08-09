// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.content;

import android.text.TextUtils;
import java.io.IOException;
import java.io.File;
import android.net.Uri;
import java.util.HashMap;

final class Code
{
    private final HashMap Code;
    
    public Code() {
        this.Code = new HashMap();
    }
    
    public final File Code(Uri uri) {
        final String encodedPath = uri.getEncodedPath();
        final int index = encodedPath.indexOf(47, 1);
        final String decode = Uri.decode(encodedPath.substring(1, index));
        final String decode2 = Uri.decode(encodedPath.substring(index + 1));
        final File file = this.Code.get(decode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        uri = (Uri)new File(file, decode2);
        File canonicalFile;
        try {
            canonicalFile = ((File)uri).getCanonicalFile();
            if (!canonicalFile.getPath().startsWith(file.getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + uri);
        }
        return canonicalFile;
    }
    
    public final void Code(final String s, final File file) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.Code.put(s, file.getCanonicalFile());
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, ex);
        }
    }
}
