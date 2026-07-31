package com.prverse.prverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prverse.prverse.entity.Subscription;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
