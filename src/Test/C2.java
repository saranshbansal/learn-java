/**
 * May 27, 2016sbansal
 */
package Test;

/**
 * @author sbansal
 *
 */
public class C2 {
	public static String upsertClientKIsByContact(Boolean x) {
		try {
			if (x==true) {
				throw new Exception();
			}else{
				
			}
		} catch (Exception e) {
			return "FROM C2: Exception Block";
		}
		return "From C2: Normal flow";
	}

}
