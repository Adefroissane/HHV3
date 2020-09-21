import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarchePage extends HentaiHeroesPage{

    public MarchePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"type_item\"]/div[3]")
    private WebElement livres;

    @FindBy(xpath = "//*[@id=\"type_item\"]/div[4]")
    private WebElement  cadeaux;

    @FindBy(xpath = "//*[@id=\"shop\"]/button[1]")
    private WebElement  acheter;

    @FindBy(xpath = "//*[@id=\"shop\"]/div[6]/div[1]/img")
    private WebElement  PremierCadeau;

    @FindBy(xpath = "//*[@id=\"shop\"]/div[5]/div[1]/img")
    private WebElement  PremierLivre;

    @FindBy(xpath = "//*[@id=\"shop\"]/div[6]/div[1]")
    private WebElement  PremierCadeauCase;

    @FindBy(xpath = "//*[@id=\"shop\"]/div[5]/div[1]")
    private WebElement  PremierLivreCase;


    public void LancerAchatLivre(WebDriver driver) {
        livres.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(PremierLivreCase));

        try {

            PremierLivre.click();
            WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
            webDriverWait2.until(ExpectedConditions.visibilityOf(acheter));
            acheter.click();

        }
        catch (NoSuchElementException e) {}
    }

    public void LancerAchatCadeau(WebDriver driver) {
        cadeaux.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(PremierCadeauCase));
        try {
            PremierCadeau.click();
            WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
            webDriverWait2.until(ExpectedConditions.visibilityOf(acheter));
            acheter.click();
        }
        catch (NoSuchElementException e) {}

    }

}
