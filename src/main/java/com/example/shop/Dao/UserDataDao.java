package com.example.shop.Dao;

import com.example.shop.Entity.Book;
import com.example.shop.Entity.UserData;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataDao {
    EntityManager em;
    
    public UserDataDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookShopPU");
        em = emf.createEntityManager();        
    }
    
    public Collection<UserData> getAllUserData(){
        return (Collection<UserData>)em.createQuery("select b from UserData b").getResultList();
    }
    
    public UserData getUserDataById(int userDataId){
        return em.find(UserData.class, userDataId);
    }
    
    public void addUserData(UserData userData){
        em.getTransaction().begin();
        em.persist(userData);
        em.getTransaction().commit();
    }
    
    public void updateUserData(UserData userData){
        em.getTransaction().begin();
        em.merge(userData);
        em.getTransaction().commit();
    }
    
    public void deleteUserData(UserData userData){
        em.getTransaction().begin();
        em.remove(em.merge(userData));
        em.getTransaction().commit();        
    }
}
