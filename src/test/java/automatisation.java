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
    public void automatisationtMission() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        MissionPage missionPage = homePage.openMissionPage(driver);
        boolean plusDeMission = missionPage.plusDeMission(driver);
        if (plusDeMission){
            missionPage.lanceMission(driver);
        }
        missionPage.collectMission(driver);
    }

    @Test
    public void automatisationChampion() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo(driver);
        if (championDispo == true) {
            championPage.combattreChampion(driver);
        }
        boolean championDispo2 = championPage.championDispo2(driver);
        if (championDispo2 == true) {
            championPage.combattreChampion2(driver);
        }

    }
}


 