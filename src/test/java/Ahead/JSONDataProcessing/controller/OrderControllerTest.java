package Ahead.JSONDataProcessing.controller;

import Ahead.JSONDataProcessing.model.Order;
import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;
import Ahead.JSONDataProcessing.services.OrderService;
import Ahead.JSONDataProcessing.services.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OrderService orderService;

    OrderServiceImpl orderServiceImpl;
    OrderData orderData = new OrderData();
    OrderInfo orderInfo;

    @BeforeEach
    void setUp() {
        orderServiceImpl = new OrderServiceImpl();

        Order order1 = Order.builder()
                .product("Product 1")
                .quantity(3)
                .unit_price(10.0)
                .build();
        Order order2 = Order.builder()
                .product("Product 2")
                .quantity(5)
                .unit_price(25.0)
                .build();
        Order order3 = Order.builder()
                .product("Product 3")
                .quantity(2)
                .unit_price(50.0)
                .build();

        ArrayList<Order> orderArrayList = new ArrayList<>();
        orderArrayList.add(order1);
        orderArrayList.add(order2);
        orderArrayList.add(order3);

        orderData.setOrders(orderArrayList);
        orderData.setOrders(orderArrayList);
        System.out.println(orderData.getOrders());
    }


    @Test
    void evaluateOrders() throws Exception {
        given(orderService.evaluateOrders(orderData)).willReturn(orderServiceImpl.evaluateOrders(orderData));

        mockMvc.perform(post("/process-orders")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderData)))
                .andExpect(status().isOk());
    }
}