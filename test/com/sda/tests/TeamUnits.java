package com.sda.tests;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Side;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import org.junit.Assert;
import org.junit.Test;
import com.sda.utils.HeroClass;

public class TeamUnits {


    /*@Test
    public void testBeternes(){
        Team team = new Team(TeamType.RED);
        team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Joker", TeamType.RED));
        team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Arturs", TeamType.RED));
        Team team2 = new Team(TeamType.BLUE);
        team2.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("IronMan", TeamType.BLUE));


        Assert.assertEquals(team.compareTo(team), team2.compareTo(team2));

    }
    @Test
    public void testBeternesBuffs(){
        Team team = new Team(TeamType.RED);
        team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Joker", TeamType.RED));
        team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Arturs", TeamType.RED));
        Team team2 = new Team(TeamType.BLUE);
        team2.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("IronMan", TeamType.BLUE));
        double afterbuff = team.getTeamPower();



        Assert.assertTrue(team2.getTeamPower()<team.getTeamPower());
    }
    @Test
    public void heroSideTest(){
        AbstractHero goodHero = HeroCreator.createHeroWithDefaultStats("Good Hero", TeamType.BLUE);
        boolean result = Side.GOOD.belongsTo(goodHero);
        boolean resultFalse = Side.EVIL.belongsTo(goodHero);

        Assert.assertTrue(result);
        Assert.assertFalse(resultFalse);
    }
    @Test
    public void testUpdateTeamSide(){
        Team team1 = new Team(TeamType.GREEN);
        HeroStatistics hs1 = new HeroStatistics(300, 300, 300);
        HeroStatistics hs2 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs3 = new HeroStatistics(500, 500, 500);
        AbstractHero hero1 = new SuperHero("Hero1", hs1, TeamType.GREEN);
        AbstractHero villain1 = new Villain("Villain1", hs2, TeamType.GREEN);
        AbstractHero villain2 = new Villain("Villain2", hs3, TeamType.GREEN);
        team1.addHeroToTeam(hero1);
        team1.addHeroToTeam(villain1);
        Assert.assertEquals(team1.getSide(), Side.GOOD);
        team1.addHeroToTeam(villain2);
        Assert.assertEquals(team1.getSide(), Side.EVIL);
    }*/
    @Test
    public void TestUpadateTeamSid2()  {
        Team team = new Team(TeamType.RED);
       try {
            team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Joker", TeamType.RED));
            team.addHeroToTeam(HeroCreator.createVillainWithDefaultStats("Jana", TeamType.RED));

            double teamnNoBuff = team.getTeamPower();
            team.increaseTeamPowerWithAdditionalBuff();
            double teamWithBuff = team.getTeamPower();

            team.increaseTeamPowerWithAdditionalBuff();
            double teamPosibleBuffed = team.getTeamPower();
            Assert.assertEquals(teamWithBuff, teamPosibleBuffed, 0);
            Assert.fail();
        }catch (InvalidHeroTeamException e){
            System.out.println(e.getLocalizedMessage());
        }

    }
    @Test(expected = InvalidHeroTeamException.class)
    public void tooManyBuffsTest() throws InvalidHeroTeamException
    {
        Team heroTeam = new Team(TeamType.RED);
        heroTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Buff Me",TeamType.RED));
        heroTeam.increaseTeamPowerWithAdditionalBuff();
        heroTeam.increaseTeamPowerWithAdditionalBuff();

    }
    @Test
    public void tooManyBuffsTest1() throws InvalidHeroTeamException
    {
        Team heroTeam = new Team(TeamType.RED);
        heroTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Buff Me",TeamType.RED));
        heroTeam.increaseTeamPowerWithAdditionalBuff();

    }
    @Test
    public void isAliveAndKillMethodeTestPleas(){

        AbstractHero hero = HeroCreator.createHeroWithDefaultStats("jon",TeamType.RED);
        System.out.println("Is hero Alive..."+hero.isAlive());
        Assert.assertEquals(true,hero.isAlive());
        hero.kill();

        System.out.println("Is hero Alive..."+hero.isAlive());
        Assert.assertEquals(false,hero.isAlive());
    }
    @Test
    public void damageTest(){
        AbstractHero hero = HeroCreator.createHeroWithDefaultStats("jon",TeamType.RED);

        System.out.println(hero.getStats());
    }
    @Test
    public void testRandomTeam(){
        Team randoHeroTeam = Team.getTeamOf(30,TeamType.RED);
        randoHeroTeam.listAllHeroes();

    }
}

