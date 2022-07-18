package com.pelinhangisi.advertisementservice.entity;

import lombok.Getter;

@Getter
public enum AdvertisementStatus {
    ACTIVE("Aktif İlan"),
    PASSIVE("Pasif İlan");

    private String label;
    AdvertisementStatus(String label){
        this.label=label;
    }
}
