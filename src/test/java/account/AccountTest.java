package account;

//import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
