package medicalApplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import medical.com.medicalApplication.model.Allergy;
import medical.com.medicalApplication.model.Doctor;
import medical.com.medicalApplication.model.Employee;
import medical.com.medicalApplication.model.MedicalRecord;
import medical.com.medicalApplication.model.Medication;
import medical.com.medicalApplication.model.Patient;
import medical.com.medicalApplication.model.PatientHistory;
import medical.com.medicalApplication.model.Treatment;

public class TestMedicalApplication {

	@Test
	public void testAllergy() {
		Allergy allergy = new Allergy("Pet Dander");
		allergy.setName("Pet Dander");
		assertEquals("Allergy Pet Dander", allergy.toString());
	}

	@Test
	public void testDoctor() {
		Doctor doctor = new Doctor("Janera Dobson", "072187");
		assertEquals("Doctor Name:Janera Dobson ID: 072187", doctor.toString());
	}

	@Test
	public void testEmployee() {
		Employee employee = new Employee("Ashley Dobson", "011892");
		assertEquals("Open", employee.getPassword());
	}

	@Test
	public void testMedicalRecord() {
		Patient patient = new Patient("Diandre Figueroa", "01032009");
		MedicalRecord medicalRecord = new MedicalRecord(patient);
		assertEquals("Diandre Figueroa", medicalRecord.getPatient().getName());

	}

	@Test
	public void testMedication() {
		Medication medication = new Medication("Penicillin", "03-01-2020", "17-01-2020", "250mg");
		assertEquals("Medication:Penicillin Start Date: 03-01-2020 End Date: 17-01-2020 Dose: 250mg",
				medication.toString());
	}

	@Test
	public void testPatient() {
		Patient patient = new Patient("Diandre Figueroa", "01032009");
		assertEquals("Patient Name: Diandre Figueroa ID: 01032009", patient.toString());
	}

	@Test
	public void testPatientHistory() {
		PatientHistory patientHistory = new PatientHistory();
		Treatment treatment = new Treatment("03-01-2020", "Ear Infection", "Sharp constant pain in both ears.");
		Medication medication = new Medication("Penicillin", "03-01-2020", "17-01-2020", "250mg");
		Allergy allergy = new Allergy("Pet Dander");
		patientHistory.addTreatment(treatment);
		patientHistory.addAllergy(allergy);
		patientHistory.addMedication(medication);

		assertEquals("Medication:Penicillin Start Date: 03-01-2020 End Date: 17-01-2020 Dose: 250mg",
				patientHistory.getAllMedications().get(0).toString());

	}

	@Test
	public void testTreatement() {
		Treatment treatment = new Treatment("03-01-2020", "Ear Infection", "Sharp constant pain in both ears.");
		assertEquals("Treatment:  Date: 03-01-2020 Diagnose: Ear Infection", treatment.toString());

	}
}
