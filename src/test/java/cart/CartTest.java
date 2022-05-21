package cart;

import com.thoughtworks.ddd_workshop.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

  @Test
  public void noItemInTheCart_ItemGetsAddedToCartWhenAddToCartIsCalled() {
    Cart cart = new Cart();
    cart.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));

    assertTrue(cart.getItems().size() == 1);
    assertTrue(cart.getItems().get(0).getQuantity() == 2);
  }

  @Test
  public void removeItemRemovesItemFromCart() {
    Cart cart = new Cart();
    cart.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));
    cart.addItem(
        new Item(new Product("Apple Pencil2", new Price(Currency.getInstance("USD"), 50)), 3));

    cart.remove(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)));

    assertTrue(cart.getItems().size() == 1);
  }

  @Test
  public void removeItemRemovesItemFromCart_addsItToRemovedList() {
    Cart cart = new Cart();
    cart.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));
    cart.addItem(
        new Item(new Product("Apple Pencil2", new Price(Currency.getInstance("USD"), 50)), 3));

    cart.remove(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)));

    assertTrue(cart.getRemovedItems().size() == 1);
  }

  @Test
  public void compareCartsForEquality() {
    Cart cart1 = new Cart();
    Cart cart2 = new Cart();
    cart1.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));
    cart2.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));

    assertFalse(cart1.equals(cart2));
    assertTrue(cart1.equals(cart1));
    assertTrue(cart2.equals(cart2));
  }

  @Test
  public void checkoutRetursFlattenedListOfProducts() {
    Cart cart1 = new Cart();
    cart1.addItem(
        new Item(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)), 2));
    cart1.addItem(new Item(new Product("Apples", new Price(Currency.getInstance("USD"), 50)), 1));

    Order actualResult = cart1.checkout();

    Order expectedResult =
        new Order(List.of(new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)),
                new Product("Apple Pencil", new Price(Currency.getInstance("USD"), 50)),
                new Product("Apples", new Price(Currency.getInstance("USD"), 50))
                ));

    assertTrue(expectedResult.equals(actualResult));
  }
}
