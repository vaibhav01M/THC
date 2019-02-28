package com.thc.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.thc.base.TestBase;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot extends TestBase{
 
	public static void takeScreenShot() {

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AShot as = new AShot();// creating an instance of AShot as to take Screen Shot
		Date date = new Date();// Creating an instance of Date , format is -> Mon Sep 03 13:06:56 IST 2018
	 
		// System.out.println("Day, Date & Time -> "+ date); // printing to check format - Mon Sep 03 13:06:56 IST 2018
									                      // Mon Sep 03 13:06:56 IST 2018 <- this format contains ":" & it is not allowed in file name
									                      // as we need file name with date+time, so we have to define new format

		SimpleDateFormat formatter = new SimpleDateFormat(" - E, dd MMM yyyy, HH_mm_ss");// SimpleDateFormat allows you to start by choosing any user 
		                                                                                // defined pattern for date-time formatting
																					 
		String DateFormat = formatter.format(date);// Passing the Date date instance as argument to formatter to madify as per user demand																	 
	    Screenshot ScrShot = as.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);// taking ScreenShot

		try {
			ImageIO.write(ScrShot.getImage(), "png", new File("F:\\Java Basic\\THC\\ScreenShot\\" + DateFormat + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
