package com.javaproject.region.service.service;

import com.javaproject.region.service.exception.RegionNotFoundException;
import com.javaproject.region.service.model.Region;
import com.javaproject.region.service.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getAllRegions(String name) {

        if(name == null){
            return  regionRepository.findAll();
        }
        else{
            regionRepository.findByName(name);
        }
        return regionRepository.findAll();
    }

    public Region createRegion(Region newRegion) {
        return regionRepository.save(newRegion);
    }

    public void deleteRegion(String id) {
        regionRepository.deleteById(id);
    }

    public Region getRegionById(String id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region can not be found"));
    }

    public void update(String id, Region newRegion) {
        Region oldRegion = getRegionById(id);
        oldRegion.setId(newRegion.getId());
        oldRegion.setName(newRegion.getName());
        regionRepository.save(oldRegion);
    }
}
