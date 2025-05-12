package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import com.FinanceManagerAPI.FinanceManagerAPI.Authenticator.JwtTokenUtil;
import com.FinanceManagerAPI.FinanceManagerAPI.Entities.*;
import com.FinanceManagerAPI.FinanceManagerAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @PutMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email,
                                    @RequestParam String password,
                                    @RequestParam String confirm_password,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName,
                                    @RequestParam String phoneNumber){
        if(!password.equalsIgnoreCase(confirm_password)) {
            return ResponseEntity.status(404).body("The passwords are not matching");
        }
        try{
            boolean data = userService.sigin(email, password, firstName, lastName, phoneNumber);
            if (data != false){
                return ResponseEntity.ok("true");
            }else {
                return ResponseEntity.status(404).body("false");
            }
        }catch (Exception e){
            return ResponseEntity.status(404).body("The user creation failed due to exception !!");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login ( @RequestParam String email,
                                     @RequestParam String password){
        if (email == null && !email.isEmpty()){
            return ResponseEntity.status(404).body("The email is not present or not valid");
        }
        if (password == null && !password.isEmpty()){
            return ResponseEntity.status(404).body("The password is not present or not valid");
        }

        try {
            UserEntity data = userService.login(email,password);
            if (data != null){
                System.out.println("The user with email : " + email + " is logged in.");
                String token = JwtTokenUtil.generateToken(email);
                return ResponseEntity.ok(new LoginResponse(token));
            }else {
                return ResponseEntity.status(404).body(" The token generation Failed !!");
            }
        }catch (Exception e){
            return ResponseEntity.status(404).body("The login failed due to Exception !!");
        }
    }

}

