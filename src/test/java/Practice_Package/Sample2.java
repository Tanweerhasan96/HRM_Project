package Practice_Package;

import org.testng.annotations.Test;

public class Sample2 
{
	@Test(groups="smoke")
	public void deleteEmployee()
	{
		System.out.println("deleted");
	}
	@Test(groups={"smoke","regression"})
	public void createBranch()
	{
		System.out.println("branch");
	}

}

