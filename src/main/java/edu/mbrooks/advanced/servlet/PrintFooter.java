package edu.mbrooks.advanced.servlet;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public  class PrintFooter {

    public static String Footer (String VERSION) {

        return "<br><hr><footer><hr><br>version = " + VERSION + "</footer>";

    }
}
