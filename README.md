# DashDC
A program that consolidates user-specified information into a single, easily accessible page hosted on the user’s local computer

The program source code uses gradle as the build automation system. 

To compile the project, use the command below: 
```
./gradlew build 
```
or, if using a Windows system: 
```
gradlew.bat build 
```

To launch the compiled JAR file that contains Spring Boot, type in: 
```
java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
```
The server page can be accessed by connecting to the localhost at port 8080. In the website URL, type in "localhost:8080"

All source code should be stored in the src/ directory. 

Dev: The build directory is ignored by the .gitignore file, therefore the directory will not be uploaded onto the git repository.
