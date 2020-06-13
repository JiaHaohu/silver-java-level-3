package com.tw.questionEasy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class HtmlEscaper {
    // TODO:
    //   You can add additional members or blocks of code here if you want.
    // <-start-

    private static LinkedHashMap<String, String> rulesMap = new LinkedHashMap<>();

    static {
        rulesMap.put("&", "&amp;");
        rulesMap.put("\"", "&quot;");
        rulesMap.put("'", "&#39;");
        rulesMap.put("<", "&lt;");
        rulesMap.put(">", "&gt;");
    }


    // --end-->

    /**
     * This function will try escaping characters according to the rules defined in HTML 4.01
     * The rules are as follows:
     * <p>
     * (1) Every `"` character will be escaped to `&quot;`
     * (2) Every `'` character will be escaped to `&#39;`
     * (3) Every `&` character will be escaped to `&amp;`
     * (4) Every `<` character will be escaped to `&lt;`
     * (5) Every `>` character will be escaped to `&gt;`
     *
     * @param text The text to escape.
     * @return The escaped string.
     */
    public static String escape(String text) {
        // TODO:
        //   Please implement the method
        // <-start-
        for (Entry<String, String> entry : rulesMap.entrySet()) {
            text = text.replaceAll(entry.getKey(), entry.getValue());
        }

        return text;
        // --end-->
    }
}
