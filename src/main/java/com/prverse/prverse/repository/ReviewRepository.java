package com.prverse.prverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.Review;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByPrPackagePackageId(Long packageId);

	List<Review> findByUserUserId(Long userId);

}
