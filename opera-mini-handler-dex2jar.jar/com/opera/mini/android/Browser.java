// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import java.util.ArrayList;
import com.opera.mini.android.notifications.o;
import com.opera.mini.android.events.ActivityResumeEvent;
import com.opera.mini.android.notifications.g;
import com.opera.mini.android.notifications.q;
import com.opera.mini.android.events.ActivityPausedEvent;
import android.view.MenuItem;
import com.opera.mini.android.events.ActivityDestroyEvent;
import android.view.Menu;
import java.io.Serializable;
import android.content.pm.PackageManager$NameNotFoundException;
import com.opera.mini.android.events.EventDispatcher;
import com.opera.mini.android.events.ActivityCreateEvent;
import android.os.Build;
import java.util.HashSet;
import android.app.Activity;
import java.io.File;
import android.os.Environment;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.content.SharedPreferences$Editor;
import android.view.WindowManager$LayoutParams;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MenuItem$OnMenuItemClickListener;

public class Browser extends TrackedActivity implements MenuItem$OnMenuItemClickListener
{
    static a Code;
    static J I;
    public static Browser Z;
    private static boolean i;
    private Configuration B;
    private Intent C;
    protected boolean J;
    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    
    static {
        Browser.i = false;
    }
    
    public Browser() {
        this.a = -1;
        this.b = -1;
        this.J = false;
        this.f = false;
        this.h = false;
    }
    
    private void Code(final Runnable runnable) {
        new Thread() {
            @Override
            public final void run() {
                while (!Browser.Code.C || !Browser.this.J || !MiniView.Code.b()) {
                    cg.Code(200);
                }
                runnable.run();
            }
        }.start();
    }
    
    private boolean Code(final Configuration configuration) {
        boolean b = false;
        final boolean b2 = true;
        switch (configuration.orientation) {
            default: {
                return false;
            }
            case 2: {
                if (!this.d) {
                    b = true;
                }
                this.d = true;
                return b;
            }
            case 1: {
                final boolean b3 = this.d && b2;
                this.d = false;
                return b3;
            }
        }
    }
    
    private void I(final String s) {
        if (s == null) {
            return;
        }
        this.Code(new Runnable() {
            @Override
            public final void run() {
                u.I.h();
                u.Z.b(u.Z.Code(s));
                u.I.Z(3);
            }
        });
    }
    
    private boolean I(final Configuration configuration) {
        boolean b = false;
        final boolean b2 = true;
        switch (configuration.hardKeyboardHidden) {
            default: {
                return false;
            }
            case 2: {
                final boolean b3 = this.e && b2;
                this.e = false;
                return b3;
            }
            case 1: {
                if (!this.e) {
                    b = true;
                }
                this.e = true;
                return b;
            }
        }
    }
    
    private native void d();
    
