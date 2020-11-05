# Acoustic

1. Assignment document is uploaded to repository with solution. File name - "QA Assignment.docx"
2. Test cases document is uploaded with name "Acoustic - Test Cases.xlsx".
3. Automation code:
  Used page object model with page factory to automate this scenario. 
  Also used TestNG with Maven for better management of code and dependancies. 
  Below is the structure of this framework:
      src/main/java ->
          package- baseClass : Have defined all the things we are being used in overall project.
          package- listeners : Contains ITestListenern methods for reporting purpose
          package- pom_HomePage : Contains the classes for login page and home page(page where dropdowns are present). Each class contains data members and method for respective pages.
          package- utilities : This contains common utilities like excel reading, capturing screenshots, reading config file and extent report methods
      
      src/main/resources/config -> Contains xml file with extent report configurations
      
      src/test/java ->
          package- testCases : contains class NewTest.java where we have written all the required tests. Required test cases are annoted with @DataProvider test annotation to run the test case for multiple set of data.
         
      src/test/resources/testConfig -> Defines browser name, URL, user name & password to be used. This file to be modified if any of the value has to be changed.
      
      pom.xml : project dependancies
      
      testng.xml : You can run this file as TestNG Suite. In this file have mentioned the name of test case and also appended listeners to generate reports.
      
      
      
