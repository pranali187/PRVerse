package com.prverse.prverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prverse.prverse.Service.ReviewService;
import com.prverse.prverse.entity.Review;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public String createReview(@RequestBody Review review) {
        reviewService.createReview(review);
        return "Review added successfully";
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @PutMapping("/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
        return "Review updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted successfully";
    }

  
    @GetMapping("/package/{packageId}")
    public List<Review> getReviewsByPackage(@PathVariable Long packageId) {
        return reviewService.getReviewsByPackage(packageId);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUser(@PathVariable Long userId) {
        return reviewService.getReviewsByUser(userId);
    }
}