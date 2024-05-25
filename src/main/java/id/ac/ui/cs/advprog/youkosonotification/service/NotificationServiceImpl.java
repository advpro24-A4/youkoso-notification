package id.ac.ui.cs.advprog.youkosonotification.service;

import id.ac.ui.cs.advprog.youkosonotification.model.Notification;
import id.ac.ui.cs.advprog.youkosonotification.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements INotificationService{

    private final INotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(INotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void createNotification(Notification notification) {
        notificationRepository.save(notification);
    }
}
