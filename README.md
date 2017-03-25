# micro-services-crud-demo
Experiments with REST Web Services, using drop-wizard framework.
@ http://www.dropwizard.io/


# To get this started you'll need.
- java 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- maven (https://maven.apache.org/download.cgi)
- mysql (https://dev.mysql.com/downloads/)
- chrome browser, with Postman.(https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en)

# How to start this service on your local machine.
- clone or download this to a directory on your system.
- start mysql server on your system, login to it (from terminal or whatever you favorite client is), and create a database and a table as given in ```mysql_setup.sql```
- provide your mysql configurations in ```src\main\resources\config.yml``` file. (These will be used by the service to connect to the database)
- change to project directory, (directory where the pom.xml is), and from the terminal or command prompt, run ```mvn clean package```.
- After you get BUILD SUCCESS, run ```java -jar target\crud-demo-0.0.1-SNAPSHOT.jar server src\main\resources\config.yml```.
- That's it !!! Voila.

# How to play around
- it'll help if you learn a bit about REST web services.
- open Postman app.
- try out these.
```
 GET     http://localhost:8080/student
 POST    http://localhost:8080/student      {"rollno":21021,"name":"Satyendra Singh"}
 PUT     http://localhost:8080/student      {"rollno":21021,"name":"Satyendra Singh"}
 DELETE  http://localhost:8080/student/{rollno}
 GET     http://localhost:8080/student/{rollno}
```