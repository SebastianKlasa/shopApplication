package com.example.shop.Dao;

import com.example.shop.Entity.OrderData;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDataDao {
    private EntityManager em;
    
    public OrderDataDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookShopPU");
        em = emf.createEntityManager();        
    }
    
    public Collection<OrderData> getAllOrderData(){
        return (Collection<OrderData>)em.createQuery("select b from OrderData b").getResultList();
    }
    
    public OrderData getOrderDataById(int orderDataId){
        return em.find(OrderData.class, orderDataId);
    }
    
    public void addOrderData(OrderData orderData){
        em.getTransaction().begin();
        em.persist(orderData); //why persist does not work? book obj's id must be null!
        em.getTransaction().commit();
    }
    
    public void updateOrderData(OrderData orderData){
        em.getTransaction().begin();
        em.merge(orderData);
        em.getTransaction().commit();
    }
    
    public void deleteOrderData(OrderData orderData){
        em.getTransaction().begin();
        em.remove(em.merge(orderData));
        em.getTransaction().commit();        
    }
}
