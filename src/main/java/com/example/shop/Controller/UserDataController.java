package com.example.shop.Controller;

import com.example.shop.Dao.UserDataDao;
import com.example.shop.Entity.UserData;
import com.example.shop.Service.UserDataService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userData")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<UserData> getAllUserData(){
        return userDataService.getAllUserData();
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public UserData getUserDataById(@PathVariable("id") int id){
        return userDataService.getUserDataById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void addUserData(@RequestBody UserData userData){
        userDataService.addUserData(userData);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateUserData(@RequestBody UserData userData){
        userDataService.updateUserData(userData);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUserData(@RequestBody UserData userData){
        userDataService.deleteUserData(userData);
    }
    
}
