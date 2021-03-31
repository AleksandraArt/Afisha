package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTestNonEmpty {
  @Test
  public void shouldRemoveIfExists() {
    CartManager manager = new CartManager();
    int idToRemove = 1;
    PurchaseItem first = new PurchaseItem(id: 1, productId: 1, productName: "first", productPrice: 1, count: 1);
    PurchaseItem second = new PurchaseItem(id: 2, productId: 2, productName: "second", productPrice: 1, count: 1);
    PurchaseItem third = new PurchaseItem(id: 3, productId: 3, productName: "third", productPrice: 1, count: 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second};

//    assertEquals(expected, actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    CartManager manager = new CartManager();
    int idToRemove = 4;
    PurchaseItem first = new PurchaseItem(id: 1, productId: 1, productName: "first", productPrice: 1, count: 1);
    PurchaseItem second = new PurchaseItem(id: 2, productId: 2, productName: "second", productPrice: 1, count: 1);
    PurchaseItem third = new PurchaseItem(id: 3, productId: 3, productName: "third", productPrice: 1, count: 1);
    manager.add(first);
    manager.add(second);
    manager.add(third);

    manager.removeById(idToRemove);

    PurchaseItem[] actual = manager.getAll();
    PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

    assertArrayEquals(expected, actual);
  }
}