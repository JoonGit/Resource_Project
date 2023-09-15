package com.example.resource_project.vo.Resource;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResourceAllVo {
    LocalDate date;
    float price;
    String korName;
    String engName;
    String Symbol;
    String unit;
}
