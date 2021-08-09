// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import java.io.Reader;
import org.xml.sax.InputSource;
import java.io.StringReader;
import org.xml.sax.ContentHandler;
import javax.xml.parsers.SAXParserFactory;
import java.util.Stack;
import org.xml.sax.helpers.DefaultHandler;

public class AdMarvelXMLReader extends DefaultHandler
{
    private AdMarvelXMLElement a;
    private Stack b;
    
    public AdMarvelXMLReader() {
        this.a = null;
        this.b = null;
    }
    
    private static String chkAndReplace(final String p0, final String p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnull          53
        //     4: new             Ljava/lang/StringBuffer;
        //     7: dup            
        //     8: aload_0        
        //     9: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    12: astore_0       
        //    13: iconst_0       
        //    14: istore_3       
        //    15: aload_0        
        //    16: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    19: aload_1        
        //    20: iload_3        
        //    21: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;I)I
        //    24: istore_3       
        //    25: aload_0        
        //    26: astore          4
        //    28: iload_3        
        //    29: iconst_m1      
        //    30: if_icmpeq       76
        //    33: aload_0        
        //    34: iload_3        
        //    35: aload_1        
        //    36: invokevirtual   java/lang/String.length:()I
        //    39: iload_3        
        //    40: iadd           
        //    41: aload_2        
        //    42: invokevirtual   java/lang/StringBuffer.replace:(IILjava/lang/String;)Ljava/lang/StringBuffer;
        //    45: pop            
        //    46: iload_3        
        //    47: iconst_1       
        //    48: iadd           
        //    49: istore_3       
        //    50: goto            15
        //    53: new             Ljava/lang/StringBuffer;
        //    56: dup            
        //    57: ldc             ""
        //    59: invokespecial   java/lang/StringBuffer.<init>:(Ljava/lang/String;)V
        //    62: astore_0       
        //    63: goto            13
        //    66: astore_1       
        //    67: aconst_null    
        //    68: astore_0       
        //    69: aload_1        
        //    70: invokevirtual   java/lang/Exception.printStackTrace:()V
        //    73: aload_0        
        //    74: astore          4
        //    76: aload           4
        //    78: ifnonnull       83
        //    81: aconst_null    
        //    82: areturn        
        //    83: aload           4
        //    85: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //    88: areturn        
        //    89: astore_1       
        //    90: goto            69
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      13     66     69     Ljava/lang/Exception;
        //  15     25     89     93     Ljava/lang/Exception;
        //  33     46     89     93     Ljava/lang/Exception;
        //  53     63     66     69     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0015:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static String xmlDecode(final String s) {
        if (s != null) {
            return chkAndReplace(chkAndReplace(chkAndReplace(chkAndReplace(s, "&amp;", "&"), "&quot;", "\""), "&gt;", ">"), "&lt;", "<");
        }
        return null;
    }
    
    static String xmlEncode(final String s) {
        if (s != null) {
            return chkAndReplace(chkAndReplace(chkAndReplace(chkAndReplace(s, "&", "&amp;"), "\"", "&quot;"), "<", "&lt;"), ">", "&gt;");
        }
        return null;
    }
    
    @Override
    public void characters(final char[] array, final int n, final int n2) {
        this.b.peek().appendData(new String(array).substring(n, n + n2));
    }
    
    @Override
    public void endElement(final String s, final String s2, final String s3) {
        this.b.pop();
    }
    
    public AdMarvelXMLElement getParsedXMLData() {
        return this.a;
    }
    
    public void parseXMLString(final String s) {
        this.b = new Stack();
        final XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        xmlReader.setContentHandler(this);
        xmlReader.parse(new InputSource(new StringReader(s)));
    }
    
    @Override
    public void startElement(final String s, final String s2, final String s3, final Attributes attributes) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (attributes != null) {
            for (int length = attributes.getLength(), i = 0; i < length; ++i) {
                linkedHashMap.put(attributes.getLocalName(i), attributes.getValue(i));
            }
        }
        final AdMarvelXMLElement a = new AdMarvelXMLElement(s2, linkedHashMap);
        if (this.b.empty()) {
            this.a = a;
        }
        else {
            final AdMarvelXMLElement adMarvelXMLElement = this.b.peek();
            ArrayList list;
            if ((list = adMarvelXMLElement.getChildren().get(s2)) == null) {
                list = new ArrayList();
                adMarvelXMLElement.getChildren().put(s2, list);
            }
            list.add(a);
        }
        this.b.push(a);
    }
}
