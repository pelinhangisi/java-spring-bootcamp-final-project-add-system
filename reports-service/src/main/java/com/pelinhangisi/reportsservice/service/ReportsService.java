package com.pelinhangisi.reportsservice.service;


import com.pelinhangisi.reportsservice.dto.AdvertisementDto;
import com.pelinhangisi.reportsservice.entity.Reports;
import com.pelinhangisi.reportsservice.repository.ReportsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportsService {
    private final ReportsRepository reportsRepository;


    @RabbitListener(queues = "${queue.name}")
    public void consume(@Payload AdvertisementDto advertisementDto){
        Reports reports = new Reports();
        reports.setDate(LocalDateTime.now());
        reports.setAdvertisementId(advertisementDto.getId());
        reports.setUserId(advertisementDto.getUserId());
        reports.setState("SENT");
        log.info("Reports {} gönderildi.");
        reportsRepository.save(reports);
    }
}
