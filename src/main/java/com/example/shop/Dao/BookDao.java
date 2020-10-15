package com.example.shop.Dao;

import com.example.shop.Entity.Book;
import java.util.Collection;
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
        em.getTransaction().begin();
        em.persist(book); //why persist does not work? book obj's id must be null!
        em.getTransaction().commit();
    }
    
    public void updateBook(Book book){
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
