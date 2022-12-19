package dev.practice.orderproject.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PartnerCommand {

    private final String partnerName;
    private final String businessNo;
    private final String email;

}