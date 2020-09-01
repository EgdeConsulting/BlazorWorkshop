FROM openjdk:11

MAINTAINER Hans Lau Borch

VOLUME /tmp

# Add Spring Boot app.jar to Container
ADD "target/BlazorWorkshop-0.0.1-SNAPSHOT.jar" app.jar

ENV JAVA_OPTS=""

EXPOSE 8080

# Fire up our Spring Boot app by default
ENTRYPOINT [ "sh", "-c", "java -Xmx400m $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]