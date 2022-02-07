package com.chenson2910.mycrudboot.repository;


import com.chenson2910.mycrudboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    Long countById(Integer id);
}
