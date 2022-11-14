# Problem

A retailer offers a rewards program to its customers awarding point based on each recorded
purchase as follows:

For Every dollar Spend over $50 on the transaction, the customer receives one point. In addition,
for every dollar spent over $100, the customer receives another point.

Ex: for a $120 purchase the customer receives 90 points (((120 - 50) * 1) + ((120 - 100) + 1))

# Database

Created a local database using H2 which will be initialized by loading sample customers and
respective transactions during application start. Schema for both will be shown as below:

#### Customer Schema

![Customer Schema](https://github.com/krishnasuhas/retailer-rewards/blob/master/src/main/resources/images/Screen%20Shot%202022-11-14%20at%203.40.32%20AM.png?raw=true "Customer Schema")

#### Customer Transactions Schema

![Customer Transactions](https://github.com/krishnasuhas/retailer-rewards/blob/master/src/main/resources/images/Screen%20Shot%202022-11-14%20at%203.42.38%20AM.png?raw=true "Customer Transactions Schema")

# Data Access layer

Used Hibernate to perform all crud operations which is efficient in terms of session management
and also achieves the functionality with the least boilerplate code.

# Service layer

Contains the Core logic of retriving the data from database and preparing the summary per user
and per month level.

# Controller Layer

Broadly classified into 3 categories Customer, Transactions and Summary:

### Customer Controller:

* [Lists All customers stored in Database](http://localhost:8080/customers)
* [Get the Customer where customer Id is 1](http://localhost:8080/customers/1)

### Customer Transactions Controller:

* [Lists All transactions stored in Database](http://localhost:8080/transactions)
* [Get the Transaction where transaction Id is 1](http://localhost:8080/transactions/1)

### Rewards Summary Controller:

* [Get Monthly Summary per User](http://localhost:8080/monthlySummary)

![Customer Schema](https://github.com/krishnasuhas/retailer-rewards/blob/master/src/main/resources/images/Screen%20Shot%202022-11-14%20at%203.43.17%20AM.png?raw=true "Customer Schema")


* [Get Total Summary per User](http://localhost:8080/totalSummary)

![Customer Schema](https://github.com/krishnasuhas/retailer-rewards/blob/master/src/main/resources/images/Screen%20Shot%202022-11-14%20at%203.43.39%20AM.png?raw=true "Customer Schema")


### Testing Layer

The core logic is to test the logic behind rewards calculation which is covered in testing folder.

Commands to test at root directory: `gradle cleanTest test`

### Start the Project

The entire application is backed by Spring boot which provides the MVC framework for us to start 
and test the application to test right awat by inbuilt Tomcat, please execute the below to start 
the application and check the above URL's to verify the application.

`gradle bootRun`