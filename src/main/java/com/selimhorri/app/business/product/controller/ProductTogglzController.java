package com.selimhorri.app.business.product.controller;

import com.selimhorri.app.business.product.model.TogglzFeatureDto;
import com.selimhorri.app.business.product.model.response.TogglzDtoResponse;
import com.selimhorri.app.business.product.service.ProductTogglzService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actuator/togglz")
@RequiredArgsConstructor
public class ProductTogglzController {

    private final ProductTogglzService productTogglzService;

    @GetMapping
    public ResponseEntity<List<TogglzDtoResponse>> findAll() {
        return ResponseEntity.ok(this.productTogglzService.findAll().getBody());
    }

    @PostMapping("/{featureName}")
    public ResponseEntity<TogglzDtoResponse> toggleFeature(@PathVariable("featureName") final String featureName,
                                                           @RequestBody final TogglzFeatureDto togglzFeatureDto) {
      return ResponseEntity.ok(this.productTogglzService.toggleFeature(featureName, togglzFeatureDto).getBody());
    };

}