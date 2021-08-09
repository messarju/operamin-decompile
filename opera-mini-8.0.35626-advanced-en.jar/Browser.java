import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class Browser extends MIDlet
{
    private static boolean I;
    private boolean Code;
    
    protected void destroyApp(final boolean b) {
        Browser.I = false;
    }
    
    protected void pauseApp() {
        this.Code = true;
    }
    
    protected void startApp() {
        Code.Code = Display.getDisplay((MIDlet)this);
        Code.Code = this;
        Code.B(Code.Code.numColors());
        if (this.Code) {
            this.Code = false;
            return;
        }
        if (Browser.I) {
            return;
        }
        Browser.I = true;
        Code.B();
        final Code i = Code.I();
        new Code(0, false);
        new Code(i, (short)0).Code();
    }
    
    public final void Code() {
        this.destroyApp(false);
        this.notifyDestroyed();
    }
}
