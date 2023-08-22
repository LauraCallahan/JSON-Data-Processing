package Ahead.JSONDataProcessing.model;

import lombok.Data;

@Data
public class OrderInfo {

    private Integer sum_digits;
    private Integer total_orders;
    private Double total_order_value;
}
