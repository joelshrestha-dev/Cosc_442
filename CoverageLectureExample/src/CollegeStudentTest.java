import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


// needs to pass node / statement coverage, edge / decision coverage, and condition converage

public class CollegeStudentTest {
    CollegeStudent alice;
    CollegeStudent bob;

    @BeforeEach
    void setUp() {
        alice = new CollegeStudent();
        bob = new CollegeStudent();
    }

    @AfterEach
    void tearDown() {
        alice = null;
        bob = null;
    }

    @Test
    void testGoOut_True_NonParam() {
        // arrange: done in setup

        // act: give bob/alice study hours, money, day, friends and goOut()
        boolean bobResult = bob.goOut(2, 10, true, "Friday");
        boolean aliceResult = alice.goOut(5, 40, true, "Thursday");

        // assert:
        assertTrue(bobResult);
        assertTrue(aliceResult);
    }
    
    @ParameterizedTest
    @CsvSource({
            "0, 0, false, Friday",
            "4, 25, false, Monday",
            "1, 25, true, Monday"
    })
    void testGoOut_True_Param(int hoursStudied, int moneyInWallet,
            boolean friendsAround, String dayOfWeek) {

        // arrange: done in setUp and parameterized values in CsvSource

        // act: with parameterized values, call goOut()
        boolean goOutResult = bob.goOut(hoursStudied, moneyInWallet, friendsAround, dayOfWeek);

        // assert
        assertTrue(goOutResult);
    }


    @ParameterizedTest
    @CsvSource({
            "0,0,false,friday",
            "4, 0, false, monday",
            "0,25, false, saturday",
            "1, 10, true, tuesday"
    })
    void testGoOut_False_Param(int hoursStudied, int moneyInWallet,
            boolean friendsAround, String dayOfWeek) {

        // arrange: done in setUp and parameterized values in CsvSource

        // act: with parameterized values, call goOut()
        boolean goOutResult = bob.goOut(hoursStudied, moneyInWallet, friendsAround, dayOfWeek);

        // assert
        assertFalse(goOutResult);
    }
}
