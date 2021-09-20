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

    @GetMapping("/mainPage/{identification}")
    public ModelAndView productDetails(@PathVariable Integer identification) {
        ModelAndView modelAndView = new ModelAndView("single_product_page");
        modelAndView.addObject("product", productRepository.getById(identification));
        return modelAndView;
    }

    @DeleteMapping(path = "/mainPage/{identifier}")
    public void deleteProductById(@PathVariable Integer identifier) {
        productRepository.deleteById(identifier);
    }

    @PostMapping("/mainPage/edit/{identifier}")
    public void editProductById(@RequestBody Product product, @PathVariable Integer identifier) {
        List<Product> products = productRepository.findAll();
        int index = product.getId() - 1;
        products.get(index).setTitle(product.getTitle());
        products.get(index).setDescription(product.getDescription());
        products.get(index).setPrice(product.getPrice());
    }
}