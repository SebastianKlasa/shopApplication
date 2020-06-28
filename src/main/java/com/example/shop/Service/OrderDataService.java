package com.example.shop.Service;

import com.example.shop.Dao.OrderDataDao;
import com.example.shop.Entity.OrderData;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDataService {
    @Autowired
    private OrderDataDao orderDataDao;
    
    public Collection<OrderData> getAllOrderData(){
        return orderDataDao.getAllOrderData();
    }
    
    public OrderData getOrderDataById(int orderDataId){
        return orderDataDao.getOrderDataById(orderDataId);
    }
    
    public void addOrderData(OrderData orderData){
        orderDataDao.addOrderData(orderData);
    }
    
    public void updateOrderData(OrderData orderData){
        orderDataDao.updateOrderData(orderData);
    }
    
    public void deleteOrderData(OrderData orderData){
        orderDataDao.deleteOrderData(orderData);
    }
}
