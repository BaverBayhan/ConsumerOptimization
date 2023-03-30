# ConsumerOptimization
GDSC Solution challenge project


Hi, this project is a social media application to help consumers with various backgrounds for optimizing their consumption habits. Project consists of
three main parts as backend application, mobile application and database. In this project we have used Java/Spring Boot - Python/Fast API for backend 
Flutter for mobile development, and MySQL as database. To, run this app you should have MySQL installed on your machine. You should create a database named
"solution_challenge" and in "application.properties" file you should change root DB password. After setting up the database you should have maven and Java 
installed in your machine. To run python backend you should have FastAPI and Gspread installed along with python.

After this steps you can run backend app in terminal by cd to "src" directory and run 

<code> mvn spring-boot:run </code>

Then cd to "sheetsapi" and run

<code> uvicorn main:app --reload </code>

Your backend app up and running now. For now we have 9 endpoints. All endpoints are working on localhost:8080 by default.Below you can check API endpoints.


**localhost:8080/api/auth/register** ***POST*** 

**localhost:8080/api/auth/login**  ***POST***

**localhost:8080/api/userinfo/save** ***POST***

**localhost:8080/api/post/save** ***POST***

**localhost:8080/api/post/retrieveAllPosts** ***GET***

**localhost:8080/api/userinfo/retrieve** ***GET***

**localhost:8080/api/post/feed?page=?** ***GET***

**localhost:8080/api/post/delete?id=?** ***DELETE***

**localhost:8080/api/post/retrieve?id=?** ***GET***

Also you can run Futter Application with 

<code> flutter run </code>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  ***Also There are attributions we want to mention. We have taken some icons from various websites. Thanks for sharing these wonderful icons for free.***
  
  
  **<a href="https://www.flaticon.com/free-icons/kitchen" title="kitchen icons">Kitchen icons created by xnimrodx - Flaticon</a>**
  **<a href="https://www.flaticon.com/free-icons/washing-machine" title="washing machine icons">Washing machine icons created by Freepik - Flaticon</a>**
  
  
