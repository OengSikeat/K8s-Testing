package com.sikeat.k8sdemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mail-service", url = "http://mail-service:8081/api/v1/mail")
public interface MailService {
    @GetMapping
    String getEmail();
}
