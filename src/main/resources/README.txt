Branch devCRUD 

- This is a basic sample of CRUD operation using spring boot. It contains the following layers

 - PRESENTATION LAYER
 - DATA ACCESS LAYER
 - SERVICE LAYER
 
 
 BRANCH devCRUDFORWAR
 
 - This has CRUD and packaged into WAR file for deployment to application server like jboss or apache.
 
 
 BRANCH devCRUDWAREMAIL
 
 - This change the pom to add dependecy for email 
 - additional package util 
 - change the properties added spring.mail 
 - change the ContractorController to use the email utility
 - on the browser login to your gmail account and switch on the allow less secure apps
     https://myaccount.google.com/u/0/lesssecureapps?pli=1&pageId=none
     
 BRANCH devCRUDWAREMAILREPORT
 
 - This change the pom to add dependency for report utility
 - additional classes added in package contractor.util
 - added in pom file 
    <!-- added for report utility sample use for using a thirdparty utility -->
		<dependency>
			<groupId>org.jfree</groupId>
			<artifactId>jfreechart</artifactId>
			<version>1.0.19</version>
		</dependency>
	ref. link: type  jfreechart maven dependency in google search and get 1.0.19 version
	
 - to test it type /generateReport this will call the jsp report.jsp to disply the graph
     
     
     
    
     
BRANCH devCRUDWAREMAILREPORTREST

  - This branch contain RestController classes
  - It can only be tested on Postman

BRANCH devCRUDWAREMAILREPORTRESTLOGIN

  - Login functionality added
  - needs password encryption
  - this the branch that works fine
 
  
  
 ON WINDOWS 
 - open the mysql workbench
 - start the server
 
 WHEN RUNNING THE APPLICATION ON THE WEB
 
-RUN AS spring app
-Type in the browser http://localhost:8080/contractorweb/login

- Generate a report 
  http://localhost:8080/contractorweb/generateReport
- Test the email
  login
  create record
  then save - this will call the savcon which will call PdfGenerator (rename the file as .pdf)  and  Email utility
  

dev3  - First stable branch with all the functionality of CRUD and Presentation Layer.  This is being used by FRONT-END REACT
 


 
 
 
 
 
