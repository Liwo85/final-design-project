package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;
import pl.sdacademy.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/admin")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.showAllProducts());
        return "admin_panel";
    }

    @GetMapping("/addProduct")
    public String addProductForm(@ModelAttribute("product") Product product) {
        return "product_add_form";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView productDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("product_edit");
        modelAndView.addObject("product", productService.productDetails(id));
        return modelAndView;
    }
//      Metoda do edycji produktu po wyszukiwaniu
//    @PostMapping(value = "/mainPage/edit/{id}")
//    public ModelAndView editProductById(@PathVariable Integer id, @ModelAttribute("product") Product product) {
//        Product product1 = productRepository.findById(id).orElseThrow(() -> {
//            throw new RuntimeException("Brak produktu o id " + id);
//        });
//        product1.setPrice(product.getPrice());
//        product1.setDescription(product.getDescription());
//        product1.setTitle(product.getTitle());
//        product1.setTypeOfProduct(product.getTypeOfProduct());
//        productRepository.save(product1);
//        ModelAndView modelAndView = new ModelAndView("redirect:/mainPage");
//        modelAndView.addObject("product", product1);
//        return modelAndView;
//    }

    @PostMapping("/admin/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
}