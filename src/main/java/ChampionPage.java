import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChampionPage extends HentaiHeroesPage {

    public ChampionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[6]/div[2]/span")
    private WebElement foyerDeVizor;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[7]/div[2]/span")
    private WebElement portSalut;

    @FindBy(css = "#contains_all > section > a:nth-child(6) > div.champion-lair-name.map-label-link > div")
    private WebElement tempRestantFoyer;

    @FindBy(css = "#contains_all > section > a:nth-child(7) > div.champion-lair-name.map-label-link > div")
    private WebElement tempRestantPort;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[5]/div/div[2]/div[3]/button[1]/span[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[2]/button")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok;


    public boolean championDispo(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(portSalut));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            driver.findElement(By.cssSelector("#contains_all > section > a:nth-child(7) > div.champion-lair-name.map-label-link > div"));
        } catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }

    public void combattreChampion(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(portSalut));
        portSalut.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(affronter));
        affronter.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 10);
        webDriverWait4.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
    }
}