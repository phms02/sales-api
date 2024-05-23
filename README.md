# Sales API

## Overview
SalesAPI is a **RESTful API** built with **Spring Boot** that **manages sales data**.

It provides endpoints for creating new sales and retrieving information about sellers and their sales within a specified period.

To develop this project, I used **[IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows)**.

## Table of Contents
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
  - [Creating a Sale](#creating-a-sale)
  - [Retrieving Sellers](#retrieving-sellers)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites
Make sure you have the following installed on your machine:
+ **[Java Development Kit (JDK) 11 or higher](https://www.oracle.com/br/java/technologies/downloads/)**;
  - I used version 22 of the JDK and Java, along with version 3.2.6 of Spring Boot.
+ **[Maven](https://maven.apache.org/download.cgi)**;
+ **[Docker](https://docs.docker.com/get-docker/)** (optional, for running in a containerized environment).

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/phms02/sales-api
   ```
2. **Navigate to the project directory:**
    ```bash
    cd salesAPI
    ```
3. **Build the project using Maven:**
    ```bash
    mvn clean install
    ```
### Running the Application

#### Without Docker
```bash
mvn spring-boot:run
```
#### With Docker (assuming Docker is installed and running)
```bash
docker build -t salesapi .
docker run -p 8080:8080 salesapi
```

## Usage

### Creating a Sale (assuming Postman or HTTPie is installed and runnind)

> I prefer and used **[HTTPie](https://httpie.io/)**!

+ To **create** a new sale, send a POST request to:
  - Include a JSON payload with the sale details in the request body.

```bash
http://localhost:8080/api/sales
```

### Retrieving Sellers

+ To **retrieve** a list of sellers with their sales data, send a GET request to:

```bash
http://localhost:8080/api/sellers?startDate=yyyy-MM-dd&endDate=yyyy-MM-dd
```

> Replace `startDate` and `endDate` with the **desired date range**.

## Technologies Used

<div align="center">
    <a href="https://skillicons.dev">
        <img alt="Java, Spring Boot, Hibernate" src="https://skillicons.dev/icons?i=java,spring,hibernate" />
    </a>
</div>

+ H2 Database (in-memory)
    - ***I'm sorry! I did not find the icon!***

## Project Structure

+ The project follows the MVC (Model-View-Controller) architecture:
    - `src/main/java/com/example/salesapi/controller`: Contains controller classes for handling HTTP requests.
    - `src/main/java/com/example/salesapi/model`: defines the **data models** used in the application.
    - `src/main/java/com/example/salesapi/service`: implements **business logic** and **data processing**.
    - `src/main/resources`: contains **application properties and configurations**. 
    - `src/test/java`: includes `unit and integration tests`.

+ Visually demonstrated:

```bash
sales-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │   │   └── sales/
│   │   │   │   │   └── api/
│   │   │   │   │   │   └── salesapi/
│   │   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   └── service/
│   │   └── resources/
│   │   │   └── application.properties
│   └── test/
│       └── java/
│           └── com/
│           │   └── example/
│           │   │   └── salesapi/
│           │   │   │   └── service/
│           │   │   │   │   └── SaleServiceTest.java
├── Dockerfile
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```

## Contributing

+ Contributions are welcome!
+ Fork the repository and submit a pull request with your changes!