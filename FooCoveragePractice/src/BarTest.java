import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BarTest {

    Bar myBar;

    @BeforeEach
    void setUp() {
      myBar = new Bar();
      boolean result1 = (myBar.foo(10,5) == 50);
      boolean result2 = (myBar.foo(10,0) == 5);
      boolean result3 = (myBar.foo(0,5) == 10);
      boolean result4 = (myBar.foo(1,1) == 0);
    }

    @AfterEach
    void tearDown() {
      myBar = null;
    }

    @Test
    void testFoo_NodeCoverage() {
      assertTrue(myBar.foo(10,5) == 50);
      assertFalse(myBar.foo(10,0) == 5);
      assertFalse(myBar.foo(0,5) == 10);
      assertTrue(myBar.foo(1,1) == 0);
    }

    @Test
    void testFoo_EdgeCoverage() {
      assertTrue(myBar.foo(10,5) == 50);
      assertFalse(myBar.foo(10,0) == 5);
      assertFalse(myBar.foo(0,5) == 10);
      assertTrue(myBar.foo(1,1) == 0);
    }

    @Test
    void testFoo_StatementCoverage() {
      assertTrue(myBar.foo(10,5) == 50);
      assertFalse(myBar.foo(10,0) == 5);
      assertFalse(myBar.foo(0,5) == 10);
      assertTrue(myBar.foo(1,1) == 0);
    }

    @Test
    void testFoo_DecisionCoverage() {
      assertTrue(myBar.foo(10,5) == 50);
      assertFalse(myBar.foo(10,0) == 5);
      assertFalse(myBar.foo(0,5) == 10);
      assertTrue(myBar.foo(1,1) == 0);
    }

    @Test
    void testFoo_ConditionCoverage() {
      assertTrue(myBar.foo(10,5) == 50);
      assertFalse(myBar.foo(10,0) == 5);
      assertFalse(myBar.foo(0,5) == 10);
      assertTrue(myBar.foo(1,1) == 0);
    }

    @Test
      void testFoo() {
      // Statement / true decision
      assertEquals(50, myBar.foo(10, 5));

      // First condition false
      assertEquals(0, myBar.foo(9, 5));

      // First condition true, second condition false
      assertEquals(0, myBar.foo(10, 4));
  }
}
