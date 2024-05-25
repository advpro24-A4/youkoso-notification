package id.ac.ui.cs.advprog.youkosonotification.service;

import id.ac.ui.cs.advprog.youkosonotification.model.Notification;
import id.ac.ui.cs.advprog.youkosonotification.model.factory.INotificationFactory;
import id.ac.ui.cs.advprog.youkosonotification.repository.INotificationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    private AutoCloseable closeable;

    @Mock
    private INotificationFactory notificationFactory;

    @Mock
    private INotificationRepository notificationRepository;

    private NotificationServiceImpl notificationService;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        notificationService = new NotificationServiceImpl(notificationRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void shouldCreateProductNotification() {
        Notification notification = new Notification();
        when(notificationFactory.createProductNotification(anyString(), anyString(), anyString())).thenReturn(notification);

        notificationService.createNotification(notification);

        ArgumentCaptor<Notification> captor = ArgumentCaptor.forClass(Notification.class);
        verify(notificationRepository).save(captor.capture());
        Notification savedNotification = captor.getValue();

        assertNotNull(savedNotification);
        assertEquals(notification, savedNotification);
    }

    // Similar tests for other notification types
    @Test
    void shouldCreateOrderNotification() {
        Notification notification = new Notification();
        when(notificationFactory.createOrderNotification(anyString(), anyString(), anyString())).thenReturn(notification);

        notificationService.createNotification(notification);

        ArgumentCaptor<Notification> captor = ArgumentCaptor.forClass(Notification.class);
        verify(notificationRepository).save(captor.capture());
        Notification savedNotification = captor.getValue();

        assertNotNull(savedNotification);
        assertEquals(notification, savedNotification);
    }

    @Test
    void shouldCreatePaymentNotification() {
        Notification notification = new Notification();
        when(notificationFactory.createPaymentNotification(anyString(), anyString(), anyString())).thenReturn(notification);

        notificationService.createNotification(notification);

        ArgumentCaptor<Notification> captor = ArgumentCaptor.forClass(Notification.class);
        verify(notificationRepository).save(captor.capture());
        Notification savedNotification = captor.getValue();

        assertNotNull(savedNotification);
        assertEquals(notification, savedNotification);
    }

    @Test
    void shouldCreateShipmentNotification() {
        Notification notification = new Notification();
        when(notificationFactory.createShipmentNotification(anyString(), anyString(), anyString())).thenReturn(notification);

        notificationService.createNotification(notification);

        ArgumentCaptor<Notification> captor = ArgumentCaptor.forClass(Notification.class);
        verify(notificationRepository).save(captor.capture());
        Notification savedNotification = captor.getValue();

        assertNotNull(savedNotification);
        assertEquals(notification, savedNotification);
    }
}
