// 
// Decompiled by Procyon v0.6-prerelease
// 

package android.support.v4.content;

import java.util.Set;
import android.net.Uri;
import android.util.Log;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Message;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.os.Handler;

public final class I
{
    private static final Object C;
    private static I a;
    private final Handler B;
    private final Context Code;
    private final HashMap I;
    private final ArrayList J;
    private final HashMap Z;
    
    static {
        C = new Object();
    }
    
    private I(final Context code) {
        this.I = new HashMap();
        this.Z = new HashMap();
        this.J = new ArrayList();
        this.Code = code;
        this.B = new Handler(code.getMainLooper()) {
            public final void handleMessage(final Message message) {
                switch (message.what) {
                    default: {
                        super.handleMessage(message);
                    }
                    case 1: {
                        android.support.v4.content.I.Code(android.support.v4.content.I.this);
                    }
                }
            }
        };
    }
    
    public static I Code(final Context context) {
        synchronized (I.C) {
            if (I.a == null) {
                I.a = new I(context.getApplicationContext());
            }
            return I.a;
        }
    }
    
    static /* synthetic */ void Code(final I i) {
    Label_0049_Outer:
        while (true) {
            Object j = i.I;
            while (true) {
                int size;
                synchronized (j) {
                    size = i.J.size();
                    if (size <= 0) {
                        return;
                    }
                    final Z[] array = new Z[size];
                    i.J.toArray(array);
                    i.J.clear();
                    monitorexit(j);
                    size = 0;
                    if (size >= array.length) {
                        continue Label_0049_Outer;
                    }
                    j = array[size];
                    for (int k = 0; k < ((Z)j).I.size(); ++k) {
                        ((J)((Z)j).I.get(k)).I.onReceive(i.Code, ((Z)j).Code);
                    }
                }
                ++size;
                continue;
            }
        }
    }
    
    public final void Code(final BroadcastReceiver broadcastReceiver) {
        while (true) {
        Label_0054_Outer:
            while (true) {
                ArrayList list;
                ArrayList list2;
                int n = 0;
                int n2 = 0;
                IntentFilter intentFilter;
                int n3 = 0;
                final BroadcastReceiver broadcastReceiver2;
                String action;
                Block_7_Outer:Label_0094_Outer:
                while (true) {
                Label_0179:
                    while (true) {
                        Label_0172: {
                            Label_0167: {
                                synchronized (this.I) {
                                    list = this.I.remove(broadcastReceiver);
                                    if (list == null) {
                                        return;
                                    }
                                    break Label_0167;
                                    Label_0133: {
                                        iftrue(Label_0179:)(list2.size() > 0);
                                    }
                                    Block_9: {
                                        break Block_9;
                                        iftrue(Label_0154:)(n >= list.size());
                                    Block_6:
                                        while (true) {
                                            Block_5: {
                                                Block_4: {
                                                    break Block_4;
                                                    iftrue(Label_0188:)(n2 >= intentFilter.countActions());
                                                    break Block_5;
                                                    Label_0154:
                                                    return;
                                                    iftrue(Label_0164:)(((J)list2.get(n3)).I != broadcastReceiver2);
                                                    list2.remove(n3);
                                                    --n3;
                                                    break Label_0172;
                                                }
                                                intentFilter = (IntentFilter)list.get(n);
                                                n2 = 0;
                                                continue Block_7_Outer;
                                            }
                                            action = intentFilter.getAction(n2);
                                            list2 = (ArrayList)this.Z.get(action);
                                            iftrue(Label_0179:)(list2 == null);
                                            break Block_6;
                                            iftrue(Label_0133:)(n3 >= list2.size());
                                            continue Label_0094_Outer;
                                        }
                                        n3 = 0;
                                        continue;
                                    }
                                    this.Z.remove(action);
                                    break Label_0179;
                                }
                                Label_0164: {
                                    break Label_0172;
                                }
                            }
                            n = 0;
                            continue Label_0054_Outer;
                        }
                        ++n3;
                        continue;
                    }
                    ++n2;
                    continue Label_0094_Outer;
                }
                Label_0188: {
                    ++n;
                }
                continue Label_0054_Outer;
            }
        }
    }
    
