package com.pelinhangisi.reportsservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto implements Serializable {

    private String id;
    private String title;
    private String description;
    private BigDecimal price;
    private String assignee;
    private Date advertisementDate;
    private String priorityType;
    private String advertisementStatus;
    private String userId;
}
