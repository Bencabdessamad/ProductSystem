package com.example.product.piece;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Getter
    private String notificationMessage;
    private long notificationDurationMillis;

    public void setNotificationMessage(String notificationMessage) {
        setNotificationMessage(notificationMessage, 10000);
    }

    public void setNotificationMessage(String notificationMessage, long durationMillis) {
        this.notificationMessage = notificationMessage;
        this.notificationDurationMillis = durationMillis;

        if (durationMillis > 0) {
            new Thread(() -> {
                try {
                    Thread.sleep(durationMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    this.notificationMessage = null;
                }
            }).start();
        }
    }
}
