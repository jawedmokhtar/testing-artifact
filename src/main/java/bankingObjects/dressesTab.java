package bankingObjects;


        import org.openqa.selenium.By;
        import org.openqa.selenium.logging.Logs;
        import org.openqa.selenium.WebDriver;
        import sun.reflect.annotation.ExceptionProxy;

        import java.io.IOException;

/**
 * Created by jawedmokhtar on 14/06/2017.
 */
public class dressesTab {
    WebDriver driver;
    Logs logs;
    By dressesTab = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a[title='Dresses']");
    By selectDress = By.cssSelector(".last-mobile-line > div > div.left-block > div > a.product_img_link > img:nth-child(1)");
    By addToCart = By.cssSelector("#add_to_cart > button > span");
    By checkoutBtn = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
    By proceedToCheckout = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span");

    public dressesTab(WebDriver driver){
        this.driver = driver;
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
        Thread.sleep(4000);
        System.out.println("DONE");
        driver.findElement(checkoutBtn).click();
    }

    public void clickProceedCheckoutButton()
    {

        driver.findElement(proceedToCheckout).click();
    }

}
