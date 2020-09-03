# LDAP - Example

Example of LDAP server with [Spring Boot](https://projects.spring.io/spring-boot/) example service using it.

Used [Docker](https://www.docker.com/) to containerize environment.  

## LDAP
* Created basic user and group initialization files. This will prepare basic data for testing. They were split into 3 files, as it was problematic to specify which entry should be created first and incorrect order would make ldap fail at start.

## Example service
* Has only one example endpoint
* All endpoints require role/group: developer
* User passwords are encoded via bcrypt

## How to run the environment?

### Before you start
* Make sure you have `Docker` and `docker-compose` installed.

[Docker CE INSTALLATION](https://docs.docker.com/install/linux/docker-ce/ubuntu/)  
[Docker Compose INSTALLATION](https://docs.docker.com/compose/install/#prerequisites)

### Start the environment
1. Build services:
    `docker-compose build`
2. Run services:
    `docker-compose up`

### Important endpoints:
* http://localhost:8080/test (credentials: test-user/test)
