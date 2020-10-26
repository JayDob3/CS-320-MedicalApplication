package medicalApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import medical.com.medicalApplication.model.Doctor;
import medical.com.medicalApplication.services.DoctorService;

public class TestDoctorService {
	@Test
	public void testGetReference() {
		assertNotNull(DoctorService.getReference());
	}

	@Test
	public void testGetAllDoctors() {
		DoctorService service = new DoctorService();
		assertEquals(0, service.getAllDoctors().size());
		assertEquals(new ArrayList<Doctor>(), service.getAllDoctors());
	}

	@Test
	public void testAddDoctor() {
		DoctorService service = new DoctorService();
		assertTrue(service.addDoctor("Doctor 1", "7"));
		assertEquals(1, service.getAllDoctors().size());
		assertTrue(service.addDoctor("Doctor 2", "10"));
		assertEquals(2, service.getAllDoctors().size());
		assertTrue(service.addDoctor("Doctor 3", "11"));
		assertEquals(3, service.getAllDoctors().size());
		assertEquals(3, service.getAllDoctors().size());
	}
}
