# MetaphorceRh
### REST project that allows to register employees and contracts, as well as to create new contracts and terminate existing ones.

## Prerequisites for starting the service:

# Create database:
`Database used: Mysql 8.0.29`
`Creation file: CreateBd.sql`

### Modification of the property file:

```
server.contextPath=/metaphorce
spring.datasource.url=jdbc:mysql://localhost:3306/metaphorcebd
spring.datasource.username={replace}
spring.datasource.password={replace}
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
server.error.include-stacktrace=never
springdoc.api-docs.path=/api-docs
spring.main.allow-circular-references=true
```
**Fields to update:**
**application.properties**
* **spring.datasource.username={replace}**: Update to the name of the database user. **Example:** spring.datasource.username=User
* **spring.datasource.password={replace}**: Update to the user password.  **Example:** spring.datasource.password=User1234
* * **Optional**: Update database connection port: default 3306 

## Start project:
Open the project with the preferred ide, compile and run to collect connection parameters and services.

## Services:
### Swagger:

Once successfully started, enter the following link in the browser: <http://http://localhost:8080/swagger-ui/index.html>

Enter username and password
## Authentication:
The services implement a basic authentication, which are **User:** metaphorce **Password:** m3t4Ph0rc3



