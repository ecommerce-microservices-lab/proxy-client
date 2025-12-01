package com.selimhorri.app.business.product.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TogglzDtoResponse {
    private String name;
    private boolean enabled;
    private String strategy;
    private Object params;
}
