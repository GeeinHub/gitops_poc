package g.gitops.poc.interfaces.dto;

import lombok.Data;

@Data
public class SoIntendedRouteDto {

    private String transportMode;

    private String carrier;

    private String serviceLoop;

    private String vesselVoyage;

    private String pol;

    private String etd;

    private String pod;

    private String eta;

    private String cargoFndEta;

    private String legType;

}
