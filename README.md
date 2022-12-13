<h3>About</h3> 

This project is made by me to demonstrate my learnings on Docker (mostly) and how can we
incorporate the same in Test Automation space.

<h3>Folder Structure</h3>

    - src
        - main
          - java > com > newtours > pages
            - billing
            - flightbooking
            - flightpreferences
            - iternary
            - registration
        - test
         - java > com > newtours 
            - tests
            - parent
        - .env
        - Dockerfile
        - docker-compose.yaml
        - healthcheck.sh
        - pom.xml
        - testng-suite.xml

- <b>src > main > java</b> : Contains our selenium page objects.
- <b>src > test > java</b> : Contains main test class (which contains test cases) and
                      a base test (which other test classes inherit).
- <b>.env</b> file : This file is like a properties file and contains our test properties like
              browser and module which can be used project-wide.
- <b>docker-compose.yaml</b> : This is .yaml file which describes what kind of nodes we want to be up and running
                               prior to execution.
- <b>healthcheck.sh</b> : It is a shell script which contains commands to check the status of our selenium grid hub.
- <b>Dockerfile</b> : It is an extensionless file that helps Docker engine to execute steps that are required  
                      to be performed at every stage of the execution. It also includes what core dependencies
                      we require.
- <b>pom.xml</b> : Since we are using a typical Maven project, hence this pom.xml helps us to
                   manage our dependencies and version of the project.
- <b>testng-suite.xml<b> : This suite file contains the list of tests to be run.

<h3> How To Run ?</h3>
    - On your terminal, please run the following command: 
        
        docker compose up

<h3>Prerequisites</h3>
    
- Docker needs to be installed on your machine.
- Java 8 or 8+ required.