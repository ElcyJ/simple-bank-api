package com.example.bank.controllers;

import com.example.bank.models.Account;
import com.example.bank.models.User;
import com.example.bank.models.UserResponse;
import com.example.bank.services.AccountService;
import com.example.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registerNewAccount(@RequestBody Account account){
        accountService.addNewAccount(account);
        return "aa";
    }
}


