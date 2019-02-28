package com.thc.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.thc.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	@Override
	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("Alert Accepted : " + arg0);
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("Alert Dismissed : " + arg0);
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		//System.out.println(" ");
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("after Clicked on : " + arg0);
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		System.out.println("Element : "+ arg1 + ", found By : "+ arg0);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("Navigated back ");
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("Navigated forword ");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("Refreshed page . . .  ");
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("Navigated to - "+arg0);
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		//System.out.println(" ");
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("Accepting alert  . . .  ");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("Dismissing Alert . . .  ");
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
//		System.out.println(" ");
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Clicking on : " + arg0);
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Finding element : "+arg1);
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Navigating back . . .  ");
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Navigating Forword . . .  ");
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("Refreshing . . . ");
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("Navigating to . . .  ");
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
	//System.out.println(" ");
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("Exception has occured .... taking SCREENSHOT...");
		ScreenShot.takeScreenShot();
	}
}
