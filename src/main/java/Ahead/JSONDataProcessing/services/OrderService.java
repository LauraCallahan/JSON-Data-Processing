package Ahead.JSONDataProcessing.services;

import Ahead.JSONDataProcessing.model.OrderData;
import Ahead.JSONDataProcessing.model.OrderInfo;

public interface OrderService {

    OrderInfo evaluateOrders(OrderData orderData);
    OrderInfo setTotalOrderAndValue(OrderData orderData);
    OrderInfo setSumDigits(OrderInfo orderInfo);

}
