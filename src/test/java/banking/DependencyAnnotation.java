package banking;

import org.testng.annotations.Test;

/**
 * Created by jawedmokhtar on 24/05/2017.
 */
public class DependencyAnnotation {

    @Test
    public void OpeningBrowser()
    {
        System.out.println("Testing - 1 Executing opening browser");
    }

    @Test (dependsOnMethods = {"OpeningBrowser"} )
    public void FlightBooking()
    {
        System.out.println("Executing Test 2");
    }

}
