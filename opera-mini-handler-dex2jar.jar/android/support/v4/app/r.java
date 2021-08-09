// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.app.RemoteInput$Builder;
import android.app.RemoteInput;

final class r
{
    static RemoteInput[] Code(final t[] array) {
        if (array == null) {
            return null;
        }
        final RemoteInput[] array2 = new RemoteInput[array.length];
        for (int i = 0; i < array.length; ++i) {
            final t t = array[i];
            array2[i] = new RemoteInput$Builder(t.Code()).setLabel(t.I()).setChoices(t.Z()).setAllowFreeFormInput(t.J()).addExtras(t.B()).build();
        }
        return array2;
    }
}
