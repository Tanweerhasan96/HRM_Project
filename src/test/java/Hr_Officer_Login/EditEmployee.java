package Hr_Officer_Login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.ObjectRepo.Hr_Officer_Dashboard;
import com.hrm.ObjectRepo.Hr_Officer_HomePage;
import com.hrm.genericUtility.Hr_Officer_Baseclass;
@Listeners(com.hrm.genericUtility.ListnerImp_Hr_Officer.class)
public class EditEmployee extends Hr_Officer_Baseclass 
{

	@Test
	public void editEmployee() throws Throwable
	{
		
		Hr_Officer_HomePage hp = new Hr_Officer_HomePage(driver);
		hp.clickEmpAsOfficer();
		Assert.assertEquals(true, false);
		String name=eLib.getDataFromExcel("EmployeeDetails",1,1);
		Hr_Officer_Dashboard hod=new Hr_Officer_Dashboard(driver);
		hod.search(name);
		
		
		
		
	}

}