    private void e() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
        alertDialog$Builder.setMessage(2130968578);
        alertDialog$Builder.setCancelable(false);
        alertDialog$Builder.setNeutralButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public final void onClick(final DialogInterface dialogInterface, final int n) {
                System.exit(0);
            }
        });
        alertDialog$Builder.create().show();
    }
    
    public final boolean B() {
        return this.d;
    }
    
    public final boolean C() {
        boolean b = false;
        if (this.B != null) {
            if (this.B.keyboard != 2) {
                b = b;
                if (this.B.keyboard != 3) {
                    return b;
                }
            }
            b = true;
        }
        return b;
    }
    
    public native void Code();
    
    public final void Code(final String s) {
        if (s == null) {
            return;
        }
        this.Code(new Runnable() {
            @Override
            public final void run() {
                u.I.h();
                u.Z.b(u.Z.Code(s));
                u.Z.c(0);
                u.Z.c(0);
                u.I.Z(2);
            }
        });
    }
    
    protected final void Code(final boolean b) {
        final WindowManager$LayoutParams attributes = this.getWindow().getAttributes();
        final int flags = attributes.flags;
        if (com.opera.mini.android.J.aw() & b) {
            attributes.flags |= 0x400;
        }
        else {
            attributes.flags &= 0xFFFFFBFF;
        }
        if (flags != attributes.flags) {
            this.getWindow().setAttributes(attributes);
        }
    }
    
    public final void I() {
        if (this.b != this.a) {
            final SharedPreferences$Editor edit = this.getPreferences(0).edit();
            edit.putInt("previousVersion", this.b);
            edit.commit();
        }
    }
    
    final boolean J() {
        return this.f;
    }
    
    public final boolean Z() {
        final ConnectivityManager connectivityManager = (ConnectivityManager)this.getSystemService("connectivity");
        return !this.h || connectivityManager.getBackgroundDataSetting();
    }
    
    public final boolean a() {
        return this.e;
    }
    
    public final boolean b() {
        return this.getPreferences(0).getBoolean("isFirstRun", true) && this.a == -1;
    }
    
    public final boolean c() {
        return this.b != this.a;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == bw.Code() && n2 == -1) {
            bw.Code(intent);
        }
        super.onActivityResult(n, n2, intent);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        final int n = 0;
        super.onConfigurationChanged(configuration);
        if (!this.g) {
            this.B = new Configuration(configuration);
            if (this.I(this.B) && Browser.Code.C) {
                u.I.h();
                final p z = u.Z;
                int n2;
                if (this.e) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                z.c(n2);
                u.I.Z(47);
            }
            if (this.Code(this.B) && Browser.Code.C) {
                u.I.h();
                final p z2 = u.Z;
                int n3 = n;
                if (this.d) {
                    n3 = 1;
                }
                z2.c(n3);
                u.I.Z(59);
            }
            if (MiniView.Code.f() && com.opera.mini.android.J.Code != null) {
                com.opera.mini.android.J.Code.requestFocus();
                com.opera.mini.android.J.B(true);
            }
        }
    }
    
    public void onCreate(Bundle applicationContext) {
        final boolean b = true;
        super.onCreate((Bundle)applicationContext);
        System.setProperty("http.keepAlive", "false");
        if (Browser.Z != null) {
            this.finish();
            return;
        }
        File file;
        long a;
        Serializable s;
        Browser z;
        boolean b2;
        int n;
        Label_0528_Outer:Label_0546_Outer:
        while (true) {
            Browser.Z = this;
            while (true) {
            Label_0546:
                while (true) {
                    while (true) {
                    Label_0656:
                        while (true) {
                            try {
                                this.b = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionCode;
                                this.a = this.getPreferences(0).getInt("previousVersion", -1);
                                file = this.getFilesDir();
                                if (file == null) {
                                    file = Environment.getDataDirectory();
                                }
                                a = com.opera.mini.android.d.a(file.getAbsolutePath());
                                if (this.b() && a < 1024000L) {
                                    this.g = true;
                                    this.e();
                                    return;
                                }
                                if (applicationContext != null && ((Bundle)applicationContext).getBoolean("com.opera.mini.android.IGNORE_ALREADY_HANDLED_START_INTENT", false)) {
                                    this.c = true;
                                }
                                x.Code(this);
                                applicationContext = (Throwable)this.getApplicationContext();
                                if (!Browser.i && Browser.Z != null) {
                                    while (true) {
                                        applicationContext = (Throwable)new File(x.Z((Context)applicationContext), System.mapLibraryName("om"));
                                        s = new File(Browser.Z.getFilesDir(), System.mapLibraryName("om"));
                                        while (true) {
                                            try {
                                                if (!((File)applicationContext).exists() && !((File)s).exists()) {
                                                    z = Browser.Z;
                                                    switch (Browser$6.Code[x.Code(x.I((Context)Browser.Z).sourceDir, "lib/" + "armeabi" + "/" + System.mapLibraryName("om"), (File)s).ordinal()]) {
                                                        case 1: {
                                                            if (x.ak >= 9) {
                                                                aj.Code((File)s, true, false);
                                                                aj.I((File)s, true, false);
                                                                aj.Z((File)s, true, true);
                                                            }
                                                            break Label_0546;
                                                        }
                                                        case 2: {
                                                            z.g = true;
                                                            z.e();
                                                        }
                                                        default: {
                                                            break Label_0656;
                                                        }
                                                    }
                                                }
                                                else if (((File)applicationContext).exists()) {
                                                    System.load(((File)applicationContext).getPath());
                                                    Browser.i = true;
                                                    if (!Browser.i) {
                                                        System.loadLibrary("om");
                                                    }
                                                    Browser.i = true;
                                                    break;
                                                }
                                            }
                                            catch (Throwable applicationContext) {
                                                continue Label_0546;
                                            }
                                            applicationContext = (Throwable)s;
                                            continue Label_0546_Outer;
                                        }
                                    }
                                }
                                this.d();
                                bw.Code(this);
                                this.Code(this.B = new Configuration(this.getResources().getConfiguration()));
                                this.I(this.B);
                                this.setContentView(2130903040);
                                this.Code(true);
                                applicationContext = (Throwable)(Browser.I = new J(this, this.getAssets()));
                                Browser.Code = new a((bn)applicationContext);
                                u.Code.Q();
                                cg.z = (!new HashSet() {
                                    {
                                        this.add("LogicPD Zoom2");
                                    }
                                }.contains(Build.MODEL) && (!Browser.Code.k() || x.ak <= 10 || x.ak >= 16));
                                if (Browser.Code.k()) {
                                    b2 = b;
                                }
                                else {
                                    b2 = b;
                                    if (this.getResources().getConfiguration().touchscreen == 1) {
                                        b2 = false;
                                    }
                                }
                                cg.I = b2;
                                cg.Code = b2;
                                if (x.ak >= 14 && Browser.Z != null) {
                                    af.Code(Browser.Z);
                                }
                                this.C = this.getIntent();
                                if (x.s()) {
                                    as.Code(this.getApplicationContext());
                                }
                                aq.I();
                                EventDispatcher.Code(new ActivityCreateEvent(this));
                                return;
                            }
                            catch (PackageManager$NameNotFoundException ex) {
                                continue Label_0528_Outer;
                            }
                            break;
                        }
                        n = 0;
                        if (n != 0) {
                            continue Label_0546_Outer;
                        }
                        break;
                    }
                    continue Label_0546;
                }
                n = 1;
                continue;
            }
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        menu.add((CharSequence)new String(new byte[] { 72, 97, 110, 100, 108, 101, 114, 32, 77, 101, 110, 117 })).setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this);
        return super.onCreateOptionsMenu(menu);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.f = true;
        EventDispatcher.Code(new ActivityDestroyEvent(this));
        if (u.I != null && !u.Code.p()) {
            u.I.h();
            u.I.Z(52);
        }
        MiniView.Code.C();
        ((ar)bs.Code).Code();
        u.Code.R();
        System.exit(0);
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        if (menuItem.getTitle().equals(new String(new byte[] { 72, 97, 110, 100, 108, 101, 114, 32, 77, 101, 110, 117 }))) {
            b$2.o(this.getClass());
        }
        return true;
    }
    
    protected void onNewIntent(final Intent c) {
        this.c = false;
        this.C = c;
    }
    
    protected void onPause() {
        super.onPause();
        if (this.g) {
            return;
        }
        MiniView.Code.Z();
        this.h = true;
        if (!this.Z()) {
            bx.I();
        }
        EventDispatcher.Code(new ActivityPausedEvent(this));
    }
    
    protected void onRestart() {
        super.onRestart();
        if (!this.g && Browser.Code.C) {
            u.I.h();
            u.I.Z(79);
        }
    }
    
    protected void onResume() {
        final int n = 1;
        super.onResume();
        if (this.g) {
            return;
        }
        MiniView.Code.J();
        this.h = false;
        if (this.C != null) {
            final Intent c = this.C;
            Label_0055: {
                if ((c.getFlags() & 0x100000) == 0x0 && !this.c) {
                    final String action = c.getAction();
                    int n2;
                    if (x.ak >= 9 && ak.Code(action)) {
                        n2 = 1;
                    }
                    else {
                        n2 = 0;
                    }
                    if (n2 != 0) {
                        if (x.ak >= 9 && Browser.Z != null) {
                            final String code = ak.Code(c);
                            if (code != null) {
                                Browser.Z.I(code);
                            }
                        }
                    }
                    else {
                        if (x.al) {
                            if (q.Code(c)) {
                                break Label_0055;
                            }
                            final String action2 = c.getAction();
                            int n3;
                            if (action2 == null || !action2.startsWith("com.opera.mini.android.ACTION_NOTIFICATION:")) {
                                n3 = 0;
                            }
                            else {
                                final o code2 = com.opera.mini.android.notifications.g.Code((Context)this).Code(action2.split(":")[1]);
                                if (code2 == null) {
                                    n3 = 0;
                                }
                                else {
                                    code2.a();
                                    n3 = n;
                                }
                            }
                            if (n3 != 0) {
                                break Label_0055;
                            }
                        }
                        if ("android.speech.action.VOICE_SEARCH_RESULTS".equals(c.getAction())) {
                            final ArrayList stringArrayListExtra = c.getStringArrayListExtra("android.speech.extras.VOICE_SEARCH_RESULT_URLS");
                            if (stringArrayListExtra != null && stringArrayListExtra.get(0) != null) {
                                this.I((String)stringArrayListExtra.get(0));
                                break Label_0055;
                            }
                        }
                        final String dataString = c.getDataString();
                        if (dataString != null) {
                            String substring = dataString;
                            if (dataString.startsWith("operamini:")) {
                                substring = dataString.substring(10);
                            }
                            if (substring.length() > 0) {
                                this.I(substring);
                            }
                        }
                    }
                }
            }
            this.C = null;
        }
        EventDispatcher.Code(new ActivityResumeEvent(this));
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        bundle.putBoolean("com.opera.mini.android.IGNORE_ALREADY_HANDLED_START_INTENT", true);
    }
    
    public boolean onSearchRequested() {
        return false;
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        if (this.g) {
            return;
        }
        this.J = true;
        Browser.Code.A();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        if (this.g) {
            return;
        }
        while (true) {
            try {
                if (Browser.Code.C && cg.D && !u.Code.p()) {
                    Browser.Code.h();
                    Browser.Code.Code(false);
                    Browser.Code.Z(78);
                }
                bw.B();
                MiniView.Code.B();
                this.J = false;
            }
            catch (Throwable t) {
                continue;
            }
            break;
        }
    }
    
    public void onWindowFocusChanged(final boolean b) {
        if (this.g || u.Code.p()) {
            return;
        }
        u.I.I(b);
    }
}
