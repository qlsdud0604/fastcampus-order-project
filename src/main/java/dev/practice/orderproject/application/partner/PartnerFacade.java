package dev.practice.orderproject.application.partner;

import dev.practice.orderproject.domain.notification.NotificationService;
import dev.practice.orderproject.domain.partner.PartnerCommand;
import dev.practice.orderproject.domain.partner.PartnerInfo;
import dev.practice.orderproject.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationServer;

    public PartnerInfo registerPartner(PartnerCommand command) {
        var partnerInfo = partnerService.registerPartner(command);
        notificationServer.sendEmail(partnerInfo.getEmail(), "title", "description");
        return partnerInfo;
    }


}
