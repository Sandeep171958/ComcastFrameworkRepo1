package tp.crm.genericUtility.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int randomNumber() {
		Random rom = new Random();
		int randomNum = rom.nextInt(10000);
		return randomNum;

	}

	public String getSupportStartDate() {
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String sDate = sim.format(date);
		return sDate;

	}

	public String getSupportExpiryDate(int days) {
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, days);
		String sedate = s.format(c.getTime());
		return sedate;
	}

}
