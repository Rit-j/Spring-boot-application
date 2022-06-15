# demo
Spring boot demo project.
This is a spring boot application, which I created while I was learning spring boot. Here, I have used mysql for the database.
In this project, I created a User.java class, which is an Entity.
For performing the CRUD operations, I have used UserDao interface, which extends to JPARepository, which will provide us all the methods that are required for 
performing the operations. After this, I created a Controller class which acts as the entrypoint for all the incoming requests. The controller will then direct 
these requests to the service layer. The service layer will use the userdao interface to handel these requests.
The input and output will be in the JSON format.
