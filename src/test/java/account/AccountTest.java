package account;

import org.testng.annotations.Test;

public class AccountTest {

    @Test
    public void someTest() {

        Account account = new Account(AccountType.CHECKING);
    }
}
