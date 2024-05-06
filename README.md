
---

## Spac Studios

Welcome to Spac Studios! This repository contains the game files for our latest project. Due to their size, we've uploaded them to our Document Management System (DMS).

### Accessing Game Files

To access the game files, please follow this link: [Spac Studios DMS](https://dms.uom.lk/s/g9rao7BD59XYJ5x)

### Instructions

1. Click on the provided link to access the DMS.
2. Log in with your credentials if required.
3. Navigate to the designated folder to find and download the game files.
4. Once downloaded, you can extract the files and start exploring our game!

### Database 

We use MySQL as our database. The database script can be found in `Codes/WebAppliaction/Backend/spacquestionnarie.sql`.

### Instructions

1. **Install MySQL**: Install MySQL on your system.

2. **Create Database**: Run the first two lines of the script (`spacquestionnarie.sql`) to create the `spacdb` database.

    ```bash
    create database spacdb;
    use spacdb;
    ```

3. **Database Configuration**: Update the database configuration in `src/main/resources/application.properties` of the Spring Boot application. Change the username and password according to your database configuration.

    ```properties
    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/spacdb
    spring.datasource.username= your_username
    spring.datasource.password= your_password
    ```

4. **Run Spring Boot Application**: Start the Spring Boot application to create the necessary tables.

5. **Populate Tables**: Once the application is running, execute the rest of the SQL script to insert values into the tables.


