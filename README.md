# Spring-boot-demo-project
Spring boot demo project.
This is a spring boot application, which I had created while I was learning spring boot. Here, I have used mysql for the database.
In this project, I created a User.java class, which is an Entity.
For performing the CRUD operations, I have used UserDao interface, which extends to JPARepository, which will provide us all the methods that are required for 
performing the operations. After this, I had created a Controller class which acts as the entrypoint for all the incoming requests. The controller will then direct 
these requests to the service layer. The service layer will use the userdao interface to handle these requests.
The input and output will be in the JSON format. The server will run on port 8080 by default.
