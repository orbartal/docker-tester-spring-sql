# docker-tester-spring-sql

### Description

A simple example of compose and 3 dockers: springboot server, sql db and an e2e tester.

### Use cases and spring profiles
There are currently 3 spring profiles that define the sql db that the backend server will use:
1. test: use in memeory h2 db. No changes are needed in the config. Good for auto testing.
2. dev: use a local postgresql server. Fill in details for local DB in application-dev.properties. Good for manual testing locally.
3. comp: use a remote/docker postgresql server. Fill in detail in the compose file. Good for e2e testing with docker compose.

There are currently 3 mods to testing the backend:
1. Running integration test without running the real backend server. Using spring profile test.
2. Running the backend server as local app togther with a local sql db. Using spring profile dev.
3. Running the backend server as a docker directly. With h2 (test) or external DB (dev).
4. Running the backend server as a docker using compose. It uses the compose postgresql docker.

### Instructions on how to build/run the backend locally 

How to build, test, run and use the project server

Download the project from its github [repo](https://github.com/orbartal/docker-tester-spring-sql)
You can downalod it as zip and extract it. Or use git clone.

Install java 17 from [oracle](https://www.oracle.com/java/technologies/downloads/#java17) 

Install maven, on any OS, using [baeldung](https://www.baeldung.com/install-maven-on-windows-linux-mac) guide. 

In the terminal (or cmd) cd into dir "..\docker-tester-spring-sql\backend" and run:

mvn clean install

mvn spring-boot:run

Open url in browser and use the [swagger-ui](http://localhost:8080/swagger-ui/index.html)

### Instructions on how to build/run a single docker 

Install docker on your host.

In the terminal (or cmd) cd into dir "..\docker-tester-spring-sql\backend" and run 3 commands:

mvn clean install
docker build -t orbartal/spring-swagger-demo .
docker run -p 8080:8080 orbartal/spring-swagger-demo -d 

### Instructions on how to build and run a all dockers

Install docker on your host.

1 In the terminal (or cmd) cd into dir "..\docker-tester-spring-sql\backend" and run 2 commands:

mvn clean install
docker build -t orbartal/spring-demo-sql .

2 In the terminal (or cmd) cd into dir "..\docker-tester-spring-sql\tester" and run 2 commands:
mvn clean install
docker build -t orbartal/spring-demo-sql-tester .

3 In the terminal (or cmd) cd into dir "..\docker-tester-spring-sql" and run 2 commands:
 docker compose  --env-file .env up
 
Open url in browser and use the [demo-backend-ui](http://localhost:8080/swagger-ui/index.html)
Open url in browser and use the [demo-tester-ui](http://localhost:8090/swagger-ui/index.html)

#### Instructions on how to login into pgAdmin and manage postgresql tables
All the below details are define, and can be modify, in the ./ docker-compose.yml file.

1 Open url in browser and use the [pgAdmin-ui](http://localhost:5050)

2 Login into pgAdmin-ui (http://localhost:5050) using user and password:
- user: demo@gmail.com
- password: admin
- Use the default language English

3 Create new server and connect to it using the docker postgresql details:
- hostname: postgres
- port: 5432
- user: demo_user
- password: demo_pass

4 In the side menu select the dmo table:
- servers->demo->Databases->demo_db->Schemas->public->Tables->demo_table

5 Run a select query on the table: demo_table
- script->select script
- SELECT demo_id, demo_key, demo_value FROM public.demo_table;

### All urls

Remember that the ports number depend on the .env values use by docker-compose
- [demo-backend-ui](http://localhost:8080/swagger-ui/index.html)
- [demo-tester-ui](http://localhost:8090/swagger-ui/index.html)
- [pgAdmin-ui](http://localhost:5050)