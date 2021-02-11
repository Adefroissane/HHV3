import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PachinkoPage extends HentaiHeroesPage{

    public PachinkoPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"playzone-replace-info\"]/div[3]/button[1]")
    private WebElement reperePatchinko;

    @FindBy(css = "#pachinko_rewards > button")
    private WebElement genial;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement ok;

    public void collectPachinkoGratuit(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(reperePatchinko));
        reperePatchinko.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(genial));
        genial.click();
        //getHeader().openHomePage(driver);
    }

    public void collectPachinkoGratuit2(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(reperePatchinko));
        reperePatchinko.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(ok));
        ok.click();
        //getHeader().openHomePage(driver);
    }

}
