/**
 * Janera Dobson			
 * 10/9/20
 * CS-320-H1152
 * Milestone One
**/

package medical.com.medicalApplication.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class represents a patient history model in the system
 *
 */
public class PatientHistory {

	private static List<Treatment> treatments;
	private static List<Medication> medications;
	private static List<Allergy> allergy;

	public PatientHistory() {
		PatientHistory.treatments = new ArrayList<Treatment>();
		PatientHistory.medications = new ArrayList<Medication>();
		PatientHistory.allergy = new ArrayList<Allergy>();
	}

	public void addTreatment(Treatment treatment) {
		treatments.add(treatment);
	}

	public void addAllergy(Allergy allegry) {
		allergy.add(allegry);
	}

	public void addMedication(Medication medication) {
		if (treatments != null) {
			medications.add(medication);
		}
	}

	public List<Allergy> getAllergies() { // changed getAlergies to getAllergies
		return allergy;
	}

	public List<Treatment> getAllTreatments() {
		return treatments;
	}

	public List<Medication> getAllMedications() {
		return medications;
	}

}
