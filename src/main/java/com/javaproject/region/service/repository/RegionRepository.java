package com.javaproject.region.service.repository;

import com.javaproject.region.service.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region, String> {

    void findByName(String name);
}
