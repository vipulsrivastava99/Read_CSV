package com.qait.advancetatoc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class SimpleTest2 {
	 private String param="";
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("before clss exeuted");
	}
	public SimpleTest2(String param)
	{
		this.param=param;
	}
	@Test
	public void testmethod()
	{
		System.out.println("test method value is "+ param);
	}
	
} 
