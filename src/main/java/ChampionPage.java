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

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[3]/div[2]/span")
    private WebElement maisonFiere;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[5]/div[2]/span")
    private WebElement universiteElite;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[4]/div[2]/span")
    private WebElement jardinAuDela;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/a[2]/div[2]/span")
    private WebElement rondinDuBois;

    @FindBy(css = "#contains_all > section > a:nth-child(6) > div.champion-lair-name.map-label-link > div")
    private WebElement tempRestantFoyer;

    @FindBy(css = "#contains_all > section > a:nth-child(7) > div.champion-lair-name.map-label-link > div")
    private WebElement tempRestantPort;

    @FindBy(css = "#contains_all > section > a:nth-child(3) > div.champion-lair-name.map-label-link > div")
    private WebElement tempMaisonFiere;

    @FindBy(css = "#contains_all > section > a:nth-child(5) > div.champion-lair-name.map-label-link > div")
    private WebElement tempUniversiteElite;

    @FindBy(css = "#contains_all > section > a:nth-child(4) > div.champion-lair-name.map-label-link > div")
    private WebElement tempJardinAuDela;

    @FindBy(css = "#contains_all > section > a:nth-child(2) > div.champion-lair-name.map-label-link > div")
    private WebElement tempRondinDuBois;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[5]/div/div[2]/div[4]/button/div[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[2]/button")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[5]/div/div[2]/div[4]/button/div[2]")
    private WebElement performance;


    public boolean championDispo(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(maisonFiere));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            driver.findElement(By.cssSelector("#contains_all > section > a:nth-child(3) > div.champion-lair-name.map-label-link > div"));
        } catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }

    public void combattreChampion(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(maisonFiere));
        maisonFiere.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(performance));
        performance.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 10);
        webDriverWait4.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
    }
    public boolean championDispo2(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(rondinDuBois));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            driver.findElement(By.cssSelector("#contains_all > section > a:nth-child(2) > div.champion-lair-name.map-label-link > div"));
        } catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }

    public void combattreChampion2(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(rondinDuBois));
        rondinDuBois.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(performance));
        performance.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 10);
        webDriverWait4.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
    }
    public boolean championDispo3(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(jardinAuDela));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            driver.findElement(By.cssSelector("#contains_all > section > a:nth-child(4) > div.champion-lair-name.map-label-link > div"));
        } catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }

    public void combattreChampion3(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(jardinAuDela));
        jardinAuDela.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(performance));
        performance.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 10);
        webDriverWait4.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
    }
}