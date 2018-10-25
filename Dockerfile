FROM openjdk:8-jdk-alpine
COPY . /app
WORKDIR /app
CMD ["./gradlew", "--stacktrace", "bootRun"]
