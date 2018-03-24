package Test;

import java.util.Date;

class TypeValidationRule {

	private Class clazz;

	public boolean validate(String fieldName, Object value) {
		if (null != value) {
			try {
				if (Integer.class.getName() == clazz.getName()) {
					Integer.parseInt(value.toString());
				}
				if (Long.class.getName() == clazz.getName()) {
					Long.parseLong(value.toString());
				}
				if (Date.class.getName() == clazz.getName()) {
					// Integer.parseInt(value.toString());
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean validate(String fieldName, Object fieldValue, Class clazz) {
		this.clazz = clazz;
		return validate(fieldName, fieldValue);
	}

}

public class ClassUnclass {
	public static void main(String[] args) {
		TypeValidationRule t = new TypeValidationRule();
		t.validate("abc", "123abc", Long.class);
//		t.validate("abc", new Date(), Date.class);
//		t.validate("abc", "123", Long.class);
	}
}
