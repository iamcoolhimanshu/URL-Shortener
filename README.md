URL Shortener Service -----

A simple URL Shortener built with Java, Spring Boot, and H2 Database.
This project allows users to shorten long URLs, redirect via short URLs, and track click counts.

Features

Shorten long URLs with a unique short link,
Redirect users from short URL to original URL,
Track click counts for analytics,
RESTful API with Swagger UI,
In-memory H2 database for simplicity.

Tech Stack--

Java, Spring Boot, Spring Data JPA, H2 Database, Springdoc OpenAPI (Swagger UI)

Getting Started
1. Clone the repository
git clone https://github.com/<your-username>/url-shortener.git
cd url-shortener

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
  "longUrl": "https://www.himanshu.com",
  "shortUrl": "2DeDK",
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



     <img width="1325" height="687" alt="image" src="https://github.com/user-attachments/assets/8c9b8774-15f8-46d7-81f6-83694db81336" />

     <img width="1325" height="687" alt="image" src="https://github.com/user-attachments/assets/6e247f7a-3e05-47d0-8215-6887c0d18ee7" />


