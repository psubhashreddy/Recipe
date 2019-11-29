
### Reference Documentation ###
-- Make sure before accessing the below H2 console url, the properties below
* H2 Database Console - http://localhost:8090/h2
* spring.h2.console.enabled=true
* spring.h2.console.path=/h2
-- should be present in the application.properties file.

-- Swagger API Documentation can be found at url
* Swagger API - http://localhost:8090/swagger-ui.html
-- All the rest apis available would be listed here with the possibility to test them

-- Below are the available rest END points 
* Search By ID - http://localhost:8090/api/recipe/id/{id-value}
* Search Recipe By Name - http://localhost:8090/api/recipe/name/{name-value}
* View the Recipe list - http://localhost:8090/api/recipe/list
* Save a new Recipe - http://localhost:8090/api/recipe/save
* Update the existing Recipe - http://localhost:8090/api/recipe/update
* Delete the Recipe - http://localhost:8090/api/recipe/remove/{id-value}

-- Steps to run this Spring Boot Project
* Make sure git is installed in your local machine
* Clone the project from Github using the command
* git clone https://github.com/psubhashreddy/Recipe.git
* From any IDE import the project as a maven project
* If you have spring boot plugin installed, then run the project as spring boot
* if there is no spring boot, right click on RecipeApplication and run it as Java Application
* Log file recipe-app.log gets created in the base folder of the project
* You can change the path of the log file in application.properties file

## Things to be Done 
-- Write Database schema - Done
-- Create a spring boot app with package structure - Done
-- Create DB creation with H2 - Done
-- Create rest endpoints for CRUD operations - Done
-- Add Swagger implementation - Done
-- Add Basic Authentication - In Progress
-- Add unit tests - Pending
-- Add front end in VUE - Pending
-- Create docker compose file to deploy both backend and front end projects - Pending


