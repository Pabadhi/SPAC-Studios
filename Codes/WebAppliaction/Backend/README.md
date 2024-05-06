
---

# Backend

## Database 

We use MySQL as our database. The database script can be found in [`Codes/WebAppliaction/Backend/spacquestionnarie.sql`] (./Backend/spacquestionnarie.sql).

### Instructions

1. **Install MySQL**: Install MySQL on your system.

3. **Create Database**: Run the first two lines of the script (`spacquestionnarie.sql`) to create the `spacdb` database.

    ```bash
    create database spacdb;
    use spacdb;
    ```

4. **Database Configuration**: Update the database configuration in `src/main/resources/application.properties` of the Spring Boot application. Change the username and password according to your database configuration.

    ```properties
    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/spacdb
    spring.datasource.username= your_username
    spring.datasource.password= your_password
    ```

5. **Run Spring Boot Application**: Start the Spring Boot application to create the necessary tables.

6. **Populate Tables**: Once the application runs, execute the rest of the SQL script to insert values into the tables.


