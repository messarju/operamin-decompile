// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.Intent;
import android.os.h;
import android.widget.Toast;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;
import android.view.Menu;
import android.view.View$OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.ScrollView;
import android.os.Bundle;
import android.app.Activity;

public class xy extends Activity
{
    static Activity AppAct;
    static Bundle AppBun;
    public static b$2 H1;
    public static xy H2;
    ml ml1;
    
    public xy() {
        this.ml1 = new ml();
    }
    
    public void aa() {
        if (b$2.m != null) {
            xy.H1.u();
            return;
        }
        final b$2 h1 = xy.H1;
        try {
            h1.t(Class.forName("com.opera.mini.android.Browser"));
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    @Override
    public void onCreate(Bundle contentView) {
        super.onCreate(contentView);
        xy.H2 = this;
        contentView = (Bundle)new ScrollView((Context)this);
        final LinearLayout linearLayout = new LinearLayout((Context)this);
        linearLayout.setOrientation(1);
        ((ScrollView)contentView).addView((View)linearLayout);
        final byte[] array = { 68, 122, 101, 98, 98, 32, 72, 97, 110, 100, 108, 101, 114 };
        final String text = new String(array);
        final TextView textView = new TextView((Context)this);
        textView.setText((CharSequence)text);
        textView.setGravity(17);
        linearLayout.addView((View)textView);
        if (this.getIntent().getBooleanExtra(text, false)) {
            this.finish();
            System.gc();
            System.exit(0);
        }
        final String s = b$2.h[b$2.j + 3];
        if (s == null || !s.equals("0")) {
            this.requestWindowFeature(1);
            this.getWindow().setFlags(1024, 1024);
        }
        for (int i = 0; i < xy.H1.q.length; ++i) {
            if (array.length == 13) {
                if (b$2.i.charAt(i) == '0') {
                    final CheckBox checkBox = new CheckBox((Context)this);
                    checkBox.setText((CharSequence)xy.H1.q[i]);
                    checkBox.setId(i);
                    checkBox.setChecked(b$2.h[i].equals("1"));
                    linearLayout.addView((View)checkBox, -1);
                }
                else {
                    final TextView textView2 = new TextView((Context)this);
                    textView2.setText((CharSequence)xy.H1.q[i]);
                    linearLayout.addView((View)textView2);
                }
                switch (b$2.i.charAt(i)) {
                    case '1': {
                        final Spinner spinner = new Spinner((Context)this);
                        spinner.setId(i);
                        spinner.setAdapter((SpinnerAdapter)new ArrayAdapter((Context)this, 17367050, (Object[])new String[] { "No Proxy", "HTTP", "Host", "Real Host" }));
                        int int1 = 0;
                        while (true) {
                            try {
                                if (b$2.h[i].length() != 0) {
                                    int1 = Integer.parseInt(b$2.h[i]);
                                }
                                spinner.setSelection(int1);
                                linearLayout.addView((View)spinner);
                                break;
                            }
                            catch (NumberFormatException ex) {
                                int1 = int1;
                                continue;
                            }
                            break;
                        }
                    }
                    case '2': {
                        final EditText editText = new EditText((Context)this);
                        editText.setText((CharSequence)b$2.h[i]);
                        editText.setId(i);
                        linearLayout.addView((View)editText);
                        break;
                    }
                }
            }
        }
        if (68 != array[0]) {
            this.moveTaskToBack(true);
        }
        final Button button = new Button((Context)this);
        button.setText((CharSequence)"Save");
        button.setGravity(17);
        button.setOnClickListener((View$OnClickListener)this.ml1);
        final Button button2 = new Button((Context)this);
        button2.setText((CharSequence)"Cancel");
        button2.setGravity(17);
        button2.setOnClickListener((View$OnClickListener)this.ml1);
        linearLayout.addView((View)button);
        linearLayout.addView((View)button2);
        this.setContentView((View)contentView);
    }
    
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final MenuItem add = menu.add((CharSequence)"Save");
        final MenuItem add2 = menu.add((CharSequence)"Cancel");
        add.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this.ml1);
        add2.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this.ml1);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 82) {
            this.z();
        }
        else if (n == 4) {
            final String s = b$2.h[b$2.j + 4];
            if (s != null && s.equals("0")) {
                if (b$2.m == null) {
                    this.moveTaskToBack(true);
                }
            }
            else {
                Toast.makeText((Context)this, (CharSequence)new String(new byte[] { 70, 111, 114, 99, 101, 32, 83, 116, 111, 112, 112, 101, 100 }), 0).show();
                new h().postDelayed((Runnable)new 100000000(), (long)500);
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public void w() {
        for (int i = 0; i < b$2.n; ++i) {
            String s = "";
            switch (b$2.i.charAt(i)) {
                case '0': {
                    if (((CheckBox)this.findViewById(i)).isChecked()) {
                        s = "1";
                    }
                    else {
                        s = "0";
                    }
                    break;
                }
                case '1': {
                    s = new StringBuffer().append("").append(((Spinner)this.findViewById(i)).getSelectedItemPosition()).toString();
                    break;
                }
                case '2': {
                    s = ((EditText)this.findViewById(i)).getText().toString();
                    break;
                }
            }
            b$2.h[i] = s;
        }
        xy.H1.v();
    }
    
    public void x() {
        final Context applicationContext = this.getApplicationContext();
        try {
            final Intent intent = new Intent(applicationContext, (Class)Class.forName("com.opera.mini.android.xy"));
            intent.setFlags(67108864);
            intent.putExtra("Dzebb Handler", true);
            this.startActivity(intent);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    public void y() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)xy.H2);
        alertDialog$Builder.setMessage((CharSequence)"Write your message here.");
        alertDialog$Builder.setCancelable(true);
        alertDialog$Builder.setPositiveButton((CharSequence)"Yes", (DialogInterface$OnClickListener)new 100000001());
        alertDialog$Builder.setNegativeButton((CharSequence)"No", (DialogInterface$OnClickListener)new 100000002());
        alertDialog$Builder.create().show();
    }
    
    public void z() {
        ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 2);
    }
    
    class 100000000 implements Runnable
    {
        private final xy this$0;
        
        100000000(final xy this$0) {
            this.this$0 = this$0;
        }
        
        static xy access$0(final 100000000 100000000) {
            return 100000000.this$0;
        }
        
        @Override
        public void run() {
            this.this$0.x();
        }
    }
    
    class 100000001 implements DialogInterface$OnClickListener
    {
        private final xy this$0;
        
        100000001(final xy this$0) {
            this.this$0 = this$0;
        }
        
        static xy access$0(final 100000001 100000001) {
            return 100000001.this$0;
        }
        
        public void onClick(final DialogInterface dialogInterface, final int n) {
            dialogInterface.cancel();
        }
    }
    
    class 100000002 implements DialogInterface$OnClickListener
    {
        private final xy this$0;
        
        100000002(final xy this$0) {
            this.this$0 = this$0;
        }
        
        static xy access$0(final 100000002 100000002) {
            return 100000002.this$0;
        }
        
        public void onClick(final DialogInterface dialogInterface, final int n) {
            dialogInterface.cancel();
        }
    }
    
    public class ml implements MenuItem$OnMenuItemClickListener, View$OnClickListener
    {
        private final xy this$0;
        
        public ml(final xy this$0) {
            this.this$0 = this$0;
        }
        
        static xy access$0(final ml ml) {
            return ml.this$0;
        }
        
        public void Operation(final String s) {
            if (!s.equals("Cancel")) {
                this.this$0.w();
                this.this$0.setResult(-1, (Intent)null);
                this.this$0.aa();
                this.this$0.finish();
                return;
            }
            if (b$2.m == null) {
                this.this$0.finish();
                return;
            }
            this.this$0.setResult(0, (Intent)null);
            this.this$0.aa();
            this.this$0.finish();
        }
        
        public void onClick(final View view) {
            this.Operation(((Button)view).getText().toString());
        }
        
        public boolean onMenuItemClick(final MenuItem menuItem) {
            this.Operation(menuItem.getTitle().toString());
            return true;
        }
    }
}
