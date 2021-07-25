import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuelPage extends HentaiHeroesPage {
    public DuelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"arena\"]/div[1]/div[2]/div[3]")
    private WebElement mesPV;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[1]/div[2]")
    private WebElement pVAdversaire1;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[2]/div[2]")
    private WebElement pVAdversaire2;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[3]/div[2]")
    private WebElement pVAdversaire3;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[1]/div[1]/span")
    private WebElement fait1;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[2]/div[1]/span")
    private WebElement fait2;

    @FindBy(xpath = "//*[@id=\"arena\"]/div[3]/div[3]/div[1]/span")
    private WebElement fait3;

    @FindBy(xpath = "//*[@id=\"seasons_tab_container\"]/div[3]/div[1]/a/div")
    private WebElement trouverUnAdversaire;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[1]/div[5]/div[1]/div[1]/span[2]")
    private WebElement monAt;

    @FindBy(xpath = "//*[@id=\"player_defence_stat\"]/span[2]")
    private WebElement maDef;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[2]/div/div[4]/div[1]/div[1]/span[2]")
    private WebElement atAdversaire1;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[2]/div/div[4]/div[1]/div[2]/span[2]")
    private WebElement defAdversaire1;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[4]/div/div[4]/div[1]/div[1]/span[2]")
    private WebElement atAdversaire2;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[4]/div/div[4]/div[1]/div[2]/span[2]")
    private WebElement defAdversaire2;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[6]/div/div[4]/div[1]/div[1]/span[2]")
    private WebElement atAdversaire3;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[6]/div/div[4]/div[1]/div[2]/span[2]")
    private WebElement defAdversaire3;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[3]/button")
    private WebElement affronter1;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[5]/button")
    private WebElement affronter2;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/div[7]/button")
    private WebElement affronter3;

    @FindBy(xpath = "//*[@id=\"season_tab_kiss_energy\"]/div/div[2]/div[2]/div/span[1]")
    private WebElement nbrCombat;

    @FindBy(xpath = "//*[@id=\"season-arena\"]/div[2]/a/img")
    private WebElement retour;

    @FindBy(xpath = "//*[@id=\"seasons_main_container\"]/a/img")
    private WebElement retour2;


    /*public int PvHeros() {

        String plif = mesPV.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        plouf.delete(0, 3);
        String plof = plouf.toString();
        int pvHeros = Integer.parseInt(plof);
        System.out.println("PV = " + pvHeros);
        return pvHeros;
    }*/

    public boolean DuelPossible() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(nbrCombat));
        String plif = nbrCombat.getText();
        StringBuffer plouf = new StringBuffer(plif);
        //plouf.delete(2, 4);
        String plof = plouf.toString();
        String plaf = plof.replaceAll("/", "");
        int nombreCombat = Integer.parseInt(plaf);
        if (nombreCombat <= 8) {
            return false;
        } else {
            return true;
        }

    }
    public int AtHeros() {

        String plif = monAt.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int atHeros = Integer.parseInt(plof);
        System.out.println("At = " + atHeros);
        return atHeros;
    }

    public int DefHeros() {

        String plif = maDef.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int defHeros = Integer.parseInt(plof);
        System.out.println("Def = " + defHeros);
        return defHeros;
    }

    public int AtAdversaire1() {

        String plif = atAdversaire1.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int atAdv1 = Integer.parseInt(plof);
        System.out.println("At = " + atAdv1);
        return atAdv1;
    }

    public int DefAdversaire1() {

        String plif = defAdversaire1.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int defAdv1 = Integer.parseInt(plof);
        System.out.println("Def = " + defAdv1);
        return defAdv1;
    }

    public int AtAdversaire2() {

        String plif = atAdversaire2.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int atAdv2 = Integer.parseInt(plof);
        System.out.println("At = " + atAdv2);
        return atAdv2;
    }

    public int DefAdversaire2() {

        String plif = defAdversaire2.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int defAdv2 = Integer.parseInt(plof);
        System.out.println("Def = " + defAdv2);
        return defAdv2;
    }

    public int AtAdversaire3() {

        String plif = atAdversaire3.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int atAdv3 = Integer.parseInt(plof);
        System.out.println("At = " + atAdv3);
        return atAdv3;
    }

    public int DefAdversaire3() {

        String plif = defAdversaire3.getText();
        String plaf = plif.replaceAll("\\s", "");
        StringBuffer plouf = new StringBuffer(plaf);
        //plouf.delete(0, 6);
        String plof = plouf.toString();
        int defAdv3 = Integer.parseInt(plof);
        System.out.println("Def = " + defAdv3);
        return defAdv3;
    }

    public int PuissanceHeros() {
        int puissanceHeros = AtHeros()+DefHeros();
        return puissanceHeros;
    }

    public int PuissanceAdversaire1() {
        int puissanceAdversaire1 = AtAdversaire1()+DefAdversaire1();
        return puissanceAdversaire1;
    }

    public int PuissanceAdversaire2() {
        int puissanceAdversaire2 = AtAdversaire2()+DefAdversaire2();
        return puissanceAdversaire2;
    }

    public int PuissanceAdversaire3() {
        int puissanceAdversaire3 = AtAdversaire3()+DefAdversaire3();;
        return puissanceAdversaire3;
    }

    /*public boolean combat1Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id=\"arena\"]/div[3]/div[1]/div[1]/span"));
            if (fait1.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }*/

    public boolean combat1PlusFaible ()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(monAt));
        int puissanceHeros = PuissanceHeros();
        int puissanceAdversaire1 = PuissanceAdversaire1();

        if (atAdversaire1.isDisplayed()) {
            if (puissanceHeros >= puissanceAdversaire1)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel1(WebDriver driver)
    {
        affronter1.click();
        return new CombatPage(driver);
    }

    /*public boolean combat2Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id=\"arena\"]/div[3]/div[2]/div[1]/span"));
            if (fait2.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }*/

    public boolean combat2PlusFaible ()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(monAt));
        int puissanceHeros = PuissanceHeros();
        int puissanceAdversaire2 = PuissanceAdversaire2();

        if (atAdversaire2.isDisplayed()) {
            if (puissanceHeros >= puissanceAdversaire2)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel2(WebDriver driver)
    {
        affronter2.click();
        return new CombatPage(driver);
    }

    /*public boolean combat3Fait(WebDriver driver)
    {
        try
        {
            driver.findElement(By.xpath("//*[@id=\"arena\"]/div[3]/div[3]/div[1]/span"));
            if (fait3.isDisplayed())
            {
                return false;
            }
        }
        catch (NoSuchElementException e)
        {
            return true;
        }
        return true;
    }*/

    public boolean combat3PlusFaible ()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(monAt));
        int puissanceHeros = PuissanceHeros();
        int puissanceAdversaire3 = PuissanceAdversaire3();

        if (atAdversaire3.isDisplayed()) {
            if (puissanceHeros >= puissanceAdversaire3)
            {
                return true;
            }
        }
        return false;
    }

    public CombatPage duel3(WebDriver driver) {

        affronter3.click();
        return new CombatPage(driver);

    }

    public void Duel(WebDriver driver)
    {
        while (DuelPossible() == true)
        {
            if (combat1PlusFaible() == true) {
                duel1(driver);
            } else if (combat2PlusFaible() == true) {
                duel2(driver);
            } else if (combat3PlusFaible() == true) {
                duel3(driver);
            } else
            {
                if (PuissanceAdversaire1() <= PuissanceAdversaire2())
                {
                    if (PuissanceAdversaire1() <= PuissanceAdversaire3())
                    {
                        duel1(driver);
                    } else
                    {
                        duel3(driver);
                    }
                } else
                {
                    duel2(driver);
                }
            }
            CombatPage combat = new CombatPage(driver);
            combat.combattreDuel(driver);
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(retour));
        retour.click();
        WebDriverWait webDriverWait2 = new WebDriverWait(driver, 30);
        webDriverWait2.until(ExpectedConditions.visibilityOf(retour2));
        retour2.click();
    }
}
