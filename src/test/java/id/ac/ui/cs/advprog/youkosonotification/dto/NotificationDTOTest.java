package id.ac.ui.cs.advprog.youkosonotification.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationDTOTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSerialization() throws JsonProcessingException {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setMessage("Test Message");
        notificationDTO.setType(NotificationType.ORDER);
        notificationDTO.setUserId("user123");
        notificationDTO.setProductId("product123");
        notificationDTO.setOrderId("order123");
        notificationDTO.setPaymentId("payment123");
        notificationDTO.setShipmentId("shipment123");

        String json = objectMapper.writeValueAsString(notificationDTO);

        String expectedJson = "{\"message\":\"Test Message\",\"type\":\"ORDER\",\"user_id\":\"user123\",\"product_id\":\"product123\",\"order_id\":\"order123\",\"payment_id\":\"payment123\",\"shipment_id\":\"shipment123\"}";

        assertNotNull(json);
        assertEquals(expectedJson, json);
    }

    @Test
    void testDeserialization() throws JsonProcessingException {
        String json = "{\"message\":\"Test Message\",\"type\":\"ORDER\",\"user_id\":\"user123\",\"product_id\":\"product123\",\"order_id\":\"order123\",\"payment_id\":\"payment123\",\"shipment_id\":\"shipment123\"}";

        NotificationDTO notificationDTO = objectMapper.readValue(json, NotificationDTO.class);

        assertNotNull(notificationDTO);
        assertEquals("Test Message", notificationDTO.getMessage());
        assertEquals(NotificationType.ORDER, notificationDTO.getType());
        assertEquals("user123", notificationDTO.getUserId());
        assertEquals("product123", notificationDTO.getProductId());
        assertEquals("order123", notificationDTO.getOrderId());
        assertEquals("payment123", notificationDTO.getPaymentId());
        assertEquals("shipment123", notificationDTO.getShipmentId());
    }
}