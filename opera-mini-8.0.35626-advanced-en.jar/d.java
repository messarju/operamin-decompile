import javax.microedition.pim.PIMItem;
import java.util.Enumeration;
import javax.microedition.pim.PIMList;
import javax.microedition.pim.Contact;
import javax.microedition.pim.PIM;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class d
{
    private static String Code(final String s) {
        final StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); ++i) {
            final char char1;
            if ((char1 = s.charAt(i)) < ' ' || char1 == '\"' || char1 == '\\') {
                sb.append("\\u").append((char1 < '\u0010') ? "000" : "00").append(Integer.toHexString(char1));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    public static String Code() {
        final PIM instance = PIM.getInstance();
        int n = 0;
        final String[] listPIMLists = instance.listPIMLists(1);
        final StringBuffer sb = new StringBuffer(512);
        final StringBuffer sb2 = new StringBuffer(128);
        int i = 0;
    Label_0081_Outer:
        while (i < listPIMLists.length) {
            final int n2 = 0;
            while (true) {
                if (n2 < i) {
                    final String[] array = listPIMLists;
                    final int n3 = i;
                    try {
                        if (array[n3].equals(listPIMLists[n2])) {}
                        final PIMList openPIMList;
                        final Enumeration items = (openPIMList = instance.openPIMList(1, 1, listPIMLists[i])).items();
                        while (items.hasMoreElements()) {
                            final Enumeration enumeration = items;
                            try {
                                final Contact contact;
                                final int[] fields = ((PIMItem)(contact = enumeration.nextElement())).getFields();
                                int j = 0;
                                while (j < fields.length) {
                                    final int[] array2 = fields;
                                    final int n4 = j;
                                    try {
                                        final int n5;
                                        if ((n5 = array2[n4]) >= 100 && n5 <= 118 && n5 != 108 && n5 != 113 && n5 != 117) {
                                            final int countValues = ((PIMItem)contact).countValues(n5);
                                            final int fieldDataType = openPIMList.getFieldDataType(n5);
                                            final StringBuffer sb3 = new StringBuffer("[");
                                            for (int k = 0; k < countValues; ++k) {
                                                final StringBuffer sb4 = new StringBuffer();
                                                if (fieldDataType == 4) {
                                                    final String string;
                                                    if ((string = ((PIMItem)contact).getString(n5, k)) != null) {
                                                        sb4.append('\"').append(Code(string)).append('\"');
                                                    }
                                                }
                                                else if (fieldDataType == 5) {
                                                    sb4.append("[");
                                                    final String[] stringArray = ((PIMItem)contact).getStringArray(n5, k);
                                                    for (int l = 0; l < stringArray.length; ++l) {
                                                        if (stringArray[l] != null && stringArray[l].length() > 0) {
                                                            sb4.append('\"').append(Code(stringArray[l])).append("\",");
                                                        }
                                                    }
                                                    sb4.setCharAt(sb4.length() - 1, ']');
                                                }
                                                if (sb4.length() > 2) {
                                                    sb3.append((Object)sb4).append(',');
                                                }
                                            }
                                            sb3.setCharAt(sb3.length() - 1, ']');
                                            if (sb3.length() > 1) {
                                                if (sb2.length() > 0) {
                                                    sb2.append(',');
                                                }
                                                sb2.append('\"').append((char)n5).append("\":").append((Object)sb3);
                                            }
                                        }
                                    }
                                    finally {
                                        ++j;
                                        continue Label_0081_Outer;
                                    }
                                    break;
                                }
                                if (n > 0) {
                                    sb.append(',');
                                }
                                sb.append('{').append(sb2.toString()).append('}');
                                sb2.setLength(0);
                                ++n;
                            }
                            finally {}
                        }
                    }
                    finally {
                        ++i;
                        continue Label_0081_Outer;
                    }
                    break;
                }
                continue;
            }
        }
        if (n > 0) {
            return sb.insert(0, "{\"c\":[").append("]}").toString();
        }
        return "{\"c\":[]}";
    }
}
