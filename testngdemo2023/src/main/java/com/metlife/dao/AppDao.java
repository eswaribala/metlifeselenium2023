package com.metlife.dao;

import com.metlife.models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AppDao {


    public static List<User> generateUsers(){

        List<User> users=new ArrayList<User>();

        for(int i=0;i<10;i++){
            users.add(new User("user"+i,"pass"+new Random().nextInt(100000)));
        }

        return users;

    }


}
