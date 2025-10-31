FROM maven:3.9.9-amazoncorretto-21 AS builder

#Set an environment variable to store where the app is installed to inside
#of the Docker image.
ENV INSTALL_PATH /club-service
RUN mkdir -p $INSTALL_PATH
WORKDIR $INSTALL_PATH

COPY ./pom.xml ./pom.xml
RUN mvn clean
#ADD ./settings.xml /root/.m2
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package -DskipTests

FROM builder AS test

FROM amazoncorretto:21 AS dev
WORKDIR /app
COPY --from=builder /club-service/target/club-service-v1.0.0.jar .
EXPOSE 8080
CMD java -XX:MaxRAMPercentage=95 -jar club-service-v1.0.0.jar

#### pre ####
FROM dev AS pre

#### latest ####
FROM pre AS latest
