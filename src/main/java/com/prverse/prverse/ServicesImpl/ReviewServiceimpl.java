package com.prverse.prverse.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.ReviewService;
import com.prverse.prverse.entity.Review;
import com.prverse.prverse.repository.ReviewRepository;

@Service
public class ReviewServiceimpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Override
    public void createReview(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @Override
    public void updateReview(Long id, Review review) {

        Review existingReview = getReviewById(id);

        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());

        // Update only if required
        existingReview.setUser(review.getUser());
        existingReview.setPrPackage(review.getPrPackage());

        reviewRepo.save(existingReview);
    }

    @Override
    public void deleteReview(Long id) {

        Review review = getReviewById(id);

        reviewRepo.delete(review);
    }

    @Override
    public List<Review> getReviewsByPackage(Long packageId) {
        return reviewRepo.findByPrPackagePackageId(packageId);
    }

    @Override
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepo.findByUserUserId(userId);
    }
}