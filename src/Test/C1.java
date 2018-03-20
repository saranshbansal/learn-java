/**
 * May 27, 2016sbansal
 */
package Test;

/**
 * @author sbansal
 *
 */
public class C1 {
	public String createClientProgram() {
		try {
			String upsertStatus = C2.upsertClientKIsByContact(false);
			// Step 4: Return SOA Status
			return upsertStatus;
		} catch (Exception e) {
			System.out.println("Exception in method " + "createClientProgram");
		}
		return "From C1: Normal flow";
	}
}
