package tech.joelf.e_commerce_api.dtos.request;

import jakarta.validation.constraints.*;

public class ProductDtoIn {

    @NotBlank(message = "Required field.")
    @Size(min = 3, max = 80, message = "Name should have at least 3 characters and 80 max characters.")
    private String name;

    @NotBlank(message = "Required field.")
    @Size(min = 10, message = "Description should have at least 10 characters")
    private String description;

    @Positive(message = "Price should be positive.")
    private Double price;
    private String imgUrl;

    public ProductDtoIn() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
