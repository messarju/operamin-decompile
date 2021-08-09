import java.util.List;
import java.util.Map;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import android.os.Binder;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class a extends Binder implements C
{
    public static C Code(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if (queryLocalInterface != null && queryLocalInterface instanceof C) {
            return (C)queryLocalInterface;
        }
        return new d(binder);
    }
    
    public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) {
        switch (n) {
            default: {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                this.Code(parcel.readHashMap(this.getClass().getClassLoader()), parcel.readLong(), parcel.readString(), parcel.createTypedArrayList(B.Code));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                this.Code();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
