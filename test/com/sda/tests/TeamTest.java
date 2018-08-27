package com.sda.tests;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import org.junit.Assert;
import org.junit.Test;

import java.awt.event.TextEvent;

public class TeamTest {

    @Test
    public void addHeroToTeamTest() throws InvalidHeroTeamException{
        //given
        Team blueTeam = new Team(TeamType.BLUE);
        SuperHero blueHero = HeroCreator.createHeroWithDefaultStats("blueHero", TeamType.BLUE);
        SuperHero redHero = HeroCreator.createHeroWithDefaultStats("redHero", TeamType.RED);
        //when
       // boolean blueHeroToBlueTeam = blueTeam.addHeroToTeam(blueHero);
       // boolean redHeroToBlueTeam = blueTeam.addHeroToTeam(redHero);
        //then
       // Assert.assertTrue(blueHeroToBlueTeam);
      //  Assert.assertFalse(redHeroToBlueTeam);
    }
    @Test
    public void testPowerOfHero() throws InvalidHeroTeamException{

        HeroStatistics hs1 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs2 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs3 = new HeroStatistics(200, 300, 400);
        HeroStatistics hs4 = new HeroStatistics(200, 300, 400);
        HeroStatistics hs5 = new HeroStatistics(300, 400, 500);
        AbstractHero superman = new SuperHero("Superman", hs1, TeamType.RED);
        AbstractHero spiderman = new SuperHero("Spiderman", hs2, TeamType.RED);
        AbstractHero catwoman = new SuperHero("Catwoman", hs3, TeamType.RED);
        AbstractHero ironman = new SuperHero("Ironman", hs4, TeamType.RED);
        AbstractHero hulk = new SuperHero("Hulk", hs5, TeamType.RED);
        Team team1 = new Team(TeamType.RED);
        team1.addHeroToTeam(spiderman);
        team1.addHeroToTeam(superman);
        team1.addHeroToTeam(catwoman);
        team1.addHeroToTeam(ironman);
        team1.addHeroToTeam(hulk);
        System.out.println(team1.getTeamPower());
        double longNum = 725000.0;
        Assert.assertEquals(longNum,team1.getTeamPower(),0);



    }
    @Test
    public void testPowerOfHero1() throws InvalidHeroTeamException {
        Team redTeam = new Team(TeamType.RED);
        redTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("defhero1", TeamType.RED));
        redTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("defhero2", TeamType.RED));
        redTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("defhero3", TeamType.RED));
        redTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("defhero4", TeamType.RED));
        redTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("defhero5", TeamType.RED));
        System.out.println(redTeam.getTeamPower());
        Assert.assertEquals(120000.0,redTeam.getTeamPower(),0);
    }
    @Test
    public void addPowerBaff() {
      Team Gotham = new Team(TeamType.RED);
        try {
            Gotham.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Joker", TeamType.RED));
        } catch (InvalidHeroTeamException e) {
            e.printStackTrace();
        }
        try {
            Gotham.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Batman", TeamType.RED));
        } catch (InvalidHeroTeamException e) {
            e.printStackTrace();
        }
        double defolt = Gotham.getTeamPower();

        Assert.assertEquals(45000.0,defolt,0);
        System.out.println(defolt);
        try {
            Gotham.increaseTeamPowerWithAdditionalBuff();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double afterBuff = Gotham.getTeamPower();

        System.out.println(afterBuff);
        Assert.assertEquals(46500.0,afterBuff,0);


    }
}
