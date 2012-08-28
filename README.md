# Simple-Contacts-Services

## Prerequisites
* maven 2.2.1
* java 1.6
* postgres database

### Setup the database
1. install postgres on your development machine
2. create a database named "contacts" (username 'postgres' with password 'postgres')

### Getting Started
1. build the project.execute a "mvn clean install" in the source directory.
2. from the source directory execute a "mvn tomcat:run"
3. visit the [default page](http://localhost:8080/contacts-service/contacts)

#### API
* to view all contacts [here](http://localhost:8080/contacts-service/contacts)
* create a new contact [here](http://localhost:8080/contacts-service/contacts/create)
* edit existing contact [here](http://localhost:8080/contacts-service/contacts/edit/$id) (replace $id with entity id)
* delete existing contact [here](http://localhost:8080/contacts-service/contacts/delete/$id) (replace $id with entity id)
* search by query parameter [here](http://localhost:8080/contacts-service/contacts/search)
** firstName
** lastName
** emailAddress
** areaCode

an example search query would look like
http://localhost:8080/contacts-service/contacts/search?firstName=John&lastName=Doe&emailAddress=foo@bar.com&areaCode=415

