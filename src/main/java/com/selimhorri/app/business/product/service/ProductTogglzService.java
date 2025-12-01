package com.selimhorri.app.business.product.service;

import com.selimhorri.app.business.product.model.TogglzFeatureDto;
import com.selimhorri.app.business.product.model.response.TogglzDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", contextId = "productTogglzService", path = "/product-service/api/actuator/togglz")
public interface ProductTogglzService {

    @GetMapping
    ResponseEntity<List<TogglzDtoResponse>> findAll();

    @PostMapping("/{featureName}")
    ResponseEntity<TogglzDtoResponse> toggleFeature(
            @PathVariable("featureName")
            @NotBlank(message = "Input must not be blank!")
            @Valid final String featureName,
            @RequestBody
            @NotNull(message = "Input must not be NULL!")
            @Valid final TogglzFeatureDto togglzFeatureDto
    );
}
