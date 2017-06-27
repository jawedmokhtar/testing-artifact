package bankingObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        System.out.println(p.getProperty("browser"));

        if(p.getProperty("browser").contains("firefox"))
        {
            System.setProperty("webdriver.firefox.marionette", "/usr/local/Cellar/geckodriver/0.17.0/bin/geckodriver");
            driver=new FirefoxDriver();
        }
        else if (p.getProperty("browser").contains("chrome"))
        {
//            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//            ChromeOptions opts = new ChromeOptions();
//            opts.addArguments("headless", "window-size=1200x600");
//            driver=new ChromeDriver(opts);

//            System.setProperty("phantomjs.binary.path", "/testingArtifact/IntegrationTests/node_modules/phantomjs-prebuilt/bin/phantomjs");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability("takesScreenShot", false);
          caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    //"/Users/jawedmokhtar/.jenkins/jobs/docker/workspace/binary/phantomjs_binary"
                  "/IntegrationTests/node_modules/phantomjs-prebuilt/lib/phantom/bin/phantomjs"
            );

            driver= new PhantomJSDriver(caps);



        }
        else
        {
            //Internetexplorer
        }
        driver.get(p.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void closeBrowser () throws IOException
    {
        driver.close();
    }
}
