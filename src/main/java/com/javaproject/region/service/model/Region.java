package com.javaproject.region.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Region {
    @Id
    private String id;
    private String name;
    private Date CratedDate = new Date();
}
