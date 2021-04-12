package com.practice.tests;


import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.practice.pages.GoogleSearchPage;
import utilities.ReadConfig;



public class Assignment1 extends BaseClass{
	
	BaseClass bc= new BaseClass();
	ReadConfig rc= new ReadConfig();
	
	@BeforeClass
	public void openChrome() throws IOException{
		bc.setup(rc.readFromPropertyFile("browserName"));
		logger.info("URL is opened");
		
		if(driver.getTitle().equals("Google"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
		}

    }
	
	@Test(dataProvider="test-data")
	public void readTopURL(String keyword, int requiredNoOfresults) throws IOException{
		logger.info("Enter text");
		GoogleSearchPage gsp=new GoogleSearchPage(driver);
		gsp.enterSerachText(keyword);
		List<String> topURLs= gsp.readSearchRsults(requiredNoOfresults);
		//System.out.println(topURLs.size());
		gsp.writeFile(topURLs);
		gsp.readFile();
    }


	
	@AfterClass
	public void closeBrowser() throws IOException{
		bc.tearDown();

    }
	
    //1st parameter is search keyword and 2nd is the top urls to fetch
	@DataProvider(name="test-data")
	public Object[][] dataProviderfunc()
	{
		return new Object [][]
	{
			{"Ferrari",10},{"Renault",10},{"Mercedes",10},{"Honda",10},{"Lamborghini",10}
			};

	}
	
}