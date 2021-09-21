package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;
import pl.sdacademy.repository.ProductRepository;

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

    @PostMapping("/mainPage/edit/{id}")
    public ModelAndView editProductById(@PathVariable(name = "id") Integer id) {
        int index = -1;
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;
            }
        }
        Product product = products.get(index);

        ModelAndView modelAndView = new ModelAndView("single_product_page_edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/mainPage/deleteProduct/{identification}")
    public String deleteProduct(@PathVariable Integer identification){
        productRepository.deleteById(identification);
        return "redirect:/mainPage";
    }
}

