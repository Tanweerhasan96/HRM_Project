package Hr_Head_Login;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.ObjectRepo.HrHead_HomePage;
import com.hrm.ObjectRepo.Hr_Head_BranchDashboard;
import com.hrm.genericUtility.Hr_Head_Baseclass;
@Listeners(com.hrm.genericUtility.ListenerImp_Hr_Head.class)
public class CreateBranchHrHead extends Hr_Head_Baseclass
{
	@Test(retryAnalyzer=com.hrm.genericUtility.RetryImplementation.class)
	public void createBranch()
	{
		HrHead_HomePage hp = new HrHead_HomePage(driver);
		hp.clickBranch();
		 //fail();
		Hr_Head_BranchDashboard hd = new Hr_Head_BranchDashboard(driver);
		hd.addBranch("Bokaro Branch", wLib, driver);
	}

}
