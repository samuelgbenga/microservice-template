
### creating the Base project 
mvn archetype:generate \
-DarchetypeGroupId=org.codehaus.mojo.archetypes \
-DarchetypeArtifactId=pom-root \
-DarchetypeVersion=RELEASE \
-DgroupId=ng.samuel.demo.microservicetemplate \
-DartifactId=microservice-template \
-Dversion=0.0.1-SNAPSHOT \
-DinteractiveMode=false



### create the user service
mvn archetype:generate \
-DgroupId=ng.samuel.demo.microservicetemplate \
-DartifactId=user-service \
-Dpackage=ng.samuel.demo.microservicetemplate.userservice \
-DinteractiveMode=false

### create the notification service
mvn archetype:generate \
-DgroupId=ng.samuel.demo.microservicetemplate \
-DartifactId=notification-service \
-Dpackage=ng.samuel.demo.microservicetemplate.notificationservice \
-DinteractiveMode=false

### create service discovery service
mvn archetype:generate \
-DgroupId=ng.samuel.demo.microservicetemplate \
-DartifactId=discovery-service \
-Dpackage=ng.samuel.demo.microservicetemplate.discoveryservice \
-DinteractiveMode=false


### create the api gateway service
mvn archetype:generate \
-DgroupId=ng.samuel.demo.microservicetemplate \
-DartifactId=api-gateway-service \
-Dpackage=ng.samuel.demo.microservicetemplate.apigagtewayservice \
-DinteractiveMode=false


### configure the notification service
#SPRING CLOUD CONFIGURATION
spring.application.name=NOTIFICATION-SERVICE
eureka.instance.preferIpAddress=true
spring.cloud.discovery.enabled=true
eureka.client.service-url.defaultZone=${DISCOVERY_SERVICE:http://localhost:8761/eureka/}

### configure the user service
#SPRING CLOUD CONFIGURATION
spring.application.name=USER-SERVICE
eureka.instance.preferIpAddress=true
spring.cloud.discovery.enabled=true
eureka.client.service-url.defaultZone=${DISCOVERY_SERVICE:http://localhost:8761/eureka/}