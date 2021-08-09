import android.text.ClipboardManager;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class af
{
    private ClipboardManager Code;
    
    public af(final ClipboardManager code) {
        this.Code = code;
    }
    
    public final String Code() {
        return this.Code.getText().toString();
    }
    
    public final void Code(final String text) {
        this.Code.setText((CharSequence)text);
    }
    
    public final boolean I() {
        return this.Code.hasText();
    }
}
