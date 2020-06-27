package com.example.shop.Dao;

import com.example.shop.Entity.Book;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private EntityManager em;
    
    public BookDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookShopPU");
        em = emf.createEntityManager();        
    }
    
    public Collection<Book> getAllBooks(){
        return (Collection<Book>)em.createQuery("select b from Book b").getResultList();
    }
    
    public Book getBookById(int bookId){
        return em.find(Book.class, bookId);
    }
    
    public void addBook(Book book){
        System.out.print(book.toString()+", "+book.getTitle());
        em.getTransaction().begin();
        em.persist(book); //why persist does not work? book obj's id must be null!
        em.getTransaction().commit();
    }
    
    public void updateBook(Book book){
        System.out.println("dao");
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }
    
    public void deleteBook(Book book){
        em.getTransaction().begin();
        em.remove(em.merge(book));
        em.getTransaction().commit();        
    }
}
