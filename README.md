# quarkus-rest-api

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Creating quarkus project
```
mvn io.quarkus:quarkus-maven-plugin:1.12.2.Final:create \
    -DprojectGroupId=org.quarkus.example \
    -DprojectArtifactId=quarkus-example \
    -DprojectVersion=1.0.0-SNAPSHOT \
    -DclassName="org.quarkus.example.QuarkusExampleApplication" \
    -Dextensions="resteasy,resteasy-jackson" \
```

> **_NOTE_**:   
Please make sure before using quarkus you must install or upgrade the maven to 3.6.2 or higher.
---

## Creating quarkus project using gradle build tool
```
mvn io.quarkus:quarkus-maven-plugin:1.12.2.Final:create \
    -DprojectGroupId=org.quarkus.example \
    -DprojectArtifactId=quarkus-example \
    -DprojectVersion=1.0.0-SNAPSHOT \
    -DclassName="org.quarkus.example.QuarkusExampleApplication" \
    -Dextensions="resteasy,resteasy-jackson" \
    -DbuildTool=gradle
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Run the application test
```
./mvnw test
```

## Adding OpenAPI extension
```
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
```
or, update the pom.xml
```
<!--Swagger OpenAPI dependency-->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-openapi</artifactId>
</dependency>
```

application.properties to configure swagger UI or custom path
```
# swagger openAPI properties
quarkus.swagger-ui.enable=true
quarkus.swagger-ui.path=swagger-ui.html
quarkus.swagger-ui.always-include=true
```
Once you set this up, you can access the swagger-ui page
```
http://<host>:<port>/q/swagger-ui.html
```
For mote info on openAPI [see this](https://quarkus.io/guides/openapi-swaggerui)

## Adding JSON logging extension
```
<!--JSON Logging dependency to change the format-->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-logging-json</artifactId>
</dependency>
```

application.properties to configure JSON logging
```
# Logging properties
# Send output to the console
quarkus.log.level=INFO
quarkus.log.category."org.hibernate".level=DEBUG
quarkus.log.console.enable=true
quarkus.log.console.color=false
quarkus.log.console.format=%d{yyyy-MM-dd HH:mm:ss,SSS} %-5p [%c{3.}] %L (%t) %s%e%n
quarkus.log.file.enable=true
quarkus.log.file.path=./log.txt

#JSON
quarkus.log.console.json=true
```

For more info on quarkus logging and other properties [see this](https://quarkus.io/guides/logging)

## CORS 
```
#CORS property to enable it
quarkus.http.cors=true
quarkus.http.cors.methods=GET,PUT,POST # methods to be allowed in CORS
```
For more info on quarkus CORS [see this](https://quarkus.io/guides/logging)

## Setting root path for your API
```
quarkus.http.root-path=/{root-path}
```
