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

    @FindBy(xpath = "//*[@id=\"harem_left\"]/div[2]/div[1]/div/div[1]/img")
    private WebElement repere;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/header/a[1]/img")
    private WebElement retour;

    @FindBy(xpath = "/html/body/div[2]/section/div[1]/div/div/div/div[2]/div[2]/div[824]/div/div[1]")
    private WebElement derniereFille;

    public int liste1(WebDriver driver){
        int n;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> myElements = driver.findElements(By.className("right"));
        n = myElements.size();
        System.out.println("n =" + myElements.size());
        WebElement e= myElements.get(n - 1);
        js.executeScript("arguments[0].scrollIntoView(true);", e);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        System.out.println(e.getText());
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(e));
        try {
            Thread.sleep(400);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        return n;
    }

    public int liste2(WebDriver driver){
        int m;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> myElements = driver.findElements(By.className("right"));
        m = myElements.size();
        System.out.println("m =" + myElements.size());
        WebElement e= myElements.get(m - 1);
        js.executeScript("arguments[0].scrollIntoView(true);", e);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        System.out.println(e.getText());
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(e));
        try {
            Thread.sleep(400);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        return m;
    }

    public void defilement(WebDriver driver){
        int n = liste1(driver);
        int m = liste2(driver);
        if(n != m){
            defilement(driver);
        }

    }

    public void recolt(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(repere));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        defilement(driver);
        List<WebElement> myElements2 = driver.findElements(By.className("collect_money"));
        System.out.println("Taille du harem =" + myElements2.size());
                try {
            for (WebElement e2 : myElements2) {
                js.executeScript("arguments[0].scrollIntoView();", e2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ab) {
                    ab.printStackTrace();
                }
                if (e2.isDisplayed()) {
                    e2.click();
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
