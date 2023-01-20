package com.hrm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		String dd = dateAndTime.split(" ")[2];
		String mm = dateAndTime.split(" ")[2];
		 
		String finalDate = yyyy+" "+mm+" "+dd;
		return finalDate;
		
	}
	public String systemDateAndTime()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yy HH:MM:SS");
		Date systemDate = new Date();
		String getDateAndTime = dateFormat.format(systemDate);
		System.out.println("getDateAndTime");
		return getDateAndTime;
		
	}
	

}
