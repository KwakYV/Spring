package gb.ru.order.rest;

import gb.ru.order.dto.OrderDto;
import gb.ru.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public OrderDto create(@RequestBody OrderDto orderDto){
        if (orderDto.getNumber() == null){
            orderDto.setNumber(orderService.findMaxNumber() + 1);
        }
        return orderService.save(orderDto);
    }

    @PutMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<?> update(@RequestBody OrderDto orderDto){
        orderService.save(orderDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = "application/json;charset=UTF-8",
               consumes = "application/json;charset=UTF-8", value = "/{orderId}")
    public ResponseEntity<OrderDto> findOrder(@PathVariable("orderId") Long orderId){
        OrderDto orderDto;
        if (orderId != null){
            orderDto = orderService.findById(orderId);
            if(orderDto.getId()!= null){
                return new ResponseEntity<>(orderDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
