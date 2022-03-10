package com.company.plantinventoryservice.util.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "grow-zone-service")
public interface GrowZoneClient {

    @GetMapping("/zone")
    public String getAllZones();
}
