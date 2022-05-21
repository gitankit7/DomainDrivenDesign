package cart;

import com.thoughtworks.ddd_workshop.domain.Cart;
import com.thoughtworks.ddd_workshop.domain.Item;
import com.thoughtworks.ddd_workshop.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

  @Test
  public void removeItemRemovesItemFromCart_addsItToRemovedList() {
    Cart cart = new Cart();
    cart.addItem(new Item(new Product("Apple Pencil"), 2));
    cart.addItem(new Item(new Product("Apple Pencil2"), 3));

    cart.remove(new Product("Apple Pencil"));

    assertTrue(cart.getRemovedItems().size() == 1);
  }

  @Test
  public void compareCartsForEquality() {
    Cart cart1 = new Cart();
    Cart cart2 = new Cart();
    cart1.addItem(new Item(new Product("Apple Pencil"), 2));
    cart2.addItem(new Item(new Product("Apple Pencil"), 2));


    assertFalse(cart1.equals(cart2));
    assertTrue(cart1.equals(cart1));
    assertTrue(cart2.equals(cart2));
  }
}
