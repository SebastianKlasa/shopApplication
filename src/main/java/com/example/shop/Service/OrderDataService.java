package com.example.shop.Service;

import com.example.shop.Dao.OrderDataDao;
import com.example.shop.Dao.UserOrderDao;
import com.example.shop.Entity.Book;
import com.example.shop.Entity.OrderData;
import com.example.shop.Entity.UserOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDataService {
    @Autowired
    private OrderDataDao orderDataDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserOrderService userOrderService; 
    
    public Collection<OrderData> getAllOrderData(){
        return orderDataDao.getAllOrderData();
    }
    
    public OrderData getOrderDataById(int orderDataId){
        return orderDataDao.getOrderDataById(orderDataId);
    }
    
    public void addOrderData(OrderData orderData){
        List<UserOrder> orderElements = (ArrayList<UserOrder>)orderData.getUserOrderCollection();
        if(isItemInMagazine(orderElements) && isOneElementInOrder(orderElements) 
                && noDuplicatesInOrder(orderElements) && isOrderCostEnough(orderElements)){
            orderDataDao.addOrderData(orderData);            
        }
    }
    
    public void updateOrderData(OrderData orderData){
        orderDataDao.updateOrderData(orderData);
    }
    
    public void deleteOrderData(OrderData orderData){
        orderDataDao.deleteOrderData(orderData);
    }
    //1. item must be in database
    //2. order must contain almost one item
    //3. non duplicates in order
    //4. order s cost must be greater than 29
    //OrderData class must contain collection of UserOrder
    //UserOrder must contain Book value
    
    private boolean isItemInMagazine(List<UserOrder> orderElements){
        boolean flag = true;
        for(UserOrder element:orderElements){
            Integer elementCountInOrder = element.getCount();
            Integer elementCountInMagazine = element.getBook().getCount();
            if(elementCountInOrder == null || elementCountInMagazine == null) return false;
            if(elementCountInOrder > elementCountInMagazine){
                flag = false;
            }
        }
        return flag;
    }
    
    private boolean isOneElementInOrder(List<UserOrder> orderElements){ 
        if(orderElements.size()>0) return true;
        else return true;
    }
    
    private boolean noDuplicatesInOrder(List<UserOrder> orderElements){ 
        Set<Book> books = new HashSet<Book>();
        for(UserOrder element:orderElements){
            if(books.add(element.getBook()) == false) return false;
        }
        return true;
    }
    
    private boolean isOrderCostEnough(List<UserOrder> orderElements){ 
        float costBounder =  29.0f;
        float currentPrice = 0.0f;
        for(UserOrder element:orderElements){
            currentPrice = element.getBook().getPrice();
        }
        if(currentPrice > costBounder) return true;
        else return false;
    }
    
}
