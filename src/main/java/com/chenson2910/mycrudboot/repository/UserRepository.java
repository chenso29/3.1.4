package com.chenson2910.mycrudboot.repository;

import com.chenson2910.mycrudboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Query("SELECT user FROM User user JOIN FETCH user.roles WHERE user.email=:email")
    Optional<UserDetails> findByEmail(String email);
}
