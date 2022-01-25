import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class automatisation {

    WebDriver driver;

    @Before
    public void init() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
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
    @Ignore
    @Test
    public void automatisationHaremCombat() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        boolean recoltNecessaire = homePage.recoltHarem(driver);
        if (recoltNecessaire == true) {
            HaremPage haremPage = homePage.ouvrirHaremParLeMArche(driver);
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
            CombatPage combatPage = lastZonePage.openCombatPage(driver);
            Combat(driver);
        }
    }

    private void Combat(WebDriver driver) {
        CombatPage combatPage = new CombatPage(driver);
        combatPage.combattreBoss(driver);
        boolean combatNonNull = combatPage.getHeader().combatNecessaire(driver);
        if (combatNonNull == true) {
            Combat(driver);
        }
    }
    @Ignore
    @Test
    public void LieuxDePouvoirRecolt() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        LieuxDePouvoirPage lieuxDePouvoirPage = homePage.openLieuxDePouvoirPage(driver);
        lieuxDePouvoirPage.RecoltMission(driver);
    }
    @Ignore
    @Test
    public void LieuxDePouvoirLancement() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        LieuxDePouvoirPage lieuxDePouvoirPage = homePage.openLieuxDePouvoirPage(driver);
        lieuxDePouvoirPage.LancerMission(driver);
    }
    @Ignore
    @Test
    public void AutomatisationEscalierMission() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        EscaliersPage escaliersPage = homePage.ouvrirEscalierDuPantheon(driver);
        boolean combatDispo = escaliersPage.CombatPossible(driver);
        if (combatDispo == true) {
            CombatPage combatPage = escaliersPage.openCombatPage(driver);
            combatPage.combattreEscalier(driver);
            Combat2(driver);
        }
        HomePage homepage2 = escaliersPage.getHeader().openHomePage(driver);
        MissionPage missionPage = homepage2.openMissionPage(driver);
        boolean plusDeMission = missionPage.plusDeMission(driver);
        if (plusDeMission) {
            missionPage.lanceMission(driver);
        }
        missionPage.collectMission(driver);
    }
    private void Combat2(WebDriver driver) {
        EscaliersPage escaliersPage = new EscaliersPage(driver);
        boolean combatDispo = escaliersPage.CombatPossible(driver);
        if (combatDispo == true) {
            CombatPage combatPage = escaliersPage.openCombatPage(driver);
            EscaliersPage escaliersPage2 = combatPage.combattreEscalier(driver);
            Combat2(driver);
        }
    }
    @Ignore
    @Test
    public void automatisationDuelDefi() throws AWTException {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        //DuelPage duelPage = homePage.openDuelPage(driver);
        //duelPage.Duel(driver);
        boolean defiAFaire = homePage.defiAFaire(driver);
        if (defiAFaire == true) {
            TourDeLaGloirePage tourDeLaGloirePage = homePage.openTourDeLaGloire(driver);
            tourDeLaGloirePage.lancerDefi(driver);
        }
    }

    @Test
    public void automatisationDuel() throws AWTException {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        DuelPage duelPage = homePage.openDuelPage(driver);
        duelPage.Duel(driver);
    }
    @Ignore
    @Test
    public void automatisationChampion() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);

        /*ChampionPage championPage = homePage.ouvrirZoneDesChampions(driver);
        boolean championDispo = championPage.championDispo(driver);
        if (championDispo == true) {
            championPage.combattreChampion(driver);
        }
        boolean championDispo2 = championPage.championDispo2(driver);
        if (championDispo2 == true) {
            championPage.combattreChampion2(driver);
        }
        boolean championDispo3 = championPage.championDispo3(driver);
        if (championDispo3 == true) {
            championPage.combattreChampion3(driver);
        }
        boolean championDispo4 = championPage.championDispo4(driver);
        if (championDispo4 == true) {
            championPage.combattreChampion4(driver);
        }
        boolean championDispo5 = championPage.championDispo5(driver);
        if (championDispo5 == true) {
            championPage.combattreChampion5(driver);
        }
        boolean championDispo6 = championPage.championDispo6(driver);
        if (championDispo6 == true) {
            championPage.combattreChampion6(driver);
        }
        HomePage homepage2 = championPage.getHeader().openHomePage(driver);*/

        ClubPage clubPage = homePage.openClubPage(driver);
        clubPage.pageBoss(driver);
        boolean bossDispo = clubPage.bossDispo(driver);
        if (bossDispo == true) {
            clubPage.vaincreBossDeClub(driver);
        }
    }

    /*@Ignore
    @Test
    public void automatisationChampionClubRepetition() {
        InitialisationPage initialisation = new InitialisationPage(driver);
        HomePage homePage = initialisation.openHomePage(driver);
        ClubPage clubPage = homePage.openClubPage(driver);
        clubPage.combattreChampion7(driver);
    }
    @Ignore
    @Test
    public void automatisationSelect() {
        JFrame f = new JFrame();
        JPanel panel = new JPanel();
        f.add(panel);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println(e.getX() + "," + e.getY());
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 200);
        f.setVisible(true);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}

