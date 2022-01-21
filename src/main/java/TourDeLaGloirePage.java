import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class TourDeLaGloirePage extends HentaiHeroesPage {

    public TourDeLaGloirePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"battle_middle\"]/div[2]/button[1]")
    private WebElement affronter;

    @FindBy(xpath = "//*[@id=\"new-battle-skip-btn\"]")
    private WebElement passer;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/div[3]/button[1]")
    private WebElement ok;

    @FindBy(xpath = "//*[@id=\"leagues_middle\"]/div[3]/div[2]/div[2]/div[2]/span[1]")
    private WebElement ptdeDefi;

    @FindBy(xpath = "//*[@id=\"leagues_middle\"]/div[4]/button")
    private WebElement recup;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/div[3]/button[1]")
    private WebElement ok2;

    @FindBy(xpath = "//*[@id=\"leagues_middle\"]/div[3]/div[2]/div[2]/div[3]/span[1]")
    private WebElement ptDeDefi2;

    @FindBy(xpath = "//*[@id=\"tower_of_fame\"]/div/div[1]/div/a/img")
    private WebElement retour;

    public boolean defiNecessaire(WebDriver driver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(ptDeDefi2));
        String plif = ptDeDefi2.getText();
        StringBuffer plouf = new StringBuffer(plif);
        plouf.delete(2, 4);
        String plof = plouf.toString();
        String plaf = plof.replaceAll("/", "");
        int combatRestant = Integer.parseInt(plaf);

        //if (ptDeDefi2.getText().equals("0/15")) {
        if (combatRestant <= 10) {
            return false;
        } else {
            return true;
        }
    }

    public void lancerDefi(WebDriver driver) {
        try {
            recup.click();
            ok2.click();
            ;
        } catch (NoSuchElementException e) {
        }
        boolean defiAFaire = defiNecessaire(driver);
        if (defiAFaire == true) {
            try {
                Thread.sleep(750);
            } catch (InterruptedException ab) {
                ab.printStackTrace();
            }

            List<WebElement> myElements = driver.findElements(By.xpath("//*[@id=\"leagues_middle\"]/div[3]/div[3]/table/tbody/tr[*]/td[4]"));
            System.out.println("nbre ennemis =" + myElements.size());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ArrayList combats = new ArrayList<WebElement>();
            for (WebElement e : myElements) {
                js.executeScript("arguments[0].scrollIntoView();", e);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ab) {
                    ab.printStackTrace();
                }
                System.out.println(e.getText());
                if (e.getText().equals("0/3") || e.getText().equals("1/3") || e.getText().equals("2/3")) {
                    combats.add(e);
                }
            }
            int i = combats.size();

            int b = i - 1; //-1
            WebElement adversaire = (WebElement) combats.get(b);
            js.executeScript("arguments[0].scrollIntoView();", adversaire);
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(adversaire));
            adversaire.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ab) {
                ab.printStackTrace();
            }
            List<WebElement> myElements2 = driver.findElements(By.className("blue_button_L"));
            System.out.println("nbre de bouton =" + myElements2.size());
            myElements2.get(2).click();
            //driver.findElement(By.className("blue_button_L")).click();
            /*WebDriverWait webDriverWait3 = new WebDriverWait(driver, 15);
            webDriverWait3.until(ExpectedConditions.visibilityOf(affronter));
            affronter.click();*/
            WebDriverWait webDriverWait4 = new WebDriverWait(driver, 5);
            webDriverWait4.until(ExpectedConditions.visibilityOf(passer));
            passer.click();
            WebDriverWait webDriverWait5 = new WebDriverWait(driver, 5);
            webDriverWait5.until(ExpectedConditions.visibilityOf(ok));
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ok.click();
            lancerDefi(driver);
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(retour));
        retour.click();
    }
}

