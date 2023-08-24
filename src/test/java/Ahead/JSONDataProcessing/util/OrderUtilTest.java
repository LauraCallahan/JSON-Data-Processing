package Ahead.JSONDataProcessing.util;

import Ahead.JSONDataProcessing.OrderTests;
import Ahead.JSONDataProcessing.model.OrderInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Order Util Tests - ")
class OrderUtilTest implements OrderTests {

    @DisplayName("Test Set Total Orders and Value - ")
    @Nested
    class TestSetTotalOrdersAndValue {
        @DisplayName("With No Orders")
        @Test
        void testSetTotalOrderAndValueWithNoOrder() {
            orderData.setOrders(new ArrayList<>());
            OrderInfo result = OrderUtil.setTotalOrderAndValue(orderData);

            assertAll("Test No Orders",
                    () -> assertEquals(0, result.getTotal_orders()),
                    () -> assertEquals(0.0, result.getTotal_order_value(), 0.001));
        }

        @DisplayName("With 1 Order")
        @Test
        void testSetTotalOrderAndValueWithSingleOrder() {
            orderData.setOrders(orderArrayListOne);
            OrderInfo result = OrderUtil.setTotalOrderAndValue(orderData);

            assertAll("Test One Order",
                    () -> assertEquals(3, result.getTotal_orders()),
                    () -> assertEquals(30.0, result.getTotal_order_value(), 0.001));
        }
        @DisplayName("With Multiple Orders")
        @Test
        void testSetTotalOrderAndValueWithMultipleOrder() {
            orderData.setOrders(orderArrayListMultiple);
            OrderInfo result = OrderUtil.setTotalOrderAndValue(orderData);

            assertAll("Test Multiple Orders",
                    () -> assertEquals(10, result.getTotal_orders()),
                    () -> assertEquals(255.0, result.getTotal_order_value(), 0.001));
        }

        @DisplayName("With Order With Null Quantity")
        @Test
        void testSetTotalOrderAndValueWithNullQuantity() {
            orderData.setOrders(orderArrayListNullQuantity);
            OrderInfo result = OrderUtil.setTotalOrderAndValue(orderData);

            assertAll("Test Null Quantity",
                    () -> assertEquals(10, result.getTotal_orders()),
                    () -> assertEquals(255.0, result.getTotal_order_value(), 0.001));
        }
        @DisplayName("With Order With Null Price")
        @Test
        void testSetTotalOrderAndValueWithNullPrice() {
            orderData.setOrders(orderArrayListNullPrice);
            OrderInfo result = OrderUtil.setTotalOrderAndValue(orderData);

            assertAll("Test Null Price",
                    () -> assertEquals(10, result.getTotal_orders()),
                    () -> assertEquals(255.0, result.getTotal_order_value(), 0.001));
        }
    }

    @DisplayName("Test Sum Digits - ")
    @Nested
    class TestSetSumDigits {
        @DisplayName("With Zero")
        @Test
        void testSumDigitsWithZero() {
            int result = OrderUtil.sumDigits(0);
            assertEquals(0, result);
        }
        @DisplayName("With Single Digit")
        @Test
        void testSumDigitsWithSingleDigit() {
            int result = OrderUtil.sumDigits(5);
            assertEquals(5, result);
        }

        @DisplayName("With Multiple Digits")
        @Test
        void testSumDigitsWithMultipleDigits() {
            int result = OrderUtil.sumDigits(123);
            assertEquals(6, result);
        }
    }
}