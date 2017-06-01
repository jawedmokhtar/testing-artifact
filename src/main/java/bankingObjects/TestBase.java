package bankingObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jawedmokhtar on 01/06/2017.
 */

public class TestBase {


    public static WebDriver driver = null;

    public void setup() throws IOException
    {

        Properties p=new Properties();
        FileInputStream fi=new FileInputStream("./src/main/java/bankingObjects/global.properties");
        p.load(fi);
        //System.out.println(p.getProperty("browser"));

        if(p.getProperty("browser").contains("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else if (p.getProperty("browser").contains("chrome"))
        {
            //System.setProperty("webdriver.chrome.driver", value);
            driver=new ChromeDriver();
        }
        else
        {
            //Internetexplorer
        }
        driver.get(p.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeBrowser () throws IOException
    {
        driver.close();
    }
}
