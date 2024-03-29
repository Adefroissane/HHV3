import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LastZonePage extends HentaiHeroesPage {

    public LastZonePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[16]")
    private WebElement affronterRoko;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterEdwarda;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterDonatien;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[6]")
    private WebElement affronterDarkLord;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[6]")
    private WebElement affronterNinja;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[10]")
    private WebElement affronterFinalmecia;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[9]")
    private WebElement affrontergrunt;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[15]")
    private WebElement affronterCarole;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterBremen;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[16]")
    private WebElement affronterJackson;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[8]")
    private WebElement affronterSilvanus;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[21]")
    private WebElement affronterPandora;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[18]")
    private WebElement affronterNike;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[19]")
    private WebElement affronterSake;

    @FindBy(xpath = "//*[@id=\"worldmap\"]/a[13]")
    private WebElement affronterSquishy;

    public CombatPage openCombatPage(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(affronterFinalmecia));
        affronterFinalmecia.click();
        return new CombatPage(driver);
    }

}
