SpringMongoGranny
================

Granny's Addressbook with Java + Spring MVC + MongoDB
Install database
----------------
Install the database.
* Download MongoDB from [here](http://www.mongodb.org/downloads)
* Extract the tar ball to any directory. 
* By default mongodb uses /data/db/ as the directory where it stores all its files. So unless you are changing that you need to create a directory /data/db/ on your filesystem.
    * Note: You can change the default by simply mentioning the path while executing the mongod server as follows <code> sudo ./mongod --dbpath=/temp/</code>
* Start the mongod server by running the mongod executable. Note: You might need sudo access for this.

Checkout Project from git
-------------------------
1. Install git  <code>sudo apt-get install git</code>
2. Do a <code> git clone https://github.com/osintegrators/SpringMongoGranny.git </code>
2. Open up your IDE ( Eclipse / STS preffered ) and go to File -> Import -> General -> Existing projects into workspace

Build
-----
4. Perform a Project -> Clean
5. Right click on the pom.xml and do a Maven -> clean, and a Maven -> install.
6. Right click on Project and Run As -> Run On server.
7. You might need to create a new server environment.

Run
---
* This project can be deployed on any of the following
<br> Tomcat
<br> vFabric tcServer
9. After you create a server, Deploy the project on the server. 
10. Note: If your IDE does not have the facility to run on a server from within, you can do a mvn package from the command line and deploy the .war file directly on an external server
11. Browse to [server URL](http://localhost:8080/SpringMongoGranny/)
