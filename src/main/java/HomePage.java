import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;


public class HomePage  extends HentaiHeroesPage{

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[1]/div/span")
    private WebElement harem;

    @FindBy(className = "orange_button_L")
    private WebElement toutCollecter;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[2]/div/span")
    private WebElement activite;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/div/a/div/span")
    private WebElement arene;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/div/a/div/span")
    private WebElement aventure;

    @FindBy(xpath = "//*[@id=\"canvas_fight_energy\"]/div/div[2]/div[2]/div/span[1]")
    private WebElement nbreCombat;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[11]/div[2]")
    private WebElement pachinkoGratuit;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[11]/div/span/span")
    private WebElement pachinkoGratuit2;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[5]/div/span")
    private WebElement pachinko;

    @FindBy(css = "#home_missions_bar1 > div > div.text")
    private WebElement missionNonDisponible;

    @FindBy(css = "#home_missions_bar2 > div > div.backbar.borderbar > div")
    private WebElement missionNonDisponible2;

    @FindBy(xpath = "//*[@id=\"activities\"]/div/div[2]/h4[2]")
    private WebElement mission;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[3]/div/span")
    private WebElement tourDeLaGloire;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[9]/div/span/span")
    private WebElement aFaire;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[6]/div/span")
    private WebElement cheminDuDieu;

    @FindBy(xpath = "//*[@id=\"activities\"]/div/div[2]/h4[4]")
    private WebElement lieuxDePouvoir;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[4]/div/span")
    private WebElement marche;

    @FindBy(xpath = "//*[@id=\"seasons_tab_container\"]/div[3]/div[1]/a/div")
    private WebElement trouverAdver;

    @FindBy(xpath = "//*[@id=\"homepage\"]/div[1]/div[1]/a[7]/div/span")
    private WebElement club;

    @FindBy(xpath = "//*[@id=\"homepage\"]/a[9]/div/span/span")
    private WebElement repereMission;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/nav/div[1]/span")
    private WebElement menu;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/nav/div[2]/div/a[11]/div/span")
    private WebElement activite2;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[1]/div[2]/a[1]/img")
    private WebElement champions;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/section/div[1]/div[2]/a[2]/img")
    private WebElement escalier;

    @FindBy(xpath = "//*[@id=\"type_item\"]/div[4]")
    private WebElement cadeau;

    @FindBy(xpath = "//*[@id=\"girls_list\"]/div[2]/span[1]")
    private WebElement arriere;

    @FindBy(css = "#girls_list > div.g1 > div > div.girl-ico.ui-droppable > img")
    private WebElement derniereFille;

    @FindBy(css = "#girls_list > div.g1 > div > div:nth-child(1) > img")
    private WebElement premiereFille;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/nav/div[2]/div/a[5]/div/span")
    private WebElement club2;

    @FindBy(xpath = "//*[@id=\"contains_all\"]/nav/div[2]/div/a[13]/div")
    private WebElement saison;

    @FindBy(xpath = "//*[@id=\"seasons_btn\"]")
    private WebElement saison2;

    public HaremPage ouvrirLeHarem(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        harem.click();
        return new HaremPage(driver);
    }

    public HaremPage ouvrirHaremParLeMArche(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(marche));
        marche.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(cadeau));
        cadeau.click();
        /*WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(arriere));
        arriere.click();*/
        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 5);
        webDriverWait4.until(ExpectedConditions.visibilityOf(premiereFille));
        premiereFille.click();

        return new HaremPage(driver);
    }

    public MarchePage openMarche(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(marche));
        marche.click();
        return new MarchePage(driver);
    }

    public boolean recoltHarem(WebDriver driver){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        if(toutCollecter.isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public AventurePage openAventure(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(aventure));
        aventure.click();
        return new AventurePage(driver);
    }

    public boolean pachinkoGratuitPresent(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
            try {
                driver.findElement(By.xpath("//*[@id=\"homepage\"]/a[11]/div[2]"));
            } catch (NoSuchElementException e)
            {
                return false;
            }
            return true;
    }

    public boolean pachinkoGratuit2Present(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        try {
            driver.findElement(By.xpath("//*[@id=\"homepage\"]/a[11]/div/span/span"));
        } catch (NoSuchElementException e)
        {
            return false;
        }
        return true;
    }

    public PachinkoPage openPachinkoPage (WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(pachinko));
        pachinko.click();
        return new PachinkoPage(driver);
    }

        public boolean missionDisponible(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        if(missionNonDisponible.isDisplayed()|| missionNonDisponible2.isDisplayed()){
            return false;
        }
        else {
            return true;
        }
    }

    public MissionPage openMissionPage (WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(activite2));
        activite2.click();

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 15);
        webDriverWait3.until(ExpectedConditions.visibilityOf(mission));
        mission.click();
        return new MissionPage(driver);
    }

    public LieuxDePouvoirPage openLieuxDePouvoirPage (WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(activite2));
        activite2.click();

        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 15);
        webDriverWait3.until(ExpectedConditions.visibilityOf(lieuxDePouvoir));
        lieuxDePouvoir.click();
        return new LieuxDePouvoirPage(driver);
    }

    public DuelPage openDuelPage(WebDriver driver) throws AWTException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(saison));
        saison.click();
        WebDriverWait webDriverWait3 = new WebDriverWait(driver, 5);
        webDriverWait3.until(ExpectedConditions.visibilityOf(saison2));
        saison2.click();

        //Classement et saison sont fusionnés dans jenkins et le classement se retrouve devant. Impossibe de cliquer sur "trouver adversaire"

        /*driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(1004, 748));
        System.out.println(driver.manage().window().getSize());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot bot = new Robot();
        bot.mouseMove(307, 325);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
        int n;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> myElements = driver.findElements(By.className("blue_button_L"));
        n = myElements.size();
        System.out.println("n =" + myElements.size());
        WebElement e= myElements.get(0);
        js.executeScript("arguments[0].scrollIntoView(true);", e);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ab) {
            ab.printStackTrace();
        }
        System.out.println(e.getText());
        /*WebDriverWait webDriverWait3 = new WebDriverWait(driver, 30);
        webDriverWait3.until(ExpectedConditions.visibilityOf(e));*/

        WebDriverWait webDriverWait4 = new WebDriverWait(driver, 30);
        webDriverWait4.until(ExpectedConditions.visibilityOf(trouverAdver));
        trouverAdver.click();
        return new DuelPage(driver);
    }

    public TourDeLaGloirePage openTourDeLaGloire(WebDriver driver) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(tourDeLaGloire));
        tourDeLaGloire.click();
        return new TourDeLaGloirePage(driver);
    }

    public ClubPage openClubPage (WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 20);
        webDriverWait2.until(ExpectedConditions.visibilityOf(club2));
        club2.click();
        return new ClubPage(driver);
    }

    public boolean defiAFaire(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(harem));
        try {
            driver.findElement(By.xpath("//*[@id=\"homepage\"]/div[1]/div[1]/a[3]/span"));
        } catch (NoSuchElementException e)
        {
            return false;
        }
        return true;
    }
    public ChampionPage ouvrirZoneDesChampions(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(cheminDuDieu));
        cheminDuDieu.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(champions));
        champions.click();
        return new ChampionPage(driver);
    }

    public EscaliersPage ouvrirEscalierDuPantheon(WebDriver driver){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(cheminDuDieu));
        cheminDuDieu.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 5);
        webDriverWait2.until(ExpectedConditions.visibilityOf(escalier));
        escalier.click();
        return new EscaliersPage(driver);
    }
}
