import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AventurePage extends HentaiHeroesPage {

    public AventurePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"map\"]/a[10]")
    private WebElement roko;

    @FindBy(css = "#contains_all > section > div.previous_world > img")
    private WebElement precedent;

    @FindBy(css = "#map > a:nth-child(9)")
    private WebElement edwarda;

    @FindBy(css = "#map > a:nth-child(11)")
    private WebElement donatien;

    @FindBy(css = "#map > a:nth-child(3)")
    private WebElement darkLord;

    @FindBy(xpath = "//*[@id=\"map\"]/a[3]")
    private WebElement ninja;

    @FindBy(xpath = "//*[@id=\"map\"]/a[9]")
    private WebElement finalmecia;

    @FindBy(xpath = "//*[@id=\"map\"]/a[4]")
    private WebElement grunt;

    @FindBy(xpath = "//*[@id=\"map\"]/a[11]")
    private WebElement carole;

    @FindBy(xpath = "//*[@id=\"map\"]/a[8]")
    private WebElement bremen;

    @FindBy(xpath = "//*[@id=\"map\"]/a[12]")
    private WebElement jackson;

    @FindBy(xpath = "//*[@id=\"map\"]/a[7]")
    private WebElement silvanus;

    @FindBy(xpath = "//*[@id=\"map\"]/a[13]")
    private WebElement pandora;

    @FindBy(xpath = "//*[@id=\"map\"]/a[14]")
    private WebElement nike;

    @FindBy(xpath = "//*[@id=\"map\"]/a[15]")
    private WebElement sake;

    @FindBy(xpath = "//*[@id=\"map\"]/a[16]")
    private WebElement squishy;

    public LastZonePage openLastZone(WebDriver driver) {

        /*WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(precedent));
        precedent.click();

        try{
            Thread.sleep(750);
        }
        catch(InterruptedException ae){
            ae.printStackTrace();
        }*/

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(precedent));
        precedent.click();

        try{
            Thread.sleep(750);
        }
        catch(InterruptedException ae){
            ae.printStackTrace();
        }

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(finalmecia));
        finalmecia.click();
        return new LastZonePage(driver);

    }
}
