public class ShippingCalculator {

    /*
     * YOUR TASKS:
     *
     * TODO: 1. UNDERSTAND THE REQUIREMENTS
     * Read the Javadocs for calculateCost() and examine the implementation.
     * Identify:
     * - valid inputs;
     * - invalid inputs;
     * - the different ways shipping cost can be calculated; and
     * - important values where the behavior changes.
     *
     * TODO: 2. REFACTOR
     * The calculateCost() method currently performs several different tasks.
     * Use Extract Method refactoring to separate meaningful responsibilities.
     *
     * Consider extracting methods for:
     * - input validation;
     * - base shipping cost; and
     * - fragile-package surcharge.
     *
     * Your refactoring must NOT change the externally observable behavior
     * of calculateCost().
     *
     * TODO: 3. COMPARE THE REFACTORED CODE
     * After refactoring:
     * - compare the readability of calculateCost() before and after;
     * - examine its cyclomatic complexity; and
     * - consider whether the overall logical complexity was reduced
     * or simply distributed among multiple methods.
     *
     * TODO: 4. WRITE NORMAL / VALIDATION TESTS
     * Develop JUnit 5 tests for normal, valid behavior.
     * Use Arrange -> Act -> Assert.
     *
     * Test several meaningful combinations of inputs.
     * Use parameterized tests when appropriate.
     *
     * TODO: 5. WRITE EXCEPTION TESTS
     * Identify invalid input conditions from the requirements and use
     * assertThrows() to verify the expected behavior.
     *
     * TODO: 6. EXAMINE CODE COVERAGE
     * Run your JUnit tests with coverage.
     * Determine:
     * - which statements have executed;
     * - which decisions/branches have been exercised; and
     * - which behaviors remain untested.
     *
     * TODO: 7. PARTITION THE INPUT SPACE
     * Divide the inputs into groups that should behave similarly.
     * Identify equivalence partitions for:
     * - weightKg;
     * - distanceMiles; and
     * - fragile.
     *
     * Select representative values from each partition.
     *
     * TODO: 8. PERFORM BOUNDARY VALUE ANALYSIS
     * Identify values where the program behavior changes.
     *
     * Pay particular attention to boundaries involving:
     * - weight: 0, 1, 5, 10, and 20;
     * - distance: 1, 500, and 1000.
     *
     * Design tests immediately below, at, and immediately above
     * important boundaries where appropriate.
     *
     * TODO: 9. USE PARAMETERIZED TESTS
     * If not done previously, identify related tests that
     * execute the same behavior using different input/output
     * combinations.
     *
     * Replace appropriate duplicated tests with JUnit 5
     * 
     * @ParameterizedTest tests using @ValueSource or @CsvSource.
     *
     * The parameter values should represent deliberate equivalence
     * partition or boundary-value choices rather than arbitrary values.
     */

    /**
     * Calculates the shipping cost for a package.
     *
     * Rules:
     * - Weight must be greater than 0 and no more than 20 kg.
     * - Distance must be between 1 and 1000 miles.
     *
     * Base cost by weight:
     * 0 < weight <= 1 kg : $5.00
     * 1 < weight <= 5 kg : $10.00
     * 5 < weight <= 20 kg : $20.00
     *
     * weight domains:
     *  exception     5        10         20    exception
     * |~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|
     * -inf      0         1         5         20       inf
     * 
     * TR = {D1 .. D5}
     * 
     * Distance domains:
     * exception     1        500       1000   exception
     * |~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|~~~~~~~~~|
     * -inf      0         1         500       1000      inf
     * 
     * Fragility domains:
     *      X         ✓
     * |~~~~~~~~~|~~~~~~~~~|
     *          false     true
     * 
     * Boundary Value Analysisi -> ISP + good TR's for just below, at, above each boundary
     * 
     * Additional charges:
     * - Distance over 500 miles: +$8.00
     * - Fragile package: +$6.00
     * - Fragile package over 10 kg: additional +$4.00 handling fee
     *
     * @param weightKg      package weight in kilograms
     * @param distanceMiles shipping distance in miles
     * @param fragile       whether the package is fragile
     * @return total shipping cost
     * @throws IllegalArgumentException for invalid weight or distance
     */
    public double calculateCost(
        double weightKg,
        int distanceMiles,
        boolean fragile) {

      validateWeightDistance(weightKg, distanceMiles);

      double cost;

      cost = calculateBaseCost(weightKg);

      cost = calculateSurcharge(weightKg, distanceMiles, fragile, cost);

      return cost;
    }

    private double calculateSurcharge(double weightKg, int distanceMiles, boolean fragile, double cost) {
      if (distanceMiles > 500) {
        cost += 8.00;
      }

      if (fragile) {
        cost += 6.00;

        if (weightKg > 10) {
          cost += 4.00;
        }
      }
      return cost;
    }

    private double calculateBaseCost(double weightKg) {
      double cost;
      if (weightKg <= 1) {
          cost = 5.00;
      } else if (weightKg <= 5) {
          cost = 10.00;
      } else {
          cost = 20.00;
      }
      return cost;
    }

    private void validateWeightDistance(double weightKg, int distanceMiles) {
      if (weightKg <= 0 || weightKg > 20) {
          throw new IllegalArgumentException(
                  "Weight must be greater than 0 and no more than 20 kg");
      }

      if (distanceMiles < 1 || distanceMiles > 1000) {
          throw new IllegalArgumentException(
                  "Distance must be between 1 and 1000 miles");
      }
    }
}