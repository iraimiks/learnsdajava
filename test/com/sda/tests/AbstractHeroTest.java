package com.sda.tests;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import org.junit.Assert;
import org.junit.Test;

public class AbstractHeroTest {

    //write a unit test in the package com.sda.tests AbstractHeroTest, which will check the creation of instances of Villain and SuperHero objects.
    @Test
    public void testSuperHero() {
        //given
        SuperHero batman = new SuperHero("Batman", new HeroStatistics(100, 20, 50), TeamType.GREEN);
        //when
        double result = batman.getPower();
        //then
        Assert.assertEquals(12000.0, result, 0);
    }

    @Test
    public void testVillain() {
        //given
        Villain joker = new Villain("Joker", new HeroStatistics(100, 20, 50), TeamType.RED);
        //when
        double result = joker.getPower();
        //then
        Assert.assertEquals(8500.0, result, 0);
    }

    @Test
    public void testAbstractHeroEqualsMethod(){
        //given
        HeroStatistics hs1 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs2 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs3 = new HeroStatistics(200, 300, 400);

        AbstractHero batman1 = new SuperHero("Batman", hs1, TeamType.RED);
        AbstractHero batman2 = new SuperHero("Batman", hs2, TeamType.RED);
        AbstractHero batman3 = new SuperHero("Batman", hs3, TeamType.RED);
        //when
        boolean theseHerosShouldBeEqual = batman1.equals(batman2);
        boolean theseHerosShouldNotBeEqual = batman1.equals(batman3);
        //then
        Assert.assertTrue(theseHerosShouldBeEqual);
        Assert.assertFalse(theseHerosShouldNotBeEqual);

    }
   /* @Test
    public void testBatmannIsInList() throws InvalidHeroTeamException {

        HeroStatistics hs1 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs2 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs3 = new HeroStatistics(200, 300, 400);

        AbstractHero superman = new SuperHero("Superman", hs1, TeamType.RED);
        AbstractHero spiderman = new SuperHero("Spiderman", hs2, TeamType.RED);
        AbstractHero catwoman = new SuperHero("Catwoman", hs3, TeamType.RED);

        // team 1: superman, spiderman, catwoman
        Team team1 = new Team(TeamType.RED);

        Assert.assertTrue( team1.addHeroToTeam(superman));
        Assert.assertTrue(team1.addHeroToTeam(spiderman));
        Assert.assertTrue(team1.addHeroToTeam(catwoman));

        HeroStatistics hs4 = new HeroStatistics(10, 50, 10);
        AbstractHero batman = new SuperHero("Batman", hs4, TeamType.RED);

        // team 2: superman, spiderman, catwoman, batman
        Team team2 = new Team(TeamType.RED);
        Assert.assertTrue( team2.addHeroToTeam(spiderman));
        Assert.assertTrue( team2.addHeroToTeam(superman));
        Assert.assertTrue(team2.addHeroToTeam(catwoman));
        Assert.assertTrue( team2.addHeroToTeam(batman));

        Assert.assertTrue(catwoman.equals(team1.getTeamLeader()));
        Assert.assertTrue(batman.equals(team2.getTeamLeader()));
        System.out.println(team1.getTeamPower());

    }*/

}
