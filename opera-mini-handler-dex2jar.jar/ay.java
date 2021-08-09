import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ay implements Runnable
{
    private String Code;
    
    ay(final String code) {
        this.Code = code;
    }
    
    @Override
    public final void run() {
    Label_0081_Outer:
        while (true) {
            while (true) {
                while (true) {
                    int j;
                    try {
                        final ah code = u.Code.Code(this.Code, null, "GET");
                        if (bx.b) {
                            code.Code("Test-Header", "debug");
                        }
                        cg.Code((InputStream)code.Z());
                        j = code.J();
                        if (j >= 301) {
                            if (j <= 303) {
                                this.Code = code.Code("Location");
                                this.run();
                                code.Code();
                                return;
                            }
                        }
                    }
                    catch (Throwable t) {
                        return;
                    }
                    if (j == 307) {
                        continue Label_0081_Outer;
                    }
                    break;
                }
                continue;
            }
        }
    }
}
