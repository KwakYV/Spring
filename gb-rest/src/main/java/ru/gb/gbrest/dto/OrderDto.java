package ru.gb.gbrest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    @JsonProperty(value="orderId")
    private Long id;
    @JsonProperty(value="orderNumber")
    private Long number;
    @JsonProperty(value="productList")
    private List<ProductDto> products;
}
