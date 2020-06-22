package com.example.shop.Controller;

import com.example.shop.Entity.Book;
import com.example.shop.Service.BookService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
//request mapper
public class BookController {
    @Autowired
    private BookService bookService;
    
    public Collection<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
}
