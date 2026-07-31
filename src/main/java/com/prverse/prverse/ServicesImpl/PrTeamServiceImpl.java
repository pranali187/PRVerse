package com.prverse.prverse.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.PrTeamService;
import com.prverse.prverse.entity.PrTeam;
import com.prverse.prverse.repository.PrTeamRepository;

@Service
public class PrTeamServiceImpl implements PrTeamService {

    @Autowired
    private PrTeamRepository prRepo;

    @Override
    public void createPrTeam(PrTeam prTeam) {
        prRepo.save(prTeam);
    }

    @Override
    public List<PrTeam> getAllPrTeams() {
        return prRepo.findAll();
    }

    @Override
    public Optional<PrTeam> getByName(String name) {
        return prRepo.findByTeamName(name);
    }

    @Override
    public Optional<PrTeam> getById(Long id) {
        return prRepo.findById(id);
    }

    @Override
    public void updatePrTeam(Long id, PrTeam prTeam) {

        PrTeam existingTeam = prRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PR Team not found"));

        existingTeam.setTeamName(prTeam.getTeamName());
        existingTeam.setDescription(prTeam.getDescription());
        existingTeam.setContactEmail(prTeam.getContactEmail());
        existingTeam.setContactPhone(prTeam.getContactPhone());

        prRepo.save(existingTeam);
    }

    @Override
    public void deletePrTeam(Long id) {

        PrTeam team = prRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PR Team not found"));

        prRepo.delete(team);
    }
}