package lv.sbogdano.javaguru.shoppinglist.domain;

import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private String category;
    private Double discount;
    private String description;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(description, product.description) &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category) &&
                Objects.equals(price, product.price) &&
                Objects.equals(discount, product.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, discount, description, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
