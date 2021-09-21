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
        return "redirect:/mainPage";
    }

    @GetMapping("/mainPage/edit/{id}")
    public ModelAndView productDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("single_product_page_edit");
        modelAndView.addObject("product", productRepository.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/mainPage/edit/{id}")
    public ModelAndView editProductById(@PathVariable Integer id, @ModelAttribute("product") Product product) {
        int index = -1;
        List<Product> products = productRepository.findAll();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                index = i;

            }
        }
        Product product1 = products.get(index);
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setTitle(product.getTitle());
        product1.setTypeOfProduct(product.getTypeOfProduct());

        ModelAndView modelAndView = new ModelAndView("redirect:/mainPage");
        modelAndView.addObject("product", product1);
        return modelAndView;
    }

    @PostMapping( "/mainPage/delete")
    public String deleteProduct(@RequestParam int id){
        productRepository.deleteById(id);
        return "redirect:/mainPage";
    }
}

