package dev.practice.orderproject.interfaces.partner;

import dev.practice.orderproject.application.partner.PartnerFacade;
import dev.practice.orderproject.common.response.CommonResponse;
import dev.practice.orderproject.domain.partner.PartnerCommand;
import dev.practice.orderproject.domain.partner.PartnerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
        var command = PartnerCommand.builder()
                .partnerName(request.getPartnerName())
                .businessNo(request.getBusinessNo())
                .email(request.getEmail())
                .build();

        var partnerInfo = partnerFacade.registerPartner(command);

        var response = PartnerDto.RegisterResponse.builder()
                .partnerToken(partnerInfo.getPartnerToken())
                .partnerName(partnerInfo.getPartnerName())
                .businessNo(partnerInfo.getBusinessNo())
                .email(partnerInfo.getEmail())
                .status(partnerInfo.getStatus())
                .build();

        return CommonResponse.success(response);
    }
}
