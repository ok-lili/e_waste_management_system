package com.example.sail_it_portal.repository;

import com.example.sail_it_portal.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Integer> {
    public Users findByEmail(String e);
    public Users findByNameContaining(String name);
    public Users findByEmailAndPassword(String email, String password);
}
