package id.ac.ui.cs.advprog.youkosonotification.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationStatus;
import id.ac.ui.cs.advprog.youkosonotification.model.enumaration.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "message",nullable = false)
    private String message;

    @Column(name = "type",nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    @Column(name = "created_at",nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
}

