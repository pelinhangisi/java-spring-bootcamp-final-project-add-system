package com.pelinhangisi.advertisementservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


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
    private LocalDateTime advertisementDate;
    private String priorityType;
    private String advertisementStatus;
    private String userId;
}
