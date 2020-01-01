FROM openjdk:8-jdk-alpine

COPY ./target/app.jar /usr/app/

COPY ./start.sh /usr/app/

WORKDIR /usr/app

EXPOSE 9091
 
ENTRYPOINT ["./start.sh"]
