package com.prverse.prverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prverse.prverse.Service.PrTeamService;
import com.prverse.prverse.entity.PrTeam;

@RestController
@RequestMapping("/prteam")
public class PrTeamController {
	@Autowired
	public PrTeamService prservice;

	@GetMapping("/prteams")
	public List<PrTeam> getAllTeams() {
		return prservice.getAllPrTeams();
	}
	
	@GetMapping("/name/{name}")
	public Optional<PrTeam> getAllByName(@PathVariable String name){
		return prservice.getByName(name);
		
	}
	
	@DeleteMapping("id/{id}")
	public void deleteById(@PathVariable int id) {
		prservice.deletePrTeam(id);
	}
}
