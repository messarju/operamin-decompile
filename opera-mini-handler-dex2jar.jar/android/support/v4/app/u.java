// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.app;

import android.os.Bundle;

final class u
{
    static Bundle[] Code(final t[] array) {
        if (array == null) {
            return null;
        }
        final Bundle[] array2 = new Bundle[array.length];
        for (int i = 0; i < array.length; ++i) {
            final t t = array[i];
            final Bundle bundle = new Bundle();
            bundle.putString("resultKey", t.Code());
            bundle.putCharSequence("label", t.I());
            bundle.putCharSequenceArray("choices", t.Z());
            bundle.putBoolean("allowFreeFormInput", t.J());
            bundle.putBundle("extras", t.B());
            array2[i] = bundle;
        }
        return array2;
    }
}
