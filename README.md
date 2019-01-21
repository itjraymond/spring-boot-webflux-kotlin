# Spring Boot and WebFlux with Kotlin

### Docker setup
Install docker for your OS. 

### Setup Cassandra on docker

* Note: taken from "Using Spring Data Cassandra with Spring Boot" by "Alberto Di Martino" the Oreilly video (2017)

Pull the cassandra latest docker image
```
docker pull cassandra:latest
```

Start cassandra
```
docker run --name cassandra -d -p 9042:9042 cassandra:latest
```

Start a cqlsh session by login in the container
```
docker exec -it cassandra cqlsh
```
You should get a cqlsh prompt:
```
cqlsh>
```

Create a schema
```
CREATE SCHEMA hr WITH replication = {'class':'SimpleStrategy', 'replication_factor': 1};
```

Switch to the hr database
```
USE hr;
```

Create an EMPLOYEE table
```
CREATE TABLE employee (
    id text PRIMARY KEY,
    firstname text,
    lastname text,
    dob date,
    position text
);
```

Insert a record
```
INSERT INTO employee (
    id, 
    firstname, 
    lastname, 
    dob, 
    position
) VALUES (
    '-1', // test records will have a negative integer for identifier
    'John',
    'Doe',
    '2000-01-25',
    'Engineer'
);  
```

View the record
```
SELECT * FROM employee;
```

Add a Configuration file (usually within a config package)
```kotlin
package ca.jent.ca.jent.webflux.config

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration

class CassandraConfig: AbstractCassandraConfiguration() {

    // @see https://stackoverflow.com/questions/53101753/spring-boot-data-cassandra-reactive-jmxreporter-problem
    override fun cluster(): CassandraClusterFactoryBean {
        val factoryBean = super.cluster()
        factoryBean.setJmxReportingEnabled(false)
        return factoryBean
    }

    override fun getKeyspaceName() = "hr"

    override fun getContactPoints() = "localhost"

    override fun getEntityBasePackages() = arrayOf("ca.jent.ca.jent.webflux")

}
```

### Build

From the terminal:
```
./gradlew clean build
```

### Run

* Note: Cassandra db must be running as specified above.

From the terminal:
```
./gradlew bootRun
```