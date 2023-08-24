package Ahead.JSONDataProcessing;

import Ahead.JSONDataProcessing.model.Order;
import Ahead.JSONDataProcessing.model.OrderData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface OrderTests {

    OrderData orderData = new OrderData();
    ArrayList<Order> orderArrayListOne = new ArrayList<>();
    ArrayList<Order> orderArrayListMultiple = new ArrayList<>();
    @BeforeAll
    default void beforeAll() {
        orderArrayListOne.clear();
        orderArrayListMultiple.clear();

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

        orderArrayListOne.add(order1);
        orderArrayListMultiple.add(order1);
        orderArrayListMultiple.add(order2);
        orderArrayListMultiple.add(order3);
    }
}
