package com.prverse.prverse.entity;

import java.time.LocalDate;
import java.util.*;

import com.prverse.prverse.enums.TaskStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;
    private String description;
    private Integer orderNo;
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private PrPackage prPackage;

    @OneToMany(mappedBy = "task")
    private List<TaskProof> proofs = new ArrayList<>();
}
