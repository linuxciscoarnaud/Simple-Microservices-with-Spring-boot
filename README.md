# Simple-Microservices-with-Spring-boot

Two basic micro-services developed using spring boot and that use RestTemplate to talk to each other

This source code is an implementation of two basic micro-services: a produser (product-service) and a consumer (customer-service)

The consumer uses RestTemplate to connect to the produser and perform the traditional Create, read, update and delete operations.

The app is developed using spring boot, Hibernate, JPA and interacts with Mysql DBMS. Each micro-service has its own data model.

# Run the app

Just download the zip files of the two micro services, import them as existing Maven projects into your favorite IDE, create the databases in your Mysql DBMS (check the application.properties files for the database names) and you are good to go.

# Some requests

Tables Category and Product before starting operations

![untitled2](https://user-images.githubusercontent.com/1300982/50041836-2e191180-0096-11e9-87e4-38e35b2f5a4d.png)

Adding a new Category with a Post request method: http://localhost:8200/consumer/category/add/customer/xMzBlBrwqOTRvc8BMKc1

![untitled4](https://user-images.githubusercontent.com/1300982/50041932-69681000-0097-11e9-8b59-0a7626d245aa.png)

![untitled6](https://user-images.githubusercontent.com/1300982/50042012-a54fa500-0098-11e9-986c-4aefed462b59.png)
