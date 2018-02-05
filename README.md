# Course project

### Overview
Web application with functionality of online shop. Created while studying at <a href="https://www.it-academy.by/">Education Center of High-Tech Park</a> on <a href="https://www.it-academy.by/course/java-developer/jd2-tekhnologii-razrabotki-enterprise-resheniy-na-java/">"Technologies for developing enterprise solutions on JAVA"</a> course.

Application was made mostly using Hibernate, Spring MVC and Spring Security. Additionally it uses Apache Tiles, fields validation, AJAX queries and even some localization  

### Setup
* Check application properties at app.properties and set appropriate path to file storage
* Optionally, to see images you may unpack images.rar to file storage destination
* Check data base properties at database.properties. By default it uses "root" for username and empty password, but it can be changed.


### How to build
Maven tool is used for building


For regular build run follow command:
````

mvn clean install

````

For build with database initialization use:
````

mvn clean install -Pinit_database

````

### How to run
To run the application you need Tomcat 7 or higher and MySQL 5.x server. Deploy built EEShop.war to Tomcat server and open http://localhost:8080/ee-shop/ in browser

### How to use
There are three users with password "123456":
* super@super.com - with super admin role that can manage everything
* admin@admin.com - with admin role that can manage everything excluding users
* user@user.com - user, who can behave like a user: look for products, place orders, write comments and so on.

Just log in and try everything by yourself!

### Author
Anton Shelkovich (anton.shelkovich@gmail.com)