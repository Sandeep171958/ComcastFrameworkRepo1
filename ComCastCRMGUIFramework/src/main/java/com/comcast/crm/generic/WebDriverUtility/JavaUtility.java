 package com.comcast.crm.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
	     int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	public String getSystemDateYYYYDDMM(){
		Date dateobj=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String date = sdf.format(dateobj);
		return date;
		
	}
	public String getRequiredDateYYYYDDMM(int days) {
		  
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
			Calendar ca1=Calendar.getInstance();
			ca1.add(Calendar.DAY_OF_MONTH,days);
			String reqDate = sim.format(ca1.getTime());
			return reqDate;
	}
	

}
