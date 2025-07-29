package com.scratchpad;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.Strings.CS;


public class CIOCheck {
    public static boolean validateCIOMembership(String partnum) {
        if (StringUtils.isNotBlank(partnum)) {
            return CS.startsWith(partnum, "ITESIG")
                    || CS.startsWith(partnum, "SIG");
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(validateCIOMembership("ITESIG123"));
    }
}
