package com.invillia.API;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User insertUser(User user){
        return user;
    }

    public User selectUserById(Integer id){
        return new User("Victor",1,19);
    }
}
