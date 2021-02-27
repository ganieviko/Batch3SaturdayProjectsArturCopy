package Project20;

public class Project20 {
}

/*
This project does not require Page Object Model
You do not have to use Cucumber (Java, Selenium and TestNG seem pretty enough but you are free to use other tools too)
You will need to use ApachePOI libraries to handle excel file

- Setup your project (dependencies, driver, etc)

- Login to https://test.campus.techno.study

- Navigate to Employees page under Human Resources menu

- Click on the three dots button on the left bottom of the Employees page

- Click on Excel Export and save the excel file about the employees listed in the page
  By default, there will be info (No, Full Name, Status, Employee Type, Gender) about first 10 employees in the excel file.

- (Optional step!) Try to save the excel file into a folder whose path is defined by you.
  So that, your test will not depend on Download folder in your computer but can be downloaded in a folder we define.
  This will be very helpful since this test will not be specific to your computer but it can run in any computer.

- Read from the excel file and to validate all the information on the Employees page correctly saved/exported.
  The way you validate each info is up to you! You are the tester.
  (Obviously the photos will not be in the excel file, ignore the photos. Selenium cannot test the graphical content anyway)

- (Optional) Try to use only only one test case because you are actually testing only one thing: Export Excel functionality

Good luck!
 */
