package com.example.shop.Dao;

import com.example.shop.Entity.UserOrder;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class UserOrderDao {
    EntityManager em;
    
    public UserOrderDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookShopPU");
        em = emf.createEntityManager();        
    }
    
    public Collection<UserOrder> getAllUserOrder(){
        return (Collection<UserOrder>)em.createQuery("select b from UserOrder b").getResultList();
    }
    
    public UserOrder getUserOrderById(int userOrderId){
        return em.find(UserOrder.class, userOrderId);
    }
    
    public Collection<UserOrder> getUserOrderByOrderId(int id){
        return (Collection<UserOrder>)em.createQuery("select b from UserOrder b where b.userOrderPK.idOrder="+id);
    }
    
    public void addUserOrder(UserOrder userOrder){
        em.getTransaction().begin();
        em.persist(userOrder);
        em.getTransaction().commit();
    }
    
    public void updateUserOrder(UserOrder userOrder){
        em.getTransaction().begin();
        em.merge(userOrder);
        em.getTransaction().commit();
    }
    
    public void deleteUserOrder(UserOrder userOrder){
        em.getTransaction().begin();
        em.remove(em.merge(userOrder));
        em.getTransaction().commit();        
    }
}
