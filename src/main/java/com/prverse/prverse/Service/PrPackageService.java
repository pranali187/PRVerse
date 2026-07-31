package com.prverse.prverse.Service;

import java.util.List;
import java.util.Optional;

import com.prverse.prverse.entity.PrPackage;

public interface PrPackageService {
	List<PrPackage> getAllPackages();
	Optional<PrPackage> getPackageByID(long id);
	void createPackage(PrPackage prpackage);
	void updatePackage(PrPackage prpackage, long id);
	void deletePackage(long id);
}
