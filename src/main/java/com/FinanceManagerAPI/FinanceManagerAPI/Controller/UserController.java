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

    @PostMapping("/signin")
    public boolean insertUser(@RequestBody SignupRequest request){
        System.out.println(request.getEmail() + request.getPassword());
        boolean response = userService.insertUser(request.firstname,request.lastname,request.email, request.password, request.phone_number);
        System.out.println(response);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        System.out.println(email);
        String password = loginRequest.getPassword();
        System.out.println(password);

        try {
            UserEntity data = userService.login(email, password);

            if (data != null) {
                String userid = data.getUserid(); // ✅ now safe
                System.out.println("This user id is recorded: " + userid);
                System.out.println("The user with email: " + email + " is logged in.");

                String token = JwtTokenUtil.generateToken(email);
                return ResponseEntity.ok(new LoginResponse(token, userid));
            } else {
                System.out.println("Login failed: invalid credentials");
                return ResponseEntity.status(401).body("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace(); // ✅ helps you debug
            return ResponseEntity.status(500).body("The login failed due to: " + e.getMessage());
        }


    }
}

