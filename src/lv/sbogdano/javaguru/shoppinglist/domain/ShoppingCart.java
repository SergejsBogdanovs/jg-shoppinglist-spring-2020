package lv.sbogdano.javaguru.shoppinglist.domain;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCart {
    private long id;
    private String name;
    private List<Product> products;
}
