package Hr_Head_Login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.ObjectRepo.Hr_Head_EmpDashboard;
import com.hrm.ObjectRepo.Hr_Head_EmpDetails;
import com.hrm.ObjectRepo.HrHead_HomePage;
import com.hrm.genericUtility.Hr_Head_Baseclass;
@Listeners(com.hrm.genericUtility.ListenerImp_Hr_Head.class)
public class CreateEmployee extends Hr_Head_Baseclass {

     @Test
     public void addEmplyHr() throws Throwable
	{
		String ExpectedRes="Insert Successfully!!!";
		
		//HomePage
		HrHead_HomePage hp=new HrHead_HomePage(driver);
        hp.clickEmployee();
        
        //Dashboard Page
        Hr_Head_EmpDashboard clickAdd=new Hr_Head_EmpDashboard(driver);
        clickAdd.addEmployee();
        
        //Add Employee Details
        Hr_Head_EmpDetails addEmp=new Hr_Head_EmpDetails(driver);
    
        addEmp.addEmp(driver);
        addEmp.uploadFile(driver);
        String orgRes = wLib.getTextAlert(driver);
        if(orgRes.equalsIgnoreCase(ExpectedRes))
        {
        	System.out.println("Added Employee");
        }
        else
        	System.out.println("Failed ");
        wLib.switchToAlertWindowAndAccept(driver);
        
		
	}

}
