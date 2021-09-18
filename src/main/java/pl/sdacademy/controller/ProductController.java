package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sdacademy.model.Product;
import pl.sdacademy.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/page")
    public String example4(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "page";
    }
}
