package com.thc.util;

import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethod {

	@Override
	public boolean isTestMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConfigurationMethod() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITestNGMethod getTestMethod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITestResult getTestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ScreenShot.takeScreenShot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
