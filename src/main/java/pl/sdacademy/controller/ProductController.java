package pl.sdacademy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;
import pl.sdacademy.service.ProductService;
import pl.sdacademy.service.impl.ProductServiceImpl;

import java.io.IOException;
import java.util.List;


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
    @ResponseBody
    public ResponseEntity<?> createProduct(Product product,
                                    final @RequestParam("image-multipart") MultipartFile file) throws IOException {
        product.setImage(file.getBytes());
        productService.addProduct(product);
        return ResponseEntity.ok("OK!");
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView productDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("product_edit");
        modelAndView.addObject("product", productService.productDetails(id));
        return modelAndView;
    }

    @PostMapping("/admin/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    @GetMapping("/image/show")
    String show(Model map) {
        List<Product> images = productService.getActiveImages();
        map.addAttribute("images", images);
        return "redirect:/mainPage";
    }
}