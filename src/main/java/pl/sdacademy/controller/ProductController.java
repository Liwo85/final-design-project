package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;
import pl.sdacademy.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;



    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/mainPage")
    public String showAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "page";
    }

    @GetMapping("/pageAdd")
    public String addProductForm(@ModelAttribute("product") Product product) {
        return "page_add_form";
    }

    @PostMapping("/pageAdd")
    public String addProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "page_add_result";
    }

    public static Product getProductById(Integer identification) {
        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            if (product.getId().equals(identification)) {
                return product;
            }
        }
            return null;
    }

    @GetMapping("/mainPage/{identification}")
    public ModelAndView productDetails(@PathVariable Integer identification) {
        ModelAndView modelAndView = new ModelAndView("single_product_page");
        modelAndView.addObject("product", ProductController.getProductById(identification));
        return modelAndView;
    }
}
