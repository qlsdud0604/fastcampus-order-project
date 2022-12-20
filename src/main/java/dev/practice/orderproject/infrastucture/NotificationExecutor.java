package dev.practice.orderproject.infrastucture;

import dev.practice.orderproject.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("Send Email");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("Send Kakao");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("Send SMS");
    }
}
