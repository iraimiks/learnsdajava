package com.sda;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import com.sda.utils.PropertyReader;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class Main {
    private final static Logger LOGGER = Logger.getLogger(PropertyReader.class.getName());

    public static void main(String[] args) {
       /* HeroCreator.loadProps();

        SuperHero defaultHeroExample = HeroCreator.createHeroWithDefaultStats("JokerSlayer", TeamType.RED);
        SuperHero defaultHeroExample2 = HeroCreator.createHeroWithDefaultStats("JokerSlayer", TeamType.RED);
        System.out.println(defaultHeroExample.equals(defaultHeroExample2));
        Villain defaultVillainExample = HeroCreator.createVillainWithDefaultStats("Joker", TeamType.GREEN);
        System.out.println("Default superhero power: " + defaultHeroExample.getPower());
        System.out.println("Default villain power: " + defaultVillainExample.getPower());
        System.out.println(System.getProperties());
        System.out.println();

        Team redTeam = new Team(TeamType.RED);
        redTeam.addHeroToTeam(defaultHeroExample);
        redTeam.listAllHeroes();
        System.out.println("***");
        redTeam.addHeroToTeam(defaultHeroExample);
        redTeam.listAllHeroes();

        System.out.println(redTeam);*/
        HeroStatistics hs1 = new HeroStatistics(100, 100, 100);
        HeroStatistics hs2 = new HeroStatistics(100, 100, 100);

        HeroStatistics hs3 = new HeroStatistics(200, 300, 400);

        AbstractHero superman = new SuperHero("Superman", hs1, TeamType.RED);
        AbstractHero spiderman = new SuperHero("Spiderman", hs2, TeamType.RED);
        AbstractHero catwoman = new SuperHero("Catwoman", hs3, TeamType.RED);

// team 1: superman, spiderman, catwoman

        HeroStatistics hs4 = new HeroStatistics(10, 50, 10);
        AbstractHero batman = new SuperHero("Batman", hs4, TeamType.RED);

        List<String> names = Arrays.asList("Janis", "Arturs", "Dāvis", "Anna");
        List<AbstractHero> heroes = Arrays.asList(superman, spiderman, catwoman, batman);
// team 2: superman, spiderman, catwoman, batman
        heroes.stream().map(AbstractHero::getName).reduce("", (currentValue, element) -> {
            if (currentValue.equals("")) {
                return element;
            } else {
                return currentValue + ", " + element;
            }
        });

    }
}
