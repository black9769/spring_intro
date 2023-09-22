# 빌드 환경
FROM gradle:latest AS build

WORKDIR /app

# 소스코드와 빌드 파일을 이미지로 복사
COPY ./src ./src
COPY ./build.gradle ./
COPY ./settings.gradle ./
COPY ./gradle ./gradle
COPY ./gradlew ./


# Gradle을 사용하여 빌드
RUN ./gradlew bootjar


# 실행 환경
FROM openjdk:11-jre-slim

WORKDIR /app

# 빌드 환경에서 생성된 JAR 파일을 현재 이미지로 복사
COPY --from=build ./build/libs/*.jar ./app.jar

# 애플리케이션 실행
ENTRYPOINT ["java","-jar","./app.jar"]
