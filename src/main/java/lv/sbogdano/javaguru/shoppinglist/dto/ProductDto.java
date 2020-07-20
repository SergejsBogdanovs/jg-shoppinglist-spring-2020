package lv.sbogdano.javaguru.shoppinglist.dto;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private String price;
    private String discount;
    private String category;
}
