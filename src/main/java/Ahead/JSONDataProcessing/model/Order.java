package Ahead.JSONDataProcessing.model;

import lombok.Data;

@Data
public class Order {
    private String product;
    private Integer quantity;
    private Double unit_price;
}
