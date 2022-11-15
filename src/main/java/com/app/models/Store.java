package com.app.models;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<User> userList;

    public Store() {
        this.userList = new ArrayList<User>();
        
        User user = new User (1,
                "admin",
                "123");
        userList.add(user);
    }

    public void insertUser(User user){
        if (user != null){
            user.setId(this.userList.size()+1);
            this.userList.add(user);
        }
    }

    public List<User> getUsers(){
        return this.userList;
    }

}
