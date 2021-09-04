### This is a CRUD Project using Spring Boot and MongoDB database. 

**Technologies:**

- IntelliJ IDEA Communit Edition 2021.2.1
- MonboDB 5.0.2 Community 
- Spring Boot 2.5.4 
- Java JDK 16.0.2 
- Maven 3.6.3
- Postman 

**MongoDB install:**

1. Install MongoDB Community Server from https://www.mongodb.com/try/download/community. Choose the (current) version for your operating system. 
  In this project, it was used a Windows version. 
  To install it just push next all the time. 
  I recommend also installing MongoDB Compass that is the official MongoDB graphic admin tool. 
  You can also use a docker version from here "https://hub.docker.com/_/mongo" if rather prefer.
2. Open MongoDB Compass, so you can check how Collections and Documents are being managed.


**How to run:**

1. Clone the repository in a folder.
2. Open the project in your preferential IDE and just run the main application.

Alternative to run :

1. Just download the jar file that is inside of "deployment" folder to a local folder.
2. Go to this local folder, open the command prompt in this folder, and run the command: "java -jar mongodb-springboot-0.0.1-SNAPSHOT.jar" to have the API running at port 8090.

**Payload:**

1) In the folder "payload" there is a "Users.json" and a "Departments.json" text files that you can use as a sample and as a payload to test the API.
2) There is also in the folder "payload" an exported file named "MongoDBPayload.postman_collection.json" that you can use to import to your Postman tool, so you will have all the endpoints ready and configured to use and test the API


**Endpoints:**

If you decide to not import the Postman configured collection that I have exported, below are the endpoints to be used to test the API.

User endpoints:
```
(POST)   http://localhost:8090/user/addUser
(DELETE) http://localhost:8090/user/delUser?id=5
(PUT)    http://localhost:8090/user/updateUser
(GET)    http://localhost:8090/user/findUser/1
(GET)    http://localhost:8090/user/listUsers
```
Department endpoints:
```
(POST)   http://localhost:8090/department/addDepartment
(DELETE) http://localhost:8090/department/delDepartment?id=1
(PUT)    http://localhost:8090/department/updateDepartment
(GET)    http://localhost:8090/department/findDepartment/2
(GET)    http://localhost:8090/department/listDepartments
```
