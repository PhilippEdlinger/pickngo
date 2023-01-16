FROM maven:3.8.7-eclipse-temurin-11-alpine
RUN mkdir /backend
WORKDIR /backend
COPY . .
EXPOSE 8080
CMD ["mvn", "clean", "compile", "quarkus:dev"]