package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CartManagerTestNonEmptyWithSetup {
  private CartManager manager = new CartManager();
  private PurchaseItem first = new PurchaseItem (id: 1, productId: 1, productName: "first", productPrice: 1, count: 1);
  private PurchaseItem second = new PurchaseItem(id: 2, productId: 2, productName: "second", productPrice: 1, count: 1);
  private PurchaseItem third = new PurchaseItem(id: 3, productId: 3, productName: "third", productPrice: 1, count: 1);

  @BeforeEach
  public void setUp() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 1;
    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 4;

    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}