package com.example.lab4.controller;

import com.example.lab4.dto.NotificationRequest;
import com.example.lab4.model.Notification;
import com.example.lab4.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationRequest request) {
        Notification notification = notificationService.createNotification(
                request.getContent(),
                request.getChannel(),
                request.getRecipient()
        );
        return ResponseEntity.ok(notification);
    }
}