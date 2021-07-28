package com.example.bank.controllers;

import com.example.bank.models.Account;
import com.example.bank.models.AccountResponse;
import com.example.bank.models.User;
import com.example.bank.models.UserResponse;
import com.example.bank.repositories.UserRepository;
import com.example.bank.services.AccountService;
import com.example.bank.services.MyUserDetailService;
import com.example.bank.services.UserService;
import com.example.bank.utils.JWTUtility;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    private JWTUtility jwtUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerNewAccount(@RequestHeader HttpHeaders headers, @RequestBody Account account){
        String token = null;
        if(headers.getFirst(HttpHeaders.AUTHORIZATION) != null) {
            token = headers.getFirst(HttpHeaders.AUTHORIZATION).substring(7);
        }
        String username = jwtUtil.getUsernameFromToken(token);
        User userFromToken = userRepository.findUserByPassword(username);

        account.setUser(userFromToken);

        accountService.addNewAccount(account);

        return new ResponseEntity<>(new AccountResponse(account.getNumber(),
                account.getBalance(), account.getUser()), HttpStatus.OK);
    }
}


