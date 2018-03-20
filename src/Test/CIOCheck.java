package Test;

import org.apache.commons.lang3.StringUtils;

public class CIOCheck {
	public static boolean validateCIOMembership(String partnum) {
		if (StringUtils.isNotBlank(partnum)) {
			return (StringUtils.startsWith(partnum, "ITESIG")
					|| StringUtils.startsWith(partnum, "SIG")) ? true : false;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(validateCIOMembership("ITESIG123"));
	}
}
