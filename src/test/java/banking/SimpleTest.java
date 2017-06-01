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
        System.out.println("Delete the Cookies");
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test\n");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
    }

    @Test (groups = {"Priority1"})
    public void FlightBooking()
    {
        System.out.println("Flight booking");
    }

    @Test (groups = {"Priority2"})
    public void FlightCancel()
    {
        System.out.println("Flight booking cancelled");
    }
    @AfterTest
    public void CookiesClose()
    {
        System.out.println("Delete the Cookies before starting the tests");
    }

}
