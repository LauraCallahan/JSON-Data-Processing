package Ahead.JSONDataProcessing.services;

import Ahead.JSONDataProcessing.model.Order;
import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderInfo evaluateOrders(OrderData orderData) {
        OrderInfo orderInfo = setTotalOrderAndValue(orderData);

        return setSumDigits(orderInfo);
    }

    public OrderInfo setTotalOrderAndValue(OrderData orderData) {
        OrderInfo orderInfo = new OrderInfo();
        Order[] orders = orderData.getOrders().toArray(new Order[0]);

        int totalOrders = 0;
        double totalOrderValue = 0.0;

        for (Order order : orders) {
            int quantity = order.getQuantity();
            totalOrders += quantity;

            totalOrderValue += (quantity * order.getUnit_price());
        }
        orderInfo.setTotal_orders(totalOrders);
        orderInfo.setTotal_order_value(totalOrderValue);

        return orderInfo;
    }

    public OrderInfo setSumDigits(OrderInfo orderInfo) {

        String[] numArray = orderInfo.getTotal_orders().toString().split("");

        int sumDigits = 0;
        for ( String num : numArray) {
            sumDigits += Integer.parseInt(num);
        }
        orderInfo.setSum_digits(sumDigits);

        return orderInfo;
    }
}
