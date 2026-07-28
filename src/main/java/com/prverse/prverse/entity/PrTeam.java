package com.prverse.prverse.entity;

import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String teamName;
    private String description;
    private String contactEmail;
    private String contactPhone;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "prTeam")
    private List<PrPackage> packages = new ArrayList<>();

    @OneToMany(mappedBy = "prTeam")
    private List<Review> reviews = new ArrayList<>();
}