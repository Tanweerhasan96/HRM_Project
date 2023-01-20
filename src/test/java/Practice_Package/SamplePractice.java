package Practice_Package;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SamplePractice {
	@Test(priority=1,invocationCount=2)
	public void create() 
	{
		 Reporter.log("created",true);
	}
	@Test(dependsOnMethods="create")
	public void update() 
	{
		Reporter.log("updated",true);
		
	}
	@Test
	public void delete() 
	{
		Reporter.log("deleted",true);
	}
	


}
