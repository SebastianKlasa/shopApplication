# shopApplication

## Description
REST API for shop application.

#### Database
Catalog 'database' contain database scheme and example data.
To start the application you have to create database before and edit 'persistence.xml' file, add correct:
- jdbc.url
- jdbc.user
- jdbc.password

#### Tests
Application has tests that has to be passed to build project.

### API description

#### Book
Data about books in shop.
  - [GET /books](#get-books)
  - [GET /books/[id]](#get-bookbyid)
  - [POST /books/[id]/book](#post-book)
  - [PUT /books/[id]/book](#put-book)
  - [DELETE /books/[id]/book](#delete-book)

##### GET /books

Example: http://localhost:8080/books

Response body:

```  [
  {
  id: 1,
  title: "Lalka",
  author: "Bolesław Prus",
  pagesCount: 859,
  price: 49.97,
  count: null,
  idUser: 1
  },
  {
  id: 2,
  title: "Stary czlowiek i morze",
  author: "Ernest Hemingway",
  pagesCount: 90,
  price: 19.99,
  count: null,
  idUser: 2
  },
  {
  id: 7,
  title: "Kamienie na szaniec",
  author: "",
  pagesCount: 100,
  price: 19.97,
  count: null,
  idUser: 2
  },
  {
  id: 12,
  title: "Krzyżacy",
  author: "Sienkiewicz",
  pagesCount: 300,
  price: 19.97,
  count: null,
  idUser: 2
  }
  ]```

#### OrderData
Data about submitted orders.
`GET /thing/id`
#### UserData
Data about users.
`GET /thing/id`
#### UserOrderData
Data about relations beetwen users and their orders.
`GET /thing/id`

### Technologies
- Java 8
- Spring Boot
- JPA
- SQL
- MySQL

## Setup
Requirements:
- Maven
- Java 8 or higher
- MySQL server
- Before run application there is required to create database
To build this project locally open project directory and run:
```
mvn package
```
To run program from Command Prompt run follow: 
```
java -jar target/prisonDBApp-1.0-SNAPSHOT.jar
```
