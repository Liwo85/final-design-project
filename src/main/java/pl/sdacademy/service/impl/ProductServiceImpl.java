package pl.sdacademy.service.impl;

import org.springframework.stereotype.Service;
import pl.sdacademy.model.Product;
import pl.sdacademy.repository.ProductRepository;
import pl.sdacademy.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> showAllProducts() {
        List<Product> products= productRepository.findAll();
        return products;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product productDetails(Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
