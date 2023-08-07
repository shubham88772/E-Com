package com.project.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Product {
        @Id
        private int product_id;
        private String product_name;
        private double product_price;
        private boolean stock;
        private int product_quantity;
        private boolean live;
        private String product_imageName;
        private String product_desc;

    }
