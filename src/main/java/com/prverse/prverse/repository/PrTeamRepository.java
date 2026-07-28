package com.prverse.prverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prverse.prverse.entity.PrTeam;

public interface PrTeamRepository extends JpaRepository<PrTeam, Long>{

	
	Optional<PrTeam> findByTeamNameContainingIgnoreCase(String keyword);

	void deleteByTeamId(int id);

}
