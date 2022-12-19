package dev.practice.orderproject.domain.partner;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartnerInfo {

    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;
    private Partner.Status status;
}
