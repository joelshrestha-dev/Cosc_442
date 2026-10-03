import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//jshrest1@......

public class BankAccountTest {

    BankAccount myAccount;
    BankAccount otherAccount;

    @BeforeEach 
    void setUp(){
         myAccount = new BankAccount("Gavin", 100.00);
         otherAccount = new BankAccount("Bob", 20.00);
    }

    @AfterEach 
    void tearDown(){
        myAccount=null;
        otherAccount=null;
    }
    
    @Test
    void testCloseAccount() {
        
        myAccount.withdraw(100.00);
        myAccount.closeAccount();
        assertFalse(myAccount.isActive());

    }

    @Test
    void testDeposit() {

        //arrange (foreach and aftereach)
        

        //act
        myAccount.deposit(25.00);

        //assert
        assertEquals(125.00, myAccount.getBalance(), 0.001);

    }

    @Test
    void testGetBalance() {

        assertEquals(100.00, myAccount.getBalance(), 0.001);

    }

    @Test
    void testGetOwner() {

        assertEquals("Gavin", myAccount.getOwner());

    }

    @Test
    void testIsActive() {

        assertTrue(myAccount.isActive());

    }

    @Test
    void testTransferTo() {

        myAccount.transferTo(otherAccount, 10.00);

        assertEquals(30.00, otherAccount.getBalance(), 0.001);

    }

    @Test
    void testWithdraw() {

        myAccount.withdraw(10.00);

        assertEquals(90, myAccount.getBalance(), 0.001);

    }

    @ParameterizedTest 
    @ValueSource (doubles = {0.0, -100.00, -7.00})
    void testWithdrawIllegal(double amount){

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(amount));

    }
}
