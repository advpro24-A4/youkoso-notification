package id.ac.ui.cs.advprog.youkosonotification.component;

import id.ac.ui.cs.advprog.youkosonotification.dto.NotificationDTO;
import id.ac.ui.cs.advprog.youkosonotification.model.Notification;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;
import id.ac.ui.cs.advprog.youkosonotification.model.factory.INotificationFactory;
import id.ac.ui.cs.advprog.youkosonotification.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private final INotificationService notificationService;
    private final INotificationFactory notificationFactory;

    @Autowired
    public NotificationListener(INotificationService notificationService, INotificationFactory notificationFactory) {
        this.notificationService = notificationService;
        this.notificationFactory = notificationFactory;
    }


    @KafkaListener(topics= "notification")
    public void notificationListener(NotificationDTO incomingNotification){
        Notification notification = new Notification();

        switch (incomingNotification.getType()){
            case NotificationType.ORDER -> notification = notificationFactory.createOrderNotification(
                    incomingNotification.getMessage(),
                    incomingNotification.getUser_id(),
                    incomingNotification.getOrder_id()
            );
            case NotificationType.PAYMENT -> notification = notificationFactory.createPaymentNotification(
                    incomingNotification.getMessage(),
                    incomingNotification.getUser_id(),
                    incomingNotification.getPayment_id()
            );
            case NotificationType.PRODUCT -> notification = notificationFactory.createProductNotification(
                    incomingNotification.getMessage(),
                    incomingNotification.getUser_id(),
                    incomingNotification.getProduct_id()
            );
            case NotificationType.SHIPMENT -> notification = notificationFactory.createShipmentNotification(
                    incomingNotification.getMessage(),
                    incomingNotification.getUser_id(),
                    incomingNotification.getShipment_id()
            );
        }
        notificationService.createNotification(notification);
    }
}
