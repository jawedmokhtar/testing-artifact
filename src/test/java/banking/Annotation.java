package banking;

import org.testng.annotations.*;

/**
 * Created by jawedmokhtar on 24/05/2017.
 */
public class Annotation {

    @BeforeSuite
    public void installSoftare()
    {
        System.out.println("I am the first to run");
    }

    @BeforeMethod
    public void UserIDGeneration(){
        System.out.println("This block executes before each Test");
    }

    @Test (dataProvider = "getData")
    public void UserId(String username, String password, String id)
    {
        System.out.println("data provider test1");
        System.out.println(username);
        System.out.println(password);
        System.out.println(id);
    }

    @BeforeTest
    public void Cookies()
    {
        System.out.println("This block executes Before all test cases");
    }

    @AfterSuite
    public void deinstallSoftware()
    {
        System.out.println("I am last, de install software");
    }

    @Test(groups = { "fast" })
    public void aFastTest() {
        System.out.println("Fast test\n");
    }

    @Test(groups = { "slow" })
    public void aSlowTest() {
        System.out.println("Slow test");
        System.out.println("Last test from Annotation");
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[3][3];
        data[0][0] = "abcd";
        data[0][1] = "xyz";
        data[0][2] = "ads";

        data[1][0] = "ghd";
        data[1][1] = "ghd";
        data[1][2] = "lkj";

        data[2][0] = "qas";
        data[2][1] = "vbd";
        data[2][2] = "qaw";

        return data;
    }

}
