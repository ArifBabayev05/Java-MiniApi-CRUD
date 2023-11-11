package com.javaproject.region.service.controller;

import com.javaproject.region.service.model.Region;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    private static final List<Region> regions = new ArrayList<>();

    public RegionController(){
        if(regions.isEmpty()){
            Region Region1 = new Region("1","Baku", new Date());
            Region Region2 = new Region("2","Rome", new Date());
            Region Region3 = new Region("3","Italy", new Date());

            regions.add(Region1);
            regions.add(Region2);
            regions.add(Region3);
        }

    }


    @GetMapping()
    public ResponseEntity<List<Region>> GetAllRegions(){
        return new ResponseEntity<>(regions,OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> GetRegionById(@PathVariable String id){
        Region result = GetRegion(id);
        return new ResponseEntity<>(result, OK);
    }

    @PostMapping
    public ResponseEntity<Region> AddRegion(@RequestBody Region newRegion){
        newRegion.setCratedDate(new Date());
        regions.add(newRegion);

        return new ResponseEntity<>(newRegion,CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> UpdateRegion(@PathVariable String id,@RequestBody Region newRegion){
        Region oldRegion  = GetRegion(id);
        oldRegion.setName(newRegion.getName());
        oldRegion.setCratedDate(new Date());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletedRegion(@PathVariable String id){
        Region region = GetRegion(id);
        regions.remove(region);

        return new ResponseEntity<>(OK);
    }

    private Region GetRegion(String id){
        return regions.stream().filter(region -> region.getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Region can not be found"));
    }

}
