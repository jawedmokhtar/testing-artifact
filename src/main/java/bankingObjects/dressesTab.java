package bankingObjects;


        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.logging.Logs;
        import org.openqa.selenium.WebDriver;
        import sun.reflect.annotation.ExceptionProxy;

        import java.io.IOException;

/**
 * Created by jawedmokhtar on 14/06/2017.
 */
public class dressesTab {
    WebDriver driver;
    By dressesTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    By selectDress = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]");
    By addToCart = By.cssSelector("#add_to_cart > button > span");
    By checkoutBtn = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    By proceedToCheckout = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span");

    String dressesPage = "http://automationpractice.com/index.php?id_product=3&controller=product";


    public dressesTab(WebDriver driver){
        this.driver = driver;
    }


    public void goToDress() {
        driver.get(dressesPage);
    }

    public void clickDressTab()
    {
        driver.findElement(dressesTab).click();
    }

    public void clickSetSelectDress()
    {
        driver.findElement(selectDress).click();
    }

    public void clickAddToCart()
    {
        driver.findElement(addToCart).click();

    }

    public void clickCheckoutButton() throws Exception
    {
        Thread.sleep(4000); // this shit

        System.out.println("DONE");
        driver.findElement(checkoutBtn).click();
    }

    public void clickProceedCheckoutButton()
    {

        driver.findElement(proceedToCheckout).click();
    }

}
