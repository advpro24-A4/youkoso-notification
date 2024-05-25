package id.ac.ui.cs.advprog.youkosonotification.model.factory;

import id.ac.ui.cs.advprog.youkosonotification.model.Notification;

public interface INotificationFactory {
    Notification createProductNotification(String message, String userId, String productId);
    Notification createOrderNotification(String message, String userId, String orderId);
    Notification createPaymentNotification(String message, String userId, String paymentId);
    Notification createShipmentNotification(String message, String userId, String shipmentId);}
