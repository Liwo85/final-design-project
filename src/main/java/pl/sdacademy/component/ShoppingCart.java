package pl.sdacademy.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.sdacademy.model.Product;

import java.util.List;
import java.util.Optional;

@Component
@SessionScope
public class ShoppingCart {

    private final List<ShoppingCartItem> shoppingCart;

    public ShoppingCart(List<ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void add(Product product, int quantity) {
        Optional<ShoppingCartItem> optionalItem = shoppingCart.stream()
                .filter(s -> s.getProduct().getId().equals(product.getId()))
                .findFirst();
        if (optionalItem.isPresent()) {
            ShoppingCartItem shoppingCartItem = optionalItem.get();
            shoppingCartItem.increaseQuantity(quantity);
        } else {
            shoppingCart.add(new ShoppingCartItem(product, quantity));
        }
    }

    public List<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void remove(Product product) {
        Optional<ShoppingCartItem> optionalItem = shoppingCart.stream()
                .filter(s -> s.getProduct().getId().equals(product.getId()))
                .findFirst();
        if (optionalItem.isPresent()) {
            ShoppingCartItem shoppingCartItem = optionalItem.get();
            shoppingCart.remove(shoppingCartItem);
        }
    }
}
