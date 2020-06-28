# FullStackProject-Solo

##  ShopForAll
Implemented an ecommerce website from scratch. Also features an API component.

### Techmologies Used

View - JSP
Backend - Oracle 11g database
Java 8 with Spring Boot

### Instructions

1)	Install Oracle 11g database (https://www.oracle.com/ca-en/database/technologies/112010-win64soft.html)
	- create a database named xe
	- create a user with username trainee1 and password bluejays123 (see application.properties file for db connectivity information)
2)	Import project to Eclipse and add ojdbc6-11.2.0.2.0.jar driver to build path. 
	- The driver is in src/main/resources/lib folder.
3)	Uncomment lines 75-78 of the DataLoader.java file if running this project for the first time. 
	- This file can be found in the util package.

### Login Credentials
#### Administrator
username: saeeds28 <br/>
password bluejays123

#### Customer
username: samad <br/>
password: password

### Permissions
#### Admins
- add users
- deactivate and deactivate users
- add items to the store
- change properties about a specific item by visiting its page
- moderate item reviews (accept/delete)
- change their passowrd
- view store analytics

### Customers
- purchase product
- change their password and address
- write reviews for a product they have purchased