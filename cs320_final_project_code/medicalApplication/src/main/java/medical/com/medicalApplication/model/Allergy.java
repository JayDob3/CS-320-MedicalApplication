/**
 * Janera Dobson		
 * 10/9/20
 * CS-320-H1152
 * Milestone One
**/

package medical.com.medicalApplication.model;

/**
 * This class represent the Allergy model in the application
 *
 */
public class Allergy { // corrected Allergey to Allergy
	private String name;

	public Allergy(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Allergy " + name;
	}

}
