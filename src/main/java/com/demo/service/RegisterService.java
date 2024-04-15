package com.demo.service;

import com.demo.cache.UserCache;
import com.demo.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private UserCache userCache;

    public boolean saveUser(String name, String userName, String password, String email) {
        UserInfo userInfo = new UserInfo(name, userName, password, email);
        userCache.addUser(userInfo);
        return true;
    }

    public List<UserInfo> getUsers() {
        return userCache.getUserInfoList();
    }
}
