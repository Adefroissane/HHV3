import com.sun.javafx.scene.EnteredExitedHandler;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.swing.*;
import java.util.List;

public class InitialisationPage extends HentaiHeroesPage
{

    public InitialisationPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#contains_all > header > div > a:nth-child(1) > img")
    private WebElement connexion;

    @FindBy(xpath = "//*[@id=\"auth-email\"]")
    private WebElement mail;

    @FindBy(xpath = "//*[@id=\"auth-password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"submit-authenticate\"]")
    private WebElement seConnecterVert;

    @FindBy(css = "#submit-authenticate")
    private WebElement seConnecterBleu;

    @FindBy(xpath = "//*[@id=\"starter_offer\"]/close")
    private WebElement pub;

    @FindBy(xpath = "//*[@id=\"confirmation_popup\"]/div/div/button[2]")
    private WebElement nonMerci;

    @FindBy(xpath = "//*[@id=\"popup_confirm\"]")
    private WebElement Ok;


    public HomePage openHomePage(WebDriver driver) {

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("hh_game");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(connexion));
        connexion.click();

        driver.switchTo().frame("authentication-iframe");
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(seConnecterBleu));
        mail.sendKeys("adefroissane@hotmail.fr");
        password.sendKeys("gegegege");
        seConnecterVert.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try
        {
            driver.switchTo().frame("hh_game");
            driver.findElement(By.xpath("//*[@id=\"confirmation_popup\"]/div/div/button[2]"));
            if (nonMerci.isDisplayed())
            {
                nonMerci.click();

            }

            return new HomePage(driver);
        }
        catch (NoSuchElementException e)
        {
            return new HomePage(driver);
        }

    }
}
