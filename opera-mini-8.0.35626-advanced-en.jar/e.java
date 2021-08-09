import javax.microedition.io.Connection;
import javax.microedition.io.file.FileSystemRegistry;
import java.util.Enumeration;
import java.io.DataOutputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemListener;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class e implements J, FileSystemListener
{
    public final String Code(final Code code, final String s) {
        return this.Z(this.Z(s));
    }
    
    public static void Code(final FileConnection fileConnection) {
        I(fileConnection);
    }
    
    public final byte[] Code(final String s) {
        FileConnection code = null;
        DataInputStream openDataInputStream = null;
        try {
            openDataInputStream = (code = Code(s)).openDataInputStream();
            final byte[] array = new byte[4];
            int n = 0;
            while ((n += openDataInputStream.read(array, n, 4 - n)) < 4) {}
            if (Code.Code(array, 0) != 47404304) {
                return null;
            }
            for (int i = 0; i < 3; ++i) {
                array[i] = openDataInputStream.readByte();
            }
            final int j;
            final byte[] array2 = new byte[j = Code.I(array, 0)];
            for (int k = 0; k < j; k += openDataInputStream.read(array2, k, Math.min(1024, j - k))) {}
            return array2;
        }
        catch (IOException ex) {
            return null;
        }
        finally {
            Code.Code((InputStream)openDataInputStream);
            I(code);
        }
    }
    
    public final boolean Z(final String s) {
        FileConnection fileConnection = null;
        final String i = Code.I(s);
        final int n = 1;
        try {
            final boolean exists = (fileConnection = (FileConnection)Connector.open(i, n)).exists();
            I(fileConnection);
            return exists;
        }
        finally {
            I(fileConnection);
            return false;
        }
    }
    
    public final Code Code(String i, final boolean b, int n) {
        i = Code.I(i);
        if ((n & 0x1) != 0x0 && (n & 0x2) != 0x0) {
            n = 3;
        }
        else if ((n & 0x2) != 0x0) {
            n = 2;
        }
        else {
            n = 1;
        }
        final FileConnection fileConnection = (FileConnection)Connector.open(i, n);
        if (b && !fileConnection.exists()) {
            fileConnection.create();
        }
        return new Code(fileConnection);
    }
    
    public final int Code(final byte[] array, final String s) {
        FileConnection fileConnection = null;
        DataOutputStream openDataOutputStream = null;
        String i = null;
        if (array == null) {
            return 0;
        }
        try {
            final FileConnection fileConnection2 = fileConnection = (FileConnection)Connector.open(i = Code.I(s), 2);
            try {
                fileConnection2.create();
            }
            catch (IOException ex) {
                i = null;
                throw ex;
            }
            (openDataOutputStream = fileConnection.openDataOutputStream()).writeInt(47404304);
            openDataOutputStream.writeByte(array.length >> 16);
            openDataOutputStream.writeShort(array.length);
            int n;
            for (int j = 0; j < array.length; j += n) {
                final int n2;
                n = (((n2 = array.length - j) >= 16384) ? 16384 : n2);
                openDataOutputStream.write(array, j, n);
            }
            openDataOutputStream.flush();
            return 0;
        }
        finally {
            try {
                final Object o;
                if (o instanceof SecurityException) {
                    return 2;
                }
                Code.Code((OutputStream)openDataOutputStream);
                I(fileConnection);
                this.Code(i);
                return 1;
            }
            finally {
                Code.Code((OutputStream)openDataOutputStream);
                I(fileConnection);
            }
        }
    }
    
    public final boolean Code(String i) {
        i = Code.I(i);
        FileConnection fileConnection = null;
        Label_0033: {
            if (i == null) {
                break Label_0033;
            }
            final String s = i;
            try {
                if (s.length() > 0) {
                    (fileConnection = (FileConnection)Connector.open(i, 2)).delete();
                }
                I(fileConnection);
                return true;
            }
            finally {
                I(fileConnection);
                return false;
            }
        }
    }
    
    public final boolean I(String i) {
        i = Code.I(i);
        FileConnection fileConnection = null;
        final String s = i;
        final int n = 2;
        try {
            (fileConnection = (FileConnection)Connector.open(s, n)).mkdir();
            return true;
        }
        catch (Exception ex) {
            final FileConnection fileConnection2 = fileConnection;
            try {
                I(fileConnection2);
                if ((fileConnection = (FileConnection)Connector.open(i, 1)).exists() && fileConnection.isDirectory()) {
                    return true;
                }
            }
            catch (Exception ex2) {}
            return false;
        }
        finally {
            I(fileConnection);
        }
    }
    
    public final long I(final String s) {
        FileConnection fileConnection = null;
        final int n = 1;
        try {
            final long availableSize = (fileConnection = (FileConnection)Connector.open(s, n)).availableSize();
            I(fileConnection);
            return availableSize;
        }
        finally {
            I(fileConnection);
            return -1L;
        }
    }
    
    private static FileConnection Code(final String s) {
        final String i = Code.I(s);
        final int n = 1;
        try {
            return (FileConnection)Connector.open(i, n);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private static void I(final FileConnection fileConnection) {
        try {
            ((Connection)fileConnection).close();
        }
        finally {}
    }
    
    public final long Code(String i) {
        i = Code.I(i);
        FileConnection fileConnection = null;
        final String s = i;
        final int n = 1;
        try {
            return (fileConnection = (FileConnection)Connector.open(s, n)).fileSize();
        }
        catch (Exception ex) {}
        finally {
            I(fileConnection);
        }
        return -1L;
    }
    
    public final String J() {
        final String property = System.getProperty("fileconn.dir.private");
        if ("null".equals(property)) {
            return null;
        }
        return property;
    }
    
    public final String Z(final int n) {
        String s = null;
        switch (n) {
            case 0: {
                s = "fileconn.dir.photos";
                break;
            }
            case 1: {
                s = "fileconn.dir.videos";
                break;
            }
            case 2: {
                s = "fileconn.dir.tones";
                break;
            }
            case 3: {
                s = "fileconn.dir.music";
                break;
            }
            default: {
                return null;
            }
        }
        final String property;
        if ((property = System.getProperty(s)) == null || property.equals("null")) {
            return null;
        }
        return property;
    }
    
    public final int Z(final String s) {
        if (s.startsWith("image")) {
            return 0;
        }
        if (s.startsWith("video")) {
            return 1;
        }
        if (s.startsWith("audio")) {
            return 3;
        }
        return 5;
    }
    
    public final int[] Code() {
        FileConnection fileConnection = null;
        final Code i = Code.I;
        try {
            fileConnection = (FileConnection)Connector.open(i.Z(), 1);
            int n = 0;
            final Enumeration list = fileConnection.list("*.obml*", true);
            while (list.hasMoreElements()) {
                final String s;
                final int j = Code.J(s = list.nextElement());
                final int b = Code.B(s);
                if (j != 0 && b != 0) {
                    n += 2;
                }
            }
            final int[] array = new int[n];
            final Enumeration list2 = fileConnection.list("*.obml*", true);
            while (list2.hasMoreElements()) {
                final String s2;
                final int k = Code.J(s2 = list2.nextElement());
                final int b2 = Code.B(s2);
                if (k != 0 && b2 != 0) {
                    array[--n] = k;
                    array[--n] = b2;
                }
            }
            return array;
        }
        catch (IOException ex) {
            return new int[0];
        }
        finally {
            I(fileConnection);
        }
    }
    
    public final void b() {
        final Code code = new Code(System.getProperty("fileconn.dir.roots.names"), (byte)0);
        final Enumeration listRoots = FileSystemRegistry.listRoots();
        while (listRoots.hasMoreElements()) {
            final String s = listRoots.nextElement();
            String code2;
            if ((code2 = code.Code()) == null || code2.length() == 0) {
                code2 = s;
            }
            if (Code.I.Code(s) == null) {
                Code.I.I(code2, s);
            }
        }
    }
    
    public void rootChanged(final int n, final String s) {
        final Code code = Code.I.Code(s);
        if (n == 0) {
            if (code == null) {
                final Code i = Code.I;
                final Code code2 = new Code(System.getProperty("fileconn.dir.roots.names"), (byte)0);
                final Enumeration listRoots = FileSystemRegistry.listRoots();
                while (true) {
                    while (listRoots.hasMoreElements()) {
                        final String s2 = listRoots.nextElement();
                        if (code2.Z()) {
                            final String code3 = code2.Code();
                            if (s2.equals(s)) {
                                final String s3 = code3;
                                i.I(s3, s);
                                Code.I.Code(s);
                                return;
                            }
                            continue;
                        }
                    }
                    final String s3 = null;
                    continue;
                }
            }
        }
        else if (n == 1) {
            Code.I.Code(s);
        }
    }
}
