package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findbyEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM tables WHERE first_name LIKE (%:firstName%)")
    List<User> findAllByFirstName(@Param("firstName") String firstName);


}