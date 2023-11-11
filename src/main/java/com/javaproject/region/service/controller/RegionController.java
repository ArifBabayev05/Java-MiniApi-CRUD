package com.javaproject.region.service.controller;

import com.javaproject.region.service.model.Region;
import com.javaproject.region.service.service.RegionService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping()
    public ResponseEntity<List<Region>> GetAllRegions(@RequestParam(required = false) String name){
        return new ResponseEntity<>(regionService.getAllRegions(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> GetRegionById(@PathVariable String id){
        return new ResponseEntity<>(GetRegion(id), OK);
    }

    @PostMapping
    public ResponseEntity<Region> AddRegion(@RequestBody Region newRegion){
        return new ResponseEntity<>(regionService.createRegion(newRegion), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> UpdateRegion(@PathVariable String id,@RequestBody Region newRegion){
        regionService.update(id, newRegion);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletedRegion(@PathVariable String id){
        regionService.deleteRegion(id);
        return new ResponseEntity<>(OK);
    }

    private Region GetRegion(String id){
        return regionService.getRegionById(id);
    }

}
