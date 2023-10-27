# Amazon PageObject Project
-----------------------

❓ What is this Repository about?
-----------------------

This project has the example code for an automation testing project for the Amazon e-commerce website using Selenium WebDriver Java, TestNG, Maven. The project aims to automate the testing of various scenarios on the Amazon website and ensure the website's functionality is not affected by any changes.

✨ Scenario covered
-----------------------

- Login to Amazon with Valid credential
- Navigate and select iteam from the burger menu 
- Click On "See more" to choose "Video Game" and then choose "Video Game" from the list
- Filter the product based on "xbox" 
- Sort the product from "Price: High to low"
- Add all products below that its cost below 15k EGP, 
- View Cart to make sure that all product was added 
- Add address to the shipment 
- Make sure that total amount of all iteam is correct when shipping fees added

Some elemnts of the test was missing due to Amazon zone configration Please note the following:
- that in my current location we don't have cash payemnt, so I couldnt do this step
- I choose "Video games" intead of "All video games"
- No freeShepping so I have decided to filter by xbox

Running the project
-----------------------

💻 Requirements
- Java 11 .
- Latest Version of Maven
- Git
- Chrome browser
- Chromedriver (Make sure that the chrome and chromedriver have the same version)
- Inellij IDEA

⚙️ Setup
-----------------------

1 - Clone this repository to your local machine.
2 - Install the required dependencies using Maven.
3 - Download the latest version of chromeDriver and place it in the project's root directory.
4 - Open the ChromeController file and update the browser path to your current path of the chromedriver.
5 - Running the Tests

Kindly note that this a page Object project, and I have used an approach to create a saperate class for selectors just for better documention and it doen't effect the page object pattern implemention at all

✨ Project Folder Description
-----------------------

Now here I'm going to explain each class and what it do exactly in small description:

- Controllers
	- BaseTest --> It is responsible for setting up and tearing down test environments it include the Befor and After class
	- ChromeController/Edge/Firefox -->managing the interaction with the  web browser.
	- ControllerFactory --> The ControllerFactory class appears to be a factory class for creating instances of classes that implement 				the ControllerInterface. It is used to provide flexibility in selecting and creating specific drivers for 				different web browsers.
	- ThreadLocalDriver --> The ThreadLocalDriver class is a utility class for managing WebDriver instances in a thread-safe and 					thread-local manner. to ensure that each thread (test execution thread) has its own WebDriver instance, 				making it safe for parallel test execution. 
	-WebDriverEventHandler --> The WebDriverEventHandler class is an implementation of the WebDriverListener interface for Selenium. 				It allows you to listen for various WebDriver events and execute code before or after those events. This 				is typically used to add custom behavior or interactions with the WebDriver during test execution.
-Logging
	-StepsLogging ---> The StepsLogging class appears to be a simple logging utility for test automation using TestNG. It is designed 			to log test steps and related information during test execution. 
- Pages This will contain all page Object pages

- Reporting --> will include the reporting of the test 

- utils
	-ActionHelper --> in this class we creat all the common used method that we need 
	- AllPagesHander --> handling various pages and their elements in web application. It acts as a factory for 				     creating page objects for different pages of the web application.
	-File --> just to declare file type if needed
	- StateHelper -->utility class designed to help manage and store state information during the execution of test steps in a test 			automation framework. It provides methods for setting, getting, clearing, and determining the size of a state map
