# Address API Client Application
Address API Client Application is a client of Address API.

### Setting up the Project: 
Address API Client is a Maven-based Spring Boot + JSF application with an embedded tomcat server. Packaging this application in maven produces a runable war that you can run with "java -jar" command locally or on any PAAS that is able to run java. This project is particularly tested with Cloud Foundry (a manifest.yml for Pivotal Cloud Foundry is included). 

Prerequisite:
i) you must have Maven installed in your environment. Test with 
```sh
$ mvn --version
```
If you do not have maven installed, see here:
https://maven.apache.org/install.html
    
ii) if you wish to run this project locally, you must have Java 8 installed. If you wish to run this project on cloud foundry (recommended), you must have Cloud Foudry Command Line Interface installed. If you do not have Cf-cli installed, see here:
https://github.com/cloudfoundry/cli

iii) You must know the URL at which Address API is available. 

1. Clone this project: 
```sh
$ git clone https://github.com/saedalav/addressapiclient.git
$ cd addressapiclient
```
2. Modify /src/main/java/me/alavinia/saed/restclient/CallRest.java and enter the URL at which Address API is available in the following format: 
private static final String URL = "https://addressapi_url/";
```sh
$ vim /src/main/java/me/alavinia/saed/restclient/CallRest.java
$ [Modify the file]
$ wq
```

3. From the project's root directory (where the pom.xml file is present), run Maven's package in order to package the project into a runnable jar 
```sh
$ mvn clean package
```
This will produce target/addressapiclient-0.0.1-SNAPSHOT.war in target directory. This is the runnable jar that you can run either locally or in Cloud Foudry 

4. Run the addressapiclient-0.0.1-SNAPSHOT.war
(a) To run the application locally with Java 8, 
```sh
$ java -jar target/addressapiclient-0.0.1-SNAPSHOT.war
```
The application will be available at http://localhost:8080/. (Make sure this doesn't conflict with your Address API application. if you are running both of them locally, you must modify the application.properties file and set the port key to another value such 8081). Test your application by attempting to Add a new member or address. 

(b) To run the application on your Cloud Foudry: 
Open manifest.yml file and modify the default values if you wish. then: 
```sh
$ cf login -a API_URL -u USERNAME -p PASSWORD (Then Select Org and workspace)
$ cf push
```
