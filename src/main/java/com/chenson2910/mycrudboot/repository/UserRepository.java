package com.chenson2910.mycrudboot.repository;


import com.chenson2910.mycrudboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Query("SELECT user FROM User user JOIN FETCH user.roles WHERE user.email=:email")
    User findByEmail(String email);

    Long countById(Integer id);
}
