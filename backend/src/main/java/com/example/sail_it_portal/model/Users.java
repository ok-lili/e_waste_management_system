package com.example.sail_it_portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    private String email;
    private String department;
    @Column(name="phone_number")
    private String  phoneNumber;
    @Column(name="room_number")
    private int roomNumber;
    private String role;
    private String  password;
}
