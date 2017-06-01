package banking;

import bankingObjects.loginPage;
import bankingObjects.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Created by jawedmokhtar on 31/05/2017.
 */
public class LoginTest extends TestBase {

    @Test
    public void logingApp () throws IOException
    {
        setup();
        loginPage lp = new loginPage(TestBase.driver);
        lp.clickSignIn();
        lp.setUserId("jmores047@gmail.com");
        lp.setPassword("manchester");
        lp.clickSignInButton();
        closeBrowser();
    }

}
