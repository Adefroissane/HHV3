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
    public void automatisationHaremCombat() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean recoltNecessaire = homePage.recoltHarem(driver);
        if (recoltNecessaire == true) {
            HaremPage haremPage = homePage.ouvrirLeHarem(driver);
            haremPage.recolt(driver);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean combatNonNull = homePage.getHeader().combatNecessaire(driver);
        if (combatNonNull == true) {
            AventurePage aventurePage = homePage.openAventure(driver);
            LastZonePage lastZonePage = aventurePage.openLastZone(driver);
            Combat(driver);
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
    public void automatisationMission() {
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
    public void automatisationDuelDefi() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        duelPage.Duel(driver);

        boolean defiAFaire = homePage.defiAFaire(driver);
        if (defiAFaire == true) {
            TourDeLaGloirePage tourDeLaGloirePage = homePage.openTourDeLaGloire(driver);
            tourDeLaGloirePage.lancerDefi(driver);
        }
    }
    @Ignore
    @Test
    public void automatisationChampionClub() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ClubPage clubPage = homePage.openClubPage(driver);
        clubPage.pageBoss(driver);
        boolean bossDispo = clubPage.bossDispo(driver);
        if (bossDispo == true) {
            clubPage.vaincreBossDeClub(driver);
        }
    }
}