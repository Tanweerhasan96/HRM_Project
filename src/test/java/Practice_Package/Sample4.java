package Practice_Package;

import org.testng.annotations.Test;

public class Sample4 
{
	@Test(groups="regression")
	public void createCorporate()
	{
		System.out.println("createCorporate");
	}
	@Test(groups={"smoke","regression"})
	public void updateCorporate()
	{
		System.out.println("updateCorporate");
	}

}

