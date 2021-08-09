import java.util.List;
import java.util.Map;
import android.os.Parcel;
import android.os.IBinder;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class d implements C
{
    private IBinder Code;
    
    d(final IBinder code) {
        this.Code = code;
    }
    
    @Override
    public final void Code() {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.Code.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    @Override
    public final void Code(final Map map, final long n, final String s, final List list) {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            obtain.writeMap(map);
            obtain.writeLong(n);
            obtain.writeString(s);
            obtain.writeTypedList(list);
            this.Code.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
    
    public final IBinder asBinder() {
        return this.Code;
    }
}
