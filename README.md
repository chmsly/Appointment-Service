For this project, we decided to go with the name Broken Pipe Plumbing as a reservation system for a local plumber. 

It provides the ability for a customer to book an appointment by timeslot selection and input the service needed then provides a
confirmation email. 

On the admin side the plumber is able to view their apppointments by day and see an inventory list to complete
the current days appointments. There is also a notification system for parts that are low on inventory.

Our tech stack is Next.js and Java. The backend is deployed using Render in a container and our frontend to Vercel.

https://dsd-cohort-2024-ruddy.vercel.app/



Requirements

Download and install java JDK 17
https://www.oracle.com/java/technologies/downloads/#jdk17-windows
test if java installed open terminal
java -version
should be similar to this -img.png
if not then you can optionaly update Path JAVA_HOME environment variable to location you installed the java JDK17 package
build project using graddle wrapper and run

cd server/
./gradlew build
./gradlew bootrun
default port will be 8000
example url http://localhost:8000/api/parts
create credentials file server/credentials.json

add firestore credentials info inside
Java project configuration
Port mapping
port mapping can be changed in the src/main/resources/application.properties file

change server.port=8000 to desired port number
