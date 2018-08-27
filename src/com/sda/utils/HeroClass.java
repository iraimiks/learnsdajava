package com.sda.utils;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Vilain;
import com.sda.teams.TeamType;

import java.util.Scanner;

public class HeroClass {
    public static SuperHero creatSuperHero(String name, HeroStatistics stats, TeamType team){
        return new SuperHero(name, stats, team);

    }
    public static Vilain creatVilain(String name, HeroStatistics stats, TeamType team){
        return  new Vilain(name,stats,team);
    }
    public static AbstractHero creatHero(String name, HeroStatistics stats, TeamType team) {

        switch (team) {
            case RED:
                return creatVilain(name, stats, team);
            case GREEN:
                return creatSuperHero(name, stats, team);
            case BLUE:
                return creatSuperHero(name, stats, team);
            default: return null;
        }
    }
}
