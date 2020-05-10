# travel-it-service-api
Server Repository

1. Open CMD as Administrator
2. Go to the travel-it-service-api root project
3. run ```change-java-version.cmd```
Output:
```
>change-java-version.cmd
"Current Java Version is"
C:\Program Files\Java\jdk-14
1 - jdk-14
```
4. press ```1```
5. run ```java -version```
Output
```
openjdk version "14" 2020-03-17
OpenJDK Runtime Environment (build 14+36-1461)
OpenJDK 64-Bit Server VM (build 14+36-1461, mixed mode, sharing)
```
5. run ```mvnw clean install```
6. run ```java -jar target\travel-it-service-api-0.0.1-SNAPSHOT.jar```
7. go to http://localhost:8080/api/ping 
Output:
```
Pong
```

8. Short documentation
```
GET /api/ping -> respond with pong 
GET /api/countries -> list all the data from db
GET /api/countries/{id} -> get a specific country
GET /api/populate -> populate database from data.json file
```


