package com.pelinhangisi.advertisementservice.service;

import com.pelinhangisi.advertisementservice.dto.AdvertisementDto;
import com.pelinhangisi.advertisementservice.entity.Advertisement;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface AdvertisementService {

    void createAdvertisement(AdvertisementDto advertisementDto);

    AdvertisementDto save(AdvertisementDto advertisementDto);

    Optional<Advertisement> update(String id, AdvertisementDto AdvertisementDto);

    Optional<Advertisement> getById(String advertisementId);

    List<Advertisement> findFirst10ByOrderByCreatedAtDesc(AdvertisementDto advertisementDto);

    Page<AdvertisementDto> getPagination(Pageable pageable);

}
