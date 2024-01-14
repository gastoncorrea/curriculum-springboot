
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM amazoncorreto:11-alpine-jdk
MAINTAINER GEC
COPY target/dinamico-0.0.1-SNAPSHOT portfolio-app.jar
ENTRYPOINT ["java","-jar","/portfolio-app.jar"]

