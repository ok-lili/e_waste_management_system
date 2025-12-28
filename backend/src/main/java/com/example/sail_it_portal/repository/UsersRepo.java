package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
    public Users findByEmail(String email);
    List<Users> findByNameContaining(String name);
    public Users findByNameAndPassword(String name, String password);
}



