# Application "CarsApp"
> The application was prepared for the subject Internet Services Architectures. This is the first part of "CarsApp" which was developed and improved with each new part.

## Table of contents
* [About The Project](#about-the-project)
* [Technologies](#technologies)
* [Getting Started](#getting-started)
* [Contact](#contact)

## About The Project
The project simulates the application in which you can manage data about cars and car's brands. Application is based on basic components: component, repository and service. Also a mechanism of dependency injection and inversion of control were implemented.  
In this part the data are stored in a single in-memory storage for buisness classes. Buisness classes are connected with 1:N realtionship. 
"Cars data" allows you to do CRUD operations.  
You can:
* add a new car with specification ( ID, name, year of creation, colour)
* add a new brand (if doesn't exisit)
* update the information about car or brand (you can't change the name of brand and the ID of car)
* delete selected car or brand
* display all brands which are in the application and all cars assigned to a given brand

## Technologies
* Spring Framework  
* Spring Boot  
* Maven  

## Getting Started
Clone the repository  
`git clone https://github.com/piotrszymanski133/CarsApp`  
  
Open project in your favourite IDE. Choose "Maven project" and run application.  
  
IntelliJ IDEA:  
See: https://www.jetbrains.com/idea/


## Contact
Piotr Szymański - piotrszymanski133@gmail.com
