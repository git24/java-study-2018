# 2018, Java 8 Study

회사 자바 스터디, Java source 분석

##Day 1
###Integer

###Number

###Object

###Serialize

###Comparable

과제 : hashCode()


##Day 2
### Collection

### List

### Set

### Map

과제 : Java 7 > 8 release note


##Day 3
### Lambda
- Supplier
- Consumer
- Function
- Predicate
- BiConsumer
- BiFunction
- BiPredicate
- UnaryOperator
- BinaryOperator
- List.replaceAll
- Map.compute
- Map.computeIfAbsent
- Map.computeIfPresent
- Map.merge
- Map.forEach
- Map.replaceAll

### Stream


### Spring boot 2.1.1.RELEASE note
https://github.com/spring-projects/spring-boot/releases/tag/v2.1.1.RELEASE

#### New feature
Deprecate spring.rabbitmq.template.queue in favor of spring.rabbitmq.template.default-receive-queue #15301
Add Actuator health check support for Elasticsearch REST Clients #15211
Improve Servlet and Filter registration logging #15166
Trim whitespace from configured value for a log level #15143
Add HANA to the lookup of well-known databases #15125
Tolerate Hibernate 5.2 #15100
Allow to disable SSL client authentication on the management port #14985
Support Java 9 Multi-Release JAR files #12523

#### Bug fixes
HibernateMetricsAutoConfiguration will fail, when using different JPA implementation #15317
EmbeddedMongoAutoConfiguration.determineVersion(?) fails with NPE when no features are configured and spring.mongodb.embedded.version specifies a version not included in de.flapdoodle.embed.mongo.distribution.Version #15311
Wrong default unit for "spring.servlet.multipart" sizes #15162
ConfigurationPropertyName equals method fails when uppercase values start the same #15152
HANA validation query does not use fully-qualified dummy table name #15124
WebFlux doesn't render HTTP status error templates #15083
Fix stack-trace line breaks in whitelabel error views #15075
Application that depends upon spring-boot-starter-web and spring-boot-starter-jersey fails to start due to attempt to override requestContextFilter bean #15048
Cannot run repackage twice with different settings #15034
TaskSchedulingAutoConfiguration prevents discovery of ScheduledExecutorService #15032
Improve endpoint mapping debug logging #14292
