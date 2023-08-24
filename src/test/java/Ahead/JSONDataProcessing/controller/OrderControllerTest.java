package Ahead.JSONDataProcessing.controller;

import Ahead.JSONDataProcessing.OrderTests;
import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.services.OrderService;
import Ahead.JSONDataProcessing.services.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OrderController.class)
class OrderControllerTest implements OrderTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OrderService orderService;

    OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    OrderData orderData = new OrderData();

    @Test
    @DisplayName("Post Request Will Return Status 200")
    void evaluateOrders() throws Exception {
        orderData.setOrders(orderArrayListMultiple);
        given(orderService.evaluateOrders(orderData)).willReturn(orderServiceImpl.evaluateOrders(orderData));

        mockMvc.perform(post("/process-orders")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orderData)))
                .andExpect(status().isOk());
    }
}