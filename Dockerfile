FROM openjdk:17 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

FROM openjdk:17
COPY --from=build /app/target/JavaCourseWork*.jar /usr/local/lib/JavaCourseWork.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/JavaCourseWork.jar"]