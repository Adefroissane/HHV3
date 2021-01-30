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


    @Test
    public void automatisationCombat() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean combatNonNull = homePage.getHeader().combatNecessaire(driver);
        if (combatNonNull == true) {
            AventurePage aventurePage = homePage.openAventure(driver);
            LastZonePage lastZonePage = aventurePage.openLastZone(driver);
            Combat(driver);
        }
    }

    @Test
    public void automatisationPachinko() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        boolean pachinkoGratuitPresent = homePage.pachinkoGratuitPresent(driver);
        if (pachinkoGratuitPresent == true) {
            PachinkoPage pachinkoPage = homePage.openPachinkoPage(driver);
            pachinkoPage.collectPachinkoGratuit(driver);
        }
    }

    @Test
    public void automatisationPachinko2() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        boolean pachinkoGratuit2Present = homePage.pachinkoGratuit2Present(driver);
        if (pachinkoGratuit2Present == true) {
            PachinkoPage pachinkoPage = homePage.openPachinkoPage(driver);
            pachinkoPage.collectPachinkoGratuit2(driver);
        }
    }

    @Test
    public void automatisationRecoltMission() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        MissionPage missionPage = homePage.openMissionPage(driver);
        missionPage.collectMission(driver);
    }

    @Test
    public void automatisationLancementMission() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        boolean missionDispo = homePage.missionDisponible(driver);
        System.out.println(missionDispo);
        if (missionDispo == true) {
            MissionPage missionPage = homePage.openMissionPage(driver);
            missionPage.lanceMission(driver);
        }
    }

    @Test
    public void automatisationDuel() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        duelPage.Duel(driver);
    }


    @Test
    public void automatisationDefi() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean defiAFaire = homePage.defiAFaire(driver);
        if (defiAFaire == true) {
        TourDeLaGloirePage tourDeLaGloirePage = homePage.openTourDeLaGloire(driver);
        tourDeLaGloirePage.lancerDefi(driver);
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


    @Test
    public void automatisationChampion() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo(driver);
        if (championDispo == true) {
            championPage.combattreChampion(driver);
        }
    }


    @Test
    public void automatisationChampion2() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo2(driver);
        if (championDispo == true) {
            championPage.combattreChampion2(driver);
        }
    }

    @Ignore
    @Test
    public void automatisationChampion3() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo3(driver);
        if (championDispo == true) {
            championPage.combattreChampion3(driver);
        }
    }


    @Test
    public void automatisationChampion4() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo4(driver);
        if (championDispo == true) {
            championPage.combattreChampion4(driver);
        }
    }


    @Test
    public void automatisationChampion5() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo5(driver);
        if (championDispo == true) {
            championPage.combattreChampion5(driver);
        }
    }


    @Test
    public void automatisationChampion6() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo6(driver);
        if (championDispo == true) {
            championPage.combattreChampion6(driver);
        }
    }
}


 