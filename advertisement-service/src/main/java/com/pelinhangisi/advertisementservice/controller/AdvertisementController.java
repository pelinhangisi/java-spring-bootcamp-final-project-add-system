package com.pelinhangisi.advertisementservice.controller;

import com.pelinhangisi.advertisementservice.dto.AdvertisementDto;
import com.pelinhangisi.advertisementservice.entity.Advertisement;
import com.pelinhangisi.advertisementservice.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @PostMapping("/create")
    public ResponseEntity<AdvertisementDto> createAdvertisement(@RequestBody AdvertisementDto advertisementDto){
        return ResponseEntity.ok(advertisementService.save(advertisementDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<Advertisement>> updateAdvertisement(@PathVariable String id, @RequestBody AdvertisementDto advertisementDto){
        return ResponseEntity.ok(advertisementService.update(id, advertisementDto));
    }

    @GetMapping("/getlist")
    public ResponseEntity<Page<AdvertisementDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(advertisementService.getPagination(pageable));
    }
}
