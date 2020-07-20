package lv.sbogdano.javaguru.shoppinglist.domain;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private String description;
    private String price;
    private String discount;
    private String category;
}
