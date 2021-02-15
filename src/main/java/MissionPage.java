import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MissionPage extends HentaiHeroesPage{

    public MissionPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "claim")
    private WebElement missionTermine;

    @FindBy(className = "blue_button_L")
    private WebElement mission;

    @FindBy(xpath = "//*[@id=\"activities\"]/div/div[2]/h4[1]")
    private WebElement repereMission;

    @FindBy(xpath = "//*[@id=\"rewards_popup\"]/div/button")
    private WebElement validerRecompense;

    @FindBy(xpath = "//*[@id=\"missions\"]/div/div[2]/button")
    private WebElement recuperer;

    @FindBy(xpath ="//*[@id=\"missions\"]/div/div[1]/a")
    private WebElement retour;

    @FindBy(className ="orange_button_L")
    private WebElement missionEnCour;

    public void collectMission(WebDriver driver) {
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        List<WebElement> myElements = driver.findElements(By.className("purple_button_L"));
        System.out.println("Nombre de mission à recolter" + myElements.size());
        if(myElements.size() !=0) {
            for (WebElement e : myElements) {
                if (e.isDisplayed()) {
                    e.click();

                    try {
                        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
                        webDriverWait2.until(ExpectedConditions.visibilityOf(validerRecompense));
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException ab) {
                            ab.printStackTrace();
                        }
                        validerRecompense.click();
                    } catch (NoSuchElementException nf) {}
                }
            }
        }
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ab){
            ab.printStackTrace();
        }
        try{
            if (recuperer.isDisplayed()) {
                recuperer.click();
            }
        }
        catch(NoSuchElementException recuperer){}
    }

    public void lanceMission(WebDriver driver){
        System.out.println("Passe");
        try{
            Thread.sleep(750);
        }
        catch(InterruptedException ne){
            ne.printStackTrace();
        }
        List<WebElement> myElements2 = driver.findElements(By.className("blue_button_L"));
        System.out.println("Nombre de mission restante" + myElements2.size());
        if (myElements2.size() != 0) {
            for (WebElement e : myElements2) {
                try{
                    Thread.sleep(750);
                }
                catch(InterruptedException ae){
                    ae.printStackTrace();
                }
                if (e.isDisplayed()) {
                    e.click();
                }
            }
        }
    }

    public boolean plusDeMission(WebDriver driver) {

        try {
            driver.findElement(By.xpath("//*[@id=\"missions\"]/div/div[1]/a"));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    public boolean missionEnCour(WebDriver driver) {

        try {
            driver.findElement(By.className("orange_button_L"));
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

}
