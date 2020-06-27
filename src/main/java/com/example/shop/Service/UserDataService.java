package com.example.shop.Service;

import com.example.shop.Dao.UserDataDao;
import com.example.shop.Entity.UserData;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {
    @Autowired
    private UserDataDao userDataDao;
    
    public Collection<UserData> getAllUserData(){
        return userDataDao.getAllUserData();
    }
    
    public UserData getUserDataById(int userDataId){
        return userDataDao.getUserDataById(userDataId);
    }
    
    public void addUserData(UserData userData){
        userDataDao.addUserData(userData);
    }
    
    public void updateUserData(UserData userData){
        userDataDao.updateUserData(userData);
    }
    
    public void deleteUserData(UserData userData){
        userDataDao.deleteUserData(userData);
    }
}
