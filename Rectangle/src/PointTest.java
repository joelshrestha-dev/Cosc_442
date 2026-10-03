import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Point}.
 */
public class PointTest {

    @Test
    public void testConstructorWithTypicalValues() {
        Point point = new Point(3.5, 8.25);

        assertEquals(3.5, point.x, 0.0);
        assertEquals(8.25, point.y, 0.0);
    }

    @Test
    public void testConstructorWithZeroAndNegativeValues() {
        Point point = new Point(0.0, -4.5);

        assertEquals(0.0, point.x, 0.0);
        assertEquals(-4.5, point.y, 0.0);
    }
}
