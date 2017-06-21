package banking;

import org.testng.annotations.*;

public class SimpleTest {
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
        System.out.println("UserId generation");
    }

    @BeforeMethod
    public void  Cookies()
    {
        System.out.println(" Testing 4 - Delete the Cookies");
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println(" Testing 5 - Fast test\n");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println(" Testing 6 - Slow test");
    }

    @Test (groups = {"Priority1"})
    public void FlightBooking()
    {
        System.out.println("Testing 7 - Flight booking");
    }

    @Test (groups = {"Priority2"})
    public void FlightCancel()
    {
        System.out.println(" Testing 8 - Flight booking cancelled");
    }
    @AfterTest
    public void CookiesClose()
    {
        System.out.println(" Testing 9 - Delete the Cookies before starting the tests");
    }

}
