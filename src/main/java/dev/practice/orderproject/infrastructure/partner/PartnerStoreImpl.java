package dev.practice.orderproject.infrastructure.partner;

import dev.practice.orderproject.domain.partner.Partner;
import dev.practice.orderproject.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner initPartner) {
        if (StringUtils.isEmpty(initPartner.getPartnerToken())) throw new RuntimeException("partner.getPartnerToken()");
        if (StringUtils.isEmpty(initPartner.getPartnerName())) throw new RuntimeException("partner.getPartnerName()");
        if (StringUtils.isEmpty(initPartner.getBusinessNo())) throw new RuntimeException("partner.getBusinessNo()");
        if (StringUtils.isEmpty(initPartner.getEmail())) throw new RuntimeException("partner.getEmail()");
        if (initPartner.getStatus() == null) throw new RuntimeException("partner.getStatus()");

        return partnerRepository.save(initPartner);
    }
}