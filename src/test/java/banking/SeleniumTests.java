package banking;

import bankingObjects.loginPage;
import bankingObjects.dressesTab;
import bankingObjects.TestBase;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jawedmokhtar on 31/05/2017.
 */
public class SeleniumTests extends TestBase {

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

    @Test
    public void selectDress() throws Exception
    {
        setup();
        dressesTab dtab = new dressesTab(TestBase.driver);
        dtab.goToDress();
        closeBrowser();

    }

    @Test
    public void checkoutDress() throws Exception
    {
        setup();
        dressesTab dt = new dressesTab(TestBase.driver);
        dt.goToDress();
        dt.clickAddToCart();
        dt.clickCheckoutButton();
        dt.clickProceedCheckoutButton();
        closeBrowser();
    }

}
