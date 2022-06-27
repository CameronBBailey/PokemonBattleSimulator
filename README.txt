
Introduction

Welcome to the Pokemon Battle Simulator, an application for storing teams and using them for storing you Pokemon teams
with their specific items, natures, ability, and attacks and then be able to use them in battles against other users.
In our first version of this application, we only allow storing of specific user's teams and the battling function will
be coming in a future update.

Overview
In this application we used the following technologies for the for these reasons
    - Spring Boot: Formed our backend project structure
    - Maria DB: Our choice of database for storing and getting information needed for the application
    - Spring Data JPA: Used to automatically create our tables in our database as well as define the relationships between
        them
    - Spring Security: Handled our  user security, ensure that only logged in users could access our site details.
    - Thymeleaf: ALlowed us to add info to our front end from our database as well as store information from our forms
    in our front end in our database.
    - HTML: Used to create our view pages
    - CSS: Used to style our view pages
    - Bootstrap: Also used to style our view pages
    - JavaScript: Used in some front end scripts


Setup
- The application should be good to run however a couple steps are needed to setup the database
- Either uncomment the 8 Config files in the config package which will allow you to access some base data to test the
application with OR
- For a full experience, run the attached SQL file for the Natures and import the 4 CSVs into their tables