package com.chenson2910.mycrudboot.Repository;


import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<com.chenson2910.mycrudboot.Model.User, Integer> {
public Long countById(Integer id);
}
