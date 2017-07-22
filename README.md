Steps to deploy the application:

1- Download the project from GitHub as .ZIP
2- Extract the project
3- Install Java 8 (https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
4- Install Tomcat 8 (https://tomcat.apache.org/tomcat-8.0-doc/setup.html)
5- Install Maven (https://maven.apache.org/install.html)
6- Open Command Prompt and navigate to the project directory
7- run the command: mvn clean package
8- In the prject directory, the target directory will be created, and it will contain the HotelDeals.war
9- Copy the HotelDeals.war to tomcat webapps folder
10- Restart Tomcat