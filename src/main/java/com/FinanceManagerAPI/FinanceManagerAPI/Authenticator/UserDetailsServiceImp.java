package com.FinanceManagerAPI.FinanceManagerAPI.Authenticator;

import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import com.FinanceManagerAPI.FinanceManagerAPI.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        try {
            UserEntity user = userRepo.findByEmail(email);

            if(user != null){
               UserDetails userdetails = User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .build();
                return userdetails;
            }
       throw new UsernameNotFoundException("Username not found : " +email);
        } catch (Exception e) {
            throw new RuntimeException("the user doesnt exits");
        }
    }
}
