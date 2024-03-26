package com.example.ex_repository.Repository;

import com.example.ex_repository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByID (Integer Id);

    List<User> findUserByEmail(String email);

    @Query("select r from User r where r.role =?1")
    List<User> allUserWithRole(String role);


    @Query("select a from User a where a.age >=?1")
    List<User> allUserWithAge(Integer age);


    User findUserByUsernameAndPassword(String username , String password);

}
