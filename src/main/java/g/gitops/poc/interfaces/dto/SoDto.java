package g.gitops.poc.interfaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class SoDto extends BaseDto {
    private String soNumber;
    private String status;
    private String customer;
    private String receiveDate;
    private String affiliate;
    private String usci;
    private String businessType;
    private String cargoType;
    private String freight;
    private String tradingTerm;
    private String transportMode;
    private String placeOfReceiptCity;
    private String placeOfReceiptDate;
    private String placeOfReceiptSameAsPolEtd;
    private String placeOfDelivery;
    private String cargoReadyDateType;
    private String cargoReadyDate;
    private String baNum;
    private String finalReceiver;
    private String preAssignBlNum;
    private List<SoIntendedRouteDto> soIntendedRouteDtos;
    private SoPartyDto notifyPartyDto;
    private SoPartyDto alsoNotifyPartyDto;
    private SoPartyDto bookingPartyDto;
    private SoPartyDto shipperPartyDto;
    private SoPartyDto consigneeDto;
    private SoPartyDto factoryDto;
    private List<SoItemDto> itemDtos;
}
