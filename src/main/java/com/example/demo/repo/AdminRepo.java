package com.example.demo.repo;

import com.example.demo.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admins, Long> {
    Admins findByNameAndPassword(String name, String password);
}
