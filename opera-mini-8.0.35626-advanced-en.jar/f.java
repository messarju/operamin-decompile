import javax.microedition.lcdui.game.Layer;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Canvas;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class f extends Canvas implements CommandListener
{
    private static boolean Z;
    private int[] Code;
    private boolean Code;
    private int Code;
    private int I;
    private int Z;
    private boolean I;
    private Sprite Code;
    private Code Code;
    private Graphics Code;
    private boolean J;
    
    private int Code(final int n) {
        if (Code.B == 3) {
            if (n == -14) {
                return -1;
            }
            if (n == -13) {
                return -2;
            }
            if (n == -20 || n == -22) {
                return 0;
            }
            if (n == -11) {
                return -5;
            }
        }
        try {
            final String keyName;
            if ((keyName = this.getKeyName(n)) != null) {
                final String lowerCase;
                if ((lowerCase = keyName.toLowerCase()).equals("sk2(left)")) {
                    return -1;
                }
                if (lowerCase.equals("sk1(right)")) {
                    return -2;
                }
                if (n == 105) {
                    return -1;
                }
                if (lowerCase.indexOf("soft") >= 0) {
                    if (lowerCase.charAt(lowerCase.length() - 1) == '1' || lowerCase.startsWith("left")) {
                        return -1;
                    }
                    if (lowerCase.charAt(lowerCase.length() - 1) == '2' || lowerCase.charAt(lowerCase.length() - 1) == '4' || lowerCase.startsWith("right")) {
                        return -2;
                    }
                }
                if (lowerCase.equals("clear") || lowerCase.equals("backspace") || lowerCase.equals("delete")) {
                    return -6;
                }
                if (lowerCase.equals("back")) {
                    return -5;
                }
                if (lowerCase.equals("select") || lowerCase.equals("ok") || lowerCase.equals("send") || lowerCase.equals("fire") || lowerCase.equals("navi-center") || lowerCase.equals("start") || lowerCase.equals("enter")) {
                    return 8;
                }
                if (lowerCase.equals("up") || lowerCase.equals("navi-up") || lowerCase.equals("up arrow")) {
                    return 1;
                }
                if (lowerCase.equals("down") || lowerCase.equals("navi-down") || lowerCase.equals("down arrow")) {
                    return 6;
                }
                if (lowerCase.equals("left") || lowerCase.equals("navi-left") || lowerCase.equals("left arrow")) {
                    return 2;
                }
                if (lowerCase.equals("right") || lowerCase.equals("navi-right") || lowerCase.equals("right arrow")) {
                    return 5;
                }
            }
        }
        finally {
            final int gameAction = 0;
        }
        int gameAction;
        try {
            gameAction = this.getGameAction(n);
        }
        finally {}
        if (n == 8 && (Code.J == 2 || (Code.Code() && gameAction == 0))) {
            return -6;
        }
        if (n == -11 && Code.B == 0) {
            return 0;
        }
        if (n == -22 && Code.B == 2) {
            return 0;
        }
        if (n == -6 || n == -21 || n == 21 || n == 65 || n == 66 || n == -202 || n == 113 || n == 57345) {
            return -1;
        }
        if (n == -7 || n == -22 || n == 22 || n == 67 || n == 68 || n == 106 || n == -203 || n == 112 || n == 57346) {
            return -2;
        }
        if (n == -5 || n == -10 || n == -20 || n == 20 || n == 23 || n == -14 || n == -26 || n == -200 || n == 13 || (n == -41 && Code.J)) {
            return 8;
        }
        if (n == -8 || n == -16 || n == -19 || n == -204) {
            return -6;
        }
        switch (n) {
            case 35:
            case 42:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                return n;
            }
            default: {
                return gameAction;
            }
        }
    }
    
    private int J(final int n) {
        if (this.J) {
            switch (n) {
                case 1: {
                    return 2;
                }
                case 6: {
                    return 5;
                }
                case 2: {
                    return 6;
                }
                case 5: {
                    return 1;
                }
            }
        }
        return n;
    }
    
    private static int Z(int n) {
        final int i;
        if ((i = I(n)) != 0) {
            n = i;
        }
        switch (n) {
            case 50: {
                return 7;
            }
            case 52: {
                return 9;
            }
            case 54: {
                return 10;
            }
            case 56: {
                return 8;
            }
            default: {
                return 0;
            }
        }
    }
    
    public final synchronized boolean I() {
        if (this.Code == 0) {
            return false;
        }
        int n = 1;
        switch (this.Code[0]) {
            case 0: {
                n = 2;
                final int n2;
                final char[] code;
                if ((code = Code.Code(n2 = this.Code[1])) != null && code.length > 0) {
                    final String value = String.valueOf(code, 1, code.length - 1);
                    Code.I(n2);
                    Code.I(0);
                    Code.I(I(n2));
                    Code.I(n2);
                    Code.I(Code.Code());
                    final int z = Z(n2);
                    int n3 = 0;
                    Label_0177: {
                        if (this.J) {
                            switch (z) {
                                case 7: {
                                    n3 = 9;
                                    break Label_0177;
                                }
                                case 9: {
                                    n3 = 8;
                                    break Label_0177;
                                }
                                case 8: {
                                    n3 = 10;
                                    break Label_0177;
                                }
                                case 10: {
                                    n3 = 7;
                                    break Label_0177;
                                }
                            }
                        }
                        n3 = z;
                    }
                    Code.I(n3);
                    Code.Code(Code.Code(value));
                    Code.Code(Code.Code(value.toUpperCase()));
                }
                else {
                    Code.Code(this.J(this.Code(n2)), I(n2), n2, Code.Code(), Z(n2));
                }
                Code.J(52);
                break;
            }
            case 1: {
                n = 2;
                final int n4;
                final char[] code2;
                Code.Code(((code2 = Code.Code(n4 = this.Code[1])) != null && code2.length > 0) ? n4 : this.J(this.Code(n4)), n4, Code.Code());
                Code.J(53);
                break;
            }
            case 2: {
                n = 3;
                final int n5 = this.Code[1];
                final int n6 = this.Code[2];
                Code.I(this.Code(n5, n6), this.I(n5, n6), Code.Code());
                Code.J(54);
                break;
            }
            case 3: {
                n = 3;
                final int n7 = this.Code[1];
                final int n8 = this.Code[2];
                Code.Z(this.Code(n7, n8), this.I(n7, n8), Code.Code());
                Code.J(55);
                break;
            }
            case 4: {
                this.Code = false;
                Code.J(this.Code(this.I, this.Z), this.I(this.I, this.Z), Code.Code());
                Code.J(56);
                break;
            }
            case 5: {
                n = 2;
                final int i = Code.I;
                final int n9 = this.Code[1];
                Code.Code(i, (boolean)((n9 | -n9) >>> 31 != 0));
                Code.J(43);
                Code.J(Code.I);
                Code.I = 0;
                break;
            }
        }
        System.arraycopy(this.Code, n, this.Code, 0, this.Code - n);
        this.Code -= n;
        return true;
    }
    
    private synchronized void Code(final int n, final int n2) {
        (this.Code = Code.Code(this.Code, this.Code + 2))[this.Code++] = n;
        this.Code[this.Code++] = n2;
    }
    
    private synchronized void Code(final int n, final int n2, final int n3) {
        (this.Code = Code.Code(this.Code, this.Code + 3))[this.Code++] = n;
        this.Code[this.Code++] = n2;
        this.Code[this.Code++] = n3;
    }
    
    public final void paint(final Graphics graphics) {
        if (this.J) {
            final int n = graphics.getClipX() + graphics.getClipWidth() - 1;
            final int n2 = graphics.getClipY() + graphics.getClipHeight() - 1;
            graphics.drawLine(n, n2, n, n2);
            if (this.Code == null || ((Layer)this.Code).getWidth() != ((Displayable)this).getHeight() || ((Layer)this.Code).getHeight() != ((Displayable)this).getWidth()) {
                this.Code = null;
                this.Code = null;
                final Image image = Image.createImage(((Displayable)this).getHeight(), ((Displayable)this).getWidth());
                this.Code = image.getGraphics();
                (this.Code = new Sprite(image)).setTransform(5);
                ((Layer)this.Code).setPosition(0, 0);
            }
            this.Code.setClip(graphics.getClipY(), ((Displayable)this).getWidth() - graphics.getClipX() - graphics.getClipWidth(), graphics.getClipHeight(), graphics.getClipWidth());
            this.Code.Code(this.Code);
            Code.Code.Code(this.Code);
            this.Code.paint(graphics);
            return;
        }
        this.Code = null;
        ((Code)(this.Code = null)).Code(graphics);
        Code.Code.Code(this.Code);
    }
    
    public f() {
        this.Code = new int[32];
        this.I = false;
        this.Code = null;
        this.Code = new Code((Graphics)null);
        this.Code = null;
        this.J = false;
    }
    
    protected final void keyReleased(final int n) {
        Code.C();
        Code.C(n);
        if (!Code.Code) {
            return;
        }
        if (Code.Z && this.I && n == -5) {
            return;
        }
        this.I = false;
        this.Code(1, n);
        Code.Code.J();
    }
    
    private synchronized void Code() {
        (this.Code = Code.Code(this.Code, this.Code + 1))[this.Code++] = 4;
    }
    
    public final boolean B() {
        return this.J;
    }
    
    public final boolean Code() {
        return this.Code > 0;
    }
    
    public final void Code(final boolean j) {
        this.J = j;
    }
    
    private static int I(int index) {
        if (Code.Code != null && (index = Code.Code.indexOf((char)index)) >= 0) {
            return Code.I.charAt(index);
        }
        return 0;
    }
    
    protected final void keyPressed(final int n) {
        Code.C();
        Code.C(n);
        if (!Code.Code) {
            return;
        }
        if (Code.Z && this.I && n == -5) {
            return;
        }
        final int n2 = n - 10;
        this.I = (((n2 | -n2) >>> 31 ^ 0x1) != 0x0);
        this.Code(0, n);
        Code.Code.J();
    }
    
    private int Code(final int n, final int n2) {
        if (this.J) {
            return n2;
        }
        return n;
    }
    
    private int I(final int n, final int n2) {
        if (this.J) {
            return ((Displayable)this).getWidth() - n;
        }
        return n2;
    }
    
    protected final void pointerReleased(final int n, final int n2) {
        Code.C();
        Code.C(n);
        Code.C(n2);
        if (!Code.Code || !f.Z) {
            return;
        }
        f.Z = false;
        this.Code(3, n, n2);
        Code.Code.J();
    }
    
    protected final void pointerPressed(final int n, final int n2) {
        Code.C();
        Code.C(n);
        Code.C(n2);
        if (!Code.Code || f.Z) {
            return;
        }
        f.Z = true;
        this.Code(2, n, n2);
        Code.Code.J();
    }
    
    protected final void pointerDragged(final int i, final int z) {
        Code.C();
        Code.C(i);
        Code.C(z);
        if (!Code.Code || !f.Z) {
            return;
        }
        monitorenter(this);
        this.I = i;
        this.Z = z;
        while (true) {
            if (!this.Code && !Code.I) {
                this.Code = true;
                try {
                    this.Code();
                }
                finally {
                    monitorexit(this);
                }
                Code.Code.J();
                return;
            }
            continue;
        }
    }
    
    protected final void showNotify() {
        Code.Code.Code(true);
    }
    
    protected final void hideNotify() {
        Code.Code.Code(false);
    }
    
    protected final void sizeChanged(final int n, final int n2) {
        final Code code = Code.Code;
        final boolean code2 = Code.Code;
        try {
            code.I(code2);
        }
        finally {}
    }
    
    public final void commandAction(final Command command, final Displayable displayable) {
        if (!Code.Code) {
            return;
        }
        final Display code = Code.Code;
        try {
            code.setCurrent((Displayable)this);
            final int n = 5;
            final int n2 = command.getCommandType() - 4;
            this.Code(n, (n2 | -n2) >>> 31 ^ 0x1);
        }
        finally {}
    }
    
    public final boolean Z() {
        return this.J;
    }
    
    public final boolean J() {
        return this.J;
    }
}
