package com.example.bank.services;

import com.example.bank.models.User;
import com.example.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email já utilizado");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("Não existe usuário com o id " + userId);
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String email, String password, String name) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("Não existe usuário com o id " + userId));

        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(),email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
            if(userOptional.isPresent()) {
                throw new IllegalStateException("Email já utilizado");
            }
            user.setEmail(email);
        }

        if(name != null && name.length() > 0 && !Objects.equals(user.getName(),name)) {
            user.setName(name);
        }
    }
}
