package Practice_Package;

import org.testng.annotations.Test;

public class Sample3
{
	@Test
	public void updateBranch()
	{
		System.out.println("UpdatedBranch");
	}
	@Test
	public void deleteBranch()
	{
		System.out.println("DeletedBranch");
	}

}

//(groups="regression")
//(groups={"smoke","regression"})