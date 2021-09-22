package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.component.ShoppingCart;
import pl.sdacademy.model.Product;

@Controller
public class ShoppingCartController {

    private ShoppingCart shoppingCart;

    @GetMapping("/mainPage/shoppingCart")
    public ModelAndView shoppingCartForm() {
        ModelAndView modelAndView = new ModelAndView("shoppingCart");
        modelAndView.addObject("shoppingCart", shoppingCart.getShoppingCart());
        return modelAndView;
    }

    @PostMapping("/mainPage/shoppingCart/add")
    public String addProductToShoppingCart(@ModelAttribute("product") Product product, int quantity) {
        shoppingCart.add(product, quantity);
        return "shoppingCart";
    }

    @PostMapping("/mainPage/shoppingCart/remove")
    public String removeProductFromCart(@RequestBody Product product){
        shoppingCart.remove(product);
        return "redirect:/mainPage/shoppingCart";
    }
}
