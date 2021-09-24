package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.component.ShoppingCart;
import pl.sdacademy.model.Product;

@Controller
public class ShoppingCartController {

    private ShoppingCart shoppingCart;

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCartForm() {
        ModelAndView modelAndView = new ModelAndView("shopping_cart");
        modelAndView.addObject("shoppingCart", shoppingCart.getShoppingCart());
        return modelAndView;
    }

    @PostMapping("/shoppingCart/add")
    public String addProductToShoppingCart(@ModelAttribute("product") Product product, int quantity) {
        shoppingCart.add(product, quantity);
        return "shopping_cart";
    }

    @PostMapping("/shoppingCart/remove")
    public String removeProductFromCart(@RequestBody Product product) {
        shoppingCart.remove(product);
        return "redirect:/shoppingCart";
    }
}