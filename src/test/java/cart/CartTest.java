package cart;

import com.thoughtworks.ddd_workshop.domain.Cart;
import com.thoughtworks.ddd_workshop.domain.Product;
import com.thoughtworks.ddd_workshop.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

  @Test
  public void noItemInTheCart_ItemGetsAddedToCartWhenAddToCartIsCalled() {
    Cart cart = new Cart();
    cart.addItem(new Item(new Product("Apple Pencil"), 2));

    assertTrue(cart.getItems().size() == 1);
    assertTrue(cart.getItems().get(0).getQuantity() == 2);
  }

  @Test
  public void removeItemRemovesItemFromCart() {
    Cart cart = new Cart();
    cart.addItem(new Item(new Product("Apple Pencil"), 2));
    cart.addItem(new Item(new Product("Apple Pencil2"), 3));

    cart.remove(new Product("Apple Pencil"));

    assertTrue(cart.getItems().size() == 1);
  }
}
