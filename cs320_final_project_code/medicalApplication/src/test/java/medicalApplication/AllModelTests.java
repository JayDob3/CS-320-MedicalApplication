/**
 * Janera Dobson		
 * 10/9/20
 * CS-320-H1152
 * Milestone One
**/

package medicalApplication;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllServicesTests.class, TestDoctorService.class, TestMedicalApplication.class,
		TestMedicalRecordsService.class })
public class AllModelTests {

}
