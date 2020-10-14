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
  - [GET /books/[id]](#get-booksid)
  - [POST /books/book](#post-booksbook)
  - [PUT /books/book](#put-booksbook)
  - [DELETE /books/book](#delete-booksbook)

##### GET /books

Example: http://localhost:8080/books

Response body:

```
[
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
  }
] 
  ```
  
##### GET /books/[id]

Example: http://localhost:8080/books/1

Response body:

```
<book>
  <author>Bolesław Prus</author>
  <id>1</id>
  <pagesCount>859</pagesCount>
  <price>49.97</price>
  <title>Lalka</title>
</book>
  ```
  
##### POST /books/book

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": null,
    "title": "Krzyżacy",
    "author": "Sienkiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": null,
    "idUser": 2
}
  ```
  
##### PUT /books/book

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": 19,
    "title": "Dziady",
    "author": "Mickiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": null,
    "idUser": 2
}
  ```
  
##### DELETE /books/book

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": 19,
    "title": "Dziady",
    "author": "Mickiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": null,
    "idUser": 2
}
  ```

#### OrderData
Data about submitted orders.
  - [GET /orderData](#get-orderData)
  - [GET /orderData/[id]](#get-orderDatabyid)
  - [POST /orderData/orderData](#post-orderData)
  - [PUT /orderData/orderData](#put-orderData)
  - [DELETE /orderData/orderData](#delete-orderData)

#### UserData
Data about users.
  - [GET /userData](#get-userData)
  - [GET /userData/[id]](#get-userDatabyid)
  - [POST /userData/userData](#post-userData)
  - [PUT /userData/userData](#put-userData)
  - [DELETE /userData/userData](#delete-userData)
  
#### UserOrderData
Data about relations beetwen users and their orders.
  - [GET /userOrder](#get-userOrder)
  - [GET /userOrder/[id]](#get-userOrderbyid)
  - [POST /userOrder/userOrder](#post-userOrder)
  - [PUT /userOrder/userOrder](#put-userOrder)
  - [DELETE /userOrder/userOrder](#delete-userOrder)

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
