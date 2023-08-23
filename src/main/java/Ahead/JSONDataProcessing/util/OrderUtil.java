package Ahead.JSONDataProcessing.util;

import Ahead.JSONDataProcessing.model.Order;
import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;

public class OrderUtil {

    public static OrderInfo setTotalOrderAndValue(OrderData orderData) {
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

    public static int sumDigits(int totalOrders) {
        if (totalOrders == 0) return 0;
        return totalOrders % 10 + sumDigits(totalOrders / 10);
    }
}