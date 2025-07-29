package com.scratchpad;

public class TestMain {

    public static String buildUrl(Long docId) {
        StringBuilder url = new StringBuilder();
        if (null != docId) {
            String primerCode = Long.toString(docId);
            String subPrimerCode =
                    primerCode.substring(0, primerCode.length() - 2 >= 0 ? primerCode.length() - 2 : 00)
                            + "00";
            url.append("=> " + subPrimerCode + "///" + primerCode);
        }
        return url.toString();
    }


    public static void main(String[] args) {
        System.out.println(TestMain.buildUrl(12345L));
        Long x = 5L;
        System.out.println(x == 5);
        String c = "a,b";
        System.out.println(c.contains("sss"));
        System.out.println(x);
    }

}
