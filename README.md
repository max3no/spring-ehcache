# Spring boot - ehcache


## Getting Started

Need jdk, spring boot, working machine.

### Prerequisites

Install Spring Boot.
Configure your java in environmental variables.


### Steps

Create a new Spring Starter Project (Dependency - Web, cache, actuator(to check metrics/cache), mysql, jpa, ehcache)

```
https://start.spring.io/
```


add the following setting in application.properties

```
spring.cache.cache-names=myCache
spring.cache.type=ehcache
spring.cache.ehcache.config=classpath:ehcache.xml
```
setting for the actuator

```
management.endpoints.web.exposure.include = *
management.endpoint.health.show-details=always
```

GET API
```
https://localhost:8080/api/v1/1
```

DELETE API
```
https://localhost:8080/api/v1/1
```

PUT API
```
https://localhost:8080/api/v1/1/someothername
```

## Acknowledgments

* Open Source community
