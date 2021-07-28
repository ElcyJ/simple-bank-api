package com.example.bank.repositories;

import com.example.bank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserByPassword(String password);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User existsByEmail(@Param("email") String email);
}
