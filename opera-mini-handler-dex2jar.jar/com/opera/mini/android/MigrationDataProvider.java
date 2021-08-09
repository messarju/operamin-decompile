// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.database.Cursor;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import android.content.pm.ApplicationInfo;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Binder;
import android.database.MatrixCursor;
import java.io.File;
import android.content.ContentProvider;

public class MigrationDataProvider extends ContentProvider
{
    private File Code;
    
    private void Code(final File file, final File file2, final MatrixCursor matrixCursor) {
        if (file2.isDirectory()) {
            final File[] listFiles = file2.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                final File file3 = listFiles[i];
                if (file3.isDirectory()) {
                    this.Code(file, file3, matrixCursor);
                }
                else {
                    matrixCursor.addRow(new Object[] { file.toURI().relativize(file3.toURI()).getPath() });
                }
            }
        }
    }
    
    private boolean Code() {
        final String[] packagesForUid = this.getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
        return packagesForUid != null && packagesForUid.length != 0 && x.Code(this.getContext(), packagesForUid[0], "02354719964C6843335C4E132F2FA87509F36C9F");
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        throw new UnsupportedOperationException();
    }
    
    public String getType(final Uri uri) {
        throw new UnsupportedOperationException();
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }
    
    public boolean onCreate() {
        if (this.Code == null) {
            final ApplicationInfo i = x.I(this.getContext());
            if (i == null) {
                return false;
            }
            this.Code = new File(i.dataDir);
        }
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) {
        final File file = new File(this.Code, uri.getPath());
        if (!this.Code() || !"r".equals(s)) {
            throw new SecurityException();
        }
        if (!file.exists()) {
            throw new FileNotFoundException(uri.getPath());
        }
        return ParcelFileDescriptor.open(file, 268435456);
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        if (!this.Code()) {
            throw new SecurityException();
        }
        if (array != null || s != null || array2 != null || s2 != null) {
            throw new IllegalArgumentException("projection, selection, selectionArgs and sortOrder not supported");
        }
        final String replaceAll = uri.getPath().replaceAll("/", "");
        if ("Branding".equals(replaceAll)) {
            final MatrixCursor matrixCursor = new MatrixCursor(new String[] { "Branding" }, 1);
            matrixCursor.addRow(new Object[] { x.Code(this.getContext()) });
            return (Cursor)matrixCursor;
        }
        if ("DataDir".equals(replaceAll)) {
            final String fragment = uri.getFragment();
            File code;
            if (fragment == null) {
                code = this.Code;
            }
            else {
                code = new File(this.Code, fragment);
            }
            final MatrixCursor matrixCursor2 = new MatrixCursor(new String[] { "Path" }, 1);
            this.Code(code, code, matrixCursor2);
            return (Cursor)matrixCursor2;
        }
        throw new IllegalArgumentException("uri.getPath() should return 'Branding' or 'DataDir'");
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException();
    }
}
