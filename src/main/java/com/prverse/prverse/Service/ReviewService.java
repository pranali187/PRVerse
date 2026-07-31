package com.prverse.prverse.Service;

import java.util.List;

import com.prverse.prverse.entity.Review;

public interface ReviewService {

	void createReview(Review review);

	List<Review> getAllReviews();

	Review getReviewById(Long id);

	void updateReview(Long id, Review review);

	List<Review> getReviewsByPackage(Long packageId);

	List<Review> getReviewsByUser(Long userId);

	void deleteReview(Long id);
}
