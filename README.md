# Simple-Contacts-Services

### Spring 3 MVC Contacts Services

> This page is under construction as of 8/25/2012
> updates should be frequent

### Prerequisites
* maven 2.2.1
* java 1.6
* postgres database

### Setup the database
1. install postgres on your development machine
2. create a database named "contacts" (in my case credentials for this connection are 'postgres' with password 'postgres')
3. database should be accessible with a jdbc url like jdbc:postgresql://localhost:5433/contacts

### Getting Started
1. first get the project building by navigating to your source directory and executing a "mvn clean install"
2. try deploying by executing a "mvn tomcat:run"
3. visit the url [welcome](http://localhost:8080/contacts-service/welcome) to see if it works

### Finished
##### Some final steps
> After you have deployed here is how you can test
> * hit the helloworld page on [localhost](http://localhost:8080/contacts-service/welcome)
> * view random non-persistent data [here](http://localhost:8080/contacts-service/contact/durpdurp)
> * persist some test data by hitting the [url](http://localhost:8080/contacts-service/contact/test)(only loads once)
> * view all persisted contacts [here](http://localhost:8080/contacts-service/contact/all)
> * view contacts by firstname [here](http://localhost:8080/contacts-service/contact/f/Br)
> * view contacts by lastname [here](http://localhost:8080/contacts-service/contact/l/Z)
> * view contacts by area code [here](http://localhost:8080/contacts-service/contact/ac/415)
> * add a new contact using a form page [here](http://localhost:8080/contacts-service/contact/new)
> * update an existing contact using a form page [here](http://localhost:8080/contacts-service/contact/edit/1) (assumes 1 is your entity ID)


### RESTful API (assumes local deployment)
* [welcome page](http://localhost:8080/contacts-service/welcome)
* [getAllContacts](http://localhost:8080/contacts-service/contact/all) **JSON**
* [getContactsByFirstName](http://localhost:8080/contacts-service/contact/f/$firstName) **JSON**
* [getContactsByLastName](http://localhost:8080/contacts-service/contact/l/$lastName)  **JSON**
* [getContactsByAreaCode](http://localhost:8080/contacts-service/contact/ac/$areaCode) **JSON**
* [getContact](http://localhost:8080/contacts-service/contact/id/$id) **JSON**
* [updateContact](http://localhost:8080/contacts-service/new) **FORM**
* [updateContact](http://localhost:8080/contacts-service/edit/$id) **FORM**
* [removeContact](http://localhost:8080/contacts-service/contact/remove) **FORM**
