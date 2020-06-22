package com.example.shop.Dao;

import com.example.shop.Entity.Book;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private static Map<Integer, Book> books;
    static{
        books = new HashMap<Integer, Book>(){
            {
                put(1, new Book("xd", "xd", 100, 25));
                put(1, new Book("abc", "hahaha", 130, 55));
                put(1, new Book("nununu", "nini", 10, 5));
            }  
        };
    }
    
    public Collection<Book> getAllBooks(){
        return this.books.values();
    }
}
