package bankingObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;
    By email = By.name("email");
    By password = By.id("passwd");
    By signIn = By.className("login");
    By signInBtn = By.id("SubmitLogin");

    public loginPage (WebDriver driver){
        this.driver = driver;
    }

    public void setPassword(String passwords) {
        driver.findElement(password).sendKeys(passwords);

    }

    public void setUserId (String userid) {
        driver.findElement(email).sendKeys(userid);
    }

    public void clickSignIn () {
        driver.findElement(signIn).click();
    }

    public void clickSignInButton () {
        driver.findElement(signInBtn).click();
    }

}


