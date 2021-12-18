package ru.gb.gbrest.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.OrderDto;

@FeignClient(url = "localhost:8084/api/v1/order", value = "orderDtoApi")
public interface OrderDtoApi {

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public OrderDto create(@RequestBody OrderDto orderDto);

    @PutMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<?> update(@RequestBody OrderDto orderDto);

    @GetMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8", value = "/{orderId}")
    public ResponseEntity<OrderDto> findOrder(@PathVariable("orderId") Long orderId);
}
