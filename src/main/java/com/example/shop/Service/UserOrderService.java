package com.example.shop.Service;

import com.example.shop.Dao.UserOrderDao;
import com.example.shop.Entity.UserOrder;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderService {
    @Autowired
    UserOrderDao userOrderDao;
      
    public Collection<UserOrder> getAllUserOrder(){
        return userOrderDao.getAllUserOrder();
    }
    
    public UserOrder getUserOrderById(int userOrderId){
        return userOrderDao.getUserOrderById(userOrderId);
    }
    
     public Collection<UserOrder> getUserOrderByOrderId(int id){
        return userOrderDao.getUserOrderByOrderId(id);
    }
    
    public void addUserOrder(UserOrder userOrder){
        userOrderDao.addUserOrder(userOrder);
    }
    
    public void updateUserOrder(UserOrder userOrder){
        userOrderDao.updateUserOrder(userOrder);
    }
    
    public void deleteUserOrder(UserOrder userOrder){
        userOrderDao.deleteUserOrder(userOrder);
    }
}
