package pl.sdacademy.service;

import pl.sdacademy.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> showAllProducts();

    void addProduct(Product product);

    Product productDetails(Integer id);

    void deleteProduct(int id);

    byte[] getImage(int productId);

//    public Optional<Product> getImageById(Integer id);

}
