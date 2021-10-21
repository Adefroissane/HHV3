import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CombatPage extends HentaiHeroesPage{

    public CombatPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"pre-battle\"]/div[2]/div[2]/a")
    private WebElement affronterx1;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/div[3]/button[3]")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/div[3]/button[1]")
    private WebElement oki;

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/div[3]/button[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"new-battle-skip-btn\"]")
    private WebElement passer2;

    @FindBy(xpath = "//*[@id=\"pre-battle\"]/div[2]/div/a")
    private WebElement perform;


    public DuelPage combattreDuel(WebDriver driver)
    {
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 30);
        webDriverWait2.until(ExpectedConditions.visibilityOf(passer2));
        passer2.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(oki));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        oki.click();
        return new DuelPage(driver);
    }

    public LastZonePage combattreBoss(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(affronterx1));
        affronterx1.click();
        /*WebDriverWait webDriverWait2 = new WebDriverWait(driver, 30);
        webDriverWait2.until(ExpectedConditions.visibilityOf(passer));
        passer.click();*/
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(oki));

        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        oki.click();
        return new LastZonePage(driver);

    }

    public EscaliersPage combattreEscalier(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(perform));
        perform.click();
        /*WebDriverWait webDriverWait2 = new WebDriverWait(driver, 30);
        webDriverWait2.until(ExpectedConditions.visibilityOf(passer2));
        passer2.click();*/
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(oki));
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        oki.click();
        return new EscaliersPage(driver);
    }
}
