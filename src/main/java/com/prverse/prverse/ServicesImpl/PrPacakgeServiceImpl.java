package com.prverse.prverse.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.PrPackageService;
import com.prverse.prverse.entity.PrPackage;
import com.prverse.prverse.repository.PrPackageRepository;
@Service
public class PrPacakgeServiceImpl implements PrPackageService{
	
	@Autowired
	public PrPackageRepository prpackagerepo;

	@Override
	public List<PrPackage> getAllPackages() {
		return prpackagerepo.findAll();
	}

	@Override
	public Optional<PrPackage> getPackageByID(long id) {
		return prpackagerepo.findById(null);
	}

	@Override
	public void createPackage(PrPackage prpackage) {
		prpackagerepo.save(prpackage);
	}

	@Override
	public void updatePackage(PrPackage prpackage, long id) {
		PrPackage prpack = prpackagerepo.findById(id).orElseThrow( ()->new RuntimeException("Package not found with this id"+id));
		prpack.setPrice(prpackage.getPrice());
		prpack.setDescription(prpackage.getDescription());
		prpack.setDurationDays(prpackage.getDurationDays());
		prpack.setPrice(prpackage.getPrice());
		prpack.setTasks(prpackage.getTasks());
		prpack.setStatus(prpackage.getStatus());
		prpackagerepo.save(prpack);
	}

	@Override
	public void deletePackage(long id) {
		prpackagerepo.deleteById(id);
		
	}

}
