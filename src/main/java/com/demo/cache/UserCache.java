package com.demo.cache;

import com.demo.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserCache {

    private List<UserInfo> userInfoList;

    public UserCache() {
        userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo("admin","admin","password","admin@gmail.com"));
    }

    public void addUser(@NonNull UserInfo userInfo){
        userInfoList.add(userInfo);
    }

}
