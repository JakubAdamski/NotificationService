package com.example.lab4.service.background;

import com.example.lab4.model.Notification;
import com.example.lab4.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationScheduler {

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 60000) // Runs every 60 seconds
    public void sendNotifications() {
        List<Notification> pendingNotifications = notificationService.getPendingNotifications();

        for (Notification notification : pendingNotifications) {
            // Simulate sending notification
            System.out.println("Sending " + notification.getChannel() + " to " + notification.getRecipient() +
                    " with content: " + notification.getContent());

            // Mark as sent
            notificationService.markAsSent(notification);
        }
    }
}