package com.prverse.prverse.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.PrTeamService;
import com.prverse.prverse.entity.PrTeam;
import com.prverse.prverse.repository.PrTeamRepository;


@Service
public class PrTeamServiceImpl implements PrTeamService{
	@Autowired
	public PrTeamRepository prTeamRepo;

	@Override
	public List<PrTeam> getAllPrTeams() {
		return prTeamRepo.findAll();
	}

	@Override
	public Optional<PrTeam> getByName(String name) {
		// TODO Auto-generated method stub
		return prTeamRepo.findByTeamNameContainingIgnoreCase(name);
	}

	@Override
	public void deletePrTeam(int id) {
		prTeamRepo.deleteByTeamId(id);
	}
	
	

}
