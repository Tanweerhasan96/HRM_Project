package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.genericUtility.ExcelUtility;

public class DataProvider 
{
	@org.testng.annotations.DataProvider
	public Object[][] demoData() throws Throwable{
		ExcelUtility excel=new ExcelUtility();
		Object[][] value = excel.readMultipleSetOfData("DataProvider");
		return value;
	}
	@Test(dataProvider="demoData")
	public void readData(String from,String to) 
	{
		System.out.println(from+"------>"+to);
		
	}

}
