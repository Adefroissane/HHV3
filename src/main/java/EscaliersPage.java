import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EscaliersPage extends HentaiHeroesPage {

    public EscaliersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"pantheon_tab_worship_energy\"]/div/div[2]/div[2]/div/span[1]")
    private WebElement nbrCombat;

    @FindBy(xpath = "//*[@id=\"pantheon_tab_container\"]/div[3]/a")
    private WebElement entrer;

    public boolean CombatPossible(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(nbrCombat));
        String plif = nbrCombat.getText();
        int nombreCombat = Integer.parseInt(plif);
        System.out.println("nbre de combat =" + nombreCombat);
        if (nombreCombat <= 1) {
            return false;
        } else {
            return true;
        }
    }

    public CombatPage openCombatPage(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(entrer));
        entrer.click();
        return new CombatPage(driver);
    }
}
