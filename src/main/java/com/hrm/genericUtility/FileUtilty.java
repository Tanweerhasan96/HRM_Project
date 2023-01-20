package com.hrm.genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class is used to fetch the data from Property file
 * @author Tanweer
 *
 */
public class FileUtilty 
{
	/**
	 * This method is used to read the data property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	public String fileUploadAbsolute()
	{
		File file = new File(IPathConstants.Resume);
		String absolute = file.getAbsolutePath();
		return absolute;
	}
	

}
