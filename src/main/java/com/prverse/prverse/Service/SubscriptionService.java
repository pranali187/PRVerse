package com.prverse.prverse.Service;

import java.util.List;

import com.prverse.prverse.entity.Subscription;

public interface SubscriptionService {

	void createSubscription(Subscription subscription);

	List<Subscription> getAllSubscription();

	Subscription getSubscriptionById(Long subscriptionId);

	void updateSubscription(Long subscriptionId, Subscription subscription);

	void deleteSubscription(Long subscriptionId);

}
