package nl.novi.javaprogrammeren;

import nl.novi.javaprogrammeren.domain.Account;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp(){
        //Arrange
        account = new Account("Nick", 12, 400);
    }

    @Test
    void depositingNegativeNumberShouldReturnFalse() {

        //Arrange
        //Account account = new Account("Nick", 12, 400);

        //Act
        boolean isDeposited = account.deposit(-12);

        //Assert
        assertFalse(isDeposited);
    }

    @Test
    void withdrawNegativeAmountShouldReturnFalse(){
        //Arrange
        //Account account = new Account("Nick", 12, 400);

        //Act
        boolean withdrawSucces=account.withdraw(-12,0);

        //Assert
        assertFalse(withdrawSucces);
    }

    @Test
    void withdrawNegativeFeeShouldReturnFalse(){
        //Arrange
        //Account account = new Account("Nick", 12, 400);

        //Act
        boolean withdrawSucces=account.withdraw(12,-0.10f);

        //Assert
        assertFalse(withdrawSucces);
    }

    @Test
    void withdrawAmountExceedsBalanceShouldReturnFalse(){
        //Arrange
        //Account account = new Account("Nick", 12, 400);

        //Act
        boolean withdrawSucces=account.withdraw(500,0.10f);

        //Assert
        assertFalse(withdrawSucces);
    }

    @Test
    void addInterestTest(){
        //Arrange
        Account account = new Account("Nick", 12, 4000000);

        //Act
        float balanceBeforeInterest=account.getBalance();
        account.addInterest();

        //Assert 400 + (400 * 0.045)= 402.916
        //assertEquals(account.getBalance(),balanceBeforeInterest + (0.045f*balanceBeforeInterest));
        assertEquals(account.getBalance(),4180000.00);

    }

}

