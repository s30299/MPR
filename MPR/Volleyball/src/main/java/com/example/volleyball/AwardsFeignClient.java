package com.example.volleyball;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "awardsFeign", url="localhost:8082")
public interface AwardsFeignClient {

    @GetMapping("/awards/{id}")
    List<String> getAwardsForPlayer(@PathVariable UUID id);
}
