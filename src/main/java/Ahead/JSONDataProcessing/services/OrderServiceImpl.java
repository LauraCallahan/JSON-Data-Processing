package Ahead.JSONDataProcessing.services;

import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;
import Ahead.JSONDataProcessing.util.OrderUtil;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderInfo evaluateOrders(OrderData orderData) {
        OrderInfo orderInfo = OrderUtil.setTotalOrderAndValue(orderData);

        int sumDigits = OrderUtil.sumDigits(orderInfo.getTotal_orders());
        orderInfo.setSum_digits(sumDigits);

        return orderInfo;
    }
}
