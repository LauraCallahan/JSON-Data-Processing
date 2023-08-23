package Ahead.JSONDataProcessing.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String product;
    private Integer quantity;
    private Double unit_price;
}
