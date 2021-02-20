package Project19;

public class Project19 {
}

/*
Design your project as POM (Page Object Model)
In your test framework you are asked to use JAva, Selenium, TestNG and Cucumber
We will test the campus website (https://test.campus.techno.study)
The username is "daulet2030@gmail.com" and the password is "TechnoStudy123@"
Do not use Thread.sleep()
Good Luck!


Tests:
- You are expected to test/verify that
   + we can create an employee with the min required info
   + we can update the employee we have created
     Test to update of at least three different info, each one at a time (Scenario Outline)
   + we can delete the employee we have created
- You are also expected to create your own tests (similar to employees) regarding "entrance exams"

Project Structure:
- Open a new Maven project
- Add your necessary dependencies (Do not forget to synchronize by clicking on the Maven icon icon)
- In your "java" folder under the "test" folder create the following folders:
   * features
   * pages
   * runners
   * stepDefinitions
   * utilities
- In the features folder create a cucumber feature file to write your test steps.
  Preferable one for employees tests and one for entrance exam tests scenarios
  Define your test steps so that they will be re-usable in other tests as much as possible
  Use Gherkin language for your test steps (Given, When, Then, And, etc)
- In pages folder, create a Base class having common methods for other page classes
  Also create the page classes for each page or section or component you will use for your tests
  In your page classes there should not be anything more than the web elements you need for testing
  and the corresponding actions of those web Elements. And the constructor of the page class.
- Keep your step definition methods of the cucumber test steps in the stepDefinitions folder.
- Create a Hook class in stepDefinitions folder. Keep your @Before and @After annotated methods here
- Create a method in the Hook class which takes screenshot after each scenario that fails
  Create a "resources" folder under "test" folder (and assign it as resources folder if IntelliJ does not do it automatically)
  As you wish you may create a "screenshots" folder under resources folder and save your screenshot files there (remember from mentoring sessions),
  or alternatively you may directly attach your screenshots to your html file (remember from Dauke's class)
- Create a singleton pattern Driver class in order to ensure the existence and uniqueness of the
  WebDriver whenever we need it. Create this singleton WebDriver class in the utilities folder
- Create EmployeeTestRunner class and EntranceExamTestsRunner class in the runners folder.In the Cucumber Options of this runner class
  add plugins for creating json and html reports.
- You may add more classes in any folder if you think you need them. But make sure you follow POM design pattern

Challenge:
- Create a "properties" folder under resources class (the one you created inder the test folder)
  Create "config.properties" file in this properties folder.
  Keep the campus homepage url and login credentials in this file.
- Create a class named "ReadFromConfigPropertiesFile" in the utilities folder.
  Let ReadFromConfigFile have a static method that can read and pass the values in the config.properties file

 */
