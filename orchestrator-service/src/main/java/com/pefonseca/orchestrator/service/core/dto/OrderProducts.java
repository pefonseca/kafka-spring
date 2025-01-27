package com.pefonseca.orchestrator.service.core.dto;

import com.pefonseca.order.service.core.document.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProducts {

    private Product product;
    private int quantity;

}
