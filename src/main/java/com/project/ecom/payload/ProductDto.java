package com.project.ecom.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int product_id;
    private String product_name;
    private double product_price;
    private boolean stock;
    private int product_quantity;
    private boolean live;
    private String product_imageName;
    private String product_desc;
}
