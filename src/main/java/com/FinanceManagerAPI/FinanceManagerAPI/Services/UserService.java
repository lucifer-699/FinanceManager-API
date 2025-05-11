package com.FinanceManagerAPI.FinanceManagerAPI.Services;

import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import com.FinanceManagerAPI.FinanceManagerAPI.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

public UserEntity login (String email,
                         String password){
    //return userRepo.
    return null;
}

public boolean sigin(String email,
                        String password,
                        String firstName,
                        String lastName,
                        String phoneNumber){
//    int value = userRepo
//    if(value == 1){
//        return true;
//    }else {
//        return false;
//    }
    return null;
}
}
