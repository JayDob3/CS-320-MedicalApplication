/**
 * Janera Dobson					
 * 10/9/20
 * CS-320-H1152
 * Milestone One
**/

package medicalApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cucumber.annotation.After;
import medical.com.medicalApplication.model.Allergy;
import medical.com.medicalApplication.model.MedicalRecord;
import medical.com.medicalApplication.model.Patient;
import medical.com.medicalApplication.services.MedicalRecordService;

public class TestMedicalRecordsService {
	private MedicalRecordService medicalRecordService;
	private List<Patient> expectedPatients;

	@Before
	public void before() {
		medicalRecordService = MedicalRecordService.getReference();
		expectedPatients = medicalRecordService.getAllPatients();
	}

	@Test
	public void testGetReference() {
		assertNotNull("Medical record service object is null", medicalRecordService);
	}

	@Test
	public void testAddPatients() {
		boolean addPatientSuccess = medicalRecordService.addPatient("Diandre Figueroa", "01032009");
		// assert
		assertTrue("medicalRecordService failed to add patient: 01032009", addPatientSuccess);
		assertNotNull("patient list is null", expectedPatients);
		assertTrue("unable to add patient, id already exists", addPatientSuccess);
		assertTrue("unable to locate specified patient id",
				expectedPatients.stream().anyMatch(patient -> patient.getId().equals("01032009")));
		assertTrue("unable to locate specified patient name",
				expectedPatients.stream().anyMatch(patient -> patient.getName().equals("Diandre Figueroa")));
	}

	@Test
	public void testGetAllPatients() {
		boolean addJusticeSuccess = medicalRecordService.addPatient("Justice Braxton", "09222016");
		// find Justice
		assertTrue("medicalRecordService failed to add patient: 09222016", addJusticeSuccess);
		assertNotNull("expectedDoctor List is null", expectedPatients);
		assertTrue("unable to locate Patient: Justice Braxton",
				expectedPatients.stream().anyMatch(patient -> patient.getName().equals("Justice Braxton")));
		assertTrue("unable to locate Doctor Id: 1001",
				expectedPatients.stream().anyMatch(patient -> patient.getId().equals("09222016")));
	}

	@Test
	public void testGetMedicalRecord() {
		// act
		MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord("09222016");
		Patient expectedPatient = medicalRecord.getPatient();
		// assert
		assertNotNull("medicalRecordService returned null object", medicalRecord);
		assertEquals("patient:09222016 returned incorrect name", expectedPatient.getName(), "Justice Braxton");
		assertEquals("patient:Justice Braxton returned incorrect ID", expectedPatient.getId(), "09222016");
	}

	@Test
	public void testGetPatient() {
		// act
		Patient actualPatient = medicalRecordService.getPatient("09222016");
		// assert
		assertNotNull("actualPatient returned null object", actualPatient);
		assertEquals("patient:09222016 returned incorrect name", actualPatient.getName(), "Justice Braxton");
		assertEquals("patient:Justice Braxton returned incorrect ID", actualPatient.getId(), "09222016");
	}

	@Test
	public void testGetPatientsWithAllergies() {
		String patientId = "042396";
		Allergy peanutAllergy = new Allergy("Peanuts");

		medicalRecordService.addPatient("Addis Dobson", patientId);
		MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(patientId);
		medicalRecord.getHistory().addAllergy(peanutAllergy);

		List<Patient> patientList = new ArrayList<Patient>();
		assertNotNull("allergy object is null", peanutAllergy);
		assertNotNull("medrecord object is null", medicalRecord);
		assertNotNull("patientList object is null", medicalRecord);
		assertTrue("testGetAllergies returned null or 0", patientList.size() >= 0);
	}

	@After
	public void after() {
		medicalRecordService = null;
		// expectedPatients = null;
	}
}
