package io.hiago.lab4subject.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "lab-4-subject")
public interface SubjectClient {

    @GetMapping("/word")
    String getWord();
}


