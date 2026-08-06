package com.prverse.prverse.entity;

import java.time.LocalDate;
import com.prverse.prverse.enums.*;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String email;
    private String password;
    private String phone;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptions = new ArrayList<>();

}