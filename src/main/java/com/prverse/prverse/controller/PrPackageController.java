package com.prverse.prverse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prverse.prverse.Service.PrPackageService;
import com.prverse.prverse.entity.PrPackage;

@RestController
@RequestMapping("/PRpackages")
public class PrPackageController {
	@Autowired
	public PrPackageService PRpackageservice;
	
	@GetMapping
	public List<PrPackage> getAllPackages(){
		return PRpackageservice.getAllPackages();
	}
	
	@GetMapping("/{id}")
	public Optional<PrPackage> getAllPackages(@PathVariable long id){
		return PRpackageservice.getPackageByID(id);
	}
	
	@PostMapping("/{id}")
	public String createPrPackag(@RequestBody PrPackage prpackage){
		PRpackageservice.createPackage(prpackage);
		return "created succesfully";
	}
	
	@PutMapping("/{id}")
	public String UpdatePrPackag(@RequestBody PrPackage prpackage, @PathVariable long id){
		PRpackageservice.updatePackage(prpackage,id);
		return "Updated succesfully";
	}
	
	@DeleteMapping("/{id}")
	public String DeletePrPackag(@PathVariable long id){
		PRpackageservice.deletePackage(id);
		return "Deleted succesfully";
	}
}
