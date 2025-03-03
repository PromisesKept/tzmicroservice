package com.example.usersubscription.service;

import com.example.usersubscription.model.Subscription;
import com.example.usersubscription.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription addSubscription(Long userId, Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getTopSubscriptions() {
        return List.of(); // TODO какая-то реализация
    }
}
