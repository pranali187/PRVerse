package com.prverse.prverse.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import com.prverse.prverse.enums.PackageCategory;
import com.prverse.prverse.enums.PackageStatus;
import com.prverse.prverse.enums.PackageType;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId;

	private String packageName;
	
	@Enumerated(EnumType.STRING)
	private PackageCategory category;
	
	private String description;
	private Double price;
	private Integer durationDays;

	@Enumerated(EnumType.STRING)
	private PackageStatus status;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@Enumerated(EnumType.STRING)
	private PackageType packageType;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private PrTeam prTeam;

	@OneToMany(mappedBy = "prPackage")
	private List<Task> tasks = new ArrayList<>();

	@OneToMany(mappedBy = "prPackage")
	private List<Subscription> subscriptions = new ArrayList<>();
}