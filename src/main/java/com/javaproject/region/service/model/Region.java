package com.javaproject.region.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Region {
    private String id;
    private String name;
    private Date CratedDate;
}
