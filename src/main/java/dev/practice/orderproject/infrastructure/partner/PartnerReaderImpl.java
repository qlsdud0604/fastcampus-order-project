package dev.practice.orderproject.infrastructure.partner;

import dev.practice.orderproject.common.exception.EntityNotFoundException;
import dev.practice.orderproject.domain.partner.Partner;
import dev.practice.orderproject.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReaderImpl implements PartnerReader {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(() -> new EntityNotFoundException());
    }
}
