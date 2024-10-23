FROM maven:3.8.7 as build
COPY .. .
RUN mvn -B clean package -DskipTests
FROM openjdk:17
COPY --from=build target/*.jar devip.jar
#ENV SPRING_PROFILES_ACTIVE prod
ENTRYPOINT ["java", "-jar", "-Dserver.port=8086", "devip.jar"]