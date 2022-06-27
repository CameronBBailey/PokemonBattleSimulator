
Introduction

Welcome to the Pokemon Battle Simulator, an application for storing teams and using them for storing you Pokemon teams
with their specific items, natures, ability, and attacks and then be able to use them in battles against other users.
In our first version of this application, we only allow storing of specific user's teams and the battling function will
be coming in a future update.

User Stories

As a User I want to be able to log in to be able to access and store my user specific information
As a User I want to be able to create my own teams
As a User I want to be able to update Team info incase I change my mind
As a User I want to be able to edit my Team Members to customize them to my preference
As a User I want to be to see which quickly and visually see my Team Members.
As a User I want to be able to logout so others cant access my information after I leave
As a User I want to auto logout after a certain period of time so I dont accidentally stay logged in
AS a User I want a consistent Navigation Bar so I can always navigate to whatever page I choose
As a User I want to be able to edit my Team Members individually so I dont have to change every member everytime I make
a slight adjustment
As an Owner I want some content to be restricted to Logged in users so only verified users can make Teams
As a User I want to be auto directed to a log in screen if trying to access a restricted page


Overview
In this application we used the following technologies for the for these reasons
    - Spring Boot: Formed our backend project structure
    - Maria DB: Our choice of database for storing and getting information needed for the application
    - Spring Data JPA: Used to automatically create our tables in our database as well as define the relationships between
        them
    - Spring Security: Handled our  user security, ensure that only logged in users could access our site details.
    - Spring Boot Testing: Used for all of our testing in the application.
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

