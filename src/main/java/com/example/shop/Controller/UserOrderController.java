package com.example.shop.Controller;

import com.example.shop.Dao.UserOrderDao;
import com.example.shop.Entity.UserOrder;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userOrder")
public class UserOrderController {
    @Autowired
    UserOrderDao userOrderService;
      
    @RequestMapping(method = RequestMethod.GET)
    public Collection<UserOrder> getAllUserOrder(){
        return userOrderService.getAllUserOrder();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserOrder getUserOrderById(@PathVariable("id") int id){
        return userOrderService.getUserOrderById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addUserOrder(@RequestBody UserOrder userOrder){
        userOrderService.addUserOrder(userOrder);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateUserOrder(@RequestBody UserOrder userOrder){
        userOrderService.updateUserOrder(userOrder);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUserOrder(@RequestBody UserOrder userOrder){
        userOrderService.deleteUserOrder(userOrder);
    }
}
