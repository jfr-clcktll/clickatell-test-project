package account;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AccountTest {

    @Test
    public void verifyBalanceAfterDepositAndWithdrawalCheckingAC() throws WithdrawException {

        Account account = new Account(AccountType.CHECKING);

        account.deposit(100);
        account.withdraw(50);

        assertEquals(50, account.getBalance());


    }

    @Test
    public void verifyBalanceAfterDepositAndWithdrawalSavingAC() throws  AddInterestException {

        Account account = new Account(AccountType.SAVINGS);

        account.deposit(50);
        account.addInterest();

        assertEquals(60.60, account.getBalance());


    }

    @Test
    public void verifyAddInterestException() throws  AddInterestException {

        Account account = new Account(AccountType.CHECKING);

        account.deposit(50);

        // Cannot add interest on CHECKING ACCOUNT
        assertThrows(AddInterestException.class, () -> account.addInterest());


    }

    @Test
    public void verifyWithdrawException() throws WithdrawException {

        Account account = new Account(AccountType.SAVINGS);

        account.deposit(100);

        // Cannot overdraw a SAVINGS ACCOUNT
        assertThrows(WithdrawException.class, () -> account.withdraw(120));


    }


    @DataProvider(name = "Savings AC Deposit and Interest Balance Check")
    public Object[][] createDataForParameterizedTestForSavingsAC(){

        return new Object[][] {
                {100, 111.1},
                {2000, 2050.2},
                {6000, 6190.3}
        };

    }

    @Test(dataProvider = "Savings AC Deposit and Interest Balance Check")
    public void verifyParameterizedTestForSavingsAC(double depositAmount, double balance) throws  AddInterestException {

        Account account = new Account(AccountType.SAVINGS);

        account.deposit(depositAmount);
        account.addInterest();

        assertEquals(account.getBalance(), balance);
    }
}
