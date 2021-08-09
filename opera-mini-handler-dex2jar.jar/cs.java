import android.os.Looper;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public interface cs
{
    public static final cs Code = new cs() {
        @Override
        public final void Code(final ck ck) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("Event bus " + ck + " accessed from non-main thread " + Looper.myLooper());
            }
        }
    };
    
    void Code(final ck p0);
}
