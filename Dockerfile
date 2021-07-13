FROM openjdk:8u181-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-XX:MetaspaceSize=128m","-XX:MaxMetaspaceSize=128m","-Xms1024m","-Xmx1024m","-Xmn256m","-Xss256k","-XX:SurvivorRatio=8","-XX:+UseConcMarkSweepGC","-jar","/app.jar"]