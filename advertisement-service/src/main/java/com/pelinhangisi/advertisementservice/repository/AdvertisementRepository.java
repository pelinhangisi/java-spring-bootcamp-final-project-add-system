package com.pelinhangisi.advertisementservice.repository;

import com.pelinhangisi.advertisementservice.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, String> {

    List<Advertisement> findFirst10ByOrderByCreatedAtDesc();
}
