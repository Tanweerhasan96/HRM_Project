package Hr_Assistant_Login;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.ObjectRepo.HrAssistant_Dashboard;
import com.hrm.ObjectRepo.HrAssistant_HomePage;
import com.hrm.genericUtility.HrAssistant_Baseclass;
@Listeners(com.hrm.genericUtility.ListenerImpl_Hr_Assistant.class)
public class DeleteEmp_Assistent extends HrAssistant_Baseclass
{
	@Test
	public void deleteEmp() {
		HrAssistant_HomePage ahp=new HrAssistant_HomePage(driver);
		ahp.clickEmpBtn();
		
		HrAssistant_Dashboard hd=new HrAssistant_Dashboard(driver);
		hd.searchEmpAss("Tanweer");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		hd.deleteEmpAss(wLib, driver);
	
	}
	

}
