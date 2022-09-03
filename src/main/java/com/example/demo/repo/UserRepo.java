package com.example.demo.repo;

import com.example.demo.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findById(long id);
    Users findByNameAndPassword(String name, String password);
}
