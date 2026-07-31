package com.prverse.prverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.PrTeam;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface PrTeamRepository extends JpaRepository<PrTeam, Long>{

	Optional<PrTeam> findByTeamNameContainingIgnoreCase(String keyword);

	Optional<PrTeam> findByTeamName(String name);



}
