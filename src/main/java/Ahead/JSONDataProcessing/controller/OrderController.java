package Ahead.JSONDataProcessing.controller;

import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;
import Ahead.JSONDataProcessing.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/process-orders")
    public OrderInfo evaluateOrders(@RequestBody OrderData orderData) {
        return orderService.evaluateOrders(orderData);
    }
}
