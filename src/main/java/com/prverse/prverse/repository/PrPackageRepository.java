package com.prverse.prverse.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.PrPackage;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface PrPackageRepository extends JpaRepository<PrPackage, Long>{

}