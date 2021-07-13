package g.gitops.poc.interfaces.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    private String id;

    private String createdBy;

    private Date createdDate;


    private String lastModifiedBy;


    private Date lastModifiedDate;


    private int version;
}
