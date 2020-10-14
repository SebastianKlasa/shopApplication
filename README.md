# shopApplication

## Description
REST API for shop application (Without Service layer).

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
  - [POST /books/book](#post-books)
  - [PUT /books/book](#put-books)
  - [DELETE /books/book](#delete-books)

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
    count: 1,
    idUser: 1
  },
  {
    id: 2,
    title: "Stary czlowiek i morze",
    author: "Ernest Hemingway",
    pagesCount: 90,
    price: 19.99,
    count: 1,
    idUser: 2
  }
] 
  ```
  
##### GET /books/[id]

Example: http://localhost:8080/books/1

Response body:

```
{
    "id": 1,
    "title": "Lalka",
    "author": "Bolesław Prus",
    "pagesCount": 859,
    "price": 49.97,
    "count": 1,
    "idUser": 1
}
  ```
  
##### POST /books

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": null,
    "title": "Krzyżacy",
    "author": "Sienkiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": 1,
    "idUser": 2
}
  ```
  
##### PUT /books

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": 19,
    "title": "Dziady",
    "author": "Mickiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": 1,
    "idUser": 2
}
  ```
  
##### DELETE /books

Example: http://localhost:8080/books/book

Request body:

```
{
    "id": 19,
    "title": "Dziady",
    "author": "Mickiewicz",
    "pagesCount": 300,
    "price": 19.97,
    "count": 1,
    "idUser": 2
}
  ```

#### OrderData
Data about submitted orders.
  - [GET /orderData](#get-orderData)
  - [GET /orderData/[id]](#get-orderDataid)
  - [POST /orderData/orderData](#post-orderData)
  - [PUT /orderData/orderData](#put-orderData)
  - [DELETE /orderData/orderData](#delete-orderData)
  
##### GET /orderData

Example: http://localhost:8080/orderData

Response body:

```
[
    {
        "id": 1,
        "orderDate": "2020-01-01",
        "payMethod": "card",
        "deliveryMethod": "delivery",
        "userOrderCollection": [
            {
                "userOrderPK": {
                    "id": 1,
                    "idBook": 1,
                    "idOrder": 1
                },
                "count": 1,
                "book": {
                    "id": 1,
                    "title": "Lalka",
                    "author": "Bolesław Prus",
                    "pagesCount": 859,
                    "price": 49.97,
                    "count": 1,
                    "idUser": 1
                }
            }
        ],
        "idUser": 1
    }
]
  ```
  
##### GET /orderData/[id]

Example: http://localhost:8080/orderData/1

Response body:

```
{
    "id": 1,
    "orderDate": "2020-01-01",
    "payMethod": "card",
    "deliveryMethod": "delivery",
    "userOrderCollection": [
        {
            "userOrderPK": {
                "id": 1,
                "idBook": 1,
                "idOrder": 1
            },
            "count": 1,
            "book": {
                "id": 1,
                "title": "Lalka",
                "author": "Bolesław Prus",
                "pagesCount": 859,
                "price": 49.97,
                "count": 1,
                "idUser": 1
            }
        }
    ],
    "idUser": 1
}
  ```
  
##### POST /orderData

Example: http://localhost:8080/orderData

Request body:

```

```
  
##### PUT /orderData

Example: http://localhost:8080/orderData

Request body:

```

```
  
##### DELETE /orderData

Example: http://localhost:8080/orderData

Request body:

```

  ```


#### UserData
Data about users.
  - [GET /userData](#get-userData)
  - [GET /userData/[id]](#get-userDataid)
  - [POST /userData/userData](#post-userData)
  - [PUT /userData/userData](#put-userData)
  - [DELETE /userData/userData](#delete-userData)
  
##### GET /userData

Example: http://localhost:8080/userData

Response body:

```
[
    {
        "id": 1,
        "email": "sebastian@wp.pl",
        "firstName": "Sebastian",
        "lastName": "Kasa",
        "city": "Gdansk",
        "postalCode": "80-000",
        "street": "Grunwaldzka",
        "homeNumber": "51"
    },
    {
        "id": 2,
        "email": "aDudek@wp.pl",
        "firstName": "Adam",
        "lastName": "Dudek",
        "city": "Warszawa",
        "postalCode": "00-000",
        "street": "Marszalkowska",
        "homeNumber": "511"
    }
]
  ```
  
##### GET /userData/[id]

Example: http://localhost:8080/userData/1

Response body:

```
{
    "id": 1,
    "email": "sebastian@wp.pl",
    "firstName": "Sebastian",
    "lastName": "Kasa",
    "city": "Gdansk",
    "postalCode": "80-000",
    "street": "Grunwaldzka",
    "homeNumber": "51"
}
  ```
  
##### POST /userData/userData

Example: http://localhost:8080/userData/userData

Request body:

```
{
    "id": null,
    "email": "sebastian@wp.pl",
    "firstName": "Sebastian",
    "lastName": "Kassowski",
    "city": "Gdansk",
    "postalCode": "80-000",
    "street": "Grunwaldzka",
    "homeNumber": "51"
}
```
  
##### PUT /userData/userData

Example: http://localhost:8080/userData/userData

Request body:

```
{
    "id": 3,
    "email": "sebastian@wp.pl",
    "firstName": "Sebastian",
    "lastName": "Kassowski",
    "city": "Gdansk",
    "postalCode": "80-000",
    "street": "Polna",
    "homeNumber": "1"
}
```
  
##### DELETE /userData/userData

Example: http://localhost:8080/userData/userData

Request body:

```
{
    "id": 3,
    "email": "sebastian@wp.pl",
    "firstName": "Sebastian",
    "lastName": "Kassowski",
    "city": "Gdansk",
    "postalCode": "80-000",
    "street": "Polna",
    "homeNumber": "1"
}
```
  
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
