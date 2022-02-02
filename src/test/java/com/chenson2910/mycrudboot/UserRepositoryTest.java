//package com.chenson2910.mycrudboot;
//
//import com.chenson2910.mycrudboot.Model.User;
//
//
//import com.chenson2910.mycrudboot.Repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTest {
//    @Autowired private UserRepository userRepository;
//
//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setName("Ivan");
//        user.setSurname("Ivanov");
//        user.setAge(100);
//        User savedUser = userRepository.save(user);
//        System.out.println(savedUser);
//        Assertions.assertNotNull(savedUser);
//        Assertions.assertNotEquals(0, savedUser.getId());
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<User> users = userRepository.findAll();
//        Assertions.assertNotNull(users);
//        for (User user: users){
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        User user =userRepository.findById(2).get();
//        user.setName("Svetozar");
//        userRepository.save(user);
//        User updatedUser = userRepository.findById(2).get();
//        Assertions.assertEquals(updatedUser.getName(), "Svetozar");
//    }
//
//    @Test
//    public void testGet(){
//        Optional<User> optionalUser = userRepository.findById(2);
//        Assertions.assertNotNull(optionalUser);
//        System.out.println(optionalUser.get());
//    }
//    @Test
//    public void testDelete(){
//        userRepository.deleteById(2);
//        Optional<User> optionalUser = userRepository.findById(2);
//        Assertions.assertNull(optionalUser);
//
//    }
//}
