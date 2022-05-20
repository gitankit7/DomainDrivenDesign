package cart;

import com.thoughtworks.ddd_workshop.domain.Cart;
import com.thoughtworks.ddd_workshop.domain.Item;
import com.thoughtworks.ddd_workshop.domain.CartItemWithQuantity;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

  @Test
  public void noItemInTheCart_ItemGetsAddedToCartWhenAddToCartIsCalled() {
    Cart cart = new Cart();
    cart.addItem(new CartItemWithQuantity(new Item("Apple Pencil"), 2));

    assertTrue(cart.getItems().size() == 1);
    assertTrue(cart.getItems().get(0).getQuantity() == 2);
  }

 /* @Test
  public void itemsInTheeCart_ItemGetsAddedToCartWhenAddToCartIsCalled() {
    Cart cart = new Cart();
    Item applePencil = new Item("Apple Pencil");
    Item sonyWirelessHeadphone = new Item("Sony Wireless headphone");

    cart.addItem(applePencil);
    cart.addItem(sonyWirelessHeadphone);

    assertTrue(cart.getItems().size() == 2);
    assertTrue(cart.getItems().containsAll(List.of(applePencil, sonyWirelessHeadphone)));
  }*/
}
