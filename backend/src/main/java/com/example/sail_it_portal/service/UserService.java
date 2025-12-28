package com.example.sail_it_portal.service;

import com.example.sail_it_portal.repository.UsersRepo;
import com.example.sail_it_portal.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersRepo usersRepo;

    public Users createUser(Users users) {
        //check if email already exsist if yes then show msg email already exixt other wise create new user(default role should be user not admin)
        Users existingUser = usersRepo.findByEmail(users.getEmail());
        if(existingUser != null) {
            return null;
        }
        // List<Role> list = new ArrayList<>();
         //   list.ads.setRole(users)
        users.setRole("user");
        return usersRepo.save(users);
        //return this.users;
    }

    public Users loginUser(String email, String password) {
        Users users = usersRepo.findByEmail(email);
        if (users!=null && users.getPassword().equals(password)){
            return users; //login success
        }
        return null; // login failed
    }
}
