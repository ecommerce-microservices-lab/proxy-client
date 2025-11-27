package com.selimhorri.app.business.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TogglzFeatureDto {
    private String name;
    private boolean enabled;
}
