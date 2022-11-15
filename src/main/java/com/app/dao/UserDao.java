package com.app.dao;

import com.app.models.Store;
import com.app.models.User;

import java.util.List;

public class UserDao {
    private Store userStore;

    public UserDao() {
        userDao();
    }

    public void userDao() {
        this.userStore = new Store();
    }

    public boolean createUser(User user){
        if (user != null) {
            this.userStore.insertUser(user);
            return true;
        } else {
            return false;
        }
    }

    public List getListUser(){
        return this.userStore.getUsers();
    }
}
