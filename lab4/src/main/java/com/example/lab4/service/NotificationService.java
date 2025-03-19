package com.example.lab4.service;

import com.example.lab4.model.Notification;
import com.example.lab4.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(String content, String channel, String recipient) {
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setChannel(channel);
        notification.setRecipient(recipient);
        notification.setSent(false);

        return notificationRepository.save(notification);
    }

    public List<Notification> getPendingNotifications() {
        return notificationRepository.findBySentFalse();
    }

    public void markAsSent(Notification notification) {
        notification.setSent(true);
        notificationRepository.save(notification);
    }
}