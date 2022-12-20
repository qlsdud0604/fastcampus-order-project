package dev.practice.orderproject.interfaces.partner;

import dev.practice.orderproject.domain.partner.Partner;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PartnerDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        private String partnerName;
        private String businessNo;
        private String email;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final Partner.Status status;
    }
}
