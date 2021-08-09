// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.content;

import android.database.MatrixCursor;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.webkit.MimeTypeMap;
import android.net.Uri;
import android.content.pm.ProviderInfo;
import android.os.Environment;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import android.content.Context;
import java.util.HashMap;
import java.io.File;
import android.content.ContentProvider;

public class FileProvider extends ContentProvider
{
    private static final String[] Code;
    private static final File I;
    private static HashMap Z;
    private Code J;
    
    static {
        Code = new String[] { "_display_name", "_size" };
        I = new File("/");
        FileProvider.Z = new HashMap();
    }
    
    private static Code Code(final Context context, final String s) {
        final HashMap z = FileProvider.Z;
        monitorenter(z);
        Code code2 = null;
        Label_0293: {
            try {
                Code code = code2 = FileProvider.Z.get(s);
                if (code != null) {
                    break Label_0293;
                }
                try {
                    code = new Code();
                    if (context.getPackageManager().resolveContentProvider(s, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS") == null) {
                        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                    }
                    goto Label_0092;
                }
                catch (IOException ex) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ex);
                }
                catch (XmlPullParserException ex2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)ex2);
                }
            }
            finally {}
            final String s2;
            final Context context2;
            final String s3;
            if ("files-path".equals(s2)) {
                Code(context2.getFilesDir(), s3);
                goto Label_0167;
            }
            if ("cache-path".equals(s2)) {
                Code(context2.getCacheDir(), s3);
                goto Label_0167;
            }
            if ("external-path".equals(s2)) {
                Code(Environment.getExternalStorageDirectory(), s3);
                goto Label_0167;
            }
            goto Label_0167;
        }
        monitorexit(z);
        return code2;
    }
    
    private static File Code(File file, final String... array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            final String s = array[i];
            if (s != null) {
                file = new File(file, s);
            }
        }
        return file;
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.J = Code(context, providerInfo.authority);
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        if (this.J.Code(uri).delete()) {
            return 1;
        }
        return 0;
    }
    
    public String getType(final Uri uri) {
        final File code = this.J.Code(uri);
        final int lastIndex = code.getName().lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(code.getName().substring(lastIndex + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) {
        final File code = this.J.Code(uri);
        int n;
        if ("r".equals(s)) {
            n = 268435456;
        }
        else if ("w".equals(s) || "wt".equals(s)) {
            n = 738197504;
        }
        else if ("wa".equals(s)) {
            n = 704643072;
        }
        else if ("rw".equals(s)) {
            n = 939524096;
        }
        else {
            if (!"rwt".equals(s)) {
                throw new IllegalArgumentException("Invalid mode: " + s);
            }
            n = 1006632960;
        }
        return ParcelFileDescriptor.open(code, n);
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, String[] array2, String s2) {
        final File code = this.J.Code(uri);
        String[] code2 = array;
        if (array == null) {
            code2 = FileProvider.Code;
        }
        array2 = new String[code2.length];
        final Object[] array3 = new Object[code2.length];
        final int length = code2.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            s2 = code2[i];
            if ("_display_name".equals(s2)) {
                array2[n] = "_display_name";
                final int n2 = n + 1;
                array3[n] = code.getName();
                n = n2;
            }
            else if ("_size".equals(s2)) {
                array2[n] = "_size";
                final int n3 = n + 1;
                array3[n] = code.length();
                n = n3;
            }
            ++i;
        }
        final String[] array4 = new String[n];
        System.arraycopy(array2, 0, array4, 0, n);
        final Object[] array5 = new Object[n];
        System.arraycopy(array3, 0, array5, 0, n);
        final MatrixCursor matrixCursor = new MatrixCursor(array4, 1);
        matrixCursor.addRow(array5);
        return (Cursor)matrixCursor;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
}
