package com.sda.superheroes;

import com.sda.teams.TeamType;

public class Villain extends AbstractHero {
    public Villain(String name, HeroStatistics stats, TeamType team) {
        super(name, stats, team);
    }

    @Override
    public double getPower() {
        HeroStatistics stats = this.getStats();
        return (stats.getAttack() + stats.getHealth()) * stats.getDefense();
    }
}
