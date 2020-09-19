import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LieuxDePouvoirPage extends HentaiHeroesPage {

    public LieuxDePouvoirPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"pop\"]/div/div[3]/button")
    private WebElement Assigner;

    @FindBy(xpath = "//*[@id=\"pop\"]/div/div[2]/button[4]")
    private WebElement Recuperer;

    @FindBy(xpath = "//*[@id=\"pop\"]/div/div[2]/button[3]")
    private WebElement Commencer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement Ok;

    public void LancerMission(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(Assigner));
        if(Recuperer.isDisplayed()) {
            Recuperer.click();
            WebDriverWait webDriverWait4= new WebDriverWait(driver, 5);
            webDriverWait4.until(ExpectedConditions.visibilityOf(Ok));
            Ok.click();
            WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
            webDriverWait2.until(ExpectedConditions.visibilityOf(Commencer));
            Assigner.click();

            WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
            webDriverWait3.until(ExpectedConditions.visibilityOf(Commencer));
            Commencer.click();
        }
    }
}