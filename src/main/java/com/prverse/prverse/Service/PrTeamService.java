package com.prverse.prverse.Service;

import java.util.List;
import java.util.Optional;

import com.prverse.prverse.entity.PrTeam;

public interface PrTeamService {

	List<PrTeam> getAllPrTeams();

	Optional<PrTeam> getByName(String name);

	void deletePrTeam(int id);

}
