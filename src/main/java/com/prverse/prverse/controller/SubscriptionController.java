package com.prverse.prverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prverse.prverse.Service.SubscriptionService;
import com.prverse.prverse.entity.Subscription;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subService;

    // Create Subscription
    @PostMapping
    public String createSubscription(@RequestBody Subscription subscription) {
        subService.createSubscription(subscription);
        return "Subscription created successfully";
    }

    // Get All Subscriptions
    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subService.getAllSubscription();
    }

    // Get Subscription By Id
    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subService.getSubscriptionById(id);
    }

    // Update Subscription
    @PutMapping("/{id}")
    public String updateSubscription(@PathVariable Long id,
                                     @RequestBody Subscription subscription) {
        subService.updateSubscription(id, subscription);
        return "Subscription updated successfully";
    }

    // Delete Subscription
    @DeleteMapping("/{id}")
    public String deleteSubscription(@PathVariable Long id) {
        subService.deleteSubscription(id);
        return "Subscription deleted successfully";
    }
}