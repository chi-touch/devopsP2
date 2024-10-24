FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean package -DskipTests
FROM openjdk:17
COPY --from=build target/*.jar devip.jar
# ENV SPRING_PROFILES_ACTIVE=$(PROFILE)
ENTRYPOINT ["java", "-jar", "-Dserver.port=8086", "devip.jar"]


## Step 1: Build stage using Maven
#FROM maven:3.8.7 AS build
#WORKDIR /app
#COPY . .
#RUN mvn -B clean package -DskipTests
#
## Step 2: Runtime stage with OpenJDK
#FROM openjdk:17
#WORKDIR /app
#COPY --from=build /app/target/*.jar devip.jar
#
## Pass the active Spring profile and other JVM args at runtime
#ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "-Dserver.port=8086", "devip.jar"]
