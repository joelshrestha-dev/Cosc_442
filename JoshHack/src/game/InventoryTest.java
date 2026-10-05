package game;


import java.awt.Color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    assertTrue(inventory1.get(0).equals(item1));
    assertTrue(inventory2.get(0).equals(item2));

  }

  @Test
  public void testContains() {
    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory2.add(item2);
    assertTrue(inventory1.contains(item1));
    assertTrue(inventory2.contains(item2));

    assertFalse(inventory1.contains(item2));
    assertFalse(inventory2.contains(item1));

  }

  @Test
  public void testGet() {

    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory1.add(item2);
    assertTrue(inventory1.get(0).equals(item1));
    assertTrue(inventory1.get(1).equals(item2));

    assertThrows(IndexOutOfBoundsException.class, () -> inventory1.get(5));

  }

  @Test
  public void testGetItems() {
    Item item1 = new Item((char) 1, Color.magenta, "Item1", "sharp");
    Item item2 = new Item((char) 0, Color.blue, "Item2", "dull");
    inventory1.add(item1);
    inventory1.add(item2);

    assertTrue(inventory1.getItems()[0].equals(item1));
    assertTrue(inventory1.getItems()[1].equals(item2));


    try{
      assertFalse(inventory2.getItems()[0].equals(item1));
    } catch (Exception e) {
      assertFalse(false);
    }
    

    assertTrue(inventory1.getItems().length == 5);

    assertTrue(inventory1.getItems()[4] == null);
  }

  @Test
  public void testIsFull() {

  }

  @Test
  public void testRemove() {

  }
}
