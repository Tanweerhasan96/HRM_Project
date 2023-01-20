package Hr_Head_Login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.ObjectRepo.HrHead_HomePage;
import com.hrm.ObjectRepo.Hr_HeadCorporateDashboard;
import com.hrm.genericUtility.Hr_Head_Baseclass;
@Listeners(com.hrm.genericUtility.ListenerImp_Hr_Head.class)
public class CreateCorporate extends Hr_Head_Baseclass
{
	@Test
	public void createCorporate()
	{
		HrHead_HomePage hp=new HrHead_HomePage(driver);
		hp.clickCorporate(); 
		Hr_HeadCorporateDashboard hc=new Hr_HeadCorporateDashboard(driver);
		hc.addCorpo("tyss");
		wLib.switchToAlertWindowAndAccept(driver);
		hc.searchCorporate("tyss");
	}
	
	
}
