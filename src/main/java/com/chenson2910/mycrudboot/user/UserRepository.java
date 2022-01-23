package com.chenson2910.mycrudboot.user;


import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<com.chenson2910.mycrudboot.user.User, Integer> {
public Long countById(Integer id);
}
