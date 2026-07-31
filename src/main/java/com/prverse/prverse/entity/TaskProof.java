package com.prverse.prverse.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskProof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proofId;

    private String status;
    private String remarks;
    private LocalDate completedDate;
    private String updatedBy;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}