import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LieuxDePouvoirPage extends HentaiHeroesPage {

    public LieuxDePouvoirPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"pop_info\"]/div[5]/button")
    private WebElement assigner;

    @FindBy(xpath = "//*[@id=\"pop_info\"]/div[4]/button[3]")
    private WebElement commencer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement Ok;

    @FindBy(xpath = "//*[@id=\"pop_info\"]/div[3]/div[1]/div[1]/img")
    private WebElement repere;

    @FindBy(xpath = "//*[@id=\"pop_info\"]/div[5]/a/span")
    private WebElement retour;


    public void RecoltMission(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(repere));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> myElements = driver.findElements(By.className("purple_button_L"));
        System.out.println("Nombre de mission fini =" + myElements.size());
        try {
            for (WebElement e : myElements) {
                //js.executeScript("arguments[0].scrollIntoView();", e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ab) {
                    ab.printStackTrace();
                }
                if (e.isDisplayed()) {
                    e.click();
                    WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
                    webDriverWait3.until(ExpectedConditions.visibilityOf(Ok));
                    Ok.click();

                }
            }
        }
        catch (NoSuchElementException ne)
        {

        }
    }

    public void LancerMission(WebDriver driver)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        List<WebElement> myElements = driver.findElements(By.xpath("//*[@id=\"pop_info\"]/div[3]/div[*]/div[1]/button"));
        System.out.println("nombre de mission =" + myElements.size());
        int i=0;
        for (WebElement e : myElements)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ab) {
                ab.printStackTrace();
            }
            List<WebElement> myElements2 = driver.findElements(By.xpath("//*[@id=\"pop_info\"]/div[3]/div[*]/div[1]/div[2]"));
            if (myElements2.get(i).isDisplayed()) {

            }
            else {
                WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
                webDriverWait.until(ExpectedConditions.visibilityOf(e));
                e.click();
                WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
                webDriverWait2.until(ExpectedConditions.visibilityOf(assigner));
                assigner.click();
                WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
                webDriverWait3.until(ExpectedConditions.visibilityOf(commencer));
                commencer.click();
                WebDriverWait webDriverWait4 = new WebDriverWait(driver, 5);
                webDriverWait4.until(ExpectedConditions.visibilityOf(retour));
                retour.click();
            }
            i=i+1;

        }
    }
}
