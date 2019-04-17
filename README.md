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
java -jar build/libs/DashDC-1.0.jar
```
The server page can be accessed by connecting to the localhost at port 8080. In the website URL, type in "localhost:8080"

All source code should be stored in the src/ directory.

Do the following to launch the code coverage tool.
From the root of the project directory, use the command:
```
./gradlew build jacocoTestReport
```
Then to view the code coverage report,, from the root of the project directory, use the command:
```
open build/reports/jacoco/test/html/index.html
```
If your terminal does not support the open command, then you must manually navigate to the file and open it with a web browser.

Dev: The build directory is ignored by the .gitignore file, therefore the directory will not be uploaded onto the git repository.
