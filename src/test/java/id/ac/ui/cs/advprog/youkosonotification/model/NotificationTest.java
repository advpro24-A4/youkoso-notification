package id.ac.ui.cs.advprog.youkosonotification.model;

import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationStatus;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;
import id.ac.ui.cs.advprog.youkosonotification.model.factory.NotificationFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class INotificationFactoryTest {

    private AutoCloseable closeable;

    @InjectMocks
    private NotificationFactory notificationFactory;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void shouldCreateProductNotification() {
        String message = "Product notification message";
        String userId = UUID.randomUUID().toString();
        String productId = UUID.randomUUID().toString();

        Notification notification = notificationFactory.createProductNotification(message, userId, productId);

        assertNotNull(notification);
        assertEquals(NotificationType.PRODUCT, notification.getType());
        assertEquals(message, notification.getMessage());
        assertEquals(userId, notification.getUserId());
        assertEquals(productId, notification.getProductId());
        assertEquals(NotificationStatus.UNREAD, notification.getStatus());
    }

    @Test
    void shouldCreateOrderNotification() {
        String message = "Order notification message";
        String userId = UUID.randomUUID().toString();
        String orderId = UUID.randomUUID().toString();

        Notification notification = notificationFactory.createOrderNotification(message, userId, orderId);

        assertNotNull(notification);
        assertEquals(NotificationType.ORDER, notification.getType());
        assertEquals(message, notification.getMessage());
        assertEquals(userId, notification.getUserId());
        assertEquals(orderId, notification.getOrderId());
        assertEquals(NotificationStatus.UNREAD, notification.getStatus());
    }

    @Test
    void shouldCreatePaymentNotification() {
        String message = "Payment notification message";
        String userId = UUID.randomUUID().toString();
        String paymentId = UUID.randomUUID().toString();

        Notification notification = notificationFactory.createPaymentNotification(message, userId, paymentId);

        assertNotNull(notification);
        assertEquals(NotificationType.PAYMENT, notification.getType());
        assertEquals(message, notification.getMessage());
        assertEquals(userId, notification.getUserId());
        assertEquals(paymentId, notification.getPaymentId());
        assertEquals(NotificationStatus.UNREAD, notification.getStatus());
    }

    @Test
    void shouldCreateShipmentNotification() {
        String message = "Shipment notification message";
        String userId = UUID.randomUUID().toString();
        String shipmentId = UUID.randomUUID().toString();

        Notification notification = notificationFactory.createShipmentNotification(message, userId, shipmentId);

        assertNotNull(notification);
        assertEquals(NotificationType.SHIPMENT, notification.getType());
        assertEquals(message, notification.getMessage());
        assertEquals(userId, notification.getUserId());
        assertEquals(shipmentId, notification.getShipmentId());
        assertEquals(NotificationStatus.UNREAD, notification.getStatus());
    }
}