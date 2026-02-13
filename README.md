# Movie Management REST API

This is a simple Spring Boot REST API project.

## Features
- Add a new movie
- Get movie by ID
- In-memory storage using ArrayList
- Input validation using Jakarta Validation

## Technologies Used
- Java 17
- Spring Boot 4
- Maven

## API Endpoints

### Add Movie
POST /api/movies

Example Body:
{
"id": 1,
"name": "Inception",
"description": "Sci-fi movie"
}

### Get Movie by ID
GET /api/movies/{id}

## How to Run
1. Run MovieApiApplication.java
2. Application runs on port 8081
