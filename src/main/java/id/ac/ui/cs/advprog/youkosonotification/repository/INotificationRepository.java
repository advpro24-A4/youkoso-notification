package id.ac.ui.cs.advprog.youkosonotification.repository;

import id.ac.ui.cs.advprog.youkosonotification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, UUID> {
}
