package com.pelinhangisi.advertisementservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Entity
@Table(name= "advertisements")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Advertisement extends BaseEntityModel {
    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "title", length = 50)
    private String title;

    @Getter
    @Setter
    @Column(name = "description", length = 5000)
    private String description;

    @Getter
    @Setter
    @Column(name = "price")
    private BigDecimal price;

    @Getter
    @Setter
    @Column(name = "assignee", length = 50)
    private String assignee;

    @Getter
    @Setter
    @Column(name = "advertisement_date")
    private LocalDateTime advertisementDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "advertisement_status")
    private AdvertisementStatus advertisementStatus;




}
