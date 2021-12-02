import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClubPage extends HentaiHeroesPage {

    public ClubPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"club_champions\"]/span")
    private WebElement ChampionClub;

    @FindBy(css = "#club_whole > div > div > div > div.club_details > div.club_champions_details_container > div:nth-child(3) > div.club_champions_buttons_container > div.team_rest_container > div > div.backbar")
    private WebElement tempRestantBoss;

    @FindBy(css = "//*[@id=\"club_whole\"]/div/div/div/div[1]/div[3]/div[3]/div[3]/div[1]/div/div[2]/div")
    private WebElement tempRestantBoss2;

    @FindBy(xpath = "//*[@id=\"club_champion_challenge_btn\"]")
    private WebElement defier;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[5]/div/div[2]/div[4]/button")
    private WebElement performance;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[2]/button")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/div[3]/button[1]")
    private WebElement ok;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/header/div[5]/div[2]")
    private WebElement repere;

    @FindBy(xpath = "//*[@id=\"club_champions\"]/span")
    private WebElement coupe;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[5]/div/div[2]/button")
    private WebElement pasDeRepos;

    @FindBy(xpath = "//*[@id=\"confirm_HC\"]/button")
    private WebElement okOrange;

    public void pageBoss(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(ChampionClub));
        ChampionClub.click();
    }

    public void vaincreBossDeClub(WebDriver driver) {

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(defier));
        defier.click();

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(performance));
        performance.click();

        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 30);
        webDriverWait4.until(ExpectedConditions.visibilityOf(passer));
        passer.click();

        WebDriverWait webDriverWait5 = new WebDriverWait(driver, 5);
        webDriverWait5.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
    }

       public boolean bossDispo(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(ChampionClub));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            driver.findElement(By.xpath("//*[@id=\"club_whole\"]/div/div/div/div[1]/div[3]/div[3]/div[3]/div[1]/div/div[2]/div"));
        } catch (NoSuchElementException e)
        {
            return true;
        }
        return false;
    }
    public void combattreChampion7(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(coupe));
        coupe.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(defier));
        defier.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(performance));
        performance.click();
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 30);
        webDriverWait4.until(ExpectedConditions.visibilityOf(passer));
        passer.click();
        WebDriverWait webDriverWait5 = new WebDriverWait(driver, 10);
        webDriverWait5.until(ExpectedConditions.visibilityOf(ok));
        ok.click();

        while (repere.isEnabled()){
            WebDriverWait webDriverWait6 = new WebDriverWait(driver, 5);
            webDriverWait6.until(ExpectedConditions.visibilityOf(pasDeRepos));
            pasDeRepos.click();
            WebDriverWait webDriverWait7 = new WebDriverWait(driver, 5);
            webDriverWait7.until(ExpectedConditions.visibilityOf(okOrange));
            okOrange.click();
            WebDriverWait webDriverWait8 = new WebDriverWait(driver, 5);
            webDriverWait8.until(ExpectedConditions.visibilityOf(performance));
            performance.click();
            WebDriverWait webDriverWait9 = new WebDriverWait(driver, 30);
            webDriverWait9.until(ExpectedConditions.visibilityOf(passer));
            passer.click();
            WebDriverWait webDriverWait10 = new WebDriverWait(driver, 10);
            webDriverWait10.until(ExpectedConditions.visibilityOf(ok));
            ok.click();
        }
    }
}