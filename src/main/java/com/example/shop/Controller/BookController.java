package com.example.shop.Controller;

import com.example.shop.Entity.Book;
import com.example.shop.Service.BookService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteBook(@RequestBody Book book){
        bookService.deleteBook(book);
    }
}
