// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class cd
{
    private int Code;
    
    public final void Code() {
        synchronized (this) {
            this.Code(0);
        }
    }
    
    public final void Code(final int n) {
        synchronized (this) {
            while (this.Code != 0) {
                cg.Code(this, n);
                if (n > 0) {
                    break;
                }
            }
        }
    }
    
    public final void I() {
        synchronized (this) {
            ++this.Code;
        }
    }
    
    public final void Z() {
        synchronized (this) {
            --this.Code;
            this.notifyAll();
        }
    }
}
