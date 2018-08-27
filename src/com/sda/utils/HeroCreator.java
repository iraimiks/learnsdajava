package com.sda.utils;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;

import java.util.Properties;

public class HeroCreator {

    public static void loadProps(){
        PropertyReader.loadPropertyValues();
    }
    public static AbstractHero createHero(boolean hero, String name, HeroStatistics stats, TeamType team) {
        if (hero) {
            return createSuperHero(name, stats, team);
        } else {
            return createVillain(name, stats, team);
        }
    }

    public static SuperHero createSuperHero(String name, HeroStatistics stats, TeamType team) {
        return new SuperHero(name, stats, team);
    }

    public static Villain createVillain(String name, HeroStatistics stats, TeamType team) {
        return new Villain(name, stats, team);
    }

    public static SuperHero createHeroWithDefaultStats(String name, TeamType team) {
        PropertyReader.loadPropertyValues();
        Properties props = System.getProperties();
        int attack = Integer.parseInt(props.getProperty("hero.superHeroBaseAttack"));
        int health = Integer.parseInt(props.getProperty("hero.superHeroBaseHealth"));
        int defense = Integer.parseInt(props.getProperty("hero.superHeroBaseDefence"));
        HeroStatistics stats = new HeroStatistics(health,attack,defense);
        return createSuperHero(name, stats ,team);
    }


    public static Villain createVillainWithDefaultStats(String name, TeamType team) {
        PropertyReader.loadPropertyValues();
        Properties props = System.getProperties();
        int attack = Integer.parseInt(props.getProperty("villain.villainBaseAttack"));
        int health = Integer.parseInt(props.getProperty("villain.villainBaseHealth"));
        int defense = Integer.parseInt(props.getProperty("villain.villainBaseDefence"));
        HeroStatistics stats = new HeroStatistics(health,attack,defense);
        return createVillain(name, stats ,team);
    }
}
