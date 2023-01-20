package Practice_Package;

import org.testng.annotations.Test;

public class Sample1 
{
	@Test
	public void createEmployee()
	{
		System.out.println("created");
	}
	@Test
	public void updateEmployee()
	{
		System.out.println("updated");
	}

}

//(groups={"smoke","regression"})
//(groups="smoke")