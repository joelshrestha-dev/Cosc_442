package game;


import java.awt.Color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {
  private Inventory inventory1;
  private Inventory inventory2;

  @BeforeEach
  public void setUp() {
    inventory1 = new Inventory(5);
    inventory2 = new Inventory(10);
  }

  @AfterEach
  public void tearDown() {
    inventory1 = null;
    inventory2 = null;
  }

  @Test
  public void testAdd() {

    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory2.add(item2);
    assertTrue(inventory1.contains(item1));
    assertTrue(inventory2.contains(item2));

  }

  @Test
  public void testContains() {

  }

  @Test
  public void testGet() {

  }

  @Test
  public void testGetItems() {

  }

  @Test
  public void testIsFull() {

  }

  @Test
  public void testRemove() {

  }
}
