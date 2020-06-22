package com.example.shop.Service;

import com.example.shop.Dao.BookDao;
import com.example.shop.Entity.Book;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    
    public Collection<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }
}
