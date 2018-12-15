# Simple-Microservices-with-Spring-boot

Two basic micro-services developed using spring boot and that use RestTemplate to talk to each other

This source code is an implementation of two basic micro-services: a produser (product-service) and a consumer (customer-service)

The consumer uses RestTemplate to connect to the produser and perform the traditional Create, read, update and delete operations.

The app is developed using spring boot, Hibernate, JPA and interacts with Mysql DBMS. Each micro-service has its own data model.

# Run the app

Just download the zip files of the two micro services, import them as existing Maven projects into your favorite IDE, create the databases in your Mysql DBMS (check the application.properties files for the database names) and you are good to go.

# Some requests

Tables Category and Product before starting operations
