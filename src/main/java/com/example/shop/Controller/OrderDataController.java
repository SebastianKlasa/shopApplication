package com.example.shop.Controller;

import com.example.shop.Dao.OrderDataDao;
import com.example.shop.Entity.OrderData;
import com.example.shop.Service.OrderDataService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderData")
public class OrderDataController {
    @Autowired
    private OrderDataService orderDataService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<OrderData> getAllOrderData(){
        return orderDataService.getAllOrderData();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public OrderData getOrderDataById(int id){
        return orderDataService.getOrderDataById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addOrderData(OrderData orderData){
        orderDataService.addOrderData(orderData);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateOrderData(OrderData orderData){
        orderDataService.updateOrderData(orderData);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrderData(OrderData orderData){
        orderDataService.deleteOrderData(orderData);
    }
}
