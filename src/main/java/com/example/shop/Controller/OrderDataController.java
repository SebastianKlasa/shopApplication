package com.example.shop.Controller;

import com.example.shop.Dao.OrderDataDao;
import com.example.shop.Entity.OrderData;
import com.example.shop.Service.OrderDataService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public OrderData getOrderDataById(@PathVariable("id") int id){
        return orderDataService.getOrderDataById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addOrderData(@RequestBody OrderData orderData){
        orderDataService.addOrderData(orderData);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateOrderData(@RequestBody OrderData orderData){
        orderDataService.updateOrderData(orderData);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrderData(@RequestBody OrderData orderData){
        orderDataService.deleteOrderData(orderData);
    }
}