    public final void Code(final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter) {
        synchronized (this.I) {
            final J j = new J(intentFilter, broadcastReceiver);
            ArrayList list;
            if ((list = this.I.get(broadcastReceiver)) == null) {
                list = new ArrayList(1);
                this.I.put(broadcastReceiver, list);
            }
            list.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); ++i) {
                final String action = intentFilter.getAction(i);
                ArrayList list2;
                if ((list2 = this.Z.get(action)) == null) {
                    list2 = new ArrayList(1);
                    this.Z.put(action, list2);
                }
                list2.add(j);
            }
        }
    }
    
    public final boolean Code(final Intent intent) {
        while (true) {
            while (true) {
                String action;
                String resolveTypeIfNeeded;
                Uri data;
                String scheme;
                Set categories;
                int n;
                ArrayList list;
                Object o;
                int match;
                ArrayList<J> list2;
                int n2;
                final HashMap hashMap;
                int i;
                Label_0478_Outer:Label_0457_Outer:Label_0419_Outer:
                while (true) {
                Label_0478:
                    while (true) {
                    Label_0155_Outer:
                        while (true) {
                            Label_0485: {
                                while (true) {
                                    Label_0470: {
                                        while (true) {
                                            synchronized (this.I) {
                                                action = intent.getAction();
                                                resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.Code.getContentResolver());
                                                data = intent.getData();
                                                scheme = intent.getScheme();
                                                categories = intent.getCategories();
                                                if ((intent.getFlags() & 0x8) == 0x0) {
                                                    break Label_0485;
                                                }
                                                n = 1;
                                                if (n != 0) {
                                                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                                                }
                                                list = this.Z.get(intent.getAction());
                                                if (list == null) {
                                                    break;
                                                }
                                                if (n != 0) {
                                                    Log.v("LocalBroadcastManager", "Action list: " + list);
                                                }
                                                break Label_0470;
                                                Block_17: {
                                                    while (true) {
                                                    Block_12:
                                                        while (true) {
                                                        Block_16:
                                                            while (true) {
                                                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                                                                break Label_0478;
                                                                Label_0228: {
                                                                    match = ((J)o).Code.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                                                }
                                                                iftrue(Label_0322:)(match < 0);
                                                                Block_15: {
                                                                    break Block_15;
                                                                    iftrue(Label_0467:)(list2 != null);
                                                                    break Block_17;
                                                                }
                                                                iftrue(Label_0285:)(n == 0);
                                                                break Block_16;
                                                                iftrue(Label_0521:)(n2 >= list.size());
                                                                o = list.get(n2);
                                                                iftrue(Label_0205:)(n == 0);
                                                                break Block_12;
                                                                list2.add((J)o);
                                                                ((J)o).Z = true;
                                                                break Label_0478;
                                                                iftrue(Label_0228:)(!((J)o).Z);
                                                                iftrue(Label_0490:)(n == 0);
                                                                continue Label_0478_Outer;
                                                            }
                                                            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                                            continue Label_0155_Outer;
                                                        }
                                                        Log.v("LocalBroadcastManager", "Matching against filter " + ((J)o).Code);
                                                        continue Label_0457_Outer;
                                                    }
                                                }
                                                list2 = new ArrayList<J>();
                                                continue Label_0457_Outer;
                                            }
                                            Label_0322: {
                                                if (n != 0) {
                                                    switch (match) {
                                                        default: {
                                                            o = "unknown reason";
                                                            break;
                                                        }
                                                        case -3: {
                                                            o = "action";
                                                            break;
                                                        }
                                                        case -4: {
                                                            o = "category";
                                                            break;
                                                        }
                                                        case -2: {
                                                            o = "data";
                                                            break;
                                                        }
                                                        case -1: {
                                                            o = "type";
                                                            break;
                                                        }
                                                    }
                                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (String)o);
                                                }
                                            }
                                            break Label_0155_Outer;
                                            Label_0467:
                                            continue Label_0457_Outer;
                                        }
                                    }
                                    list2 = null;
                                    n2 = 0;
                                    continue Label_0457_Outer;
                                    ++n2;
                                    continue Label_0457_Outer;
                                }
                            }
                            n = 0;
                            continue Label_0478_Outer;
                        }
                        continue Label_0478;
                    }
                    while (true) {
                        while (true) {
                            monitorexit(hashMap);
                            return true;
                            this.J.add(new Z(intent, list2));
                            iftrue(Label_0457:)(this.B.hasMessages(1));
                            this.B.sendEmptyMessage(1);
                            continue Label_0419_Outer;
                        }
                        while (i < list2.size()) {
                            list2.get(i).Z = false;
                            ++i;
                        }
                        continue;
                    }
                }
                monitorexit(hashMap);
                return false;
                Label_0521: {
                    if (list2 != null) {
                        i = 0;
                        continue;
                    }
                }
                break;
            }
            continue;
        }
    }
}
