package com.prverse.prverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prverse.prverse.Service.PrTeamService;
import com.prverse.prverse.entity.PrTeam;
import com.prverse.prverse.entity.User;
@RestController
@RequestMapping("/prteam")
public class PrTeamController {

    @Autowired
    public PrTeamService prservice;

    @PostMapping
    public String createPrTeam(@RequestBody PrTeam prTeam) {
        prservice.createPrTeam(prTeam);
        return "PR Team created successfully";
    }

    @GetMapping
    public List<PrTeam> getAllTeams() {
        return prservice.getAllPrTeams();
    }

    @GetMapping("{name}")
    public Optional<PrTeam> getAllByName(@PathVariable String name) {
        return prservice.getByName(name);
    }

    @PutMapping("{id}")
    public String updatePrTeam(@PathVariable Long id,
                               @RequestBody PrTeam prTeam) {
        prservice.updatePrTeam(id, prTeam);
        return "PR Team updated successfully";
    }

    @DeleteMapping("{id}")
    public String deletePrTeam(@PathVariable Long id) {
        prservice.deletePrTeam(id);
        return "PR Team deleted successfully";
    }
}