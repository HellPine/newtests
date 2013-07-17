package TESTS;

import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import java.net.*;


public class ContentTest {
  		
  static String separator="<p>\n------------------------------------------------------------------------------------------</p>\n\n";
  static String result="";
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  
  static Connection con = null;
	static String servername="db4free.net";
	static String username="hellpine";
	static String db="firsttry";
	static String pass="111111";
	public static ResultSet rs=null;
	public static Statement stat=null;
	public int cu=0;
	public int ban=0;
	public int tc=0;
	public int rg=0;
	public int end=0;
	public int id=0;	
	
	
	public void readdatabase(String[] args) throws Exception {
		
		if(args.length>=1){
	    	baseUrl=args[0];
	    }else{
	    	baseUrl="http://carlton.minver.com/carlton/bingo/home/";
	    }
			
		
	}
  
	@Before
	
	public void setUp() throws Exception {
	
	 
	
	//baseUrl= JOptionPane.showInputDialog(null,"Please write URL to test");
	driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    baseUrl="http://carlton.minver.com/carlton/bingo/home/";
    driver.get(baseUrl);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	test();  
    //cus(result);
  }
  
	
	
  @Test
   
   public void test() throws Exception {
	  
	  	  
	  if(cu==1& end==0){
		  
		end=1;
		cus();
	  		  	
	  }
	  
	  if(ban==1 & end==0){
		  
		  end=1;
		  banktest();
		  
	  }
	  
	  if(tc==1 & end==0){
		  
		  end=1;
		  termsandconditions();
		  
  		}
	  if(rg==1 & end==0){
		 
		  end=1;
		  responsiblegaming();
		  
  		}
		  
	  
	  if(end==0){
	  
	  JOptionPane.showMessageDialog(null,
  		    result,
  		    "Test Results For"+baseUrl,
  		    JOptionPane.INFORMATION_MESSAGE);
  		driver.close();
	    	    
  		try{
	    	
	    	
	    	File file=new File("report"+id+".htm");
	    	
	    	String header="<html>\n<head>\n<title>Report</title>\n</head>\n<body>\n<h1>\nReports</h1>\n<p>\n-----------------------------------------------------------------------------------------</p>\n";
	    	String footer="<p>\n------------------------------------------------------------------------------------------</p>\n\n<strong>Report End</strong></p>\n</body>\n</html>\n";
	    	FileWriter write = new FileWriter(file,true);
	    	write.write(header);
	    	write.write("<p>"+result+"<p>");
	    	write.write(footer);
	    	write.close();
	    	
	    }catch(Exception e){
	    	
	    	 JOptionPane.showMessageDialog(null,
	    	  		    "File Error",
	    	  		    "Error",
	    	  		    JOptionPane.ERROR_MESSAGE );
	    }
	  }System.exit(0);
  }
  
