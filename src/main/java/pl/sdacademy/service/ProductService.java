package pl.sdacademy.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> showAllProducts();

    public void addProduct(Product product);

    public Product productDetails(Integer id);

    public void deleteProduct(int id);

    public Product getActiveImages(int id);

//    public Optional<Product> getImageById(Integer id);

}
