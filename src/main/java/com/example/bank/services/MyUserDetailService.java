package com.example.bank.services;

import com.example.bank.models.MyUserDetails;
import com.example.bank.models.User;
import com.example.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return new MyUserDetails(user);
        //return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                //new ArrayList<>());
    }

}
