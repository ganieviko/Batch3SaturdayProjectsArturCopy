package Project18;

public class Part1 {
}

/*
Feature: Adding a user and logging in by using the user we have created on the

* Create a Background step to open the webpage "http://thedemosite.co.uk/"

* Scenario outline: User cannot be created with short credentials
  (you need to navigate to adduser page by clicking "3.Add a User" link
  Examples:
    - if the username length is less than 4 characters but password length is four or more
    - if the password length is less than 4 characters but username length is four or more
    - Both username and password lengths are less than 4 characters

* Scenario: User can be created with a username and a password whose lengths are more than 3 characters

* Scenario: User can login by using the credentials that have just been created

* Scenario outline: User cannot login with invalid credentials
  Examples:
   - with an invalid username and a valid password
   - with a valid username and an invalid password
   - with an invalid username and an invalid password

* Scenario outline: User cannot login if at least one of the credentials is less than 4 characters
  Examples:
   - with a valid username and a short password
   - with a valid password and a short username
   - both username and password are short
 */
