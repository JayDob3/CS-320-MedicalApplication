/**
 * Janera Dobson			
 * 10/9/20
 * CS-320-H1152
 * Milestone One
**/

package medical.com.medicalApplication.services;

import java.util.ArrayList;
import java.util.List;

import medical.com.medicalApplication.model.Doctor;

/**
 * 
 * This class uses a singleton pattern to mock a service instead of using
 * dependency injection
 * 
 * In addition, it stores data in memory only using Lists
 *
 */
public class DoctorService {
	private static DoctorService reference = new DoctorService();
	private static List<Doctor> doctors;

	public DoctorService() { // DoctorService needed to be public in order to be visible
		doctors = new ArrayList<Doctor>();
	}

	public static DoctorService getReference() {
		return reference;
	}

	public List<Doctor> getAllDoctors() {
		return doctors;
	}

	public boolean addDoctor(String name, String id) {
		String tempId = new String(id);
		// Test kept failing at doctor.getId()== tempId and needed to be changed to
		// doctor.getId().equals(tempId));
		// Compliance and JRE needed to be changed to 1.8 to rid Lambda expression error
		boolean createDoctor = !doctors.stream().anyMatch(doctor -> doctor.getId().equals(tempId));
		if (createDoctor) {
			doctors.add(new Doctor(name, id));
		}
		return createDoctor;
	}

}
