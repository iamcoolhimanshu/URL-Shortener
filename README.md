URL Shortener Service -----

A simple URL Shortener built with Java, Spring Boot, and H2 Database.
This project allows users to shorten long URLs, redirect via short URLs, and track click counts.

Features

Shorten long URLs with a unique short link

Redirect users from short URL to original URL

Track click counts for analytics

RESTful API with Swagger UI

In-memory H2 database for simplicity

Tech Stack

Java 24

Spring Boot 3.x

Spring Data JPA

H2 Database

Springdoc OpenAPI (Swagger UI)

Getting Started
1. Clone the repository
git clone https://github.com/<your-username>/url-shortener.git
cd url-shortener

2. Build and Run
mvn clean install
mvn spring-boot:run


The application runs on: http://localhost:8080

3. H2 Database Console

Access the H2 console at:

http://localhost:8080/h2-console


JDBC URL: jdbc:h2:mem:shorturl_db

User: sa

Password: (leave empty)

API Endpoints
1. Shorten URL

Endpoint: POST /api/url/shorten

Parameters: longUrl (query param)

Example Request:

POST http://localhost:8080/api/url/shorten?longUrl=https://www.example.com


Response:

{
  "id": 1,
  "longUrl": "https://www.example.com",
  "shortUrl": "aB3",
  "clickCount": 0
}

2. Redirect via Short URL

Endpoint: GET /api/url/{shortUrl}

Example Request:

GET http://localhost:8080/api/url/aB3


Redirects to the original URL

Increments click count

3. Swagger UI

Access Swagger API documentation at:

http://localhost:8080/swagger-ui/index.html


From here, you can test all endpoints directly in the browser.
