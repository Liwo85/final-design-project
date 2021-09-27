package pl.sdacademy.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.model.Product;
import pl.sdacademy.service.ProductService;
import java.io.IOException;

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
    public ResponseEntity<?> createProduct(
            Product product, final @RequestParam("image-multipart") MultipartFile file) throws IOException {
        product.setImage(file.getBytes());
        productService.addProduct(product);
        return ResponseEntity.ok("redirect:/admin");
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


    @GetMapping(path = "/admin/show/{id}", produces = MediaType.ALL_VALUE)
    @ResponseBody
    public byte[] showImage(@PathVariable int id) {
        return productService.getImage(id);
    }

}