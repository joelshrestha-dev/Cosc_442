import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarCoverageTest {
    Bar myBar;

    @BeforeEach
    void setUp() {
        myBar = new Bar();
    }

    @AfterEach
    void tearDown() {
        myBar = null;
    }

    @Test
    void testFoo_NodeCoverage() {
        assertEquals(50, myBar.foo(10, 5));
        assertEquals(0, myBar.foo(9, 5));
    }

    @Test 
    void testFoo_EdgeCoverage() {
        assertEquals(50, myBar.foo(10, 5));
        assertEquals(0, myBar.foo(10, 4));
        assertEquals(0, myBar.foo(9, 5));
    }

    @Test
    void testFoo_StatementCoverage() {
        assertEquals(50, myBar.foo(10, 5));
    }

    @Test
    void testFoo_DecisionCoverage() {
        assertEquals(50, myBar.foo(10, 5));
        assertEquals(0, myBar.foo(9, 5));
    }

    @Test
    void testFoo_ConditionCoverage() {
        assertEquals(50, myBar.foo(10, 5));
        assertEquals(0, myBar.foo(10, 4));
        assertEquals(0, myBar.foo(9, 5));
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