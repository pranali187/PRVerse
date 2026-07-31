package com.prverse.prverse.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prverse.prverse.Service.SubscriptionService;
import com.prverse.prverse.entity.Subscription;
import com.prverse.prverse.repository.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepo;

    @Override
    public void createSubscription(Subscription subscription) {
        subscriptionRepo.save(subscription);
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepo.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    @Override
    public void updateSubscription(Long subscriptionId, Subscription subscription) {

        Subscription existing = getSubscriptionById(subscriptionId);

        existing.setStartDate(subscription.getStartDate());
        existing.setEndDate(subscription.getEndDate());
        existing.setStatus(subscription.getStatus());

        // Update user/package only if required
        existing.setUser(subscription.getUser());
        existing.setPrPackage(subscription.getPrPackage());

        subscriptionRepo.save(existing);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {

        Subscription subscription = getSubscriptionById(subscriptionId);

        subscriptionRepo.delete(subscription);
    }
}
