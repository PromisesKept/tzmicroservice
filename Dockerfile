
FROM openjdk:17-jdk-slim as builder
WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle
COPY src ./src

RUN ./gradlew build --no-daemon

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
