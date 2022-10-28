# contractorweb
CONTRACTOR WEB APPLICATION PROJECT
Broker of Home Improvement

Updates: 

17-Oct-2022

1. Update the pom.xml in such a way that it can be packaged the contractorweb into war file
2. The war file is tested on Apache Tomcat ver. 8.5 .   https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.0/bin/
	On installing the Apache Tomcat on windows follow the steps in this link https://www.javatpoint.com/spring-boot-project-deployment-using-tomcat

3. On deploying the war file
	a. Build the project
	b. Copy the file /target/contractor.war to Apache tomcat web container folder e.g. C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps
	c. Run from the browser http://localhost:8080/contractorweb/login
	
Updates 25-Oct-2022

1. Reference on Udemy Security 
2. Changes were made to have password encrypted, added the user_role and role tables
3. Please see below files changes and added 
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   contractor.sql
        modified:   pom.xml
        modified:   src/main/java/com/gino/contractor/controllers/ContractorController.java
        modified:   src/main/java/com/gino/contractor/entities/User.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        src/main/java/com/gino/contractor/entities/Role.java
        src/main/java/com/gino/contractor/repos/RoleRepository.java
        src/main/java/com/gino/contractor/security/
        src/main/java/com/gino/contractor/service/SecurityService.java
        src/main/java/com/gino/contractor/service/SecurityServiceImpl.java
        src/main/java/com/gino/contractor/service/UserDetailsServiceImpl.java

devphase1 Updates 26-Oct-2022
1. Modified and pushed 
        modified:   contractor.sql
        modified:   pom.xml
        modified:   src/main/java/com/gino/contractor/controllers/ContractorController.java
        modified:   src/main/java/com/gino/contractor/entities/User.java
        
        Added

        src/main/java/com/gino/contractor/entities/Role.java
        src/main/java/com/gino/contractor/repos/RoleRepository.java
        src/main/java/com/gino/contractor/security/
        src/main/java/com/gino/contractor/service/SecurityService.java
        src/main/java/com/gino/contractor/service/SecurityServiceImpl.java
        src/main/java/com/gino/contractor/service/UserDetailsServiceImpl.java




