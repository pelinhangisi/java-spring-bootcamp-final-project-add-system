package com.pelinhangisi.advertisementservice.service;

import com.pelinhangisi.advertisementservice.dto.AdvertisementDto;
import com.pelinhangisi.advertisementservice.entity.Advertisement;
import com.pelinhangisi.advertisementservice.entity.AdvertisementStatus;
import com.pelinhangisi.advertisementservice.entity.PriorityType;
import com.pelinhangisi.advertisementservice.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdvertisementServiceImpl implements AdvertisementService{

    private final AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    @Override
    @Transactional
    public AdvertisementDto save(AdvertisementDto advertisementDto) {
        //advertisement entity
        if(advertisementDto.getDescription() == null)
            throw new IllegalArgumentException("Description can not be null");

        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(advertisementDto.getDescription());
        advertisement.setAdvertisementDate(advertisementDto.getAdvertisementDate());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisement.setPrice(advertisementDto.getPrice());
        advertisement.setAdvertisementStatus(AdvertisementStatus.valueOf(advertisementDto.getAdvertisementStatus()));
        advertisement.setPriorityType(PriorityType.valueOf(advertisementDto.getPriorityType()));
        log.info("New advertisement added {}", advertisement.getAdvertisementDate());
        advertisement = advertisementRepository.save(advertisement);    // postgresql db ye kaydedildi
        //oluşan nesne döner
        advertisementDto.setId(advertisement.getId());
        return advertisementDto;
    }


    @Override
    @Transactional
    public Optional<Advertisement> update(String id , AdvertisementDto advertisementDto) {
        return advertisementRepository.findById(id).map(item -> {
            item.setAssignee(advertisementDto.getAssignee());
            item.setPrice(advertisementDto.getPrice());
            item.setTitle(advertisementDto.getTitle());
            item.setPriorityType(PriorityType.valueOf(advertisementDto.getPriorityType()));
            item.setAdvertisementStatus(AdvertisementStatus.valueOf(advertisementDto.getAdvertisementStatus()));
            return advertisementRepository.save(item);
        });
    }

    @Override
    public Optional<Advertisement> getById(String advertisementId) {
        return advertisementRepository.findById(advertisementId);
    }

    @Override
    public List<Advertisement> findFirst10ByOrderByCreatedAtDesc(AdvertisementDto advertisementDto) {
        return advertisementRepository.findFirst10ByOrderByCreatedAtDesc();
    }

    @Override
    public Page<AdvertisementDto> getPagination(Pageable pageable) {
        return null;
    }


    @Override
    public void createAdvertisement(AdvertisementDto advertisementDto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setPriorityType(PriorityType.URGENT);
        advertisement.setAdvertisementStatus(AdvertisementStatus.ACTIVE);
        advertisement.setAdvertisementDate(LocalDateTime.now());
        advertisement.setPrice(advertisementDto.getPrice());
        advertisement.setTitle(advertisementDto.getTitle());
        advertisementRepository.save(advertisement);

        rabbitTemplate.convertAndSend(queue.getName(), advertisementDto);

    }
}


