/**
 * Apr 27, 2016sbansal
 */
package com.scratchpad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sbansal
 */
public class MatcherTestt {

    public static final String entityType = "baw";


    /**
     * @param source
     * @param subItem
     * @return
     */
    private static boolean isContain(String response, String searchTerm) {
        String pattern = searchTerm;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(response);
        return m.find();
    }


    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        String newLine = System.getProperty("line.separator");// This will retrieve line separator
        // dependent on OS.
        System.out.println(MatcherTestt.class.getDeclaredField("entityType").get(new Object()));
        System.out.println("line 1" + newLine + "line2");
        String response = "\"Multiple weeks of analysis saved more than six weeks of my time preparing for key decisions around integration platforms.\"";
        System.out.println(isContain(response, "\""));
    }
}
