package com.pelinhangisi.reportsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reports {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String userId;
    private String advertisementId;
    private LocalDateTime date;
    private String state;


}
