FROM openjdk:11
MAINTAINER anitina.chaves@gmail.com
COPY target/console-twitter-1.0-SNAPSHOT.jar console-twitter-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/console-twitter-1.0-SNAPSHOT.jar"]
CMD [""]