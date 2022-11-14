# Problem
A retailer offers a rewards program to its customers awarding point based on each recorded 
purchase as follows:

For Every dollar Spend over $50 on the transaction, the customer receives one point. In addition,
for every dollar spent over $100, the customer receives another point. 

Ex: for a $120 purchase the customer receives 90 points (((120 - 50) * 1) + ((120 - 100) + 1))

# Database
Created a local database usingH2 which will be initialized by loading few customers and 
respective transactions during application start. Schema for both will be shown as below:

![Customer Schema](relative/path/to/img.jpg?raw=true "Title")


# Data Access layer
Used a Hibernate to perform all crud operations

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

