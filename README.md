A few words about the reporting solutions:
•	All solutions are built with Java, Selenium WebDriver, TestNG and Maven.
•	All code is structured using page object model.
•	The page classes use a base page class for common page information
•	The test class uses a base test class for the driver variable and test fixtures.
All solutions implement a simple test case for the Assignments:
Assignment 1:
•	Open google.com and enter any keyword
•	Retrieve the top 10 results
•	Store it in a file
•	Repeat this operation for any other 5 keywords
•	Read the values from the file and display it in the console
Assignment 2:
•	Open google.com and enter any keyword
•	Open the top 10 results in the page
•	Check if all the links are working fine
•	Search for the entered keyword in the page
•	Display the number of occurrences of the keyword in the page
Folder and Files in the Project:
•	com.practice.pages – it will give you the POM concept to store Object and basic methods
•	config – to store the url, chromepath and browser name
•	testData – it holds the text file to write and read the stored results
•	utilities – this will give you to read data from different files
•	com.practice.tests – this holds the assignments class file to achieve the expected results
•	log - it will give you the generated logs after the execution of the test cases
Improvements required:
•	Test data file should be dynamic to run the test.
