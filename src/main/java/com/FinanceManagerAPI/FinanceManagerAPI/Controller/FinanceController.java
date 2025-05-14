package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @GetMapping("/dashboard")
    public ResponseEntity<?>dashboard(){

    }
}
