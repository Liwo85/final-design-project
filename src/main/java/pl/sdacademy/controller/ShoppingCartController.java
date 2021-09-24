package pl.sdacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.component.ShoppingCart;
import pl.sdacademy.model.Product;

@Controller
public class ShoppingCartController {

    private ShoppingCart shoppingCart;

    @GetMapping("/orders/shopping_cart")
    public String shoppingCartForm(Model model) {
//        ModelAndView modelAndView = new ModelAndView("orders/shopping_cart");
//        modelAndView.addObject("shoppingCart", shoppingCart.getShoppingCart());
        return "orders/shopping_cart";
    }

//    @PostMapping("/orders/shopping_cart/add")
//    public String addProductToShoppingCart(@ModelAttribute("product") Product product, int quantity) {
//        shoppingCart.add(product, quantity);
//        return "shoppingCart";
//    }
//
//    @PostMapping("/orders/shopping_cart/remove")
//    public String removeProductFromCart(@RequestBody Product product){
//        shoppingCart.remove(product);
//        return "redirect:/mainPage/shoppingCart";
//    }
}