  public void cus() throws Exception {
    
	//Vars 
	
	String cus="Contact Us"; 
	String mainwindowname= driver.getWindowHandle(); //Get the name of the main window	
	String currentURL="";
	boolean success = true;
	
	
    // Looking for a Contact Us Link
    
    System.out.println(result);
	result=result+"<p><p><strong>Contact US TEST</strong><p><p>";
	result=result+separator;
	try {
    	driver.findElement(By.linkText(cus));
    } catch (NoSuchElementException e1){
    	cus="contact us";						//Control different spelling for Contact Us Link
    	try{
    		driver.findElement(By.linkText(cus));
    	}catch (NoSuchElementException e2){
    		cus="Contact us";
    		try{
        		driver.findElement(By.linkText(cus));
        	}catch (NoSuchElementException e3){
        		success=false;
        		result=(result + "Contact Us Not Finded\n"); 
        		//If no Contact Us 
    	}}
    } finally{
    	if (success){
    		//If a Contact Us finded
    		driver.findElement(By.linkText(cus)).click(); //Click on it
    		
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		
    		if(driver.getPageSource().contains("support@casino-response.com")||driver.getPageSource().contains("support@bingoresponse.com")){
    			result=result+"<p>E-mail Shown<p>";
    			
    			}else{
    				result=result+"<p>E-mail absent<p>";
    			
    			}

    		if(driver.getPageSource().contains("0800 376 2814")||driver.getPageSource().contains("0800 376 5619")){
    			result=result+"<p>UK Phone Shown<p>";
    			
    			}else{
    				result=result+"<p>UK Phone absent<p>";
    			
    			}
    		
    		if(driver.getPageSource().contains("+350 20049552")||driver.getPageSource().contains("+350 200 79264")){
    			result=result+"<p>Intl Phone Shown<p>";
    			
    			}else{
    				result=result+"<p>Intl Phone absent<p>";
    			
    			}
    		
    		if(driver.getPageSource().contains("Casino Response")||driver.getPageSource().contains("Bingo Response")){
    			result=result+"<p>Adress Shown<p>";
    			
    			}else{
    				result=result+"<p>Adress absent<p>";
    				
    			}
    	
    	} 	
    	}
    //banktest();
    //JUnitCore.main();
    System.out.println(result);
    cu=0;
    end=0;
    result=result+separator;
    test();
   }
  
    	
   	public void banktest()throws Exception {
    		String mainwindowname= driver.getWindowHandle(); //Get the name of the main window	
    		String currentURL="";
    		
    		boolean success = true;
    		
    		String cardselect="";
    	// Looking for a Banking Link
        String bkn="Banking";
    	
        success=true;
        result=result+"<p><p><strong>BANKING TEST</strong><p><p>";
        result=result+separator;
        try {
        	driver.findElement(By.linkText(bkn));
        } catch (NoSuchElementException e3){
        	bkn="banking";
        	try{
        		driver.findElement(By.linkText(bkn));
        	}catch (NoSuchElementException e2){
        	
        		success=false;
        		result=(result + "<p>Banking Link not found<p>"); 
        		//If no Banking link 
        	}
        } finally{
        	if (success){
        		//If a Banking Link is finded/
        		driver.findElement(By.linkText(bkn)).click(); //Click on it
        		
        		try {
    				Thread.sleep(3000);
    			} catch (InterruptedException e4) {
    				// TODO Auto-generated catch block
    				e4.printStackTrace();
    			}
        		
        		success=true;
        		cardselect="Visa";
        		if(driver.getPageSource().contains("Visa")||driver.getPageSource().contains("VISA")){
        			result=result+"<p>Visa present<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e5){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e6) {
        	        				// TODO Auto-generated catch block
        	        				e6.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			if(currentURL.contains("http://www.visa.")||currentURL.contains("https://www.visa.")){ //check taht the page is correct
        	        				result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close Visa page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Visa absent<p>";
        			
        			}

        		cardselect="Visa Debit";
        		success=true;
        		if(driver.getPageSource().contains("Visa Debit")||driver.getPageSource().contains("VISA DEBIT")){
        			result=result+"<p>Visa Debit Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+ cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			if(currentURL.contains("http://www.visa.")||currentURL.contains("https://www.visa.")){ //check taht the page is correct
        	        				result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close Visa page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Visa Debit not present<p>";
        			
        			}
        		
        		cardselect="Visa Electron";
        		success=true;
        		if(driver.getPageSource().contains("Visa Electron")||driver.getPageSource().contains("VISA ELECTRON")){
        			result=result+"<p>Visa Electron Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>" +cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			if(currentURL.contains("http://www.visa.")||currentURL.contains("http://www.visa.")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close Visa page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Visa Electron absent<p>";
        			
        			}
        		cardselect="MasterCard";
        		success=true;
        		if(driver.getPageSource().contains("MasterCard")||driver.getPageSource().contains("MASTERCARD")){
        			result=result+"<p>MasterCard Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			
        	        			if(currentURL.contains("http://www.mastercard.")||currentURL.contains("https://www.mastercard.")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"Check "+cardselect+" Linked Page\n";
        	        			driver.close(); // Close Visa page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>MasterCard absent<p>";
        				
        			}
        	
        		cardselect="Maestro";
        		success=true;
        		if(driver.getPageSource().contains("Maestro")||driver.getPageSource().contains("MAESTRO")){
        			result=result+"<p>Maestro Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+ cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			currentURL=driver.getCurrentUrl();
        	        			
        	        			if(currentURL.contains("http://www.maestrocard")||currentURL.contains("https://www.maestrocard")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Maestro absent<p>";
        				
        			}
        	
        		cardselect="Paypal";
        		success=true;
        		if(driver.getPageSource().contains("PayPal")||driver.getPageSource().contains("PAYPAL")){
        			result=result+"<p>PayPal Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        				cardselect="PayPal";
        				try{
            				driver.findElement(By.linkText(cardselect)); //Check for visa link
            			}catch (NoSuchElementException e2){
       			
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link
            			}
        	        } finally{
        	        	if (success){
        	        		driver.findElement(By.linkText(cardselect)).click();
        	        		try {
        	        			Thread.sleep(3000);
        	        		} catch (InterruptedException e2) {
        	        			// TODO Auto-generated catch block
        	        			e2.printStackTrace();
        	        		}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			        	        			
        	        			if(currentURL.contains("https://www.paypal.")||currentURL.contains("http://www.paypal.")){ //check that the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>PayPal absent<p>";
        				
        			}
        		
        		cardselect="NETELLER";
        		success=true;
        		if(driver.getPageSource().contains("Neteller")||driver.getPageSource().contains("NETELLER")){
        			result=result+"<p>Neteller Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			currentURL=driver.getCurrentUrl();
        	        			
        	        			if(currentURL.contains("http://www.neteller.")||currentURL.contains("https://www.neteller.")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Neteller absent<p>";
        				
        			}
        		
        	cardselect="Skrill (Moneybookers)";
        	success=true;	
        		if(driver.getPageSource().contains("Skrill")||driver.getPageSource().contains("SKRILL")){
        			result=result+"<p>Skrill Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        				cardselect="Skrill (moneybookers)";
        				try{
            				driver.findElement(By.linkText(cardselect)); //Check for visa link
            			}catch (NoSuchElementException e2){
       			
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link
            			}
        	        } finally{
        	        	if (success){
        	        		driver.findElement(By.linkText(cardselect)).click();
        	        		try {
        	        			Thread.sleep(3000);
        	        		} catch (InterruptedException e2) {
        	        			// TODO Auto-generated catch block
        	        			e2.printStackTrace();
        	        		}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			
        	        			currentURL=driver.getCurrentUrl();
        	        			        	        			
        	        			if(currentURL.contains("https://www.moneybookers.")||currentURL.contains("http://www.moneybookers.")){ //check that the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Skrill absent<p>";
        				
        			}
        		
        		cardselect="PaySafeCard";
        		success=true;
        		if(driver.getPageSource().contains("PaySafeCard")||driver.getPageSource().contains("PAYSAFECARD")){
        			result=result+"<p>PaySafeCard Shown<p>";
        			
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + cardselect+" Link not found\n"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			currentURL=driver.getCurrentUrl();
        	        			
        	        			if(currentURL.contains("https://www.paysafecard.")||currentURL.contains("http://www.paysafecard.")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
	        	
        			}else{
        				result=result+"<p>PaySafeCard absent<p>";
        				
        			}
        		
        		cardselect="Ukash";
        		success=true;
        		if(driver.getPageSource().contains("Ukash")||driver.getPageSource().contains("UKASH")){
        			result=result+"<p>Ukash Shown<p>";
        			try{
        				driver.findElement(By.linkText(cardselect)); //Check for visa link
        			}catch (NoSuchElementException e1){
        	        	        	        	
        	        		success=false;
        	        		result=(result + "<p>"+cardselect+" Link not found<p>"); 
        	        		//If no Banking link 
        	        	} finally{
        	        		if (success){
        	        			driver.findElement(By.linkText(cardselect)).click();
        	        			try {
        	        				Thread.sleep(3000);
        	        			} catch (InterruptedException e1) {
        	        				// TODO Auto-generated catch block
        	        				e1.printStackTrace();
        	        			}
        	        			
        	        			//Switch to new window opened
        	        			for(String winHandle : driver.getWindowHandles()){ //switch to visa page
        	        			    driver.switchTo().window(winHandle);
        	        			}
        	        			currentURL=driver.getCurrentUrl();
        	        			
        	        			if(currentURL.contains("https://www.ukash.")||currentURL.contains("http://www.ukash.")){ //check taht the page is correct
        	            			result=result+"<p>"+cardselect+" page correct<p>";
        	        			}else
        	        				result=result+"<p>Check "+cardselect+" Linked Page<p>";
        	        			driver.close(); // Close opened page
        	        			
        	        			driver.switchTo().window(mainwindowname); //back to main page
        	        		}
        	        	}
        			}else{
        				result=result+"<p>Ukash absent<p>";
        				
        			}
        		
        		        	
     		        	
        	}
        }ban=0;
        end=0;
        result=result+separator;
        test();
    }
  
   	public void termsandconditions()throws Exception { //Term & Conditions test
		String mainwindowname= driver.getWindowHandle(); //Get the name of the main window	
		String currentURL="";
		
		boolean success = true;
		
		
	// Looking for a T&C Link
  String tac="Terms and Conditions"; //first option
	
  success=true;
  result=result+"<p><p><strong>Terms & Conditions</strong><p><p>";
  result=result+separator;
  try {
  	driver.findElement(By.linkText(tac));
  } catch (NoSuchElementException e3){
  	tac="terms & conditions"; //2nd option
  	try{
  		driver.findElement(By.linkText(tac));
  	}catch (NoSuchElementException e2){
  		tac="Terms & Conditions";
  		try{
  	  		driver.findElement(By.linkText(tac));
  	  	}catch (NoSuchElementException e4){
  	  		success=false;
  	  		result=(result + "<p>Terms & Conditions Link not found<p>"); 
  	  		//If no T&C link 
  	}}
  } finally{
  	if (success){
  		//If a Banking Link is finded/
  		driver.findElement(By.linkText(tac)).click(); //Click on it
  		
  		try {
				Thread.sleep(3000);
			} catch (InterruptedException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
  		
  		if(driver.getPageSource().contains("404")){
			result=result+"<p>Check T&C Page<p>";
  		}else{
  			result=result+"<p>T&C Page is OK<p>";
  		
  			tc=0;
  		    end=0;
  		  result=result+separator;
  		    test();
  	}}
  }
  }
   	
   	public void responsiblegaming()throws Exception { //Responsible Gaming test
		String mainwindowname= driver.getWindowHandle(); //Get the name of the main window	
		String currentURL="";
		
		boolean success = true;
		
		
	// Looking for a T&C Link
  String tac="RESPONSIBLE GAMING"; //first option
	
  success=true;
  result=result+"<p><p><strong>Responsible Gaming</strong><p><p>";
  result=result+separator;
  try {
  	driver.findElement(By.linkText(tac));
  } catch (NoSuchElementException e3){
  	tac="responsible gaming"; //2nd option
  	try{
  		driver.findElement(By.linkText(tac));
  	}catch (NoSuchElementException e2){
  		tac="Responsible Gaming";
  		try{
  	  		driver.findElement(By.linkText(tac));
  	  	}catch (NoSuchElementException e4){
  	  		success=false;
  	  		result=(result + "<p>Responsible Gaming Link not found<p>"); 
  	  		//If no T&C link 
  	}}
  } finally{
  	if (success){
  		//If a Responsible Gaming Link is finded/
  		driver.findElement(By.linkText(tac)).click(); //Click on it
  		
  		try {
				Thread.sleep(3000);
			} catch (InterruptedException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
  		
  		if(driver.getPageSource().contains("404")){
			result=result+"<p>Check Responsible Gaming Page<>";
  		}else{
  			result=result+"<p>Responsible Gaming Page is OK<p>";
  		
  			rg=0;
  		    end=0;
  		  result=result+separator;
  		    test();
    		
  	}}
  }
  }
	 
       
 

 
  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}



