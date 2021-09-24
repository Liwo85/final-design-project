package pl.sdacademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TypeOfProduct typeOfProduct;

    @Column(length = Integer.MAX_VALUE, nullable = false)
    @Lob
    private byte[] image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TypeOfProduct getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(TypeOfProduct typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
