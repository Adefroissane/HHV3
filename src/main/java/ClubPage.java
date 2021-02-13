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

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok;

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
}