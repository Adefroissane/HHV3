import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HaremPage extends HentaiHeroesPage{

    public HaremPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#harem_left > div.girls_list > div:nth-child(7) > div > div.left > img")
    private WebElement repere;

    @FindBy(xpath = "//*[@id=\"harem_whole\"]/div/div/div/a/img")
    private WebElement retour;

    public void recolt(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(repere));
        List<WebElement> myElements = driver.findElements(By.className("collect_money"));
        System.out.println("Taille du harem =" + myElements.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            for (WebElement e : myElements) {
                js.executeScript("arguments[0].scrollIntoView();", e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ab) {
                    ab.printStackTrace();
                }
                if (e.isDisplayed()) {
                    e.click();
                }
            }
        }
        catch(NoSuchElementException ne)
        {

        }
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(retour));
        retour.click();
    }

}
