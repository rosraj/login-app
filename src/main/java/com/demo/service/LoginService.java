package com.demo.service;

import com.demo.cache.UserCache;
import com.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserCache userCache;

    public String validateUser(String userid, String password) {
        List<UserInfo> userInfoList = userCache.getUserInfoList();
        List<UserInfo> fiteredUserInfoList = userInfoList.stream()
                .filter(user -> userid.equalsIgnoreCase(user.getUsername()))
                .toList();
        if(fiteredUserInfoList.isEmpty()){
            return null;
        }
        else {
            Optional<UserInfo> userInfo = fiteredUserInfoList.stream()
                    .filter(user -> password.equalsIgnoreCase(user.getPassword()))
                    .findFirst();

            return userInfo.map(UserInfo::getName).orElse(null);
        }
    }

    public List<UserInfo> getUserInfoList(){
        return userCache.getUserInfoList();
    }
}
