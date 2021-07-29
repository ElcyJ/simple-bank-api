package com.example.bank.controllers;

import com.example.bank.models.*;
import com.example.bank.repositories.UserRepository;
import com.example.bank.services.AccountService;
import com.example.bank.services.TransferService;
import com.example.bank.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts/transfer")
public class TransferController {
    private final TransferService transferService;
    @Autowired
    private JWTUtility jwtUtil;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerNewTransfer(@RequestHeader HttpHeaders headers, @RequestBody Transfer transfer){
        String token = null;
        if(headers.getFirst(HttpHeaders.AUTHORIZATION) != null) {
            token = headers.getFirst(HttpHeaders.AUTHORIZATION).substring(7);
        }
        String username = jwtUtil.getUsernameFromToken(token);
        User userFromToken = userRepository.findUserByPassword(username);

        transfer.setUserTransfer(userFromToken);

        transferService.addNewTransfer(transfer);

        return new ResponseEntity<>(new TransferResponse(transfer.getAmount(),
                transfer.getSourceAccountNumber(), transfer.getDestinationAccountNumber(),
                transfer.getUserTransfer()), HttpStatus.OK);
    }
}
