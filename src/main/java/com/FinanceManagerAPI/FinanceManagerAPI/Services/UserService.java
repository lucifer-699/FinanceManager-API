package com.FinanceManagerAPI.FinanceManagerAPI.Services;

import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import com.FinanceManagerAPI.FinanceManagerAPI.Repositories.UserRepo;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity login(String email, String password) {
        UserEntity user = userRepo.findByEmail(email);
        if (user == null) {
            System.out.println("No user found for email: " + email);
            return null;
        }
        boolean isPasswordValid = passwordEncoder.matches(password, user.getPassword());
        System.out.println("Password match result: " + isPasswordValid);

        if (isPasswordValid) {
            return user;
        } else {
            return null;
        }
    }

    //        public UserEntity login (String email,
//                                 String password){
//            String pass = passwordEncoder.encode(password);
//            System.out.println(pass);
//            return userRepo.validateuser(email,pass);
//        }
    public boolean insertUser (String firstname,String lastname, String email,String password,String phone_number){
        try {
            String pass = passwordEncoder.encode(password);
            System.out.println(pass);
            List<Object[]> rawData = userRepo.insertUser(firstname,lastname,email,pass,phone_number);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                System.out.println(result);
                return "1".equals(result);
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false;
    }
}
