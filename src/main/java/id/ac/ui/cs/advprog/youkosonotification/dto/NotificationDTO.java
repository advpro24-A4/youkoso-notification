package id.ac.ui.cs.advprog.youkosonotification.dto;

import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
    private String message;
    private NotificationType type;
    private String user_id;
    private String product_id;
    private String order_id;
    private String payment_id;
    private String shipment_id;
}
