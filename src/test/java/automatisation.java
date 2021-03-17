import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automatisation {

    WebDriver driver;

    @Before
    public void init() {
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.get("https://www.hentaiheroes.com/");
    }

    @After
    public void teardown() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void automatisationHarem() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean recoltNecessaire = homePage.recoltHarem(driver);
        if (recoltNecessaire == true) {
            HaremPage haremPage = homePage.ouvrirLeHarem(driver);
            haremPage.recolt(driver);
        }
    }

    private void Combat(WebDriver driver)
    {
        LastZonePage lastZonePage = new LastZonePage(driver);
        CombatPage combatPage = lastZonePage.openCombatPage(driver);
        LastZonePage lastZonePage2 = combatPage.combattreBoss(driver);
        boolean combatNonNull = lastZonePage2.getHeader().combatNecessaire(driver);
        if (combatNonNull == true)
        {
            Combat(driver);
        }
    }

    @Test
    public void LieuxDePouvoirRecolt()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        LieuxDePouvoirPage lieuxDePouvoirPage = homePage.openLieuxDePouvoirPage(driver);
        lieuxDePouvoirPage.RecoltMission(driver);
    }

    @Test
    public void LieuxDePouvoirLancement()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        LieuxDePouvoirPage lieuxDePouvoirPage = homePage.openLieuxDePouvoirPage(driver);
        lieuxDePouvoirPage.LancerMission(driver);
    }

    @Test
    public void Achat()
    {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        MarchePage marchePage = homePage.openMarche(driver);
        marchePage.LancerAchatLivre(driver);
        marchePage.LancerAchatCadeau(driver);
    }
}


 