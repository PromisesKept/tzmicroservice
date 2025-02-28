package com.example.usersubscription.controller;

import com.example.usersubscription.model.Subscription;
import com.example.usersubscription.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.addSubscription(userId, subscription));
    }

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionsByUserId(userId));
    }

    @DeleteMapping("/{subId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long userId, @PathVariable Long subId) {
        subscriptionService.deleteSubscription(subId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<Subscription>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTopSubscriptions());
    }
}
