package id.ac.ui.cs.advprog.youkosonotification.model.factory;

import id.ac.ui.cs.advprog.youkosonotification.model.Notification;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationStatus;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;

import java.util.UUID;

public class NotificationFactory implements INotificationFactory{
    @Override
    public Notification createProductNotification(String message, String userId, String productId) {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID());
        notification.setType(NotificationType.PRODUCT);
        notification.setMessage(message);
        notification.setUserId(userId);
        notification.setProductId(productId);
        notification.setStatus(NotificationStatus.UNREAD);
        return notification;
    }

    @Override
    public Notification createOrderNotification(String message, String userId, String orderId) {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID());
        notification.setType(NotificationType.ORDER);
        notification.setMessage(message);
        notification.setUserId(userId);
        notification.setOrderId(orderId);
        notification.setStatus(NotificationStatus.UNREAD);
        return notification;
    }

    @Override
    public Notification createPaymentNotification(String message, String userId, String paymentId) {
        Notification notification = new Notification();
        notification.setType(NotificationType.PAYMENT);
        notification.setId(UUID.randomUUID());
        notification.setMessage(message);
        notification.setUserId(userId);
        notification.setPaymentId(paymentId);
        notification.setStatus(NotificationStatus.UNREAD);
        return notification;
    }

    @Override
    public Notification createShipmentNotification(String message, String userId, String shipmentId) {
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID());
        notification.setType(NotificationType.SHIPMENT);
        notification.setMessage(message);
        notification.setUserId(userId);
        notification.setShipmentId(shipmentId);
        notification.setStatus(NotificationStatus.UNREAD);
        return notification;
    }
}
