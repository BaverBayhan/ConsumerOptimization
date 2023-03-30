# ConsumerOptimization
GDSC Solution challenge project


Hi, this project is a social media application to help consumers with various backgrounds for optimizing their consumption habits. Project consists of
three main parts as backend application, mobile application and database. In this project we have used Java/Spring Boot - Python/Fast API for backend 
Flutter for mobile development, and MySQL as database. To, run this app you should have MySQL installed on your machine. You should create a database named
"solution_challenge" and in "application.properties" file you should change root DB password. After setting up the database you should have maven and Java 
installed in your machine. To run python backend you should have FastAPI and Gspread installed along with python.

After this steps you can run backend app in terminal by cd to "src" directory and run 

# mvn spring-boot:run

Then cd to "sheetsapi" and run

# uvicorn main:app --reload

Your backend app up and running now. For now we have 9 endpoints.
