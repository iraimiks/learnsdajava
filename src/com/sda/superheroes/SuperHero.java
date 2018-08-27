package com.sda.superheroes;

import com.sda.teams.TeamType;

public class SuperHero extends AbstractHero {
    public SuperHero(String name, HeroStatistics stats, TeamType team) {
        super(name, stats, team);
    }

    @Override
    public double getPower() {
        HeroStatistics stats = this.getStats();
        return (stats.getDefense() + stats.getAttack()) * stats.getHealth();
    }
}