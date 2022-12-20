package dev.practice.orderproject.interfaces.partner;

import dev.practice.orderproject.domain.partner.Partner;
import dev.practice.orderproject.domain.partner.PartnerCommand;
import dev.practice.orderproject.domain.partner.PartnerInfo;
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

        public PartnerCommand toCommand() {
            return PartnerCommand.builder()
                    .partnerName(partnerName)
                    .businessNo(businessNo)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final Partner.Status status;

        public RegisterResponse(PartnerInfo partnerInfo) {
            this.partnerToken = partnerInfo.getPartnerToken();
            this.partnerName = partnerInfo.getPartnerName();
            this.businessNo = partnerInfo.getBusinessNo();
            this.email = partnerInfo.getEmail();
            this.status = partnerInfo.getStatus();
        }
    }
}
