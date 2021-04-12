package com.practice.pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	
	public WebDriver driver;
	//String filePath = "C:\\Users\\NKusingh\\eclipse-workspace\\MyTest\\src\\main\\java\\testData\\DataFile.txt";
	

	public GoogleSearchPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);

	}
	

	@FindBy(name="q")
	@CacheLookup
	WebElement txtSearch;

	@FindBy(xpath="//body/div[1]/div[2]/div[1]/img[1]")
	@CacheLookup
	WebElement homePageTitle;
	
	@FindBy(xpath="//*[@id='rso']//h3/following::a")
	@CacheLookup
	WebElement urlresults;
	
	@FindBy(xpath="//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath="*//div[@id='cnt']/div[@id='rcnt']//a")
	@CacheLookup
	WebElement searchResults;
	
	
	public void enterSerachText(String txt)
	{
		txtSearch.clear();
		txtSearch.sendKeys(txt+ Keys.ENTER);
		
		
	}
	
	public void clickSubmit()
	{
		btnSearch.submit();
	}
	
	public List<String> readSearchRsults(int requiredNoOfresults)
	{
	List<String> currentURL = new ArrayList<>();
	List<WebElement> listResult= driver.findElements((By.xpath("*//div[@id='cnt']/div[@id='rcnt']//a")));
	//System.out.println(listResult.size());
	int searchURL = 1;
	//if you want to print matching results
	     for(int i = 0; i < listResult.size(); i++)
	       {
	    	 if(searchURL <= requiredNoOfresults)
	    	 {
	    		 //String value= searchResults.getText();
	    		 currentURL.add(searchResults.getText());
	    		 //System.out.println(value);
	    		 searchURL++;
	    		 
	    	 }
	       } 
	     return currentURL;
	}
	
	public void writeFile(List<String> currentURL)
            throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\NKusingh\\eclipse-workspace\\MyTest\\src\\main\\java\\testData\\DataFile.txt", true);
        int size = currentURL.size();
        for (int i=0;i<size;i++) {
            String str = currentURL.get(i).toString();
            fw.write(str);
            //if(i < size-1)//This prevent creating a blank like at the end of the file
            	//fw.write("\n");
        }
        fw.close();
    }
	

	public void readFile()
            throws IOException {
        FileReader fr = new FileReader("C:\\Users\\NKusingh\\eclipse-workspace\\MyTest\\src\\main\\java\\testData\\DataFile.txt");
        BufferedReader reader = new BufferedReader(fr);
        String s=null;
        while((s = reader.readLine()) != null )
        {
        	System.out.println("Data URl is :"+s);
        }
        
        reader.close();
        
    }
	public List<String> openSearchURL(int requiredNoOfresults) throws InterruptedException
	{
	List<String> currentURL = new ArrayList<>();
	List<WebElement> listResult= driver.findElements((By.xpath("*//div[@id='cnt']/div[@id='rcnt']//a")));
	//System.out.println(listResult.size());

	int searchURL = 1;
	//if you want to print matching results
	     for(int i = 0; i < listResult.size(); i++)
	       {
	    	 if(searchURL <= requiredNoOfresults)
	    	 {
	    		 String s=listResult.get(i).getText();
	    		 String url=s.substring(24);
	    		 System.out.println("My URL is :"+url);
	    		 //listResult.get(i).click();
	    		 ((JavascriptExecutor)driver).executeScript("window.open()");
	    		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    		 driver.switchTo().window(tabs.get(1)); //switches to new tab
	    		 driver.get(url);
	    		 //switch window from child to parent
	    		 
	    		 searchURL++;
	    		 
	    	 }
	    	// driver.close();
	    	 Thread.sleep(3000);
	    	 driver.navigate().back();
	       } 
	     return currentURL;
	}
	
	public void occurrencesOfString(String keyword) {
		// get the text of the body element
		WebElement body = driver.findElement(By.tagName("body"));
		String bodyText = body.getText();

		// count occurrences of the string
		int count = 0;

		// search for the String within the text
		while (bodyText.contains(keyword)){

		    // when match is found, increment the count
		    count++;

		    // continue searching from where you left off
		    bodyText = bodyText.substring(bodyText.indexOf(keyword) + keyword.length());
		}
		System.out.println("Number of occurrences of the is :"  + count);
		
	}
}
