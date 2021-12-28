package ru.gb.gbrest.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbrest.dto.OrderDto;
import ru.gb.gbrest.service.feign.OrderDtoApi;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderDtoApi orderDtoApi;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable("orderId") Long id){
        ResponseEntity<OrderDto> order = orderDtoApi.findOrder(id);
        return new ResponseEntity<>(order.getBody(), HttpStatus.FOUND);
    }

    @DeleteMapping("/{orderId}/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("orderId") Long orderId, @PathVariable("productId") Long productId){
        OrderDto orderDto = orderDtoApi.findOrder(orderId).getBody();
        orderDto.getProducts().removeIf(product -> product.getId().equals(productId));
        orderDtoApi.update(orderDto);
    }


}
