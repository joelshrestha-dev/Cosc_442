import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ShippingCalculatorTest {

  ShippingCalculator myShippingCalculator;

  // validation testing
  // exception testing
  // boundary testing
    // a. input space partitioning
    // b. boundary value analysis

  @BeforeEach
  void setUp() {
    myShippingCalculator = new ShippingCalculator();
  }

  @AfterEach
  void tearDown() {
    myShippingCalculator = null;
  }

  @ParameterizedTest
  @CsvSource({
    "3.0, 200, false, 10.00", // validation, happy path
    "0.5, 100, false, 5.00", // validation, happy path
    "1.0, 100, false, 5.00", // validation, happy path
    "1.5, 100, false, 10.00", // validation, happy path
    "5.0, 100, false, 10.00", // validation, happy path
    "5.5, 100, false, 20.00", // validation, happy path
    "20.0, 100, false, 20.00", // validation, happy path
    "3.0, 600, false, 18.00", // validation, happy path
    "3.0, 200, true, 16.00", // validation, happy path
    "3.0, 600, true, 24.00", // validation, happy path
    "11.0, 200, true, 30.00", // validation, happy path
  })
  void testCalculateCost(double weight, int distance, boolean fragile, double expectedCost) {
    // arrange 
    // act
    double actualCost = myShippingCalculator.calculateCost(weight, distance, fragile);

    // assert
    assertEquals(expectedCost, actualCost, 0.01);
  }

  @ParameterizedTest
  @CsvSource({
    "0.0, 100, false", // weight too low
    "-1.0, 100, false", // weight too low
    "21.0, 100, false", // weight too high
    "10.0, 0, false", // distance too low
    "10.0, -1, false", // distance too low
    "10.0, 1001, false" // distance too high
  })
  void testCalculateCost_exception(double weight, int distance, boolean fragile){
    assertThrows(IllegalArgumentException.class,
      () -> myShippingCalculator.calculateCost(weight, distance, fragile)
    );
  }
}
