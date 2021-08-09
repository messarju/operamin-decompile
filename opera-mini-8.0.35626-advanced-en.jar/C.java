import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class C extends Thread
{
    private static int a;
    private String Z;
    private boolean B;
    private String B;
    private String I;
    private int B;
    private int Z;
    private boolean Code;
    private String J;
    private boolean I;
    private int J;
    private a Code;
    private int C;
    private static Object Code;
    private boolean Z;
    private boolean J;
    public int I;
    public int Code;
    public byte[] Code;
    public String Code;
    
    public static void Code(int code) {
        if (a <= C.a) {
            return;
        }
        C.a = a;
        monitorenter(code = (int)C.Code);
        final Object code2 = C.Code;
        try {
            code2.notifyAll();
        }
        finally {
            monitorexit(code);
        }
    }
    
    public final void run() {
        final int n = 110;
        try {
            final Object[] array = new Object[n];
            final int[] array2 = new int[110];
            final Object[] array3 = array;
            final int[] array4 = array2;
            final Object[] array5 = array3;
            if (this.Z == null) {
                this.Z = "";
            }
            array5[64] = this.Z.getBytes();
            array4[65] = (this.I ? 1 : 0);
            array4[29] = ((this.J != null) ? 3 : 1);
            array5[42] = this.J;
            array4[37] = this.J;
            array5[53] = this.I;
            array4[93] = this.C;
            Label_0220: {
                if (this.Code = Code.Code(array, array2, (this.B != 0) ? this.B : Code.Code(this.I, (String)null))) {
                    break Label_0220;
                }
                try {
                    final DataInputStream dataInputStream = new DataInputStream(this.Code);
                    if (this.B) {
                        this.Code(dataInputStream);
                    }
                    else {
                        Code.Code.I();
                        if (this.Code) {
                            Code.Code.Z();
                        }
                        else {
                            Code.a();
                            this.I(8);
                            this.J(dataInputStream);
                        }
                    }
                }
                finally {
                    Code.Code((InputStream)this.Code);
                }
            }
        }
        catch (Exception ex) {
            if (!this.Code) {
                final int n2 = (this.Code != null && this.Code.Z()) ? this.Code.f() : 0;
                String s = null;
                Label_0366: {
                    if (this.Code != null && this.Code.Z()) {
                        switch (this.Code.f()) {
                            case 0: {
                                s = "Unknown error";
                                break Label_0366;
                            }
                            case 1: {
                                s = "Key expired";
                                break Label_0366;
                            }
                            case 2: {
                                s = "Timeout";
                                break Label_0366;
                            }
                        }
                    }
                    final Exception ex2;
                    final String message;
                    s = (((message = (ex2 = ex).getMessage()) != null) ? message : ex2.toString());
                }
                this.Code(n2, s);
            }
        }
        Code.J(this.Z);
        Code.I(this);
    }
    
    private void Code(final DataInputStream dataInputStream) {
        if (dataInputStream.readByte() != 1) {
            this.Code(0, "Unknown version");
            return;
        }
        final int unsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUTF();
        final String utf = dataInputStream.readUTF();
        if (unsignedShort != 200) {
            this.Code(unsignedShort, utf);
            return;
        }
        int unsignedShort2 = dataInputStream.readUnsignedShort();
        while (unsignedShort2-- > 0) {
            final String utf2 = dataInputStream.readUTF();
            final String utf3 = dataInputStream.readUTF();
            final String s = utf2;
            if (s.equals("content-length")) {
                this.Code = Integer.parseInt(utf3);
            }
            else {
                if (!s.equals("update-digest")) {
                    continue;
                }
                this.Code = utf3;
            }
        }
        final byte byte1;
        if ((byte1 = dataInputStream.readByte()) == 0) {
            this.J(dataInputStream);
            return;
        }
        if (byte1 == 6) {
            this.Code(0, dataInputStream.readUTF());
            return;
        }
        this.Code(0, "Bad data");
    }
    
    private void Z(final DataInputStream dataInputStream) {
        final byte[] array = new byte[2048];
        while (!this.Code) {
            final byte[] array2 = array;
            int read;
            try {
                read = dataInputStream.read(array2);
            }
            catch (EOFException ex) {
                read = -1;
            }
            Code.Code.I();
            if (this.Code) {
                Code.Code.Z();
                return;
            }
            if (read <= 0) {
                this.I(10);
                return;
            }
            Code.Code(array, read, read);
            this.I(9);
        }
    }
    
    private C(final String i, final int n) {
        this.I = i;
        this.Z = Code.I(n);
        Code.Code(this);
    }
    
    private void I(final int n) {
        if (this.Z != 0) {
            Code.Code.Code(Code.Z(this.Z), n);
        }
    }
    
    private static String Code(int i) {
        if (i == 0) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        final int code = Code.Code(i);
        Code.Z(i);
        for (i = 0; i < code / 2; ++i) {
            if (sb.length() != 0) {
                sb.append('\n');
            }
            sb.append(Code.Code(Code.Code[Code.Code + (i << 1)]));
            sb.append(':');
            sb.append(Code.Code(Code.Code[Code.Code + (i << 1) + 1]));
        }
        return sb.toString();
    }
    
    private C(final String s, final int n, final String z, final String j, final boolean i, final int c, final int k, final int b) {
        this(s, n);
        this.Z = z;
        this.J = j;
        this.I = i;
        this.J = k;
        this.C = c;
        this.B = b;
    }
    
    public C(final String s, final int n, final int n2, final String s2, final boolean b, final int n3, final int n4) {
        this(s, n, Code(n2), s2, b, n3, n4, 0);
    }
    
    public C(final String s, final int n, final int n2) {
        this(s, n, n2, null, this.B = true, 0, 0);
    }
    
    public final void Code() {
        this.Z = true;
    }
    
    public final void I() {
        if (this.B) {
            if (this.J) {
                this.Code = true;
                return;
            }
            this.Code = true;
            final Object code;
            monitorenter(code = C.Code);
            final Object code2 = C.Code;
            try {
                code2.notifyAll();
                return;
            }
            finally {
                monitorexit(code);
            }
        }
        this.Code = true;
    }
    
    static {
        C.a = Integer.MIN_VALUE;
        C.Code = new Object();
    }
    
    private C(final String s) {
        this.B = true;
        this(s, 0, null, null, this.J = true, 0, 0, 1);
    }
    
    public C(final String s, final String s2) {
        this.B = true;
        this.J = true;
        this(s + "/res/8.0.35626/" + s2);
    }
    
    private void I(final DataInputStream dataInputStream) {
        final byte[] array = new byte[2048];
        while (!this.Code) {
            final int read = dataInputStream.read(array);
            Code.Code.I();
            if (this.Code) {
                Code.Code.Z();
                return;
            }
            if (read < 0) {
                Code.Code.Z();
                break;
            }
            Code.Code(array, read, read);
            this.I(9);
            if (this.Z) {
                break;
            }
        }
        while (!this.Code) {
            Label_0137: {
                if (!this.Code.J()) {
                    final Object code;
                    monitorenter(code = C.Code);
                    final Object code2 = C.Code;
                    try {
                        code2.wait();
                        monitorexit(code);
                        break Label_0137;
                    }
                    finally {
                        monitorexit(code);
                    }
                }
                final int read2;
                if ((read2 = dataInputStream.read()) < 0) {
                    this.Code(504, "Server closed connection");
                    return;
                }
                if (read2 != 0) {
                    continue;
                }
            }
            Code.Code.I();
            if (this.Code) {
                Code.Code.Z();
                return;
            }
            this.I(13);
        }
    }
    
    private void J(final DataInputStream dataInputStream) {
        if (!this.B) {
            this.Z(dataInputStream);
            return;
        }
        if (!this.J) {
            this.I(dataInputStream);
            return;
        }
        if (this.Code > 0) {
            final byte[] array = new byte[1024];
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.Code);
            int read;
            while (this.I < this.Code && (read = dataInputStream.read(array)) >= 0) {
                byteArrayOutputStream.write(array, 0, read);
                this.I += read;
            }
            this.Code = byteArrayOutputStream.toByteArray();
            return;
        }
        if (this.B == null) {
            this.Code(0, "Invalid content length");
        }
    }
    
    private void Code(final int n, final String b) {
        if (this.B) {
            this.B = b;
            this.Code = -1;
            return;
        }
        Code.Code.I();
        if (this.Code) {
            Code.Code.Z();
            return;
        }
        Code.Code(n, (b != null) ? b : "Unspecified error");
        this.I(11);
    }
}
